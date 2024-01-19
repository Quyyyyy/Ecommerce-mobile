package org.example.webdt.controller.user;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.webdt.config.PaymentConfig;
import org.example.webdt.controller.BaseController;
import org.example.webdt.dto.*;
import org.example.webdt.dto.mapper.UserMapper;
import org.example.webdt.entities.UserEntity;
import org.example.webdt.services.OrderService;
import org.example.webdt.services.ProductService;
import org.example.webdt.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class CartController extends BaseController {
    private ProductService productService;
    private OrderService orderService;
    private UserService userService;

    public CartController(ProductService productService, OrderService orderService, UserService userService) {
        this.productService = productService;
        this.orderService = orderService;
        this.userService = userService;
    }

    @GetMapping("/cart")
    public String cart(Model model,HttpServletRequest request){
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        if(cart == null || cart.getItems().isEmpty()){
            model.addAttribute("mess", "CART_NULL");
        } else{
            model.addAttribute("mess", "CART_NOT_NULL");
        }
        model.addAttribute("url","../../");
        return "user/cart";
    }

    @GetMapping("/cart/checkout")
    public String cartCheckout(Model model){
        String url = "../../";
        model.addAttribute("url",url);
        return "user/checkout";
    }

    @PostMapping("/ajax/addToCart/{id}")
    public ResponseEntity<Integer> addCart(HttpServletRequest request, HttpServletResponse response,
            @PathVariable("id") Long id, @RequestParam("num") Integer quantity){
        HttpSession session = request.getSession();
        Cart cart = null;
        if(session.getAttribute("cart")!=null){
            cart = (Cart) session.getAttribute("cart");
        } else{
            cart = new Cart();
            session.setAttribute("cart",cart);
        }
        List<CartItem> cartItems = cart.getItems();
        Boolean isExists = false;
        for(CartItem item:cartItems){
            if(item.getProduct().getId() == id){
                isExists = true;
                item.setQuantity(item.getQuantity()+quantity);
                break;
            }
        }
        if(!isExists){
            ProductDto productDto = productService.getProductById(id);
            CartItem t = new CartItem(productDto,quantity, productDto.getDiscount());
            cart.getItems().add(t);
        }
        Integer count = this.getTotalsItem(request);
        Long totalPrice = this.getToltalsPrice(request);
        session.setAttribute("totalItems",count);
        session.setAttribute("totalPrices",totalPrice);
        return ResponseEntity.ok(count);
    }

    @PostMapping("/ajax/update-cart/{id}")
    public ResponseEntity<Map<String,Object>> updateQuanlityCart(
            HttpServletRequest request,HttpServletResponse response,
            @PathVariable("id") Long id,@RequestParam("num") Integer quantity){
        HttpSession session = request.getSession();
        Cart cart = null;
        if(session.getAttribute("cart")!=null){
            cart = (Cart) session.getAttribute("cart");
            List<CartItem> cartItems = cart.getItems();
            for(CartItem item:cartItems){
                if(item.getProduct().getId() == id){
                    item.setQuantity(quantity);
                    if(quantity <= 0){
                        cart.getItems().remove(item);
                    }
                    break;
                }
            }
        }
        ProductDto productDto = productService.getProductById(id);

        session.setAttribute("cart",cart);
        Map<String,Object> jsonResult = new HashMap<>();
        jsonResult.put("cart_empty",cart.getItems().size());
        jsonResult.put("num",quantity);
        jsonResult.put("total",productDto.getDiscount()*quantity);
        jsonResult.put("totalPrices",getToltalsPrice(request));

        session.setAttribute("totalItems", getTotalsItem(request));
        return ResponseEntity.ok(jsonResult);
    }

    @PostMapping("/create-payment")
    public String createPayment(Model model,
                                HttpServletRequest request) throws UnsupportedEncodingException {
        HttpSession session = request.getSession();
        UserDto user = new UserDto();
        if(userLogined().getName() == null){
            user = null;
        } else{
            user = UserMapper.MAPPER.mapToUserDto(userLogined());
        }
        String customerName = request.getParameter("name");
        String customerEmail = request.getParameter("email");
        String customerPhone = request.getParameter("phone");
        String customerAddress = request.getParameter("address");
        String payment = request.getParameter("fav_language");

        OrderDto order = new OrderDto();
        order.setUser(user);
        order.setCustomerName(customerName);
        order.setCustomerEmail(customerEmail);
        order.setCustomerPhone(customerPhone);
        order.setCustomerAddress(customerAddress);
        order.setOrderCode(String.valueOf(System.currentTimeMillis()));
        order.setPayment(payment);

        Cart cart = (Cart) session.getAttribute("cart");
        if(cart == null || cart.getItems().isEmpty()){
            model.addAttribute("mess", "CART_NULL");
            model.addAttribute("url","../../");
            return "user/cart";
        }

        Set<OrderItemDto> orderItemDtos = new HashSet<>();

        for(CartItem item:cart.getItems()){
            int exis = item.getProduct().getQuantity();
            if(exis >= item.getQuantity()){
                OrderItemDto orderItemDto = new OrderItemDto();
                orderItemDto.setProduct(item.getProduct());
                orderItemDto.setQuantity(item.getQuantity());
                orderItemDto.setPriceBuy(item.getPrice());
                orderItemDtos.add(orderItemDto);
            }
            else{
                model.addAttribute("mess", "NOT_ENOUGH");
                session.setAttribute("cart", null);
                session.setAttribute("totalItems", 0);
                model.addAttribute("url","../../");
                return "user/cart";
            }
        }
        order.setOrderItems(orderItemDtos);
        order.setTotal(getToltalsPrice(request));
        order.setOrder_status("mới");
        session.setAttribute("saleOrder", order);

        if (payment == null) {
            model.addAttribute("mess", "PAYMENT_MISSING");
            model.addAttribute("url","../../");
            return "user/cart"; // -> đường dẫn tới View.
        }
        if(payment.equals("VNPAY")){
            long amount = (long) (this.getToltalsPrice(request) * 100);
            String orderType = "other";
            String bankCode = "NCB";
            String vnp_TxnRef = PaymentConfig.getRandomNumber(8);
            String vnp_IpAddr = PaymentConfig.getIpAddress(request);

            String vnp_TmnCode = PaymentConfig.vnp_TmnCode;

            Map<String, String> vnp_Params = new HashMap<>();
            vnp_Params.put("vnp_Version", PaymentConfig.vnp_Version);
            vnp_Params.put("vnp_Command", PaymentConfig.vnp_Command);
            vnp_Params.put("vnp_TmnCode", vnp_TmnCode);
            vnp_Params.put("vnp_Amount", String.valueOf(amount));
            vnp_Params.put("vnp_CurrCode", "VND");
            vnp_Params.put("vnp_BankCode", bankCode);

            vnp_Params.put("vnp_TxnRef", vnp_TxnRef);
            vnp_Params.put("vnp_OrderInfo", "Thanh toan don hang:" + vnp_TxnRef);
            vnp_Params.put("vnp_Locale", "vn");

            vnp_Params.put("vnp_OrderType", orderType);

            vnp_Params.put("vnp_ReturnUrl", PaymentConfig.vnp_ReturnUrl);
            vnp_Params.put("vnp_IpAddr", vnp_IpAddr);

            Calendar cld = Calendar.getInstance(TimeZone.getTimeZone("Etc/GMT+7"));
            SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
            String vnp_CreateDate = formatter.format(cld.getTime());
            vnp_Params.put("vnp_CreateDate", vnp_CreateDate);

            cld.add(Calendar.MINUTE, 15);
            String vnp_ExpireDate = formatter.format(cld.getTime());
            vnp_Params.put("vnp_ExpireDate", vnp_ExpireDate);

            List fieldNames = new ArrayList(vnp_Params.keySet());
            Collections.sort(fieldNames);
            StringBuilder hashData = new StringBuilder();
            StringBuilder query = new StringBuilder();
            Iterator itr = fieldNames.iterator();
            while (itr.hasNext()) {
                String fieldName = (String) itr.next();
                String fieldValue = (String) vnp_Params.get(fieldName);
                if ((fieldValue != null) && (fieldValue.length() > 0)) {
                    //Build hash data
                    hashData.append(fieldName);
                    hashData.append('=');
                    hashData.append(URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII.toString()));
                    //Build query
                    query.append(URLEncoder.encode(fieldName, StandardCharsets.US_ASCII.toString()));
                    query.append('=');
                    query.append(URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII.toString()));
                    if (itr.hasNext()) {
                        query.append('&');
                        hashData.append('&');
                    }
                }
            }
            String queryUrl = query.toString();
            String vnp_SecureHash = PaymentConfig.hmacSHA512(PaymentConfig.secretKey, hashData.toString());
            queryUrl += "&vnp_SecureHash=" + vnp_SecureHash;
            String paymentUrl = PaymentConfig.vnp_PayUrl + "?" + queryUrl;

            return "redirect:" + paymentUrl;
        } else{
            for (OrderItemDto item: order.getOrderItems()) {
                ProductDto p = item.getProduct();
                p.setQuantity(p.getQuantity() - item.getQuantity());
                // Hết hàng thì status = false
                if (p.getQuantity() == 0) {
                    p.setStatus(false);
                }
                productService.updateProduct(p);
            }
            orderService.createOrder(order);
            session.setAttribute("cart", null);
            session.setAttribute("totalItems", 0);
            model.addAttribute("mess", "OK");
            model.addAttribute("url","../../");
            return "user/cart";
        }
    }


    @GetMapping("/finish-payment")
    public String finishPayment(Model model,HttpServletRequest request,
            @RequestParam(value = "vnp_ResponseCode", required = false) String responseCode){
        HttpSession session = request.getSession();
        OrderDto order = (OrderDto) session.getAttribute("saleOrder");
        if (responseCode != null) {
            if (responseCode.equals("00")) {
                // Thanh toán thành công
                for (OrderItemDto item: order.getOrderItems()) {
                    ProductDto p = item.getProduct() ;
                    p.setQuantity(p.getQuantity() - item.getQuantity());
                    // Hết hàng thì status = false
                    if (p.getQuantity() == 0) {
                        p.setStatus(false);
                    }
                    productService.updateProduct(p);
                }
                orderService.createOrder(order);
                session.setAttribute("cart", null);
                session.setAttribute("totalItems", 0);
                model.addAttribute("mess", "OK");
                model.addAttribute("url","../../");
                return "user/cart"; // -> đường dẫn tới View.
            } else {
                // Thanh toán thất bại
                model.addAttribute("mess", "FAILED");
                model.addAttribute("url","../../");
                return "user/cart"; // -> đường dẫn tới View.
            }
        } else {
            // Thanh toán thất bại
            model.addAttribute("mess", "FAILED");
            model.addAttribute("url","../../");
            return "user/cart"; // -> đường dẫn tới View.
        }
    }



    private int getTotalsItem(HttpServletRequest request){
        HttpSession session = request.getSession();
        if(session.getAttribute("cart") == null){
            return 0;
        }

        Cart cart = (Cart) session.getAttribute("cart");
        List<CartItem> cartItems = cart.getItems();

        int total = 0;
        for(CartItem cartItem:cartItems){
            total += cartItem.getQuantity();
        }

        return total;
    }




    private long getToltalsPrice(HttpServletRequest request){
        HttpSession session = request.getSession();
        if(session.getAttribute("cart") == null){
            return 0;
        }

        Cart cart = (Cart) session.getAttribute("cart");
        List<CartItem> cartItems = cart.getItems();

        long price = 0;
        for(CartItem cartItem:cartItems){
            price += cartItem.getPrice()*cartItem.getQuantity();
        }

        return price;
    }
}
