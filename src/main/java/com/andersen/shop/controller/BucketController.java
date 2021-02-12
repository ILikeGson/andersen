package com.andersen.shop.controller;

import com.andersen.shop.service.BucketService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bucket")
public class BucketController {
    private final BucketService bucketService;

    public BucketController(BucketService bucketService) {
        this.bucketService = bucketService;
    }

    @GetMapping("/{userId}/add/{id}")
    public String addProductToBucket(@PathVariable("userId") int userId, @PathVariable("id") int productId) {
        bucketService.addProductToUserBucketById(userId, productId);
        return "redirect:/bucket/" + userId;
    }

    @GetMapping("/{userId}/delete/{id}")
    public String deleteProductFromBucket(@PathVariable("userId") int userId, @PathVariable("id") int productId) {
        bucketService.removeProductById(userId, productId);
        return "redirect:/bucket/" + userId;
    }

    @GetMapping("/{userId}")
    public String showUserBucket(@PathVariable("userId") int userId, Model model) {
        model.addAttribute("products", bucketService.getAll(userId));
        return "bucket";
    }
}
