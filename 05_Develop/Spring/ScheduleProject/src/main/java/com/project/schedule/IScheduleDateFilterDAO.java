package com.project.schedule;

import java.util.HashMap;
import java.util.List;

public interface IScheduleDateFilterDAO {
	
	//DAO에서 작업 할 내용 적음
	List<ScheduleDTO> startdateFilter_result(HashMap<String,String> map);
	List<ScheduleDTO> enddateFilter_result(HashMap<String,String> map);

}
