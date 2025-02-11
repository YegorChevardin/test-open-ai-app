package com.example.openai.test.testOpenAiApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
    @GetMapping
    public String viewHomePage() {
        return "home";
    }

    @PostMapping
    public String handlePromptRequest() {
        return "home";
    }
}
