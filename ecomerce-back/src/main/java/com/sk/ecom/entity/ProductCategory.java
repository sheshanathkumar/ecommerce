package com.sk.ecom.entity;

import java.io.Serializable;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


/**
 * The persistent class for the product_category database table.
 * 
 */
@Entity
@Table(name="product_category")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductCategory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="pc_id")
	private Integer pcId;

	@Column(name="category_name")
	private String categoryName;

	//bi-directional many-to-one association to Product
	@OneToMany(mappedBy="productCategory")
	private List<Product> products;
}