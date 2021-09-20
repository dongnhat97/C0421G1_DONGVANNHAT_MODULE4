package com.controller.controller;

import com.controller.dto.ServiceDto;
import com.controller.model.entity.Customer;
import com.controller.model.entity.Service;
import com.controller.model.service.IRenType;
import com.controller.model.service.IService;
import com.controller.model.service.IServiceType;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/service")
public class ServiceController {
    @Autowired
    IService iService;
    @Autowired
    IRenType iRenType;
    @Autowired
    IServiceType iServiceType;
    @GetMapping("/list")
    public String list(@PageableDefault(value = 1) Pageable pageable, Model model) {
        model.addAttribute("serviceList",iService.findAll(pageable));
        return "serviceList";
    }
    @GetMapping("/showUpdate/{serviceId}")
    public String showUpdate(@PathVariable Integer serviceId,Model model ) {
        Service service=iService.findById(serviceId);
        model.addAttribute("service",service);
        model.addAttribute("rentType",iRenType.findAll());
        model.addAttribute("serviceType",iServiceType.findAll());
        return "serviceUpdate";

    }
    @GetMapping("/showCreate")
    public String showCreate(Model model) {
        model.addAttribute("serviceDto",new ServiceDto());
        model.addAttribute("rentType",iRenType.findAll());
        model.addAttribute("serviceType",iServiceType.findAll());
        return "serviceCreate";
    }
    @PostMapping("/update")
    public String update(@ModelAttribute Service service, RedirectAttributes redirectAttributes) {
        iService.save(service);
        redirectAttributes.addFlashAttribute("message","Update thành công");
        return "redirect:/service/list";
    }
    @PostMapping("/create")
    public String create(@Validated @ModelAttribute ServiceDto serviceDto, BindingResult bindingResult, RedirectAttributes redirectAttributes,Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("rentType",iRenType.findAll());
            model.addAttribute("serviceType",iServiceType.findAll());
            return "serviceCreate";
        }else {
            Service service = new Service();
            BeanUtils.copyProperties(serviceDto,service);
            iService.save(service);
            redirectAttributes.addFlashAttribute("message","Thêm mới thành công");
            return "redirect:/service/list";
        }

    }
    @PostMapping("/delete")
    public String delete(@RequestParam(value = "id") int id,RedirectAttributes redirectAttributes) {
        iService.delete(id);
        redirectAttributes.addFlashAttribute("message","Xóa thành công");
        return "redirect:/service/list";
    }
}
