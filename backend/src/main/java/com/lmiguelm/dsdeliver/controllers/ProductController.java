package com.lmiguelm.dsdeliver.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lmiguelm.dsdeliver.dto.ProductDTO;
import com.lmiguelm.dsdeliver.services.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ProductDTO>> findAll() {
		List<ProductDTO> productsDto = service.findAll(); 
		return ResponseEntity.ok().body(productsDto);
	}
}
