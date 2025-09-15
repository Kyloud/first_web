package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dto.Policy;
import com.example.demo.service.PoliciesService;

@Controller
public class PoliciesController {
	
	private final PoliciesService policiesService;
	
	public PoliciesController (PoliciesService policesService)
	{
		this.policiesService = policesService;
	}
	
	@GetMapping("policy")
    @ResponseBody
    public List<Policy> getAllPolicy() {
        return policiesService.getAllPolicy();
    }
}
