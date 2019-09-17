package com.go2it.frame.repository;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.go2it.frame.entity.Customer;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Testing on PROD DB
 * Transactions are rolled back after each test
 *
 * @author Alex Ryzhkov
 */
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CustomerRepositoryTest {
	@Autowired private CustomerRepository customerRepository_;

	@BeforeEach
	public void setUpBeforeTheClass() {
		List<Customer> customerList = seedCustomers();
		customerRepository_.saveAll(customerList);
	}

	@DisplayName("Customer can be successfully fetched from DB")
	@Test
	public void testCustomerFetch() {
		Customer customer = customerRepository_.findByName("Joe Doe 1");
		assertNotNull(customer);
	}

	private List<Customer> seedCustomers() {
		List<Customer> customers = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			Customer customer = new Customer();
			customer.setPersonId("S11122233" + i);
			customer.setName("Joe Doe " + i);
			customer.setAddress(i + " 5th ave New York");
			customer.setPersonInChargeId(customer.getPersonId());
			customer.setPhoneNumber("111-222-33-44 ext" + i);
			customer.setDateOfBirth(LocalDate.now().minus(i, ChronoUnit.DAYS));
			customer.setType(Customer.Type.MALE);
			customer.setMaritalStatus(Customer.MaritalStatus.DIVORCED);
			customer.setCitizen(i % 2 == 0);

			customers.add(customer);
		}
		return customers;
	}

}
