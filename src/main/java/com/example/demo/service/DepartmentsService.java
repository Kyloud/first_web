package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dao.DepartmentsDAO;
import com.example.demo.dto.Departments;

@Service
public class DepartmentsService
{
	private final DepartmentsDAO departmentsDAO;
	
	public DepartmentsService(DepartmentsDAO departmentsDAO)
	{
		this.departmentsDAO = departmentsDAO;		
	}
	
	public List<Departments> getDepartmentsTable()
	{
		return departmentsDAO.getDepartmentsTable();
	}
	
	
}
