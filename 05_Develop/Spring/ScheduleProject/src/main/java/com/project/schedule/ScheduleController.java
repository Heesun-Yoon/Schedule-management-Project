package com.project.schedule;

import javax.servlet.http.HttpServletRequest;

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
	
	@RequestMapping(value="/main.do", method = {RequestMethod.POST, RequestMethod.GET})
	public String schedule(HttpServletRequest request, HttpServletRequest response) {
		
		
		//반환값O
		//1. 단일값 반환 : 단일 레코드 + 단일 컬럼 : int or double or String
		//2. 다중값 반환 : 단일 레코드 + 다중 컬럼 : DTO
		//3. 다중값 반환 : 다중 레코드 + 단일 컬럼 : List<String>
		//4. 다중값 반환 : 다중 레코드 + 다중 컬럼 : List<DTO>
		
		
		//DB에서 게시글 정보 가져와서 JSP로 넘겨주기
		
		return "/main/main";

	}

}
