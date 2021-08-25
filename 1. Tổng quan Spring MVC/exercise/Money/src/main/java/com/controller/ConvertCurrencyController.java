package com.controller;


import com.model.service.IConverterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ConvertCurrencyController {
   @Autowired
  private IConverterService iConverterService;
    @GetMapping("/money")
    public String money() {
        return "index";
    }
   @RequestMapping(value = "/money",method = RequestMethod.POST)
    public ModelAndView convertCurrency(@RequestParam("rate") double rate,
                                        @RequestParam("usd") double amount,
                                        ModelAndView modelAndView) {
        double vnd = iConverterService.convert(rate,amount);
        modelAndView.addObject("rate",rate);
         modelAndView.addObject("usd",amount);
         modelAndView.addObject("vnd",vnd);
         modelAndView.setViewName("index");
         return modelAndView;
   }
}
