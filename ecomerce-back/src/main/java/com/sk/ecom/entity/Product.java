package com.sk.ecom.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


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
	@Column(name = "id")
	private Integer pid;

	private int active;

	@Column(name="date_created")
	private Timestamp dateCreated;

	@Column(name="description")
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