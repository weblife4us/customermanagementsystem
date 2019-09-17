package com.go2it.frame.service;

import java.util.List;
import java.util.Optional;

import com.go2it.frame.entity.Customer;

/**
 * @author Alex Ryzhkov
 */
public interface ICustomerService {

	Optional<Customer> getById(String customerId);

	Optional<Customer> getByName(String name);

	List<Customer> getAll();

	Customer add(Customer customer);
}
