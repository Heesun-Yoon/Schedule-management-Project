package com.project.schedule;

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
public class ScheduleController {
	
	@Autowired
	private IScheduleDAO dao;
	
	@RequestMapping(value="/smain.do", method = {RequestMethod.POST, RequestMethod.GET})
	public String schedule(HttpServletRequest request, HttpServletRequest response) {
		
		
		//반환값O
		//1. 단일값 반환 : 단일 레코드 + 단일 컬럼 : int or double or String
		//2. 다중값 반환 : 단일 레코드 + 다중 컬럼 : DTO
		//3. 다중값 반환 : 다중 레코드 + 단일 컬럼 : List<String>
		//4. 다중값 반환 : 다중 레코드 + 다중 컬럼 : List<DTO>
		
		Object session_seq = 0;
		
		
		//로그인 세션 
		HttpSession session = request.getSession();
		session_seq = (int)(session.getAttribute("seq"));
//		session_seq = (int)session_seq;
		
		System.out.println("스케줄 세션seq"+session.getAttribute("seq"));
		
		
		//DB에서 게시글 정보 가져와서 JSP로 넘겨주기
		
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		
		map.put("seq",(Integer) session_seq);
		
		
		List<ScheduleDTO> scheduleResult = dao.scheduleList(map);
		
		System.out.println(scheduleResult.get(0).getTitle());
		System.out.println(scheduleResult.get(0).getContent());
		
		request.setAttribute("s_result", scheduleResult);
		
		return "/main/main";

	}

}
