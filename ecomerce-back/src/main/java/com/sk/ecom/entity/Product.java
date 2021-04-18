package com.sk.ecom.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * The persistent class for the product database table.
 * 
 */
@Entity
@Table(name = "product")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer pid;

	private Boolean active;

	@Column(name="date_created")
	private Timestamp dateCreated;

	private String description;

	@Column(name="image_url")
	private String imageUrl;

	@Column(name="last_updated")
	private Timestamp lastUpdated;

	private String name;

	private String sku;

	@Column(name="unit_price")
	private BigDecimal unitPrice;

	@Column(name="units_in_stock")
	private Integer unitsInStock;

	//bi-directional many-to-one association to ProductCategory
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="category_id")
	private ProductCategory productCategory;
}