package com.controller.controller;

import com.controller.dto.ContractDto;
import com.controller.model.entity.Contract;
import com.controller.model.service.IContractService;
import com.controller.model.service.ICustomerService;
import com.controller.model.service.IEmployeeService;
import com.controller.model.service.IService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    private IContractService icontractService;
    @Autowired
    private IEmployeeService iEmployeeService;
    @Autowired
    private IService iService;
    @Autowired
    private ICustomerService iCustomerService;

    @GetMapping("/list")
    public String list(@PageableDefault(value = 1) Pageable pageable, Model model) {
        model.addAttribute("contract",icontractService.findAll(pageable));
        return "contractList";
    }
    @GetMapping("/showCreate")
    public String showCreate(Model model) {
        model.addAttribute("customer",iCustomerService.findAll());
        model.addAttribute("employee",iEmployeeService.findAll());
        model.addAttribute("service",iService.findAll());
        model.addAttribute("contractDto",new ContractDto());
        return "contractCreate";
    }
    @PostMapping("create")
    public String create(@Validated @ModelAttribute ContractDto contractDto, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("customer",iCustomerService.findAll());
            model.addAttribute("employee",iEmployeeService.findAll());
            model.addAttribute("service",iService.findAll());
            return "contractCreate";
        }else {
            Contract contract = new Contract();
            BeanUtils.copyProperties(contractDto,contract);
            icontractService.save(contract);
            redirectAttributes.addFlashAttribute("message","Thêm mới thành công ");
            return "redirect:/contract/list";
        }
    }
}
