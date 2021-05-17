package com.capitalfloat.product.service;

import java.text.ParseException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capitalfloat.product.dao.IProductDAO;
import com.capitalfloat.product.dto.ProductDto;
import com.capitalfloat.product.dto.ResponseDto;
import com.capitalfloat.product.model.Offer;
import com.capitalfloat.product.model.Product;
import com.capitalfloat.product.utility.OffersType;
import com.capitalfloat.product.utility.Utill;

@Service
public class ProductServiceImpl implements IProductService {
	
	private  IProductDAO productDAO;


	@Autowired
	public ProductServiceImpl(final IProductDAO productDAO ) {
		this.productDAO=productDAO;
	}

	@Override
	public ResponseDto addProduct( ProductDto productDto) {
		try {
			//userDto

			/*Integer userId=productDAO.getUser(productDto.getUserId());
			if(Objects.isNull(userId) || userId<0) {
				return ResponseDto.builder()
						.staus("Error")
						.message("User not found")
						.build();

			}*/

			Offer offer=productDAO.getOffer(productDto.getOfferId());
			if(Objects.isNull(offer)) {
				return ResponseDto.builder()
						.staus("Error")
						.message("Offer is Invalid")
						.build();

			}
			if(offer.getStatus().equals("false")) {
				return ResponseDto.builder()
						.staus("Error")
						.message("Offer was expired")
						.build();

			}
			if(productDto.getProductQuantity() < offer.getConditionQuantiy()) {
				return ResponseDto.builder()
						.staus("Error")
						.message("Offer is not applicable")
						.build();
			}

			ProductDto newProduct=	applyOffer(productDto,offer);
			Product productEntity=Utill.convertToEntity(newProduct);



			Long id=productDAO.saveProduct(productEntity);
			if(Objects.isNull(id)&& id<=0) {
				return ResponseDto.builder()
						.staus("Error")
						.message("Product is not added")
						.build();

			}
			//	System.out.println();
			return ResponseDto.builder()
					.staus("ok")
					.message("Product added successfully")
					.build();	
		}catch(Exception e) {
			e.printStackTrace();
		}
		return ResponseDto.builder()
				.staus("error")
				.build();

	}

	private ProductDto applyOffer(ProductDto productDto, Offer offer) {

		OffersType offerType=	OffersType.valueOf(offer.getOfferType());
		Double finalPrice=productDto.getProductPrice();
		switch(offerType) {
		case DISCOUNT:
			finalPrice=((100-offer.getBenfit())*productDto.getProductPrice())/100;
			productDto.setFinalPrice(finalPrice);
			break;
		case FLAT: 		 finalPrice=productDto.getProductPrice()-offer.getBenfit();
		productDto.setFinalPrice(finalPrice);
		break;
		case EXTRA: 	productDto.setFinalPrice(finalPrice);
		productDto.setProductQuantity(productDto.getProductQuantity()+offer.getBenfit());
		break;
		default:	productDto.setFinalPrice(finalPrice);
		}
		return productDto;
	}

	@Override
	public ResponseDto getAllProductDetails() throws ParseException  {
		try {
			
			List<Product> poductList=productDAO.getProducts();
			if(Objects.isNull(poductList)) {
				return ResponseDto.builder()
						.staus("ERROR")
						.message("Products not found")
						.build();
			}
		List<ProductDto> productDtos=	poductList.stream().map(t -> {
				try {
					return Utill.convertToDto(t);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				return null;
			}).collect(Collectors.toList());
		
		Double totalActualAmount=productDtos.stream().collect(Collectors.summingDouble(ProductDto::getFinalPrice));
		Double totalAmount=productDtos.stream().collect(Collectors.summingDouble(ProductDto::getProductPrice));

			return ResponseDto.builder()
					.staus("OK")
					.totalAmount(totalAmount)
					.totalActualAmount(totalActualAmount)
					.product(productDtos)
					.build();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseDto.builder()
				.staus("error")
				.build();
	}



}
