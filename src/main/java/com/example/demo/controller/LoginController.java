package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.dto.User;
import com.example.demo.service.LoginService;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController
{
	private final LoginService LoginService;
	
	LoginController (LoginService LoginService)
	{
		this.LoginService = LoginService;
	}
	
	@PostMapping("login")
	public String getUser
	(
			  @ModelAttribute User user
			  // @RequestParam("login_id") String login_id
			  // , @RequestParam("login_password") String login_password
			, Model model 
			, HttpSession session
	)
	{
		System.out.println("현재 세션 ID : " 	+ session.getId());
		System.out.println("MAX inactive : " 	+ session.getMaxInactiveInterval());
		System.out.println("입력한 ID : " 		+ user.getLogin_id());
		System.out.println("입력한 PASSWORD : " + user.getLogin_password());
		
		User login_user = LoginService.login(user.getLogin_id(), user.getLogin_password());
		
		if (login_user != null)
		{			
			model.addAttribute("result", 0);
			model.addAttribute("user", login_user);
			return "dashboard";
		}
		else
			return "redirect:/login.html";
		
		 
		 
	}
	
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
}
