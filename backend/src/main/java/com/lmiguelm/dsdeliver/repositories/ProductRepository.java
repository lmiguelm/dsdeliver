package com.lmiguelm.dsdeliver.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lmiguelm.dsdeliver.entites.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
