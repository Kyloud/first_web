package com.example.demo.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.resource.NoResourceFoundException;

//try-catch사용하지 않아도 예외처리가 가능
//Component 포함되어 있기 때문에 자바에서 bean으로 관리
@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(NoResourceFoundException.class)
  public String handleResourceFoundException(NoResourceFoundException e)
  {
	  if(e.getMessage().contains("com.chrome.devtools.json"))
	  {
		  return "404";
	  }
	  
	  //오류 내용에 따른 적절한 처리 실행.
	  System.err.println("오류발생 : " + e.getMessage());
      return "404";
  }
  
  @ExceptionHandler(SessionExpiredException.class)
  public ModelAndView handleSessionExpiredException (SessionExpiredException e) 
  {
	  System.err.println(e.getMessage());
	  
	  ModelAndView modelAndView = new ModelAndView();
	  modelAndView.setViewName("redirect:/login.html");
	  
	  return modelAndView;
  }
  
  @ExceptionHandler(Exception.class)
  public String handleException(Exception e) {
	  System.err.println("예외 발생 : " + e.getClass().getName());
	  System.err.println("원인 : " + e.getMessage());
	  
      return "500";
  }

}
