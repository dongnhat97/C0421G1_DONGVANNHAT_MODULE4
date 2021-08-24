package com.controller;

import com.model.bean.Email;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmailController {
    @RequestMapping("/")
     public ModelAndView index() {
        return new ModelAndView("index","email",new Email());
    }
    @RequestMapping("save")
    public ModelAndView save(@ModelAttribute("email") Email email) {
           return new ModelAndView("result");
    }
}
