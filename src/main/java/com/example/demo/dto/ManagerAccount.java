package com.example.demo.dto;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import com.example.demo.dto.enumeration.AccessLevel;
import com.example.demo.dto.enumeration.AccountStatus;

import lombok.Data;

@Data
public class ManagerAccount
{
	String manager_id;
	String manager_name;
	String login_id;
	String login_password;
	String email;
	AccessLevel access_level;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	LocalDateTime create_dt;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	LocalDateTime expire_dt;

	AccountStatus account_status;
	String delete_at;
}
