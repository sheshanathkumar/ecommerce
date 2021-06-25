package com.sk.ecom.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sk.ecom.entity.Product;
import com.sk.ecom.util.EcomConstant;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer>{
	
	Product findByPid (int id);
	
	@Query(value = "select * from product where category_id= ?", nativeQuery = true)
	List<Product> findByCategoryId (int id);
	
	List<Product> findByNameContains (String name);
	
	@Query(value = EcomConstant.SEARCH_PRODUCT, nativeQuery = true)
	List<Product>  findProduct (String name, String descr);

	
}
