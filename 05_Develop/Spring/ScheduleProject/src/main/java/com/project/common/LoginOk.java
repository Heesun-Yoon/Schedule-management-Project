package com.project.common;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class LoginOk {
	
	@RequestMapping(value="/loginok.do",  method = {RequestMethod.POST, RequestMethod.GET})
	public String LoginCheck(HttpServletRequest request, HttpServletRequest response) {
		
		//login.jsp에서 loginok.jsp로 데이터 넘김 
		//loginok.java에서 로그인 성공 유무 및 로그인 session 저장
		//완료되면 main.jsp 이동
		return "/common/main";
		
	}

}
