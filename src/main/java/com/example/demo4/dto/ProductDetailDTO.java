package com.example.demo4.dto;

import java.util.Date;

import lombok.Data;

@Data
public class ProductDetailDTO {
	
	private Long detailId;
	
	private Long productId;
	
	private String productDetail;
	
    private Date createdAt;

    private Date updatedAt;
}
