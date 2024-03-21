package com.example.demo.controllers;

import com.example.demo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;
import com.example.demo.domain.Product;
import java.util.Optional;

@Controller
public class BuyNowController {

    @Autowired
    private ProductRepository productRepository;

    @PostMapping("/buynow")
    public String buynow(@RequestParam Long productID) {
        Optional<Product> optProd = productRepository.findById(productID);
        if (optProd.isPresent()) {
            Product prod = optProd.get();
            if (prod.getInv() > 0) {
                prod.setInv(prod.getInv() - 1);
                productRepository.save(prod);
                return "redirect:/buynow";
            } else {
                return "redirect:/buynowerror";
            }
        } else {
            return "redirect:/buynowerror";
        }
    }

    @GetMapping("/buynow")
    public String buynow() {
        return "buynow";
    }

    @GetMapping("/buynowerror")
    public String buynowerror() {
        return "buynowerror";
    }
}