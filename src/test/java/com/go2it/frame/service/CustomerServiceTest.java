package com.go2it.frame.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import com.go2it.frame.entity.Customer;
import com.go2it.frame.repository.CustomerRepository;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;

/**
 * @author Alex Ryzhkov
 */
@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {
	@Mock private CustomerRepository customerRepository_;
	@Spy private CustomerService customerService_;

	@DisplayName("Should show the happy path")
	@Test
	public void testGetByName() {
		Customer customer = new Customer();
		customer.setName("test customer");
		customer.setType(Customer.Type.MALE);

		doReturn(customer).when(customerRepository_).findByName("test custormer");
		Optional<Customer> result = customerService_.getByName("test customer");
		assertTrue(result.isPresent());
		assertEquals(customer, result.get());
	}

	@DisplayName("Should show the happy path")
	@Test
	public void testGetById() {
		Customer customer = new Customer();
		customer.setPersonId("S11122233");
		customer.setName("test customer");
		customer.setType(Customer.Type.MALE);

		doReturn(customer).when(customerRepository_).findByName("S11122233");
		Optional<Customer> result = customerService_.getById("S11122233");
		assertTrue(result.isPresent());
		assertEquals(customer, result.get());
	}

	@DisplayName("Should show the happy path")
	@Test
	public void testGetAll() {
		Customer customer = new Customer();
		customer.setPersonId("S11122233");
		customer.setName("test customer");
		customer.setType(Customer.Type.MALE);

		Customer customer2 = new Customer();
		customer2.setPersonId("S000111");
		customer2.setName("test customer 2");
		customer2.setType(Customer.Type.FEMALE);

		List<Customer> expectedResult = new ArrayList<>();
		expectedResult.add(customer);
		expectedResult.add(customer2);

		doReturn(expectedResult).when(customerRepository_).findAll();
		List<Customer> result = customerService_.getAll();
		assertEquals(2, result.size());
		assertEquals(customer, result.get(0));
		assertEquals(customer2, result.get(1));
	}

	@DisplayName("Should show the happy path")
	@Test
	public void testSave() {
		Customer customer = new Customer();
		customer.setPersonId("S11122233");
		customer.setName("test customer");
		customer.setType(Customer.Type.MALE);

		doReturn(customer).when(customerRepository_).save(customer);
		Customer result = customerService_.add(customer);
		assertNotNull(result);
		assertEquals(customer, result);
	}
}
