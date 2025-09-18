package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.dao.account.ManagerAccountDAO;
import com.example.demo.dao.employees.EmployeesUsersDAO;
import com.example.demo.dto.ManagerAccount;
import com.example.demo.dto.Users;

@Service
public class LoginService
{
	private final EmployeesUsersDAO employeesUsersDAO;
	private final ManagerAccountDAO managerAccountDAO;
	
	public LoginService(EmployeesUsersDAO employeesUsersDAO, ManagerAccountDAO managerAccountDAO)
	{
		this.employeesUsersDAO = employeesUsersDAO;
		this.managerAccountDAO = managerAccountDAO;
	}

	public Users employeesUsersLogin(String login_id, String login_password)
	{
		// TODO : 비즈니스 로직.
		return employeesUsersDAO.login(login_id, login_password);
	}
	
	public ManagerAccount managerAccountLogin(String login_id)
	{
		// 리턴 매니저 다오
		return managerAccountDAO.login(login_id);
	}
	
	
}
