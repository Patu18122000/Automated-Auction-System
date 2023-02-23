package com.masai.dao;

import com.masai.exception.EmployeeException;
import com.masai.model.Employee;

public interface EmployeeDao {
	public String registerEmployee(Employee emp) throws EmployeeException;
	
}
