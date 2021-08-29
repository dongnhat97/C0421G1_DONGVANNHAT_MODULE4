package com.controller;

import com.model.bean.Product;
import com.model.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    IProductService iProductService;
    @GetMapping("")
    public ModelAndView index(ModelAndView modelAndView) {
        modelAndView.addObject("listProduct",iProductService.finAll());
        modelAndView.setViewName("index");
        return modelAndView;
    }
    @GetMapping("/showSave")
    public ModelAndView  showSave(ModelAndView modelAndView , Product product) {
        modelAndView.addObject("product",product);
        modelAndView.setViewName("create");
        return  modelAndView;
    }
    @PostMapping("/save")
    public String save(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("message","Thêm mới thành công");
        iProductService.Save(product);
        return "redirect:/product/";
    }
    @GetMapping("/showEdit/{id}")
    public ModelAndView showUpdate(@PathVariable int id, ModelAndView modelAndView) {
        modelAndView.addObject("product",iProductService.findByID(id));
        modelAndView.setViewName("edit");
        return modelAndView;
    }
    @PostMapping("/edit")
    public String edit(Product product, RedirectAttributes redirectAttributes) {
          iProductService.update(product);
          redirectAttributes.addFlashAttribute("message","cập nhật thành công");
          return "redirect:/product";
    }
    @GetMapping("/showID/{id}")
    public  ModelAndView showID(@PathVariable int id, ModelAndView modelAndView) {
        modelAndView.addObject("product",iProductService.findByID(id));
        modelAndView.setViewName("view");
        return modelAndView;
    }
    @GetMapping("/showDelete/{id}")
    public ModelAndView showDelete(@PathVariable int id, ModelAndView modelAndView) {
        modelAndView.addObject("product",iProductService.findByID(id));
        modelAndView.setViewName("delete");
        return modelAndView;
    }
    @PostMapping("/delete")
    public String delete(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        iProductService.delete(product.getId());
        redirectAttributes.addFlashAttribute("message","xoa thanh cong");
        return "redirect:/product";
    }
    @PostMapping("/search")
    public  ModelAndView search(@RequestParam String name, ModelAndView modelAndView) {

       modelAndView.addObject("product",iProductService.search(name));
       modelAndView.setViewName("search");
       return modelAndView;
    }
}
