package com.controller;

import com.model.service.ICalculateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControllerCalculate {
    @Autowired
    ICalculateService iCalculateService;
    @RequestMapping(value = "/")
    public String index() {
        return "index";
    }

    @RequestMapping( value = "calculate",method = RequestMethod.POST)
    public ModelAndView calculate(@RequestParam("a") double a,@RequestParam("b") double b,
                                  @RequestParam("operator") String operator, ModelAndView modelAndView) {
        modelAndView.addObject("a",a);
        modelAndView.addObject("b",b);
        modelAndView.addObject("result",iCalculateService.calculate(a,b,operator));

        modelAndView.setViewName("index");
        return modelAndView;
    }
}
