package com.project.schedule;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScheduleFilterDAO implements IScheduleFilterDAO{
	
	@Autowired
	private SqlSessionTemplate template;
	
	@Override
	public List<ScheduleDTO> filter_result(HashMap<String, String> map) {
		return template.selectList("schedule.filter_result",map);
	}
}
