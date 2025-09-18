package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dto.ManagerAccount;
import com.example.demo.service.AccountManagementService;

@Controller
public class ManagerAccountController
{
	private final AccountManagementService accountManagementService;
	private static final Logger logger = LoggerFactory.getLogger(ManagerAccountController.class);

	ManagerAccountController(AccountManagementService accountManagementService)
	{
		this.accountManagementService = accountManagementService;
	}
	
	@GetMapping("acountManagement")
    public String addUser()
	{
        return "acountManagement";
    }
	
	@PostMapping("addNewManager")
	@ResponseBody
	public String addNewManager(ManagerAccount managerAccount)
	{
		String requestResult = null;
		
		// 로그인 암호화 처리
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	    String encodedPssword = encoder.encode(managerAccount.getLogin_password()); // 인코딩하고싶은 문자열 삽입

	    System.out.println(managerAccount.getLogin_password());
	    System.out.println("EncodedPassword: " + encodedPssword);
        
        managerAccount.setLogin_password(encodedPssword);
		
		logger.info("=========== ManagerAccount ==============");
		logger.info(managerAccount.getManager_id());
		logger.info(managerAccount.getManager_name());
		logger.info(managerAccount.getLogin_id());
		logger.info("로그인 패스워드 : " + managerAccount.getLogin_password());
		logger.info("이메일 : " + managerAccount.getEmail());
		logger.info("권한 레벨 : " + managerAccount.getAccess_level());
		logger.info("만료 날짜 : " + managerAccount.getExpire_dt());
		
		
		System.out.println("=========== ManagerAccount ==============");          
		System.out.println(managerAccount.getManager_id());
		System.out.println(managerAccount.getManager_name());
		System.out.println(managerAccount.getLogin_id());
		System.out.println("로그인 패스워드 : " + managerAccount.getLogin_password());
		System.out.println("이메일 : " + managerAccount.getEmail());       
		System.out.println("권한 레벨 : " + managerAccount.getAccess_level());
		System.out.println("만료 날짜 : " + managerAccount.getExpire_dt());
		
		
		
		try
		{
			int updateRowValue = accountManagementService.addNewManager(managerAccount);
			requestResult = "Success..!\n" + updateRowValue + "개의 행이 업데이트 되었습니다.";
		}
		catch (Exception e)
		{
			System.err.println(e.getClass().getName());
			System.err.println(e.getMessage());
			requestResult = "Failed..."; 
		}
		
		return requestResult;
	}
}
