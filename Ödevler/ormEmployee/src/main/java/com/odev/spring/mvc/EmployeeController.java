package com.odev.spring.mvc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.odev.spring.entity.Employee;
import com.odev.spring.repository.EmployeeRepository;


@Controller
@RequestMapping("/company")
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@GetMapping("/employees/bydepartment")
	@ResponseBody
	public String getEmployeesByDepartment() {
		long departmentId=2;
		List<Employee> employees = employeeRepository.findAllByDepartmentId(departmentId);
		double totalSalary=0;
		for (Employee employee : employees) {
			System.out.println(employee.getEmployeeId()+ " "
					+employee.getEmployeeName()+ " "
					+employee.getMonthlySalary());
			totalSalary += employee.getMonthlySalary();
		}
		double averageSalary=0;
		if (employees.size()>0) {
			averageSalary = totalSalary / employees.size();
		}
		return "Ortalama maaş: " + averageSalary;
		}
	}


