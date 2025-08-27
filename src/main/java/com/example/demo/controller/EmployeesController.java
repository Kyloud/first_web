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
		List<Employees> employees = employeesService.getAllEmployees();
		return employees;
	}
	
	@GetMapping("/employeeById")
	@ResponseBody
	public Employees getEmployeeById(@RequestParam("id") String id)
	{
		Employees employees = employeesService.getEmployeeById(id);
		if ( employees == null )
		{
			employees = new Employees();
			employees.setFirst_name("없어");
		}
		return employees;
	}
	
	@GetMapping("/employee")
	@ResponseBody
	public Employees getEmployee(@RequestParam(value = "emp_no", required = false) String emp_no, @RequestParam(value = "first_name", required = false)String first_name)
	{
		return employeesService.getEmployee(emp_no, first_name);
	}
	
	@GetMapping("/updateFirstName")
	@ResponseBody
	public String updateFirstName() 
	{
		Employees employees = new Employees();
		employees.setEmp_no(10001);
		employees.setFirst_name("lee");
		employees.setLast_name("sungran");
		
		int result = employeesService.updateFirstName(employees);
		
		if (result == 0)		return "실패";
		else if (result == 1)	return "성공";
		else					return "대형사고";
	}
}
