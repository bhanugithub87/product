package com.photon.order.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.photon.order.dao.OrderRepository;
import com.photon.order.dto.OrderDto;
import com.photon.order.entity.Order;
import com.photon.order.exception.ProductNotFoundException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

	@Value("${productApi}")
	String productApi;

	OrderRepository orderRepository;
	WebClient.Builder wcBuilder;

	public OrderServiceImpl(OrderRepository orderRepository, WebClient.Builder wcBuilder) {
		this.orderRepository = orderRepository;
		this.wcBuilder = wcBuilder;
	}

	@Override
	public OrderDto createOrder(OrderDto request) {
		System.out.println(wcBuilder);
		var wc = wcBuilder.baseUrl(productApi).build();
		if (validateProductOrders(wc, request.getProductId())) {
			var order = new Order(request.getCustomerName(), request.getProductId(), request.getOrderDate());
			order = orderRepository.save(order);
			request.setId(order.getId());
			return request;
		} else {
			throw new ProductNotFoundException("One of product(s) not valid");
		}
	}

	private boolean validateProductOrders(WebClient wc, Set<Long> productId) {
		Map<Long, Boolean> productMap = new HashMap<Long, Boolean>();
		productId.forEach(id -> {
			var status = wc.get().uri("/"+String.valueOf(id)).exchange().block().statusCode().is2xxSuccessful();
			productMap.put(id, status);

		});
		return productMap.values().stream().allMatch(t -> t == true);

	}

}
