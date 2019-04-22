package com.example.demo4.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.example.demo4.dto.Product;
import com.example.demo4.dto.ProductDTO;


@Mapper
public interface ProductMapper {
    ProductDTO toProductDTO(Product product);

    List<ProductDTO> toProductDTOs(List<Product> products);

    Product toProduct(ProductDTO productDTO);
}