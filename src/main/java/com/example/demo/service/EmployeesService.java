package com.example.demo.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.example.demo.dao.employees.EmployeesDAO;
import com.example.demo.dto.Employees;

@Service
public class EmployeesService
{
	private final EmployeesDAO employeesDAO;
	
	public EmployeesService(EmployeesDAO employeesDAO)
	{
		this.employeesDAO = employeesDAO;
	}
	
	public List<Employees> getEmployeesDefaultList
	(int limit, int offset)
	{
		// TODO : 비즈니스 로직.
		return employeesDAO.getEmployeesDefaultList(limit, offset);
	}
	
	public int getEmployeesRowCnt()
	{
		return employeesDAO.getEmployeesRowCnt();
	}
	
	public Employees getEmployeeById(String id)
	{	
		// TODO : 비즈니스 로직
		Employees employee = employeesDAO.getEmployeeById(id);
		return employee;
	}
	
	public Employees getEmployee(String emp_no, String first_name)
	{	
		// TODO : 비즈니스 로직
		return employeesDAO.getEmployee(emp_no, first_name);
	}

	public int updateFirstName(Employees employee)
	{
		// TODO : 비즈니스 로직
		return employeesDAO.updateFirstName(employee);
	}
}
