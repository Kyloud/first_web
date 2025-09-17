package com.example.demo.dao.policy;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.dto.Policy;

@Mapper
public interface PresentPolicy {
	public List<Policy> getAllPolicy();
}
