package com.example.openai.test.testOpenAiApp.controllers;

import com.example.openai.test.testOpenAiApp.service.OpenAiService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class HomeController {
    private final OpenAiService openAiService;

    @GetMapping
    public String viewHomePage() {
        return "home";
    }

    @PostMapping("request")
    public String handlePromptRequest(@RequestParam("language") String language, Model model) {
        var response = openAiService.getPromptResponse(language);
        model.addAttribute("response", response);
        return "home";
    }
}
