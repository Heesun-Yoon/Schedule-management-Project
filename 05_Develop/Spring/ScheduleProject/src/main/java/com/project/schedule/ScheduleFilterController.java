package com.project.schedule;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class ScheduleFilterController {
	
	@Autowired
	private IScheduleFilterDAO dao;

	@ResponseBody
	@RequestMapping(value="/schedule/schedulefilter.do", method = {RequestMethod.POST, RequestMethod.GET} )
	public void scheduleFilter (HttpServletRequest request, HttpServletRequest response) {
		
		//Main 페이지에서 filter 부분 DB select 진행 작업 Controller
		String filter1_txt = request.getParameter("filter1_txt");
		System.out.println("스케줄 필터: "+filter1_txt);
	}
	
}
