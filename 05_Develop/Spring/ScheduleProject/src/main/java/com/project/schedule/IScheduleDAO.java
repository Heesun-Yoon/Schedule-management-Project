package com.project.schedule;

import java.util.HashMap;
import java.util.List;

public interface IScheduleDAO {
	
	//DAO에서 작업 할 내용 
	
	List<ScheduleDTO> scheduleList(HashMap<String,String> smap);
	List<ScheduleCountDTO> scheduleList_cnt(HashMap<String, String> cntmap);

}
