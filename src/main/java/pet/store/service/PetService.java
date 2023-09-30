package pet.store.service;

import java.util.NoSuchElementException;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pet.store.controller.model.CustomerData;
import pet.store.dao.CustomerDao;
import pet.store.entity.Customer;

@Service
public class PetService {
	@Autowired
	private CustomerDao customerDao;

	@Transactional(readOnly = false)
	public CustomerData saveCustomer(CustomerData customerData) {
		Long customerId = customerData.getCustomerId();
		Customer customer = findOrCreateCustomer(customerId);
		
		setFieldsInCustomer(customer, customerData);
		return new CustomerData (customerDao.save(customer));
	}

	private void setFieldsInCustomer(Customer customer, CustomerData customerData) {
		customer.setCustomerFirstName(customerData.getCustomerFirstName());
		customer.setCustomerLastName(customerData.getCustomerLastName());
		customer.setCustomerEmail(customerData.getCustomerEmail());
	}

	private Customer findOrCreateCustomer(Long customerId) {
		Customer customer;

		if (Objects.isNull(customerId)) {
			customer = new Customer();
		} else {
			customer = findCustomerById(customerId);
		}

		return customer;
	}

	private Customer findCustomerById(Long customerId) {
		return customerDao.findById(customerId).orElseThrow(
				() -> new NoSuchElementException("Contributor with ID=" + customerId + " was not found."));

	}

}