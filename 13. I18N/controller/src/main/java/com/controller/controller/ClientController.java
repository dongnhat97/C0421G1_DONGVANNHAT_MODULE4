package com.controller.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClientController {
    @GetMapping("")
    public String client() {
        return "index";
    }
    @GetMapping("/login")
    public String login() {
        return "login";
    }
}