package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.dto.User;
import com.example.demo.service.LoginService;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController
{
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	private final LoginService LoginService;
	
	LoginController (LoginService LoginService)
	{
		this.LoginService = LoginService;
	}
	
	@PostMapping("login")
	public String login
	(
			  @ModelAttribute User user
			  // @RequestParam("login_id") String login_id
			  // , @RequestParam("login_password") String login_password
			, Model model 
			, HttpSession session
	)
	{
		logger.info("사용자가 로그인을 시도했습니다!");
		logger.info("로그인을 요청한 세션 ID : [" 	+ session.getId() + "]");
		logger.debug("MAX inactive : " 	+ session.getMaxInactiveInterval());
		logger.info("입력한 ID : " 		+ user.getLogin_id());
		logger.info("입력한 PASSWORD : " + user.getLogin_password());
		
		User login_user = (User) session.getAttribute("user");
		
		if (login_user == null)
		{
			login_user = LoginService.login(user.getLogin_id(), user.getLogin_password());
		
			if (login_user != null)
			{	
				session.setAttribute("user", login_user);			
				model.addAttribute("result", 0);
				model.addAttribute("user", login_user);
				
				logger.info("사용자가 로그인에 성공했습니다!");
				return "dashboard";
			}
			else
			{
				logger.warn("사용자가 로그인에 실패했습니다");
				return "redirect:/login.html";	
			}
			
		}
		return "dashboard";
	}

	@GetMapping("logout")
	public String logout(HttpSession session)
	{
		logger.info("사용자가 로그아웃을 요청했습니다, 삭제된 세션 ID : [" + session.getId()+ "]");
		session.removeAttribute("user");
		return "redirect:/login.html";
	}






}

	 
	 
