package com.project.common;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class LoginOkController {
	
	@Autowired
	private IMemberDAO dao;
	
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
			
			//DB에서 로그인 정보 맞는지 확인 후 SEQ main controller에 넘겨주기
			List<MemberDTO> login_ok = dao.list(map);
			
			System.out.println(map.get("id"));
			System.out.println(map.get("pw"));
			
			System.out.println("loginOK:: "+login_ok.get(0).getSeq());
			System.out.println("loginOK:: "+login_ok.get(0).getId());
			System.out.println("loginOK:: "+login_ok.get(0).getPw());

//			map.put("seq", login_ok.get(0).getSeq()+"");
			
			session.setAttribute("seq", login_ok.get(0).getSeq());
			
			request.setAttribute("login_map", map);
			
			
			return "redirect:/main.do";
//			return "/common/loginok";
		}

		System.out.println("로그인값 비었음");
		return "redirect:/login.do";
//		return "/common/loginok";
		
	}

}
