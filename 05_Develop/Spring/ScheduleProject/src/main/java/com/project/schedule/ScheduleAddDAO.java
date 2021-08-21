package com.project.schedule;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScheduleAddDAO implements IScheduleAddDAO{
	@Autowired
	private SqlSessionTemplate template;
	
	@Override
	public List<ScheduleDTO> scheduleAdd(HashMap<String,String> saddmap) {
		return template.selectList("shcedule.scheduleAdd", saddmap);
	}
	
}
