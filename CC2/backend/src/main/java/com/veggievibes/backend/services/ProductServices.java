package com.veggievibes.backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.veggievibes.backend.model.Category;
import com.veggievibes.backend.model.Products;
import com.veggievibes.backend.repository.CategoryRepo;
import com.veggievibes.backend.repository.ProductRepo;

@Service
public class ProductServices {
    
    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private ProductRepo productRepo;

    public Category saveCategory(Category category) {
        return categoryRepo.save(category);
    }

    public List<Category> getCategories() {
        return categoryRepo.findAll();
    }

    public Products saveProduct(Products product)
    {
        return productRepo.save(product);
    }

    public List<Products> getProducts()
    {
        return productRepo.findAll();
    }

    public Page<Products> getProductsByCategory(int categoryId, int pageNo, int pageSize) {
        return productRepo.findProductsByCategoryId(categoryId,PageRequest.of(pageNo, pageSize));
    }

    public List<Products> getSortedProductsASC(String field) {
        return productRepo.findAll(Sort.by(Sort.Direction.ASC, field));
    }
    public List<Products> getSortedProductsDESC(String field) {
        return productRepo.findAll(Sort.by(Sort.Direction.DESC, field));
    }
}
