package com.sk.ecom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sk.ecom.entity.Product;
import com.sk.ecom.model.CategoryModel;
import com.sk.ecom.model.ProductPageModel;
import com.sk.ecom.repo.ProductCategoryRepo;
import com.sk.ecom.repo.ProductRepo;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired private ProductCategoryRepo productCategoryRepo;
	@Autowired private ProductRepo productRepo;

	@Override
	public ProductPageModel getAllProduct() {
		
		List<String> allCategory = productCategoryRepo.getAllCategory();
		List<Product> prodList = productRepo.findAll();
		
		return ProductPageModel.builder()
				.categories(allCategory)
				.products(prodList).build();
	}
	

}
