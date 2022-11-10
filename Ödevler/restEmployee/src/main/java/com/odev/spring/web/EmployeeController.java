package com.odev.spring.web;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import com.odev.spring.Employee;

//Client 
@Controller
public class EmployeeController {

	@GetMapping("/employee/get")
	@ResponseBody
	public String getEmployee() {
		long employeeId=101;
		String url= "http://localhost:8081/api/employee/"+employeeId;
		RestTemplate restTemplate = new RestTemplate();
		Employee employee = restTemplate.getForObject(url, Employee.class);
		System.out.print("Çalışan: " +employee.getEmployeeName());
		return "Edinme Başarılı "+employee.getEmployeeName()+" "+employee.getMonthlySalary();
	}
	
	@GetMapping("/employee/post")
	@ResponseBody
	public String postEmployee() {
		Employee employee = new Employee(0, "Selin Yapar", 9250);
		String url= "http://localhost:8081/api/employee/";
		RestTemplate restTemplate = new RestTemplate();
		Employee result = restTemplate.postForObject(url, employee, Employee.class);
		return "Yollama Başarılı "+result.getEmployeeId();
	}
	
	@GetMapping("/employee/put")
	@ResponseBody
	public String putEmployee() {
		Employee employee = new Employee(102, "Ceylin Kısa", 10550);
		String url= "http://localhost:8081/api/employee/";
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.exchange(url, HttpMethod.PUT, new HttpEntity<Employee>(employee), Void.class);
		return "Koyma Başarılı";
	}
	
	@GetMapping("/employee/delete")
	@ResponseBody
	public String deleteEmployee() {
		long employeeId=101;
		String url= "http://localhost:8081/api/employee/"+employeeId;
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(url);
		return "Silme Başarılı";
	}
}

