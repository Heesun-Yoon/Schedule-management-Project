package com.project.common;

import java.util.HashMap;
import java.util.List;

import com.project.schedule.ScheduleDTO;

public interface IMemberDAO {
	
	//DAO에서 작업 할 내용 적음
	
	List<MemberDTO> list(HashMap<String, String> map);
	int list_cnt(HashMap<String, String> map);
//	List<ScheduleDTO> scheduleList(HashMap<String, String> smap);
	

}
