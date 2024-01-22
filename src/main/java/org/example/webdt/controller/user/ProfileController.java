package org.example.webdt.controller.user;

import org.example.webdt.controller.BaseController;
import org.example.webdt.dto.OrderDto;
import org.example.webdt.dto.ResultResponse;
import org.example.webdt.dto.request.ChangePassword;
import org.example.webdt.dto.request.UserRequest;
import org.example.webdt.entities.UserEntity;
import org.example.webdt.services.OrderService;
import org.example.webdt.services.UserService;
import org.example.webdt.utils.AppConstants;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProfileController extends BaseController {
    private UserService userService;
    private OrderService orderService;

    public ProfileController(UserService userService, OrderService orderService) {
        this.userService = userService;
        this.orderService = orderService;
    }

    @GetMapping("/profile")
    public String hone(Model model){
        model.addAttribute("url","../../");
        return "user/profile";
    }

    @PutMapping("/edit-profile")
    public ResponseEntity<String> editProfile(Model model, @RequestBody UserRequest userRequest){
        UserEntity user = userLogined();
        String content = userService.editProfile(user,userRequest);
        model.addAttribute("url","../../");
        return ResponseEntity.ok(content);
    }

    @PutMapping("/edit-pass")
    public ResponseEntity<String> editPass(Model model, @RequestBody ChangePassword change){
        UserEntity user = userLogined();
        String content = userService.changePassword(user,change);
        model.addAttribute("url","../../");
        return ResponseEntity.ok(content);
    }

    @GetMapping("/my-order")
    public String myOrders(
            @RequestParam(value="lang",required = false) String status,
            @RequestParam(value="pageNo",defaultValue = AppConstants.DEFAULT_PAGE_NUMBER,required = false) int pageNo,
            @RequestParam(value="pageSize",defaultValue = "10",required = false) int pageSize,
            @RequestParam(value="sortBy",defaultValue = "updated",required = false) String sortBy,
            @RequestParam(value="sortDir",defaultValue = AppConstants.DEFAULT_SORT_DIRECTION,required = false) String sortDir,
            Model model
    ){
        UserEntity user = userLogined();
        if(status == null||status.equals("all")) {
            ResultResponse result = orderService.getAllOrdersBYUsers(user, pageNo, pageSize, sortBy, sortDir);
            List<OrderDto> orders = (List<OrderDto>) result.getContent();
            model.addAttribute("orders", orders);
            model.addAttribute("result", result);
        } else{
            if (status.equals("moi")) {
                status = "mới";
            }
            if (status.equals("dang-giao-hang")) {
                status = "đang vận chuyển";
            }
            if (status.equals("da-nhan-hang")) {
                status = "đã nhận hàng";
            }
            if (status.equals("da-huy")) {
                status = "đã hủy";
            }
            ResultResponse result = orderService.getAllOrdersByUsersAndStatus(user.getId(), status, pageNo, pageSize, sortBy, sortDir);
            List<OrderDto> orders = (List<OrderDto>) result.getContent();
            model.addAttribute("status",status);
            model.addAttribute("ordersStatus", orders);
            model.addAttribute("result1", result);
        }
        model.addAttribute("url","../../");
        return "user/my-orders";
    }

    @GetMapping("/my-order/{id}")
    public String getOrderById(@PathVariable("id") Long id,Model model){
        OrderDto orderDto = orderService.getOrderById(id);
        model.addAttribute("url","../../");
        model.addAttribute("order",orderDto);
        return "user/d-order";
    }

    @PutMapping("/my-order/{id}")
    public ResponseEntity<String> updateStatus(@PathVariable("id") Long id,
                                               @RequestParam("status") String status){
        if (status.equals("da-nhan-hang")) {
            status = "đã nhận hàng";
        }
        if (status.equals("da-huy")) {
            status = "đã hủy";
        }
        OrderDto orderDto = orderService.updateOrder(id,status);
        return ResponseEntity.ok(orderDto.getOrder_status());
    }
}
