package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.dao.UserDAO;
import com.example.demo.dto.User;

@Service
public class LoginService
{
	private final UserDAO UserDAO;
	
	public LoginService(UserDAO UsersDAO)
	{
		this.UserDAO = UsersDAO;
	}

	public User getUser(String login_id, String login_password)
	{
		// TODO : 비즈니스 로직.
		return UserDAO.getUser(login_id, login_password);
	}
	
	
}
