package com.example.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dto.Employees;
import com.example.demo.service.EmployeesService;

@Controller
public class EmployeesController
{
	private static final Logger logger = LoggerFactory.getLogger(EmployeesController.class);
	private final EmployeesService employeesService;
	
	
	public EmployeesController(EmployeesService employeesService)
	{
		this.employeesService = employeesService;
	}
	
	@GetMapping("employees")
	public String getAllEmployees(Model model)
	{
		List<Employees> employees = employeesService.getAllEmployees();
		
		model.addAttribute("employees", employees);
		logger.info("사용자가 /employees 페이지를 요청함");
		
		return "employees";
	}
	
	@GetMapping("employeeById")
	@ResponseBody
	public Employees getEmployeeById(@RequestParam("id") String id)
	{
		logger.info("사용자가 /employeesById 페이지를 요청함");
		Employees employees = employeesService.getEmployeeById(id);
		if ( employees == null )
		{
			logger.warn("사용자가 사원 번호로 [" + id + "] 를 검색했지만 어떠한 결과도 찾을 수 없었습니다.");
			employees = new Employees();
			employees.setFirst_name("없어");
		}
		return employees;
	}
	
	@GetMapping("employee")
	@ResponseBody
	public Employees getEmployee(@RequestParam(value = "emp_no", required = false) String emp_no, @RequestParam(value = "first_name", required = false)String first_name)
	{
		logger.info("사용자가 /employee 페이지를 요청함");
		return employeesService.getEmployee(emp_no, first_name);
	}
	
	@GetMapping("updateFirstName")
	@ResponseBody
	public String updateFirstName() 
	{
		logger.info("사용자가 /updateFirstName 페이지를 요청함");
		Employees employees = new Employees();
		employees.setEmp_no(10001);
		employees.setFirst_name("lee");
		employees.setLast_name("sungran");
		
		int result = employeesService.updateFirstName(employees);
		
		if (result == 0)		return "실패";
		else if (result == 1)	return "성공";
		else					return "대형사고";
	}
	
	@GetMapping("thymeleaf")
	public String thymeleafExe (@RequestParam("emp_no") String emp_no, Model model)
	{
		logger.info("사용자가 /thymeleaf 페이지를 요청함");
		Employees employee = employeesService.getEmployeeById(emp_no);

		model.addAttribute("employee", employee);
		
		return "welcome";
	}
	
}
