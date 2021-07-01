package com.luv2code.ecommerce.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name="product")
@Data
public class Product {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "category_id", nullable = false)
	private ProductCategory category;

	@Column
	private String sku;

	@Column
	private String name;

	@Column
	private String description;

	@Column(name="unit_price")
	private BigDecimal unitPrice;

	@Column(name="image_url")
	private String imageUrl;

	@Column
	private boolean active;

	@Column(name="units_in_stock")
	private int unitsInStock;

	@Column(name="date_created")
	@CreationTimestamp
	private Date dateCreated;

	@Column(name="last_updated")
	@UpdateTimestamp
	private Date lastUpdated;
}