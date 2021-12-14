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
import com.project.schedule.ScheduleDTO;

@Controller
@Log4j
public class ScheduleFilterController {
	
	@Autowired
	private IScheduleFilterDAO dao;

	@RequestMapping(value="/schedule/schedulefilter.do", method = {RequestMethod.POST, RequestMethod.GET} )
	@ResponseBody
	//List<ScheduleDTO>
	public List<ScheduleDTO> scheduleFilter (ScheduleDTO dto, HttpServletRequest request, HttpServletRequest response) {
		
	{
			//Main 페이지에서 filter 부분 DB select 진행 작업 Controller
			String filter1_txt = request.getParameter("filter1_txt");
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			System.out.println("스케줄 필터: "+filter1_txt);
			System.out.println("스케줄 필터 id: "+id);
			System.out.println("스케줄 필터 pw: "+pw);
			
			//select 하는데 필요한 정보
			//user id, pw 
			HashMap<String,String> map = new HashMap<String,String>();
			
			map.put("id", id);
			map.put("pw", pw);
			map.put("filter_txt", filter1_txt);
			
	
			//select 날리기		
			List<ScheduleDTO> filter_result = dao.filter_result(map);
			
			System.out.println("필터 select 완료:: "+filter_result.size());
			System.out.println("필터 select 완료:: "+filter_result.get(0).getTag());
			
			//select 작업이라 결과값 return 필요
			return filter_result;
	
			
			}
			
		}
		
	}
