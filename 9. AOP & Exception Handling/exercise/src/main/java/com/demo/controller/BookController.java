package com.demo.controller;

import com.demo.exception.OutOfNumberException;
import com.demo.exception.WrongCodeException;
import com.demo.model.bean.Book;
import com.demo.model.bean.Code;
import com.demo.model.service.IBookService;
import com.demo.model.service.ICodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class BookController {
    @Autowired
    IBookService iBookService;
    @Autowired
    ICodeService iCodeService;

    @GetMapping("list")
    public ModelAndView index() {
        return new ModelAndView("list", "listBook", iBookService.finAll());
    }

@GetMapping("/showRent/{id}")
public String showCode(@PathVariable("id") int id, Model model) {
    Book book = this.iBookService.findById(id);
    int code = (int) (10000 + (Math.random() * 89999));
    if (book.getCount() > 0) {
        model.addAttribute("book", book);
        model.addAttribute("code", code);
        return "rent";
    } else {
        return "error";
    }
}

    @PostMapping("/rent")
    public String bookRenting(@ModelAttribute("book") Book book, @RequestParam("code") int code, RedirectAttributes attributes) throws OutOfNumberException {
        Code codeRent = new Code();

        if (book.getCount() > 0) {

            book.setCount(book.getCount() - 1);
            this.iBookService.save(book);

            codeRent.setCode(code);
            codeRent.setBook(book);
            this.iCodeService.save(codeRent);
            attributes.addFlashAttribute("message", "Success. Your code is: " + codeRent.getCode());
        } else {
           throw new OutOfNumberException();
        }
        return "redirect:/list";
    }
    @GetMapping("/showPay/{id}")
    public String showPay(@PathVariable int id,Model model) {
        Book book = iBookService.findById(id);
        model.addAttribute("book",book);
        return "pay";
    }
    @PostMapping("/pay")
    public String pay(@RequestParam("code") int code,@ModelAttribute Book book  ){
        boolean isTrueCode = false;
        List<Code> codeList = iCodeService.findAll();
        Code code1 = null;
        for (Code code2 :codeList ) {
            if (code==code2.getCode()) {
                isTrueCode = true;
                code1 = code2;
                break;
            }
        }
        if (isTrueCode) {
            book.setCount(book.getCount()+1);
            iBookService.save(book);
            iCodeService.delete(code1.getCodeId());
        }
        return "redirect:/list";
    }
    @ExceptionHandler(WrongCodeException.class)
    public ModelAndView wrongCodeScreen() {
        return new ModelAndView("wrong-code");
    }

    @ExceptionHandler(OutOfNumberException.class)
    public ModelAndView outOfNumbScreen() {
        return new ModelAndView("out-of-number");
    }
}