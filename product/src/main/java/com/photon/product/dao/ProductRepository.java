package com.photon.product.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.photon.product.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
