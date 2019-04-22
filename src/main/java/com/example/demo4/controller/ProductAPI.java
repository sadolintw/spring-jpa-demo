package com.example.demo4.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo4.dto.Product;
import com.example.demo4.dto.ProductDTO;
import com.example.demo4.dto.ProductDetail;
import com.example.demo4.dto.ProductDetailDTO;
import com.example.demo4.mapper.ProductDetailMapper;
import com.example.demo4.mapper.ProductMapper;
import com.example.demo4.service.ProductDetailService;
import com.example.demo4.service.ProductService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/products")
public class ProductAPI {
    @Autowired
	ProductService productService;
    
    @Autowired
    ProductDetailService productDetailService;
    
    @Autowired
    ProductMapper productMapper;
    
    @Autowired
    ProductDetailMapper productDetailMapper;

    @GetMapping
    public ResponseEntity<List<ProductDTO>> findAll() {
        return ResponseEntity.ok(productMapper.toProductDTOs(productService.findAll()));
    }

    @PostMapping
    public ResponseEntity<ProductDTO> create(@RequestBody ProductDTO productDTO) {
    	Product temp = productService.save(productMapper.toProduct(productDTO));

        return ResponseEntity.status(HttpStatus.CREATED).body(productMapper.toProductDTO(temp));
    }

    @PostMapping("/detail")
    public ResponseEntity<ProductDetailDTO> createDetail(@RequestBody ProductDetailDTO productDetailDTO){
    	ProductDetail temp = productDetailService.save(productDetailMapper.toProductDetail(productDetailDTO));

    	return ResponseEntity.status(HttpStatus.CREATED).body(productDetailMapper.toProductDetailDTO(temp));
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> findById(@PathVariable Long id) {
        Optional<Product> product = productService.findById(id);

        return ResponseEntity.ok(productMapper.toProductDTO(product.get()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> update(@PathVariable Long id, @RequestBody ProductDTO productDTO) {
        Product product = productMapper.toProduct(productDTO);
        product.setId(id);

        productService.save(product);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(productDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        productService.deleteById(id);

        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
}