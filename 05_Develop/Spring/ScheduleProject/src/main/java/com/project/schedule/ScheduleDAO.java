package com.project.schedule;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScheduleDAO {
	
	@Autowired
	private SqlSessionTemplate template;

}
