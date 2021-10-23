package com.project.schedule;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
//@Repository
public class ScheduleAddDAO implements IScheduleAddDAO{
	@Autowired
	private SqlSessionTemplate template;
	
//	@Autowired
//	private SqlSession session;
	
//	public int scheduleAdd(int saddmap) {
//		return template.insert("shcedule.scheduleAdd", saddmap);
//	}

	@Override
	public int scheduleAdd(HashMap<String, String> saddmap) {
		System.out.println(saddmap);
		return template.insert("schedule.scheduleAdd", saddmap);
//		return session.insert("shcedule.scheduleAdd", saddmap);
	}
	

	
}
