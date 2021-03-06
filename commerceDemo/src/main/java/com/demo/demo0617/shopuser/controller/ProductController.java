package com.demo.demo0617.shopuser.controller;

import com.demo.demo0617.common.domain.Product;
import com.demo.demo0617.common.dto.ProductDto;
import com.demo.demo0617.shopadmin.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@AllArgsConstructor
@Controller
public class ProductController {

    private ProductService productService;

    @GetMapping(value = {"/", "/index"})
    public String index(Model model) {
        List<Product> productList = productService.findAll();
        model.addAttribute("productList", productList);
        return "/customer/index";
    }

    @GetMapping("/product/{id}")
    public String productById(Model model, @PathVariable Long id) {
        ProductDto productDto = productService.findById(id);
        model.addAttribute("product", productDto);
        return "/customer/product";
    }

}
