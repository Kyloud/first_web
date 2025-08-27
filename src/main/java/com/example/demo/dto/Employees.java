package com.example.demo.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Employees
{
	private int emp_no;
	private Date birth_date;
	private String first_name;
	private String last_name;
	private String gender;
	private Date hire_date;
}