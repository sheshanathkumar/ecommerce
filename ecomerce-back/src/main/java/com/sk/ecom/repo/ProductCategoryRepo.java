package com.sk.ecom.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sk.ecom.entity.ProductCategory;

@Repository
public interface ProductCategoryRepo extends JpaRepository<ProductCategory, Integer>{

	public ProductCategory findByPcId (int id);
	
	public ProductCategory findByCategoryName (String name);
	
}


