package com.capitalfloat.product.dao;

import java.util.List;

import com.capitalfloat.product.model.Offer;
import com.capitalfloat.product.model.Product;

import lombok.NonNull;

public interface IProductDAO  {
	

	public Long saveProduct(final Product userEntit);

	public Offer getOffer(Long offerId);
	
	public List<Product> getProducts();

	Integer getUser(@NonNull Long userId);


}
