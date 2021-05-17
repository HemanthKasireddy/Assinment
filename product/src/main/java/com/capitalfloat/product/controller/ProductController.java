package com.capitalfloat.product.controller;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capitalfloat.product.dto.ProductDto;
import com.capitalfloat.product.dto.ResponseDto;
import com.capitalfloat.product.service.IProductService;
@RestController
@RequestMapping(value="/product")
public class ProductController {
	
	private  IProductService productService;
	
	@Autowired
	public ProductController( IProductService accountService) {
		this.productService=accountService;
	}
	@PostMapping(value="/addProduct",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseDto addProduct(@RequestBody ProductDto productDto) throws ParseException {
		ResponseDto dto=productService.addProduct(productDto);
		return dto;
	}

	@GetMapping(value="/getAllProductDetails",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseDto getAllProductDetails() throws ParseException {
		ResponseDto dto=productService.getAllProductDetails();
		return dto;
	}
	
}
