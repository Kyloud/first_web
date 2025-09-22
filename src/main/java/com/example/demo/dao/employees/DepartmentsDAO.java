package com.example.demo.dao.employees;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.dto.Departments;

@Mapper
public interface DepartmentsDAO
{
	public List<Departments> getAllDepartments();
	
	public int insertDepartment(@Param("dept_no")String dept_no, @Param("dept_name")String dept_name);
}