package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dao.employees.DepartmentsDAO;
import com.example.demo.dto.Departments;

@Service
public class DepartmentsService
{
	private final DepartmentsDAO departmentsDAO;
	
	public DepartmentsService(DepartmentsDAO departmentsDAO)
	{
		this.departmentsDAO = departmentsDAO;		
	}
	
	public List<Departments> getAllDepartments()
	{
		return departmentsDAO.getAllDepartments();
	}
	
	public int insertDepartment(String dept_no, String dept_name)
	{
		return departmentsDAO.insertDepartment(dept_no, dept_name);
	}
	
	
}
