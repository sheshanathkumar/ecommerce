package com.sk.ecom.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ProductModel {

	@JsonProperty("active")
	private Boolean active;

	@JsonProperty("date_created")
	private Timestamp dateCreated;

	@JsonProperty("description")
	private String description;

	@JsonProperty("image_url")
	private String imageUrl;

	@JsonProperty("last_updated")
	private Timestamp lastUpdated;

	@JsonProperty("name")
	private String name;

	@JsonProperty("sku")
	private String sku;

	@JsonProperty("unit_price")
	private BigDecimal unitPrice;

	@JsonProperty("units_in_stock")
	private Integer unitsInStock;
	
	@JsonProperty("category")
	private String category;

}
