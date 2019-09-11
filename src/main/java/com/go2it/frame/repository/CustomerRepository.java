package com.go2it.frame.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.go2it.frame.entity.Customer;

/**
 * @author Alex Ryzhkov
 */
@org.springframework.stereotype.Repository
public interface CustomerRepository extends Repository<Customer, Integer> {

	Customer findByName(String name);

	List<Customer> findAllByOrderByPersonId();
}
