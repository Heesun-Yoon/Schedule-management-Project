package com.project.schedule;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScheduleDateFilterDAO implements IScheduleDateFilterDAO{
	
	@Autowired
	private SqlSessionTemplate template;

	@Override
	public List<ScheduleDTO> startdateFilter_result(HashMap<String, String> map) {
		return template.selectList("schedule.startdate_filter_result",map);
	}
	
	public List<ScheduleDTO> enddateFilter_result(HashMap<String, String> map) {
		return template.selectList("schedule.enddate_filter_result",map);
	}
	
	
	

}
