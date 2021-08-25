package com.controller;

import com.model.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class Dictionary {
    @Autowired
   private IDictionaryService iDictionaryService;
    @GetMapping("/translate")
    public String index() {
        return "index";
    }
    @RequestMapping(value = "/search",method = RequestMethod.POST)
    public ModelAndView translate(@RequestParam("english") String english) {
        ModelAndView modelAndView= new ModelAndView("index");
        String result = iDictionaryService.translate(english);
        modelAndView.addObject("english",english);
        modelAndView.addObject("result",result);
        return modelAndView;
    }


}
