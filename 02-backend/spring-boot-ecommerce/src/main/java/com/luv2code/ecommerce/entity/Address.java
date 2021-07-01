package com.luv2code.ecommerce.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table
@Getter
@Setter
public class Address {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column
	private Long id;

	@Column
	private String street;

	@Column
	private String city;

	@Column
	private String state;

	@Column
	private String country;

	@Column(name="zip_code")
	private String zipCode;

	@OneToOne
	@PrimaryKeyJoinColumn
	private Order order;
}

