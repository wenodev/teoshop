package com.demo.demo0617.shopadmin.controller;

import com.demo.demo0617.common.domain.Product;
import com.demo.demo0617.common.dto.ProductDto;
import com.demo.demo0617.shopadmin.service.CategoryService;
import com.demo.demo0617.shopadmin.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Controller
public class AdminProductController {

    private ProductService productService;
    private CategoryService categoryService;

    // 상품 관리 페이지
    @GetMapping("/admin/product-list")
    public String productList(Model model) {
        List<Product> productList = productService.findAll();
        model.addAttribute("productList", productList);
        model.addAttribute("categoryList", categoryService.findAll());

        return "/admin/product-list";
    }

    //상품 등록
    // String = CategoryId , Object = ProductDto
    @PostMapping("/admin/product-list")
    @ResponseBody
    public Map<String, Object> saveProduct(@RequestBody Map<String, Object> productDtoIntegerMap) {

//        productService.saveProduct(productDtoIntegerMap);

        for (Map.Entry<String, Object> entry : productDtoIntegerMap.entrySet()){
            System.out.println("KEY : " + entry.getKey());
            System.out.println("VALUE : " + entry.getValue());
        }

        Long categoryId = Long.valueOf((String) productDtoIntegerMap.get("categoryId"));
        System.out.println(categoryId);

        System.out.println(productDtoIntegerMap.get("productDto"));
        System.out.println(productDtoIntegerMap.get("productDto"));





        return productDtoIntegerMap;
    }

}
