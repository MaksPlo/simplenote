package com.spring.simplenote.controller;

import com.spring.simplenote.model.User;
import com.spring.simplenote.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class MainController {

    private final UserService userService;

    @GetMapping
    public String main(Model model, @AuthenticationPrincipal User user) {
        model.addAttribute("frontendData", userService.getUserNotes(user));
        return "index";
    }
}
