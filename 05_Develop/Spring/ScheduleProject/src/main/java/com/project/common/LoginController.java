package com.project.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class LoginController {
	@RequestMapping(value="/login.do", method = {RequestMethod.POST, RequestMethod.GET} )
	public String loginPage (MemberDTO dto, HttpServletRequest request, HttpServletRequest response, String id, String pw) {
		
		//로그인 세션
		HttpSession session = request.getSession();
		
		//세션 유지시간 설정 (30분)
		session.setMaxInactiveInterval(1800);
		
		session.setAttribute("seq", dto.getSeq());
		session.setAttribute("id", dto.getSeq());
		session.setAttribute("pw", dto.getPw());
		

		String result_flag = "start";
		
		System.out.println("로그인"+id);
		System.out.println("로그인"+pw);
		
		if(id==null && pw==null) {
			request.setAttribute("result", result_flag);
			return "/common/login";
		}
		
		return "/common/login";
	}

}
