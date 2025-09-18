package com.example.demo.dao.account;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.dto.ManagerAccount;

@Mapper
public interface ManagerAccountDAO
{
	public int addNewManager
	(@Param("newManagerInfo")ManagerAccount managerAccount);
	
	public ManagerAccount login
	(String login_id);
}
