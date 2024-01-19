package org.example.webdt.controller.admin;

import org.example.webdt.services.OrderService;
import org.example.webdt.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/admin")
public class AdminDefaultController{
    private OrderService orderService;
    private UserService userService;

    public AdminDefaultController(OrderService orderService, UserService userService) {
        this.orderService = orderService;
        this.userService = userService;
    }

    @GetMapping("/home")
    public String HomeAdmin(Model model){
        Long p = orderService.totalOrderNew();
        Long q = orderService.getTotalOrderMonth();
        Long u = userService.getToTalUser();
        Long price = orderService.getTotalIncome();
//        List<SaleData> datas = orderService.getOrderCountByDay();

        model.addAttribute("url","../");
        model.addAttribute("p",p);
        model.addAttribute("q",q);
        model.addAttribute("u",u);
        model.addAttribute("price",price);
//        model.addAttribute("data",datas);
        return "admin/index";
    }


}
