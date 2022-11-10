package com.odev.spring.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.odev.spring.Employee;

@RestController
public class EmployeeResource {

	@GetMapping("/api/employee/{id}")
	public Employee getEmployee(@PathVariable("id") long employeeId) {
		Employee employee = new Employee(101, "Ahmet Kemer", 5250);
		return employee;
	}
	
	@GetMapping("/api/employees")
	public List<Employee> getEmployees(){
		List <Employee> employeeList = new ArrayList<>();
		employeeList.add(new Employee(101, "Ahmet Kemer", 5250));
		employeeList.add(new Employee(102, "Ayse Bıçak", 14450));
		employeeList.add(new Employee(103, "Mehmet Uçar", 8850));
		return employeeList;	
	}
	
	@PostMapping("/api/employee")
	public Employee postEmployee(@RequestBody Employee employee) {
		employee.setEmployeeId(301);
		System.out.print("Çalışan eklendi " +employee.getEmployeeId()+ " "
				+ employee.getEmployeeName()+ " "+employee.getMonthlySalary());
		return employee;
	}
	
	@PutMapping("/api/employee")
	public void putEmployee(@RequestBody Employee employee) {
		System.out.print("Çalışan güncellendi " +employee.getEmployeeId()+ " "
				+ employee.getEmployeeName()+ " "+employee.getMonthlySalary());
	}
	
	@DeleteMapping("/api/employee/{id}")
	public void deleteEmployee(@PathVariable("id")long employeeId) {
		System.out.print("Çalışan silindi " +employeeId);

	}
}
