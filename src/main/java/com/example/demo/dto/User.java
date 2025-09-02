package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User
{
	private String user_id;
	private String login_id;
	private String login_password;
	private String user_name;
	private String phone_number;
	private String address;
}