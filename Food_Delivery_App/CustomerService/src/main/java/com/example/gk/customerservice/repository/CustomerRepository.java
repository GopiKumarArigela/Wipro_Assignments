package com.example.gk.customerservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.gk.customerservice.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
	
}

