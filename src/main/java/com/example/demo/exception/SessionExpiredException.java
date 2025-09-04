package com.example.demo.exception;

public class SessionExpiredException extends RuntimeException
{
	public SessionExpiredException (String message)
	{
		super(message);
	}
}
