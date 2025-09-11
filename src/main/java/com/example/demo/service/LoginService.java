package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.dao.UserDAO;
import com.example.demo.dto.User;

@Service
public class LoginService
{
	private final UserDAO userDAO;
	
	public LoginService(UserDAO usersDAO)
	{
		this.userDAO = usersDAO;
	}

	public User login(String login_id, String login_password)
	{
		// TODO : 비즈니스 로직.
		return userDAO.login(login_id, login_password);
	}
	
	
}
