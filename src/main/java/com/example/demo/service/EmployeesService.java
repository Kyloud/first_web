package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dao.EmployeesDAO;
import com.example.demo.dto.Employees;

@Service
public class EmployeesService
{
	private final EmployeesDAO EmployeesDAO;
	
	public EmployeesService(EmployeesDAO EmployeesDAO)
	{
		this.EmployeesDAO = EmployeesDAO;
	}
	
	public List<Employees> getAllEmployees()
	{
		// TODO : 비즈니스 로직.
		return EmployeesDAO.getAllEmployees();
	}
	
	public Employees getEmployeeById(String id)
	{	
		//TODO : 비즈니스 로직
		return EmployeesDAO.getEmployeeById(id);
	}
	
	public Employees getEmployee(String emp_no, String first_name)
	{	
		//TODO : 비즈니스 로직
		return EmployeesDAO.getEmployee(emp_no, first_name);
	}
	
}
