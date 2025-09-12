package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dto.Employees;
import com.example.demo.service.EmployeesService;

@Controller
public class AjaxController
{
	private final EmployeesService employeesService;
	
	public AjaxController (EmployeesService employeesService) {
		this.employeesService = employeesService;
	}
	
	@PostMapping("/ajaxExam")
	@ResponseBody
	public Employees ajaxExam(@RequestBody Employees employees)
	{
		employees = employeesService.getEmployee(Integer.toString(employees.getEmp_no()), employees.getFirst_name());
		return employees;
	}

}
