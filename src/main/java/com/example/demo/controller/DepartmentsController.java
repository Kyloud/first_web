package com.example.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dto.Departments;
import com.example.demo.service.DepartmentsService;

@Controller
public class DepartmentsController 
{
	private final DepartmentsService departmentsService;
	private static final Logger logger = LoggerFactory.getLogger(DepartmentsController.class);
	
	public DepartmentsController(DepartmentsService departmentsService)
	{
		this.departmentsService = departmentsService;
	}
	
	@GetMapping("departments")
	public String getDepartmentsTable(Model model)
	{
		List<Departments> departments = departmentsService.getAllDepartments();
		
		model.addAttribute("departments", departments);
		logger.info("사용자가 /departments 페이지를 요청함");
		
		return "departments";
	}
	
	@PostMapping("/ajaxInsertDepartment")
	@ResponseBody
	public int ajaxInsertDepartment (@RequestBody Departments departments)
	{
		int result;
		
		try { result = departmentsService.insertDepartment(departments.getDept_no(), departments.getDept_name()); }
		catch (DuplicateKeyException e) { result = 0; }
		
		return result;
	}
}
