package com.controller.controller;

import com.controller.dto.CustomerDto;
import com.controller.model.entity.Customer;
import com.controller.model.service.ICustomerService;
import com.controller.model.service.ICustomerTypeService;
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
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    ICustomerService iCustomerService;
    @Autowired
    ICustomerTypeService iCustomerTypeService;
    @GetMapping("/list")
    public ModelAndView index (@PageableDefault(value = 2) Pageable pageable) {
        return new ModelAndView("customerList","customerList",iCustomerService.findAll(pageable));

    }
    @GetMapping("/showUpdate/{customerId}")
    public String showUpdate(@PathVariable Integer customerId,Model model ) {
        Customer customer=iCustomerService.findById(customerId);
        model.addAttribute("customer",customer);
        model.addAttribute("customerType",iCustomerTypeService.findAll());
        return "customerUpdate";
    }
    @GetMapping("/showCreate")
    public String showCreate(Model model) {
         model.addAttribute("customerDto",new CustomerDto());
         model.addAttribute("customerType",iCustomerTypeService.findAll());
         return "customerCreate";
    }
    @PostMapping("/update")
    public String update(@ModelAttribute Customer customer, RedirectAttributes redirectAttributes) {
        iCustomerService.save(customer);
        redirectAttributes.addFlashAttribute("message","Update thành công");
        return "redirect:/customer/list";
    }
    @PostMapping("/create")
    public String create(@Validated @ModelAttribute CustomerDto customerDto, BindingResult bindingResult, RedirectAttributes redirectAttributes,Model model) {
        if (bindingResult.hasErrors()){
            model.addAttribute("customerType",iCustomerTypeService.findAll());
            return "customerCreate";
        }else {
            Customer customer1 = new Customer();
            BeanUtils.copyProperties(customerDto,customer1);
            iCustomerService.save(customer1);
            redirectAttributes.addFlashAttribute("message","Thêm mới thành công");
            return "redirect:/customer/list";
        }

    }
    @PostMapping("/delete")
    public String delete(@RequestParam(value = "id") int id,RedirectAttributes redirectAttributes) {
          iCustomerService.delete(id);
          redirectAttributes.addFlashAttribute("message","Xóa thành công");
          return "redirect:/customer/list";
    }
    @GetMapping("/view/{id}")
    public ModelAndView view (@PathVariable int id){
        Customer customer = iCustomerService.findById(id);
        return new ModelAndView("view","customer",customer);
    }
    @PostMapping("/search")
    public ModelAndView search(@PageableDefault(value = 2) Pageable pageable,@RequestParam(value = "name") String name) {
         return new ModelAndView("search","customerList",iCustomerService.findAllByCustomerNameContaining(name,pageable));
    }

}
