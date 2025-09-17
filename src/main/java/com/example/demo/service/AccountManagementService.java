package com.example.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.account.ManagerAccountDAO;
import com.example.demo.dto.ManagerAccount;

@Service
public class AccountManagementService
{
	private final ManagerAccountDAO managerAccountDAO;
	
	public AccountManagementService(ManagerAccountDAO managerAccountDAO)
	{
		this.managerAccountDAO = managerAccountDAO;
	}
	
	@Transactional(transactionManager = "accountTransactionManager")
	public int addNewManager(ManagerAccount managerAccount)
	{
		return managerAccountDAO.addNewManager(managerAccount);
	}
}
