package org.example.webdt.controller.admin;

import org.example.webdt.dto.OrderDto;
import org.example.webdt.dto.ResultResponse;
import org.example.webdt.services.OrderService;
import org.example.webdt.utils.AppConstants;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminOrderController {
    private OrderService orderService;

    public AdminOrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/orders")
    public String home(
            @RequestParam(value="pageNo",defaultValue = AppConstants.DEFAULT_PAGE_NUMBER,required = false) int pageNo,
            @RequestParam(value="pageSize",defaultValue = AppConstants.DEFAULT_PAGE_SIZE,required = false) int pageSize,
            @RequestParam(value="sortBy",defaultValue = "updated",required = false) String sortBy,
            @RequestParam(value="sortDir",defaultValue = AppConstants.DEFAULT_SORT_DIRECTION,required = false) String sortDir,
            Model model
    ){
        ResultResponse result = orderService.getAllOrders(pageNo, pageSize, sortBy, sortDir);
        List<OrderDto> orders = (List<OrderDto>) result.getContent();
        model.addAttribute("orders",orders);
        model.addAttribute("result",result);
        model.addAttribute("url","../");
        return "admin/list-order";
    }

    @GetMapping("/orders/filter")
    public String search(
            @RequestParam("lang") String status,
            @RequestParam(value="pageNo",defaultValue = AppConstants.DEFAULT_PAGE_NUMBER,required = false) int pageNo,
            @RequestParam(value="pageSize",defaultValue = AppConstants.DEFAULT_PAGE_SIZE,required = false) int pageSize,
            Model model
    ){
        if(status.equals("all")){
            return "redirect:/admin/orders";
        } else{
            if(status.equals("moi")){
                status = "mới";
            }
            if(status.equals("dang-giao-hang")){
                status = "đang vận chuyển";
            }
            if(status.equals("da-nhan-hang")){
                status = "đã nhận hàng";
            }
            if(status.equals("da-huy")){
                status = "đã hủy";
            }
            ResultResponse result = orderService.getAllOrdersByStatus(status,pageNo, pageSize);
            List<OrderDto> orders = (List<OrderDto>) result.getContent();
            model.addAttribute("ordersStatus",orders);
            model.addAttribute("result1",result);
            model.addAttribute("lang",status);
            model.addAttribute("url","../../");
            return "admin/list-order";
        }
    }

    @PutMapping("/orders/{id}")
    public ResponseEntity<String> updateStatus(@PathVariable("id") Long id){
        String status = "đang giao hàng";
        OrderDto orderDto = orderService.updateOrder(id,status);
        return ResponseEntity.ok(orderDto.getOrder_status());
    }

    @GetMapping("/orders/{id}")
    public String getOrderById(@PathVariable("id") Long id,Model model){
        OrderDto orderDto = orderService.getOrderById(id);
        model.addAttribute("url","../../");
        model.addAttribute("order",orderDto);
        return "admin/order-detail";
    }
}
