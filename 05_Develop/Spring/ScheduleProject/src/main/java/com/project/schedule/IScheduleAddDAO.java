package com.project.schedule;

import java.util.HashMap;
import java.util.List;

public interface IScheduleAddDAO {
	
	List<ScheduleDTO> scheduleAdd(HashMap<String,String> saddmap);

}
