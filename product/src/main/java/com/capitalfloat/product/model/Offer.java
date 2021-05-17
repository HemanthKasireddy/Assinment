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
@Table(name="OfferDetails")
public class Offer {

@Id
@GeneratedValue
@Getter
private Long id; 

@Getter
@Setter
@NonNull
@Column(name="offerName")
private String offerName;

@Getter
@Setter
@NonNull
@Column(name="conditionQuantity")
private Integer conditionQuantiy;

@Getter
@Setter
@NonNull
@Column(name="offerType")
private String offerType;

@Getter
@Setter
@NonNull
@Column(name="benfit")
private Integer benfit;

@Getter
@Setter
@NonNull
@Column(name="status")
private String status;

}
