package com.example.demo.dto;

import java.math.BigInteger;
import java.util.Date;

import com.example.demo.dto.enumeration.Action;
import com.example.demo.dto.enumeration.DetectionType;
import com.example.demo.dto.enumeration.RiskLevel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Policy
{
	private String 			policy_id;
	private String			policy_name;
	private DetectionType 	detection_type;
	private String 			large_category;
	private String 			middle_category;
	private String 			content1;
	private String 			content2;
	private String 			content3;
	private BigInteger 		base_time;
	private Integer 		base_count;
	private String 			target_ip;
	private Integer 		target_port;
	private String 			server_ip;
	private RiskLevel 		risk_level;
	private Action 			action;
	private boolean 		is_running;
	private String 			policy_detail;
	private Date 			created_at;
	private String 			created_by;
	private Date 			updated_at;
	private String 			updated_by;
		
}
