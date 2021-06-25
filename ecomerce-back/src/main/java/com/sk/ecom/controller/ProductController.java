package com.sk.ecom.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sk.ecom.entity.Product;
import com.sk.ecom.entity.ProductCategory;
import com.sk.ecom.exception.SearchProductException;
import com.sk.ecom.model.ProductModel;
import com.sk.ecom.model.ProductPageModel;
import com.sk.ecom.repo.ProductCategoryRepo;
import com.sk.ecom.repo.ProductRepo;
import com.sk.ecom.service.ProductService;



@RestController
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-10-10T17:14:38.169Z")
public class ProductController {
	
	private static Logger log = LogManager.getLogger(ProductController.class);
	
	@Autowired ProductRepo productRepo;
	@Autowired ProductCategoryRepo productCategoryRepo;
	@Autowired ProductService productService;
	
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
	ResponseEntity<ProductPageModel> getAllProduct () {
		log.info("START: ProductController.getProduct");
		ProductPageModel productPageModel = productService.getAllProduct();
		
		if (! productPageModel.getProducts().isEmpty()) {
			log.info("END: ProductController.getProduct");
			return new ResponseEntity<> (productPageModel, HttpStatus.OK);
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
		log.info("START: ProductController.getProductByCategory, category={}", category);
		ProductCategory pc = productCategoryRepo.findByCategoryNameContaining(category);
		List<Product> prodList = pc.getProducts();
		if (!prodList.isEmpty()) {
			return new ResponseEntity<> (prodList, HttpStatus.OK);
		} else {
			return new ResponseEntity<> (HttpStatus.NOT_FOUND);
		}
	}
	
	
	@GetMapping(value = "/product/book", produces = {"application/json" })
	ResponseEntity<List<Product>> getProductByName(@RequestParam("name") String name) {
		
		List<Product> products = productRepo.findByNameContains(name.toUpperCase());
		if (!products.isEmpty()) {
			return new ResponseEntity<> (products, HttpStatus.OK);
		}
		return new ResponseEntity<> (HttpStatus.NOT_FOUND);
	}
	
	
	@GetMapping(value = "/categories", produces = {"application/json" })
	ResponseEntity<List<String>> getAllCategories () {
		
		List<String> allCategory = productCategoryRepo.getAllCategory();
		if (! allCategory.isEmpty()) {
			return new ResponseEntity<>(allCategory, HttpStatus.OK);
		} else {
			return new ResponseEntity<> (HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping(value = "/product/find", produces = {"application/json" })
	ResponseEntity<List<Product>>  findProduct (@RequestParam("search")  String value) {
		
		if (! StringUtils.isBlank(value.trim()) && value.trim().length() > 2) {
			value = "%"+value+"%";
			List<Product> products = productRepo.findProduct (value.trim(), value.trim());
			if (! products.isEmpty()) {
				return new ResponseEntity<> (products, HttpStatus.OK);
			} else {
				return new ResponseEntity<> (HttpStatus.NOT_FOUND);
			}
		} else {
			throw new SearchProductException("Search value is null or less than 2");
		}
	}
	
	
}
