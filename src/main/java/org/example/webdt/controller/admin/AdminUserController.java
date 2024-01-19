package org.example.webdt.controller.admin;

import org.example.webdt.dto.ResultResponse;
import org.example.webdt.dto.UserDto;
import org.example.webdt.dto.request.UserRequest;
import org.example.webdt.entities.RoleEntity;
import org.example.webdt.services.UserService;
import org.example.webdt.utils.AppConstants;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminUserController {
    UserService userService;

    public AdminUserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String home(
            @RequestParam(value="pageNo",defaultValue = AppConstants.DEFAULT_PAGE_NUMBER,required = false) int pageNo,
           @RequestParam(value="pageSize",defaultValue = AppConstants.DEFAULT_PAGE_SIZE,required = false) int pageSize,
           @RequestParam(value="sortBy",defaultValue = AppConstants.DEFAULT_SORT_BY,required = false) String sortBy,
           @RequestParam(value="sortDir",defaultValue = AppConstants.DEFAULT_SORT_DIRECTION,required = false) String sortDir,
           Model model){
        ResultResponse result = userService.getAllUsers(pageNo, pageSize, sortBy, sortDir);
        List<UserDto> users = (List<UserDto>) result.getContent();
        model.addAttribute("users",users);
        model.addAttribute("result",result);
        model.addAttribute("url","../");
        return "admin/list-user";
    }

    @GetMapping("/users/create")
    public String ShowAddUserView(Model model){
        model.addAttribute("url","../../");
        List<RoleEntity> list = userService.getRoles();
        model.addAttribute("roles",list);
        return "admin/add-user";
    }

    @PostMapping("/users/create")
    public String AddUser(Model model, @ModelAttribute UserRequest user){
        UserDto userDto1 = userService.createUser(user);
//        model.addAttribute("url","../");
        return "redirect:/admin/users";
    }

    @GetMapping("/users/{id}")
    public String getUserById(Model model, @PathVariable("id") Long id){
        UserDto userDto1 = userService.getUserById(id);
        model.addAttribute("url","../../");
        model.addAttribute("user",userDto1);
        List<RoleEntity> list = userService.getRoles();
        model.addAttribute("roles",list);
        return "admin/add-user";
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<String> deleteCate(@PathVariable("id") Long id){
        String result = userService.deleteUser(id);
        return ResponseEntity.ok(result);
    }
}
