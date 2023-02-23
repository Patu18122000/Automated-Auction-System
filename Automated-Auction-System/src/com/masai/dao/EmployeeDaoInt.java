package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.masai.exception.EmployeeException;
import com.masai.model.Employee;
import com.utility.JDBdao;

public class EmployeeDaoInt implements EmployeeDao{

	@Override
	public String registerEmployee(Employee emp) throws EmployeeException {
		String response = "Not Registered";
		
		try(Connection conn = JDBdao.provideConnector()) {
			
			PreparedStatement ps = conn.prepareStatement("insert into Employee(empId,ename,address,email,password,salary,depId) values(?,?,?,?,?)");
			
			ps.setString(1, emp.getEname());
			ps.setString(2, emp.getAddress());
			ps.setString(3, emp.getEmail());
			ps.setString(4, emp.getPassword());
			ps.setInt(5, emp.getSalary());
			ps.setInt(6,emp.getDepId());
			
			int row = ps.executeUpdate();
			if(row>0) {
				response = "Employee is Successfully registered";
			}
			
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new EmployeeException(e.getMessage());
		}
		
		return response;
	}

}
