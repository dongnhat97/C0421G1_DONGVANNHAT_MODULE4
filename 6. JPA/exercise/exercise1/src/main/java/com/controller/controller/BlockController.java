package com.controller.controller;

import com.controller.model.bean.Block;
import com.controller.model.service.IBlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/block")
public class BlockController {
    @Autowired
   private IBlockService iBlockService;
    @GetMapping("/list")
    public ModelAndView index() {
        return new ModelAndView("index","listBlock",iBlockService.finAll());
    }

    @GetMapping("/showCreate")
    public ModelAndView showCreate() {
        return new ModelAndView("create","block",new Block());
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Block block , RedirectAttributes redirectAttributes) {
            iBlockService.save(block);
            redirectAttributes.addFlashAttribute("message","them moi thanh cong");
            return "redirect:/block/list";
    }

    @GetMapping("/showUpdate/{id}")
    public ModelAndView showUpdate(@PathVariable long id) {
        return  new ModelAndView("update","block",iBlockService.findById(id));
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Block block,RedirectAttributes redirectAttributes) {
        iBlockService.save(block);
        redirectAttributes.addFlashAttribute("message","cap nhat moi thanh cong");
        return "redirect:/block/list";
    }

    @GetMapping("/showDelete/{id}")
    public ModelAndView showDelete(@PathVariable long id) {
        return  new ModelAndView("delete","block",iBlockService.findById(id));
    }

    @PostMapping("/delete")
    public String delete(@ModelAttribute Block block,RedirectAttributes redirectAttributes) {
        iBlockService.delete(block.getId());
        redirectAttributes.addFlashAttribute("message","xoa moi thanh cong");
        return "redirect:/block/list";
    }

    @GetMapping("/view/{id}")
    public ModelAndView  view (@PathVariable long id) {
        return new ModelAndView("views","block",iBlockService.findById(id));
    }

    
}
