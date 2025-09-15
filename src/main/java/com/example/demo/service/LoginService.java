package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.dao.employees.UsersDAO;
import com.example.demo.dto.Users;

@Service
public class LoginService
{
	private final UsersDAO usersDAO;
	
	public LoginService(UsersDAO usersDAO)
	{
		this.usersDAO = usersDAO;
	}

	public Users login(String login_id, String login_password)
	{
		// TODO : 비즈니스 로직.
		return usersDAO.login(login_id, login_password);
	}
	
	
}
