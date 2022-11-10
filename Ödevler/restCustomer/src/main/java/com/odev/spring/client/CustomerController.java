package com.odev.spring.client;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.odev.spring.Customer;

@Controller
public class CustomerController {

	@GetMapping("/customer/get")
	@ResponseBody
	public String getCustomer() {
		long customerId=101;
		String url = "http://localhost:8081/api/customer/"+customerId;
		RestTemplate restTemplate = new RestTemplate();
		Customer customer = restTemplate.getForObject(url, Customer.class);
		System.out.println("Müşteri: " + customer.getCustomerName());
		return "Edinme Başarılı " + customer.getCustomerName() + " " + customer.getTotalDebit();
	}
	
	
	@GetMapping("/customer/post")
	@ResponseBody
	public String postCustomer() {
		Customer customer = new Customer(0, "Funda Uçar", 95000);
		String url = "http://localhost:8081/api/customer/";
		RestTemplate restTemplate = new RestTemplate();
		Customer result = restTemplate.postForObject(url, customer, Customer.class);
		return "Yollama Başarılı " + result.getCustomerId();
	}
	
	@GetMapping("/customer/put")
	@ResponseBody
	public String putCustomer() {
		Customer customer = new Customer(104, "Akif Ersoy", 205000);
		String url = "http://localhost:8081/api/customer/";
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.exchange(url, HttpMethod.PUT, new HttpEntity<Customer>(customer), Customer.class);
		return "Koyma Başarılı..";
	}
	

	@GetMapping("/customer/delete")
	@ResponseBody
	public String deleteCustomer() {
		long customerId=104;
		String url = "http://localhost:8081/api/customer/"+ customerId;
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(url);
		return "Silme Başarılı..";
	}
	
}
