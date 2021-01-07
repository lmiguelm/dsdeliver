package com.lmiguelm.dsdeliver.services;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lmiguelm.dsdeliver.dto.OrderDTO;
import com.lmiguelm.dsdeliver.dto.ProductDTO;
import com.lmiguelm.dsdeliver.entites.Order;
import com.lmiguelm.dsdeliver.entites.Product;
import com.lmiguelm.dsdeliver.entites.enums.OrderStatus;
import com.lmiguelm.dsdeliver.repositories.OrderRepository;
import com.lmiguelm.dsdeliver.repositories.ProductRepository;

@Service
public class OrderService {	
	
	@Autowired
	private OrderRepository repo;
	
	@Autowired
	private ProductRepository productRepository;
	
	public List<OrderDTO> findAll() {
		return repo.findOrderWithProducts().stream().map(o -> new OrderDTO(o)).collect(Collectors.toList());
	}
	
	public OrderDTO insert(OrderDTO dto) {
		Order order = new Order(null, dto.getAddress(), dto.getLatitude(), dto.getLongitude(), Instant.now(), OrderStatus.PENDING, dto.getTotal());
		
		for(ProductDTO p : dto.getProducts()) {
			Product product = productRepository.getOne(p.getId());
			order.getProducts().add(product);
		}
		
		return new OrderDTO(repo.save(order));
	}
	
	public OrderDTO update(Long id) {
		Order order = repo.getOne(id);
		order.setStatus(OrderStatus.DELIVERED);
		order = repo.save(order);
		return new OrderDTO(order);
	}
}	
