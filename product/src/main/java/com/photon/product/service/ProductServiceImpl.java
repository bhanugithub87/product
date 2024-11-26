package com.photon.product.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.photon.product.dao.ProductRepository;
import com.photon.product.dto.ProductDto;
import com.photon.product.exception.ProductNotFoundException;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

	ProductRepository productRepository;

	public ProductServiceImpl(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Override
	public List<ProductDto> getAllProducts() {
		log.info("ProductServiceImpl.getAllProducts()");
		var productsStream = productRepository.findAll().stream().map(product -> new ProductDto(product.getId(),
				product.getName(), product.getDescription(), product.getPrice(), product.getImageUrl()));
		return productsStream.toList();
	}

	@Override
	public ProductDto getProductById(Long id) {
		log.info("ProductServiceImpl.getProductById()");
		var product = productRepository.findById(id)
				.orElseThrow(() -> new ProductNotFoundException("No product found with id: " + id));

		return new ProductDto(product.getId(), product.getName(), product.getDescription(), product.getPrice(),
				product.getImageUrl());
	}

}
