package com.go2it.frame.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.go2it.frame.entity.Customer;
import com.go2it.frame.repository.CustomerRepository;

/**
 * @author Alex Ryzhkov
 */
@Service
public class CustomerService implements ICustomerService {
	@Autowired
	private CustomerRepository customerRepository_;

	@Override
	public Optional<Customer> getById(String customerId) {
		return customerRepository_.findByPersonId(customerId);
	}

	@Override
	public Optional<Customer> getByName(String name) {
		return customerRepository_.findByName(name);
	}

	@Override
	public List<Customer> getAll() {
		return customerRepository_.findAllByOrderByPersonId();
	}

	@Override
	public Customer add(Customer customer) {
		return customerRepository_.save(customer);
	}
}
