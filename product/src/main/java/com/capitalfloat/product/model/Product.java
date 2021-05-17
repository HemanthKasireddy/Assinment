package com.capitalfloat.product.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name="ProductDetails")
public class Product {

@Id
@GeneratedValue
@Getter
private Long id; 

@Getter
@Setter
@NonNull
@Column(name="userId")
private Long userId;

@Getter
@Setter
@NonNull
@Column(name="productName")
private String productName;
@Getter
@Setter
@NonNull
@Column(name="productQuantity")
private String productQuantity;

@Getter
@Setter
@NonNull
@Column(name="productPrice")
private Double productPrice;

@Getter
@Setter
@Column(name="offerId")
private Long offerId;

@Getter
@Setter
@Column(name="finalPrice")
private Double finalPrice;
}
