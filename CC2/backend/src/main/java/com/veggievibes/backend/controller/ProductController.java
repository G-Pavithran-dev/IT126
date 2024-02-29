package com.veggievibes.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.veggievibes.backend.model.Category;
import com.veggievibes.backend.model.Products;
import com.veggievibes.backend.services.ProductServices;

@RestController
public class ProductController {
    
    @Autowired
    private ProductServices productServices;

    @PostMapping("/addCategory")
    public Category addCategory(@RequestBody Category category) {
        return productServices.saveCategory(category);
    }

    @GetMapping("/getCategories")
    public List<Category> getCategories() {
        return productServices.getCategories();
    }

    @PostMapping("/addProduct")
    public Products addProduct(@RequestBody Products product)
    {
        return productServices.saveProduct(product);
    }

    @GetMapping("/getProducts")
    public List<Products> geProducts() {
        return productServices.getProducts();
    }

    @GetMapping("/getProductsByCategory/{categoryId}")
    public Page<Products> getProductsByCategory(@PathVariable("categoryId") int categoryId, @RequestParam int pageNo, @RequestParam int pageSize) {
        return productServices.getProductsByCategory(categoryId, pageNo, pageSize);
    }

    @GetMapping("/getSortedProductsASC")
    public List<Products> getSortedProducts(@RequestParam String field) {
        return productServices.getSortedProductsASC(field);
    }

    @GetMapping("/getSortedProductsDESC")
    public List<Products> getSortedProductsDESC(@RequestParam String field) {
        return productServices.getSortedProductsDESC(field);
    }
}
