package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dao.policy.PresentPolicy;
import com.example.demo.dto.Policy;

@Service
public class PoliciesService 
{
	private final PresentPolicy presentPolicy;
	
	public PoliciesService(PresentPolicy presentPolicy)
	{
		this.presentPolicy = presentPolicy;
	}

	public List<Policy> getAllPolicy()
	{
		return presentPolicy.getAllPolicy();
	}
}
