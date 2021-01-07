package com.lmiguelm.dsdeliver.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.lmiguelm.dsdeliver.dto.OrderDTO;
import com.lmiguelm.dsdeliver.services.OrderService;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {
	
	@Autowired
	OrderService service;	
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<OrderDTO>> findAll() {
		List<OrderDTO> ordersDTO = service.findAll(); 
		return ResponseEntity.ok().body(ordersDTO);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<OrderDTO> insert(OrderDTO objDto) {
		OrderDTO orderDto = service.insert(objDto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(orderDto.getId()).toUri();
		return ResponseEntity.ok().body(orderDto);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<OrderDTO> update(@PathVariable Long id) {
		OrderDTO orderDto = service.update(id);
		return ResponseEntity.ok().body(orderDto);
	}
}
