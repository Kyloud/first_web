package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.dto.ManagerAccount;
import com.example.demo.service.LoginService;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController
{
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	private final LoginService loginService;

	LoginController(LoginService loginService) {
		this.loginService = loginService;
	}	
	
	@PostMapping("login")
	public String login
	(@ModelAttribute ManagerAccount login_users
	//    @RequestParam("login_id") String login_id
	// 	, @RequestParam("login_password") String login_password
		, Model model, HttpSession session
	)
	{
		logger.info("사용자가 로그인을 시도했습니다!");
		logger.info("로그인을 요청한 세션 ID : [" + session.getId() + "]");
		logger.debug("MAX inactive : " + session.getMaxInactiveInterval());
		logger.info("입력한 ID : " + login_users.getLogin_id());
		logger.info("입력한 PASSWORD : " + login_users.getLogin_password());

		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encodeedPassword = encoder.encode(login_users.getLogin_password());
		
		System.out.println("사용자가 입력한 로그인 아이디 : " + login_users.getLogin_id());
		System.out.println("EncodedPassword : " + encodeedPassword);
		
		// 사용자가 입력한 로그인 아이디로 로우 가져옴
		ManagerAccount managerAccount = loginService.managerAccountLogin(login_users.getLogin_id());
		System.out.println(managerAccount.getManager_id());
		
		try
		{
			Boolean result = encoder.matches(login_users.getLogin_password(), managerAccount.getLogin_password());
		
			if(result)
			{
				session.setAttribute("account", managerAccount);
				model.addAttribute("result", 0);
				model.addAttribute("account", managerAccount);
				
				System.out.println("사용자가 로그인에 성공했습니다!");
				logger.info("사용자가 로그인에 성공했습니다!");
			}
		}
		catch(Exception e)
		{
			System.err.println("사용자가 로그인에 실패했습니다");
			logger.warn("사용자가 로그인에 실패했습니다");
			return "redirect:/login.html";
		}
		
		return "dashboard";
		
		/*
		Users login_user = (Users)session.getAttribute("user");

		if (login_user == null) {
			login_user = loginService.login(users.getLogin_id(), users.getLogin_password());

			if (login_user != null) {
				session.setAttribute("user", login_user);
				model.addAttribute("result", 0);
				model.addAttribute("user", login_user);

				logger.info("사용자가 로그인에 성공했습니다!");
				return "dashboard";
			} else {
				logger.warn("사용자가 로그인에 실패했습니다");
				return "redirect:/login.html";
			}

		}
		return "dashboard";
		*/
	}

	@GetMapping("logout")
	public String logout(HttpSession session) {
		logger.info("사용자가 로그아웃을 요청했습니다, 삭제된 세션 ID : [" + session.getId() + "]");
		session.removeAttribute("user");
		return "redirect:/login.html";
	}
	
}
