package com.project.schedule;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class ScheduleAddController {
	
	@Autowired
	private IScheduleAddDAO dao;
	
	//ajax에서 응답을 받기 위한 어노테이션 (안적으면 ajax에서 success로 안넘어감)
	@ResponseBody
	@RequestMapping(value="/schedule/scheduleadd.do", method = {RequestMethod.POST, RequestMethod.GET} )
	public void scheduleAdd (HttpServletRequest request, HttpServletRequest response, ScheduleDTO dto) {
		
		//main modal창에서 넘어온 데이터를 DB에 insert 
		
		System.out.println("추가 페이지");  	

		
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String tag = request.getParameter("tag");
		String startdate = request.getParameter("startdate");
		String enddate = request.getParameter("enddate");
		String priority = request.getParameter("priority");
		
		System.out.println(title);
		System.out.println(content);
		System.out.println(tag);
		System.out.println(startdate);
		System.out.println(enddate);
		System.out.println(priority);
		
		HashMap<String,String> saddmap = new HashMap<String,String>(); 
		saddmap.put("title",title);
		saddmap.put("content",content);
		saddmap.put("tag",tag);
		saddmap.put("startdate",startdate);
		saddmap.put("enddate",enddate);
		saddmap.put("priority",priority);
		
		//insert 작업 
		//임시 주석
//		List<ScheduleDTO> saddmap_ok = dao.scheduleAdd(saddmap);
//		System.out.println("saddmap_ok"+saddmap_ok);
		
		
		request.setAttribute("saddmap", saddmap);
		
		
//		return "/main/main";
		
	}

}
