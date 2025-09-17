package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dto.ManagerAccount;
import com.example.demo.service.AccountManagementService;

@Controller
public class ManagerAccountController
{
	private AccountManagementService accountManagementService;
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
		
		logger.info("===========ManagerAccount==============");
		logger.info(managerAccount.getManager_id());
		logger.info(managerAccount.getManager_name());
		logger.info(managerAccount.getLogin_id());
		logger.info(managerAccount.getLogin_password());
		logger.info(managerAccount.getEmail());
		logger.info("권한 레벨" + managerAccount.getAccess_level());
		logger.info("만료 날짜" + managerAccount.getExpire_dt());
		
		try
		{
			accountManagementService.addNewManager(managerAccount);
			requestResult = "Success..!";
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
