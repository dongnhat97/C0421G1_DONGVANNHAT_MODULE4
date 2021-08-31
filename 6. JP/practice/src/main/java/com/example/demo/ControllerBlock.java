package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControllerBlock {
    @RequestMapping("")
    public ModelAndView  index(ModelAndView modelAndView) {
        return new ModelAndView("index");
    }
}
