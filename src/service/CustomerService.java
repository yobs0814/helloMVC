package service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import java.util.Set;

import model.Customer;

public class CustomerService {

	private Map<String, Customer> customers;

	private static final CustomerService instance = new CustomerService();

	private CustomerService() {
		customers = new HashMap<String, Customer>();

	}

	public static CustomerService getInstance() {
		return instance;
	}

	public void addCustomer(Customer customer) {
		customers.put(customer.getId(), customer);// (key, value)저장

	}

	public Customer findCustomer(String id) {
		return (customers.get(id.toLowerCase()));
	}

	public Customer login(String id, String pw) {
		Customer customer = findCustomer(id);

		if (customer.getPassword().equals(pw))
			return customer;
		else
			return null;

	}

}
