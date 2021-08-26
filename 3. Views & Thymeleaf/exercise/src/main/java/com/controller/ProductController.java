package com.controller;

import com.model.bean.Product;
import com.model.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/product")
public class ProductController {
//    Show list
    @Autowired
    private IProductService iProductService;
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public ModelAndView index(ModelAndView modelAndView) {
         modelAndView.addObject("productList",iProductService.findAll());
         modelAndView.setViewName("index");
         return modelAndView;

//    Sang form create
    }
    @RequestMapping(value = "/create",method = RequestMethod.GET)
    public  ModelAndView create(ModelAndView modelAndView) {
        modelAndView.addObject("product",new Product());
        modelAndView.setViewName("create");
        return modelAndView;
    }
//   Create Post
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Product product, RedirectAttributes redirectAttributes) {
        iProductService.save(product);
        redirectAttributes.addFlashAttribute("message","successfully added new");
        return "redirect:/product/";
    }
//    Show Edit
    @GetMapping("/{id}/showEdit")
    public ModelAndView showUpdate(@PathVariable int id,ModelAndView modelAndView) {
            modelAndView.addObject("product",iProductService.finById(id));
            modelAndView.setViewName("edit");
            return modelAndView;
    }
//    Edit
    @PostMapping("/edit")
    public String edit(Product product,RedirectAttributes redirectAttributes) {
       iProductService.update(product);
       redirectAttributes.addFlashAttribute("message","Update thanh cong");
       return "redirect:/product/";
    }
//   Show delete
     @GetMapping("/showDelete/{id}")
    public ModelAndView showDelete(@PathVariable int id,ModelAndView modelAndView) {
         modelAndView.addObject("product",iProductService.finById(id));
         modelAndView.setViewName("delete");
         return modelAndView;
    }
//    delete post
    @PostMapping("/delete")
    public String delete(RedirectAttributes redirectAttributes, Product product){
          iProductService.delete(product.getId());
        redirectAttributes.addFlashAttribute("message","delete thanh cong");
        return "redirect:/product/";
    }
//    search
    @PostMapping("/search")
    public ModelAndView search(ModelAndView modelAndView, String name ) {
        modelAndView.addObject("productList",iProductService.finByName(name));
        modelAndView.setViewName("search");
        return modelAndView;
    }
//    view chi tiết
    @GetMapping("/view/{id}")
    public ModelAndView view(@PathVariable int id, ModelAndView modelAndView ) {
        modelAndView.addObject("product",iProductService.finById(id));
        modelAndView.setViewName("view");
        return modelAndView;
    }
}
