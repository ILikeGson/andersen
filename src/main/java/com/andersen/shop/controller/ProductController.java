package com.andersen.shop.controller;

import com.andersen.shop.Product;
import com.andersen.shop.service.ProductService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.text.DateFormat;
import java.text.spi.DateFormatProvider;
import java.text.spi.DateFormatSymbolsProvider;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping()
    public String getPage(Model model) {
        model.addAttribute("products", productService.getAll());
        return "index";
    }

    @GetMapping("/add")
    public String getAddProductPage() {
        return "addProductForm";
    }

    @PostMapping("/add")
    public String addProduct(@RequestParam("price") int price,
                             @RequestParam("name") String name,
                             @RequestParam("description") String description,
                             @RequestParam("created") String createdDate,
                             @RequestParam("expired") String expired,
                             Model model) {
        productService.add(new Product(price, name, description, convert(createdDate), convert(expired)));
        model.addAttribute("products" ,productService.getAll());
        return "redirect:/products";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") int id, Model model) {
        productService.deleteById(id);
        model.addAttribute("products" ,productService.getAll());
        return "redirect:/products";
    }

    private LocalDate convert(String s) {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(s, fmt);
    }
}
