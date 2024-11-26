package com.photon.order.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.photon.order.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
