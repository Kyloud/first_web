package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dao.policy.PoliciesDAO;
import com.example.demo.dto.Policy;

@Service
public class PoliciesService 
{
	private final PoliciesDAO policiesDAO;
	
	public PoliciesService(PoliciesDAO policiesDAO)
	{
		this.policiesDAO = policiesDAO;
	}

	public List<Policy> getAllPolicy()
	{
		return policiesDAO.getAllPolicy();
	}
}
