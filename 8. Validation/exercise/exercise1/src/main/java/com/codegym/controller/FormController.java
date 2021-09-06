package com.codegym.controller;

import com.codegym.dto.FormDto;
import com.codegym.model.bean.Form;
import com.codegym.model.service.IFormService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FormController {
    @Autowired
    IFormService iFormService;

    @GetMapping(value = {"", "/showCreate"})
    public ModelAndView showCreate() {
        return new ModelAndView("create", "formDto", new FormDto());
    }


    @PostMapping("/create")
    public String create(@Validated @ModelAttribute("formDto") FormDto formDto, BindingResult bindingResult
                               ) {
      if (bindingResult.hasErrors()) {
        return "create";
      }else {
          Form form = new Form();
          BeanUtils.copyProperties(formDto,form);
          iFormService.save(form);
          return "create";
      }
    }

//    public ModelAndView errors() {
//        return new ModelAndView("create", "formDto", new FormDto());
//    }
//    BindingResult mang dữ liệu sang create.html rồi nên không phải gọi lại hàm này ( gọi lại sẽ bị sai )
}
