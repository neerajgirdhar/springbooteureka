package com.example.springboot.dataservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springboot.dataservice.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {
	public List<Customer> findByUsername(String username);
}
