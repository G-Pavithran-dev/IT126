package com.veggievibes.backend.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.veggievibes.backend.model.Products;

@Repository
public interface ProductRepo extends JpaRepository<Products, Integer>{
    @Query("SELECT p FROM Products p WHERE p.category.categoryId = ?1")
    Page<Products> findProductsByCategoryId(int categoryId, Pageable pageable);
}
