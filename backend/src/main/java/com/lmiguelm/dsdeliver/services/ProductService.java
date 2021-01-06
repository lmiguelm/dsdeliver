package com.lmiguelm.dsdeliver.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lmiguelm.dsdeliver.dto.ProductDTO;
import com.lmiguelm.dsdeliver.entites.Product;
import com.lmiguelm.dsdeliver.repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired	
	private ProductRepository repo;
	
	private List<ProductDTO> findAll() {
		List<Product> products = repo.findAll();
		return products.stream().map(p -> new ProductDTO(p)).collect(Collectors.toList());
	}
}
