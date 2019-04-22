package com.example.demo4.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo4.dto.ProductDetail;
import com.example.demo4.repository.ProductDetailRepository;

@Service
public class ProductDetailService {
	@Autowired
	ProductDetailRepository productDetailRepository;
	
	public ProductDetail save(ProductDetail detail) {
		return productDetailRepository.save(detail);
		
	}
}
