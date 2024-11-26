package com.photon.product.service;

import java.util.List;

import com.photon.product.dto.ProductDto;

public interface ProductService {

	List<ProductDto> getAllProducts();

	ProductDto getProductById(Long id);

}
