package com.capitalfloat.product.service;



import java.text.ParseException;

import org.springframework.stereotype.Service;

import com.capitalfloat.product.dto.ProductDto;
import com.capitalfloat.product.dto.ResponseDto;


@Service
public interface IProductService {
	
	

	public ResponseDto getAllProductDetails() throws ParseException;

	public ResponseDto addProduct(ProductDto productDto);

}
