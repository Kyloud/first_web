package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 로그인 관련된 클라이언트의 요청을 처리하는 클래스
 * Controller는 View 의 요청을 처리.
 */
@Controller
public class LoginController {
	
	@GetMapping("login")
	@ResponseBody
	public String login()
	{
		return "어서와라 인간";
	}
	
	@GetMapping("logout")
	@ResponseBody
	public String logout()
	{
		return "잘가라 인간";
	}

	@PostMapping("login")
	public String login2
	(
		@RequestParam("id") String id
		, @RequestParam("password") String password
		,Model model
	)
	{
		System.out.println("id : " + id);
		System.out.println("password : " + password);
		
		model.addAttribute("name", id);
		return "welcome";
	}
	
	
}
