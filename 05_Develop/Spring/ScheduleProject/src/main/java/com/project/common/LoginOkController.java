package com.project.common;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class LoginOkController {
	
	@RequestMapping(value="/loginok.do",  method = {RequestMethod.POST, RequestMethod.GET})
	public String LoginCheck(HttpServletRequest request, HttpServletRequest response) {
		
		//login.jsp에서 loginok.jsp로 데이터 넘김 
		//loginok.java에서 로그인 성공 유무 및 로그인 session 저장
		//완료되면 main.jsp 이동
		
		//세션 생성 
		HttpSession session = request.getSession();
		
		String userid = request.getParameter("id");
		String userpw = request.getParameter("pw");
		
		System.out.println("loginok 페이지 "+userid);
		System.out.println("loginok 페이지 "+userpw);
		
		if(userid != null && userpw != null){
			session.setAttribute("userid",userid);
			session.setAttribute("userpw",userpw);
			System.out.println("loginok 페이지 id "+session.getAttribute("userid"));
			System.out.println("loginok 페이지 pw "+session.getAttribute("userpw"));

			HashMap<String,String> map = new HashMap<String,String>();

			map.put("id", userid);
			map.put("pw", userpw);
			
			request.setAttribute("login_map", map);
			
			
			return "redirect:/main.do";
		}

		
		return "redirect:/login.do";
		
	}

}
