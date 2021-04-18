package com.sk.ecom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sk.ecom.entity.Product;
import com.sk.ecom.entity.ProductCategory;
import com.sk.ecom.model.ProductModel;
import com.sk.ecom.repo.ProductCategoryRepo;
import com.sk.ecom.repo.ProductRepo;

import lombok.extern.slf4j.Slf4j;



@RestController
@RequestMapping("/api")
@Slf4j
//@CrossOrigin(value="*", maxAge = 3600)
public class ProductController {
	
	@Autowired ProductRepo productRepo;
	
	@Autowired ProductCategoryRepo productCategoryRepo;
	
	@GetMapping("/test")
	public String test() {
		return "Hello";
	}
	
	@GetMapping(value = "/product/{id}", produces = {"application/json" })
	ResponseEntity<Product> getProductById (@PathVariable("id") Integer id){
		log.info("START: ProductController.getProductById, id={}", id);
		Product p = productRepo.findByPid(id);
		if ( p != null) {
			return new ResponseEntity<>(p, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@GetMapping(value = "/product/all", produces = {"application/json" })
	ResponseEntity<List<Product>> getAllProduct () {
		
		List<Product> prodList = productRepo.findAll();
		if (! prodList.isEmpty()) {
			return new ResponseEntity<> (prodList, HttpStatus.OK);
		} else {
			return new ResponseEntity<> (HttpStatus.NOT_FOUND);
		}
		
	}
	
	@PostMapping(value = "/product/add", produces = {"application/json" }, consumes = {"application/json" })
	ResponseEntity<Product> addProduct (@RequestBody ProductModel product) {
		
		
		return null;
	}
	
	@GetMapping(value = "/product/category", produces = {"application/json" })
	ResponseEntity<List<Product>> getProductByCategory (@RequestParam("category") String category){
	//	log.info("START: ProductController.getProductByCategory, category={}", category);
		
		ProductCategory pc = productCategoryRepo.findByCategoryName(category);
		List<Product> prodList = pc.getProducts();
		if (!prodList.isEmpty()) {
			return new ResponseEntity<> (prodList, HttpStatus.OK);
		} else {
			return new ResponseEntity<> (HttpStatus.NOT_FOUND);
		}
	}
	
}
