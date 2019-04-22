package com.example.demo4.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class ProductDTO {
	private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private List<ProductDetail> details;
    private Date createdAt;
    private Date updatedAt;
}