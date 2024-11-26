package com.photon.order.service;

import com.photon.order.dto.OrderDto;

public interface OrderService {

	OrderDto createOrder(OrderDto request);

}
