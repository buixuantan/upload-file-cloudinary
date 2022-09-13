package com.cg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/products")
public class HomeController {

    @GetMapping
    public ModelAndView productPage() {
        return new ModelAndView("dashboard/list_products");
    }
}
