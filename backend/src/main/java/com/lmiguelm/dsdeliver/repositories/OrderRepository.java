package com.lmiguelm.dsdeliver.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lmiguelm.dsdeliver.entites.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
