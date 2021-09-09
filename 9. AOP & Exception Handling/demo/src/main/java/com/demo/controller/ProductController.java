package com.demo.controller;

import com.demo.cartDto.CartDto;
import com.demo.model.service.IProductService;
import com.demo.model.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@SessionAttributes("cart")
@Controller
@RequestMapping(value = "/shop")
public class ProductController {
  @Autowired
  IProductService iProductService;
  @ModelAttribute("cart")
    public CartDto initCart() {
         return new CartDto();
  }
  @GetMapping
    public ModelAndView showList(@CookieValue(value = "idProduct",defaultValue = "-1") Long idProduct, Model model) {
      if (idProduct!=-1){
          model.addAttribute("historyProduct",iProductService.findById(idProduct));
      }else {

      }

  }
}
