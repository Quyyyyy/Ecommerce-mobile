package org.example.webdt.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.webdt.dto.request.RegisterRequest;
import org.example.webdt.entities.UserEntity;
import org.example.webdt.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {
    private UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/login")
    public String showLoginForm(HttpServletRequest request, HttpServletResponse response,Model model){
        model.addAttribute("url","../../");
        return "user/login";
    }

    @GetMapping("/register")
    public String showSignupForm(Model model){
        model.addAttribute("url","../../");
        return "user/sign-up";
    }

    @PostMapping("/register")
    public String registration(@ModelAttribute RegisterRequest userDto,
                               BindingResult result, Model model){
        UserEntity existingUser = userService.findByUsernameOrEmail(userDto.getUsername(),userDto.getEmail());
        if(existingUser != null && existingUser.getEmail() != null && !existingUser.getEmail().isEmpty()){
            result.rejectValue("email",null,
                    "There is already an account registered with the same email");
        }

        if(result.hasErrors()){
            model.addAttribute("user",userDto);
            return "redirect:/register";
        }
        userService.register(userDto);
        return "redirect:/register?success";
    }
}
