package org.example.webdt.controller.user;

import org.example.webdt.dto.FeedBackDto;
import org.example.webdt.services.FeedBackService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ContactController {
    private FeedBackService feedBackService;

    public ContactController(FeedBackService feedBackService) {
        this.feedBackService = feedBackService;
    }

    @GetMapping("/contact")
    public String contact(Model model){
        String url = "../../";
        model.addAttribute("url",url);
        return "user/intro";
    }


    @PostMapping(value="/contact-us")
    public String createContact(@ModelAttribute FeedBackDto feedBackDto, Model model){
        FeedBackDto feedBackDto1 = feedBackService.createFeed(feedBackDto);
        String url = "../../";
        model.addAttribute("url",url);
        model.addAttribute("mes","Create FeedBack Successfully!!");
        return "user/intro";
    }
}
