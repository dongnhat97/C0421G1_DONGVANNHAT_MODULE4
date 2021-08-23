package com.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@org.springframework.stereotype.Controller
public class Controller {
    @RequestMapping("/")
    public String index() {
        return "index";
    }
   @RequestMapping(value = "save",method = RequestMethod.POST)
    public ModelAndView save(@RequestParam(value = "condiment",required = false) String[] condiment,  ModelAndView modelAndView){
        modelAndView.setViewName("index");
        modelAndView.addObject("message","vui long chon gia vi");
        modelAndView.addObject("save",condiment);
        return modelAndView;
   }
}
