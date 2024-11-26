package com.photon.product.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.photon.product.dto.ProductDto;
import com.photon.product.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping({"/api/products"})
@Slf4j
public class ProductController {
	
	ProductService productService;
	
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	@GetMapping
	public List<ProductDto> getAllProducts(){
		log.info("ProductController.getAllProducts()");
		return productService.getAllProducts();
	}
	
	@GetMapping("{id}")
	public ProductDto getProductById(@PathVariable Long id) {
		log.info("ProductController.getProductById()");
		return productService.getProductById(id);
	}
	
	

}
