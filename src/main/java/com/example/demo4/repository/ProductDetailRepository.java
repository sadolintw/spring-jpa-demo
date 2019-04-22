package com.example.demo4.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo4.dto.ProductDetail;

public interface ProductDetailRepository extends JpaRepository<ProductDetail, Long>{

}
