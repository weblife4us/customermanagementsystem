package com.go2it.frame.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.go2it.frame.config.payload.ApiResponse;
import com.go2it.frame.entity.Customer;
import com.go2it.frame.service.CustomerService;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
	@Autowired private CustomerService customerService_;

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public ResponseEntity getHelloWorldMessage() {
		return ResponseEntity.ok(new ApiResponse(true, "Test passed successfully"));
	}

	@GetMapping
	public ResponseEntity getAllCustomers() {
		List<Customer> customers = customerService_.getAll();
		return new ResponseEntity<>(customers, HttpStatus.OK);
	}

	@GetMapping(value = "/id/{id}")
	public ResponseEntity getCustomerById(@PathVariable("id") String customerId) {
		Optional<Customer> customer = customerService_.getById(customerId);
		return customer.<ResponseEntity>map(ResponseEntity::ok).orElseGet(
				() -> ResponseEntity.notFound().build());
	}

	@GetMapping(value = "/name/{name}")
	public ResponseEntity getCustomerByName(@PathVariable("name") String customerName) {
		Optional<Customer> customer = customerService_.getByName(customerName);
		return customer.<ResponseEntity>map(ResponseEntity::ok).orElseGet(
				() -> ResponseEntity.notFound().build());
	}

}
