package com.controller.controller;

import com.controller.model.bean.Block;
import com.controller.model.service.IBlockService;
import com.controller.model.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/block")
public class BlogController {
    @Autowired
   private IBlockService iBlockService;
    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/list")
    public ModelAndView page(@PageableDefault(value = 1,sort = "startTime",direction = Sort.Direction.ASC)Pageable pageable) {
        return new ModelAndView("index","blogPage",iBlockService.finAll(pageable));
    }

    @GetMapping("/showCreate")
    public ModelAndView showCreate(ModelAndView modelAndView) {
        modelAndView.setViewName("create");
        modelAndView.addObject("block",new Block());
        modelAndView.addObject("listCategory",iCategoryService.finAll());
        return modelAndView;
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Block block , RedirectAttributes redirectAttributes) {
            iBlockService.save(block);
            redirectAttributes.addFlashAttribute("message","them moi thanh cong");
            return "redirect:/block/list";
    }

    @GetMapping("/showUpdate/{id}")
    public ModelAndView showUpdate(@PathVariable long id, ModelAndView modelAndView) {
        modelAndView.addObject("listCategory",iCategoryService.finAll());
        modelAndView.addObject("block",iBlockService.findById(id));
        modelAndView.setViewName("update");
        return modelAndView;
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Block block, RedirectAttributes redirectAttributes) {
        iBlockService.save(block);
        redirectAttributes.addFlashAttribute("message","cap nhat moi thanh cong");
        return "redirect:/block/list";
    }

    @GetMapping("/showDelete/{id}")
    public ModelAndView showDelete(@PathVariable long id) {
        return  new ModelAndView("delete","block",iBlockService.findById(id));
    }

    @PostMapping("/delete")
    public String delete(@ModelAttribute Block block, RedirectAttributes redirectAttributes) {
        iBlockService.delete(block.getId());
        redirectAttributes.addFlashAttribute("message","xoa moi thanh cong");
        return "redirect:/block/list";
    }

    @GetMapping("/view/{id}")
    public ModelAndView  view (@PathVariable long id) {
        return new ModelAndView("views","block",iBlockService.findById(id));
    }
    @GetMapping("/search")
    public ModelAndView search(@PageableDefault(value = 3)Pageable pageable,@RequestParam String name,ModelAndView modelAndView) {
          modelAndView.addObject("blogPage",iBlockService.findByBlockName(pageable,name));
          modelAndView.setViewName("search");
          return modelAndView;
    }
    
}
