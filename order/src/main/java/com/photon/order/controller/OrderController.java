package com.photon.order.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.photon.order.dto.OrderDto;
import com.photon.order.service.OrderService;


import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping({"/api/orders"})
@Slf4j
public class OrderController {
	
	OrderService orderService;
	
	public OrderController(OrderService orderService) {
		this.orderService = orderService;
	}
	
	@PostMapping
	public OrderDto createOrder(@RequestBody OrderDto request) {
		log.info("OrderController.createOrder()");
		return orderService.createOrder(request);
		
	}
	
	

}
