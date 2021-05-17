package com.capitalfloat.product.utility;

import java.text.ParseException;

import org.modelmapper.ModelMapper;

import com.capitalfloat.product.dto.ProductDto;
import com.capitalfloat.product.model.Product;


public class Utill {
    private static ModelMapper modelMapper = new ModelMapper();
    
    public static Product convertToEntity(ProductDto userDto) throws ParseException {
    
        return modelMapper.map(userDto, Product.class);
    }
    
    public static ProductDto convertToDto(Product product) throws ParseException {
    
        return modelMapper.map(product, ProductDto.class);
    }
}
