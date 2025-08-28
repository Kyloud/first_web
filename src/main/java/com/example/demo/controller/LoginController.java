package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.dto.User;
import com.example.demo.service.LoginService;

@Controller
public class LoginController {

	  private final LoginService LoginService;

	  LoginController (LoginService LoginService) {
	        this.LoginService = LoginService;
	    }
	
	 @PostMapping("login")
	public String getUser
	(
			  @ModelAttribute User login_user
//			  @RequestParam("login_id") String login_id
//			, @RequestParam("login_password") String login_password
			, Model model 
	)
	{
		System.out.println("입력한 ID : " + login_user.getLogin_id());
		System.out.println("입력한 PASSWORD : " + login_user.getLogin_password());
		 
		User user = LoginService.getUser(login_user.getLogin_id(), login_user.getLogin_password());
		
		if (user != null)
		{
			model.addAttribute("user", user);
			return "dashboard";
		}
		else
			return "redirect:/login.html";
	}
	
}
