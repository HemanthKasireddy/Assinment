package com.capitalfloat.product.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@Builder
public class ProductDto {


	@Getter
	@Setter
	@NonNull
	private Long productId;	


	@Getter
	@Setter
	@NonNull
	private Long userId;	


	@Getter
	@Setter
	@NonNull
	private String productName;

	@Getter
	@Setter
	@NonNull
	private Integer productQuantity;

	@Getter
	@Setter
	@NonNull
	private Double productPrice;


	@Getter
	@Setter
	private Long offerId;

	@Getter
	@Setter
	private Double finalPrice;

	@Getter
	@Setter
	private Double totalCartPrice;

	//user id // name, prod price
}
