package com.example.demo.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.dto.Users;

@Mapper
public interface UsersDAO
{
	// 단일 객체로 반환하는 경우
	// 마이 바티스가 SQl 을 매핑해서 실제 쿼리처리 할 때 selectOne() 을 사용
	public Users login(@Param("login_id")String login_id, @Param("login_password")String login_password);

}
