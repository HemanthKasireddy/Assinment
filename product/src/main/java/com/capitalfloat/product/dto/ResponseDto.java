package com.capitalfloat.product.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseDto {

@Getter
@Setter
@JsonProperty("status")
private String staus;

@Getter
@Setter
@JsonProperty("message")
private String message;

@Getter
@Setter
@JsonProperty("totalActualAmount")
private Double totalActualAmount;

@Getter
@Setter
@JsonProperty("totalAmount")
private Double totalAmount;

@Getter
@Setter
@JsonProperty("productDetails")
private List<ProductDto> product;



}
