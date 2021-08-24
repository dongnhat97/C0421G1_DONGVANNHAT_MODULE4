package com.controller;

import com.model.bean.People;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FormController {
    @RequestMapping("/")
    public ModelAndView  index() {
        return new ModelAndView("index","people",new People());
    }
}
