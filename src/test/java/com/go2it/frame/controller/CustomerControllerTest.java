package com.go2it.frame.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.go2it.frame.entity.Customer;
import com.go2it.frame.service.CustomerService;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Testing the controller level only
 *
 * @author Alex Ryzhkov
 */
@RunWith(SpringRunner.class)
@WebMvcTest(CustomerController.class)
public class CustomerControllerTest {
	@Autowired private MockMvc mockMvc;
	@MockBean private CustomerService customerService_;

	private final String ALL_CUSTOMERS = "[{\"id\":0,\"personId\":\"S11122233\",\"name\":\"test customer\",\"address\":null,\"personInChargeId\":null,\"phoneNumber\":null,\"email\":null,\"dateOfBirth\":null,\"type\":\"MALE\",\"hasProvidedAuthorization\":false,\"yearT1Done\":0,\"corporationEmail\":null,\"t2Books\":null,\"fullName\":null,\"maritalStatus\":null,\"numberOfDependants\":null,\"spouse\":null,\"loginName\":null,\"hasWebAccess\":false,\"activeClient\":false,\"citizen\":false},{\"id\":0,\"personId\":\"S000111\",\"name\":\"test customer 2\",\"address\":null,\"personInChargeId\":null,\"phoneNumber\":null,\"email\":null,\"dateOfBirth\":null,\"type\":\"FEMALE\",\"hasProvidedAuthorization\":false,\"yearT1Done\":0,\"corporationEmail\":null,\"t2Books\":null,\"fullName\":null,\"maritalStatus\":null,\"numberOfDependants\":null,\"spouse\":null,\"loginName\":null,\"hasWebAccess\":false,\"activeClient\":false,\"citizen\":false}]";

	private final String ONE_CUSTOMER = "{\"id\":0,\"personId\":\"S11122233\",\"name\":\"test customer\",\"address\":null,\"personInChargeId\":null,\"phoneNumber\":null,\"email\":null,\"dateOfBirth\":null,\"type\":\"MALE\",\"hasProvidedAuthorization\":false,\"yearT1Done\":0,\"corporationEmail\":null,\"t2Books\":null,\"fullName\":null,\"maritalStatus\":null,\"numberOfDependants\":null,\"spouse\":null,\"loginName\":null,\"hasWebAccess\":false,\"activeClient\":false,\"citizen\":false}";

	@DisplayName("Should return all the available customers")
	@Test
	public void getAllCustomers() throws Exception {
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

		when(customerService_.getAll()).thenReturn(expectedResult);
		this.mockMvc.perform(get("/api/customers/"))
				//				.andDo(print())
				.andExpect(status().isOk()).andExpect(content().string(ALL_CUSTOMERS));
	}

	@DisplayName("Should return a customer by id")
	@Test
	public void getCustomerById() throws Exception {
		Customer customer = new Customer();
		customer.setPersonId("S11122233");
		customer.setName("test customer");
		customer.setType(Customer.Type.MALE);

		when(customerService_.getById("S11122233")).thenReturn(Optional.of(customer));
		this.mockMvc.perform(get("/api/customers/id/S11122233"))
				//				.andDo(print())
				.andExpect(status().isOk()).andExpect(content().string(ONE_CUSTOMER));
	}

	@DisplayName("Should return no customer")
	@Test
	public void getCustomerByIdNotFound() throws Exception {
		when(customerService_.getById("S11122233")).thenReturn(Optional.empty());
		this.mockMvc.perform(get("/api/customers/id/S11122233"))
				//				.andDo(print())
				.andExpect(status().isNotFound());
	}

	@DisplayName("Should return a customer by name")
	@Test
	public void getCustomerByName() throws Exception {
		Customer customer = new Customer();
		customer.setPersonId("S11122233");
		customer.setName("test customer");
		customer.setType(Customer.Type.MALE);

		when(customerService_.getByName("test customer")).thenReturn(Optional.of(customer));
		this.mockMvc.perform(get("/api/customers/name/test customer"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().string(ONE_CUSTOMER));
	}

	@DisplayName("Should return no customer")
	@Test
	public void getCustomerByNameNotFound() throws Exception {
		when(customerService_.getByName("test customer")).thenReturn(Optional.empty());
		this.mockMvc.perform(get("/api/customers/name/test customer"))
				//				.andDo(print())
				.andExpect(status().isNotFound());
	}

}


