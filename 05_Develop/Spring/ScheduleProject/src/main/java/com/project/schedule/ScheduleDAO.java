package com.project.schedule;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScheduleDAO implements IScheduleDAO{
	
	@Autowired
	private SqlSessionTemplate template;

	@Override
	public List<ScheduleDTO> scheduleList(HashMap<String, String> smap) {
//		System.out.println("DAO map id "+smap.get("id"));
//		System.out.println("DAO map pw "+smap.get("pw"));
//		System.out.println("dao : "+smap.toString());
		return template.selectList("schedule.scheduleList",smap);
	}

	@Override
	public List<ScheduleCountDTO> scheduleList_cnt(HashMap<String, String> cntmap) {
		return template.selectList("schedule.scheduleList_cnt",cntmap);
	}

}
