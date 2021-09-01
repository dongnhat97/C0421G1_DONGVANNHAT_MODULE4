package com.controller.controller;

import com.controller.model.bean.Category;
import com.controller.model.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/category")
public class CateGoryController {
    @Autowired
    ICategoryService iCategoryService;
    @GetMapping("")
    public ModelAndView index(@PageableDefault(value = 1)Pageable pageable) {
        return new ModelAndView("indexCategory","pageCategory",iCategoryService.finAll(pageable));
    }
    @GetMapping("/showCreate")
    public ModelAndView showCreate() {
        return new ModelAndView("categoryCreate","category",new Category());
    }
   @PostMapping("/create")
    public String create(@ModelAttribute Category category, RedirectAttributes redirectAttributes) {
        iCategoryService.save(category);
        redirectAttributes.addFlashAttribute("them moi thanh cong");
        return "redirect:/category";
   }
   @GetMapping("/showUpdate/{id}")
    public ModelAndView showUpdate(@PathVariable int id) {
        return new ModelAndView("categoryUpdate","category",iCategoryService.finById(id));
   }
   @PostMapping("/update")
    public String update(@ModelAttribute Category category) {
        iCategoryService.save(category);
        return "redirect:/category";
   }
   @GetMapping("/showDelete/{id}")
    public ModelAndView showDelete(@PathVariable int id) {
        return new ModelAndView("categoryDelete","category",iCategoryService.finById(id));
   }
   @PostMapping("/delete")
    public String delete(@ModelAttribute Category category) {
        iCategoryService.delete(category.getId());
        return "redirect:/category";
   }
}
