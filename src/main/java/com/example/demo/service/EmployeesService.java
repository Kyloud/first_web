package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dao.EmployeesDAO;
import com.example.demo.dto.Employees;

@Service
public class EmployeesService
{
	private final EmployeesDAO employeesDAO;
	
	public EmployeesService(EmployeesDAO employeesDAO)
	{
		this.employeesDAO = employeesDAO;
	}
	
	public List<Employees> getAllEmployees()
	{
		// TODO : 비즈니스 로직.
		return employeesDAO.getAllEmployees();
	}
	
	public Employees getEmployeeById(String id)
	{	
		// TODO : 비즈니스 로직
		Employees employees = employeesDAO.getEmployeeById(id);
		return employees;
	}
	
	public Employees getEmployee(String emp_no, String first_name)
	{	
		// TODO : 비즈니스 로직
		return employeesDAO.getEmployee(emp_no, first_name);
	}

	public int updateFirstName(Employees employees)
	{
		// TODO : 비즈니스 로직
		return employeesDAO.updateFirstName(employees);
	}
}
