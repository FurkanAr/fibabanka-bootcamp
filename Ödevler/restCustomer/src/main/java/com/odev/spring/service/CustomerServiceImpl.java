package com.odev.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.odev.spring.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Override
	public Customer find(long customerId) {
		Customer customer = new Customer(customerId, "Ahmet Keser", 10000);
		System.out.println("İşgörü çalıştı..");
		return customer;
	}

	@Override
	public List<Customer> findAll() {
		List<Customer> customerList = new ArrayList<>();
		customerList.add(new Customer(101,"Ahmet Keser", 10000));
		customerList.add(new Customer(102,"Zeynep Uçar", 8000));
		customerList.add(new Customer(103,"Ceren Aslan", 12000));
		return customerList;
	}

	@Override
	public void createCustomer(Customer customer) {
		customer.setCustomerId(101);
		System.out.print("Müşteri eklendi "+ customer.getCustomerId()+" "
		+ customer.getCustomerName()+ " "+customer.getTotalDebit());
	}

	@Override
	public void updateCustomer(Customer customer) {
		System.out.print("Müşteri güncellendi "+ customer.getCustomerId()+" "
				+ customer.getCustomerName()+ " "+customer.getTotalDebit());
	}

	@Override
	public void deleteCustomer(long customerId) {
		System.out.print("Müşteri silindi.. "+ customerId);		
	}

}
