package com.project.schedule;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class ScheduleAddController {
	
	@Autowired
	private IScheduleAddDAO dao;
	
	@RequestMapping(value="/scheduleadd.do", method = {RequestMethod.POST, RequestMethod.GET} )
	public String scheduleAdd (HttpServletRequest request, HttpServletRequest response, ScheduleDTO dto) {
		
		//main modal창에서 넘어온 데이터를 DB에 insert 
		return null;
		
	}

}
