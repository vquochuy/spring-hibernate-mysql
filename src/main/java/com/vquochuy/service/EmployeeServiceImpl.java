package com.vquochuy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vquochuy.dao.EmployeeDao;
import com.vquochuy.model.Employee;

@Service("EmployeeService")
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDao employeeDao;

	@Override
	public Employee findById(int id) {
		return employeeDao.findById(id);
	}

	@Override
	public void saveEmployee(Employee employee) {
		employeeDao.save(employee);

	}

	/*
	 * Since the method is running with Transaction, No need to call hibernate
	 * update explicitly. Just fetch the entity from db and update it with
	 * proper values within transaction. It will be updated in db once
	 * transaction ends.
	 */
	@Override
	public void updateEmployee(Employee employee) {
		Employee entity = employeeDao.findById(employee.getId());
		if (entity != null) {
			entity.setName(employee.getName());
			entity.setJoiningDate(employee.getJoiningDate());
			entity.setSalary(employee.getSalary());
			entity.setSsn(employee.getSsn());
		}
	}

	@Override
	public void deleteEmployeeBySsn(String ssn) {
		employeeDao.deleteEmployeeBySSN(ssn);
	}

	@Override
	public List<Employee> findAllEmployees() {
		return employeeDao.findAll();
	}

	@Override
	public Employee findEmployeeBySsn(String ssn) {
		return employeeDao.findEmployeeBySSN(ssn);
	}

	@Override
	public boolean isEmployeeSsnUnique(Integer id, String ssn) {
		Employee employee = findEmployeeBySsn(ssn);
		return (employee == null || ((id != null) && (employee.getId() == id)));
	}

}
