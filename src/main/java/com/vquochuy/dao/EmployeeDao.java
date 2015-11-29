package com.vquochuy.dao;

import java.util.List;

import com.vquochuy.model.Employee;

public interface EmployeeDao {
	Employee findById(int id);

	void save(Employee employee);

	void deleteEmployeeBySSN(String ssn);

	List<Employee> findAll();

	Employee findEmployeeBySSN(String ssn);
}
