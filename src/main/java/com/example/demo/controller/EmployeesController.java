package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dto.Employees;
import com.example.demo.service.EmployeesService;

@Controller
public class EmployeesController
{
	private final EmployeesService employeesService;
	
	
	public EmployeesController(EmployeesService employeesService)
	{
		this.employeesService = employeesService;
	}
	
	@GetMapping("/employees")
	@ResponseBody
	public List<Employees> getAllEmployees()
	{
		return employeesService.getAllEmployees();
	}
	
	@GetMapping("/employeeById")
	@ResponseBody
	public Employees getEmployeeById(@RequestParam("id") String id)
	{
		return employeesService.getEmployeeById(id);
	}
	
	@GetMapping("/employee")
	@ResponseBody
	public Employees getEmployee(@RequestParam("emp_no") String emp_no, @RequestParam("first_name")String first_name)
	{
		return employeesService.getEmployee(emp_no, first_name);
	}
	
}
