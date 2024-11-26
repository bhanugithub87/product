package com.photon.order.entity;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "Orders")
public class Order {
	@Id
	@GeneratedValue
	Long id;
	String customerName;
	@ElementCollection
	Set<Long> productIds = new HashSet();
	LocalDate orderDate;
	
	public Order() {}
	
	public Order(String customerName, Set<Long> prods, LocalDate orderDate) {
		this.customerName = customerName;
		this.productIds = prods;
		this.orderDate = orderDate;
	}

}
