package com.example.demo4.mapper;

import org.mapstruct.Mapper;

import com.example.demo4.dto.ProductDetail;
import com.example.demo4.dto.ProductDetailDTO;

@Mapper
public interface ProductDetailMapper {
	ProductDetail toProductDetail(ProductDetailDTO producctDetailDTO);
	
	ProductDetailDTO toProductDetailDTO(ProductDetail producctDetail);
	
}
