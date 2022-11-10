package com.odev.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import com.odev.spring.entity.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long>  {
	@Query("select e from Employee e where e.department.departmentId = :departmentId")
	List<Employee> findAllByDepartmentId(@Param("departmentId") long departmendId);
	
	
	
}
