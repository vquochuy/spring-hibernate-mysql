package com.vquochuy.service;

import java.util.List;

import com.vquochuy.model.Employee;

public interface EmployeeService {
	Employee findById(int id);

	void save(Employee employee);

	void update(Employee employee);

	void deleteEmloyeeBySSN(String ssn);

	List<Employee> findAll();

	Employee findEmployeeBySSN(String ssn);

	boolean isEmployeeSsnUnique(Integer id, String ssn);
}
