package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.dto.Employees;

@Mapper
public interface EmployeesDAO
{
	// 단일 객체가 아닌 리스트로 반환하는 경우
	// 마이 바티스가 sQl 을 매핑해서 실제 쿼리처리 할 때 selectList()를 사용
	public List<Employees> getAllEmployees();
	
	// 단일 객체로 반환하는 경우
	// 마이 바티스가 SQl 을 매핑해서 실제 쿼리처리 할 때 selectOne() 을 사용
	public Employees getEmployeeById(String id);
	
	// 숙제....
	public Employees getEmployee(@Param("emp_no")String emp_no, @Param("first_name")String first_name);
}
