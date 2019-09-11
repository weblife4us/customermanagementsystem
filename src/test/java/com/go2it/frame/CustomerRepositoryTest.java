package com.go2it.frame;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.go2it.frame.entity.Customer;
import com.go2it.frame.repository.CustomerRepository;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author Alex Ryzhkov
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerRepositoryTest {
	@Autowired
	private CustomerRepository customerRepository_;

	@DisplayName("Customer can be successfully fetched from DB")
	@Test
	public void testCustomerFetch() {
		Customer customer = customerRepository_.findByName("JARINOV VIKTOR");
		assertNotNull(customer);
	}

}
