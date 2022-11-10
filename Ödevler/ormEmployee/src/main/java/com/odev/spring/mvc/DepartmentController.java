package com.odev.spring.mvc;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.odev.spring.entity.Department;
import com.odev.spring.entity.Employee;
import com.odev.spring.repository.DepartmentRepository;

@Controller
@RequestMapping("/company")
public class DepartmentController {

	@Autowired
	private DepartmentRepository departmentRepository;
	
	@GetMapping("/department/insert")
	@ResponseBody
	public String insertEmployee() {
	Department departmentSw = new Department(0,"Software");
	departmentSw.setEmployeeList(new ArrayList<>());
	
	Employee employee1 = new Employee(0, "Ahmet Uçak", 10000);
	employee1.setDepartment(departmentSw);
	departmentSw.getEmployeeList().add(employee1);
	
	Employee employee2 = new Employee(0, "Ayşe Kısa", 80000);
	employee2.setDepartment(departmentSw);
	departmentSw.getEmployeeList().add(employee2);
	
	Employee employee3 = new Employee(0, "Zeynep İlkan", 12000);
	employee3.setDepartment(departmentSw);
	departmentSw.getEmployeeList().add(employee3);
	
	departmentRepository.save(departmentSw);
	
	return "Sokuldu";
	}
	

}
