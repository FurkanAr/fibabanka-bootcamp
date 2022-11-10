package com.odev.spring.repository;

import org.springframework.data.repository.CrudRepository;

import com.odev.spring.entity.Department;


public interface DepartmentRepository extends CrudRepository<Department, Long> {

}
