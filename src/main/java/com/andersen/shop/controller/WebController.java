package com.andersen.shop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/")
public class WebController {

    @GetMapping
    public String showProducts() {
        return "redirect:/products";
    }

}
