package com.controller.controller;

import com.controller.dto.EmployeeDto;
import com.controller.model.entity.Employee;
import com.controller.model.service.IEducationService;
import com.controller.model.service.IEmployeeService;
import com.controller.model.service.IPositionService;
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
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private IEmployeeService iEmployeeService;
    @Autowired
    private IPositionService iPositionService;
    @Autowired
    private IEducationService iEducationService;

    @GetMapping("/list")
    public String employeeList(@PageableDefault(value = 1) Pageable pageable, Model model) {
        model.addAttribute("employeeList",iEmployeeService.findAll(pageable));
        return "employeeList";
    }
    @GetMapping("/showCreate")
    public String showCreate(Model model) {
        model.addAttribute("employeeDto",new EmployeeDto());
        model.addAttribute("position",iPositionService.findAll());
        model.addAttribute("education",iEducationService.findAll());
        return "employeeCreate";
    }
    @PostMapping("/create")
    public String create(@Validated @ModelAttribute EmployeeDto employeeDto, BindingResult bindingResult, RedirectAttributes redirectAttributes,Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("position",iPositionService.findAll());
            model.addAttribute("education",iEducationService.findAll());
            return "employeeCreate";
        }else {
            Employee employee = new Employee();
            BeanUtils.copyProperties(employeeDto,employee);
            iEmployeeService.save(employee);
            redirectAttributes.addFlashAttribute("message","Thêm mới thành công");
            return "redirect:/employee/list";
        }
    }
    @GetMapping("/showUpdate/{id}")
    public String showUpdate(@PathVariable int id,Model model) {
        Employee employee = iEmployeeService.findById(id);
        model.addAttribute("employee",employee);
        model.addAttribute("position",iPositionService.findAll());
        model.addAttribute("education",iEducationService.findAll());
        return "employeeUpdate";
    }
    @PostMapping("/update")
    public String update(@ModelAttribute Employee employee,RedirectAttributes redirectAttributes) {
         iEmployeeService.save(employee);
         redirectAttributes.addFlashAttribute("message","cập nhật thành công");
         return "redirect:/employee/list";
    }
    @PostMapping("/delete")
    public String delete(@RequestParam int id,RedirectAttributes redirectAttributes) {
          iEmployeeService.delete(id);
        redirectAttributes.addFlashAttribute("message","xóa thành công");
        return "redirect:/employee/list";
    }
}
