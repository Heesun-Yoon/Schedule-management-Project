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
public class ScheduleDateFilterController {
	
	@Autowired
	private IScheduleDateFilterDAO dao;
	
	@RequestMapping(value="/schedule/scheduledatefilter.do", method = {RequestMethod.POST, RequestMethod.GET})
	@ResponseBody
	public List<ScheduleDTO> scheduleDateFilter (ScheduleDTO dto,  HttpServletRequest request, HttpServletRequest response) {
		
		
		//date필터 select 처리
		
		String sel_txt = request.getParameter("sel_txt");
		String filter3_txt = request.getParameter("filter3_txt");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		if(sel_txt.equals("start")) sel_txt = "start_time"; 
		if(sel_txt.equals("end")) sel_txt = "end_time"; 
		
		System.out.println("datefilter: "+sel_txt);
		System.out.println("datefilter: "+filter3_txt);
		
		HashMap<String,String> map = new HashMap<String,String>();
		
		map.put("id", id);
		map.put("pw", pw);
		map.put("sel_txt", sel_txt);
		map.put("filter3_txt", filter3_txt);
		
		List<ScheduleDTO> dateFilter_result = dao.dateFilter_result(map);
		
		
		System.out.println("datesize :: "+dateFilter_result.size());

		return dateFilter_result;
	}
	
}
