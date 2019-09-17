package com.go2it.frame.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.go2it.frame.entity.Customer;

/**
 * @author Alex Ryzhkov
 */
@org.springframework.stereotype.Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {

	Optional<Customer> findByName(String name);

	List<Customer> findAllByOrderByPersonId();

	Optional<Customer> findByPersonId(String customerId);
}
