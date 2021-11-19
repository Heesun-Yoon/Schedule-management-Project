package com.project.schedule;

import java.util.HashMap;
import java.util.List;

import com.project.common.MemberDTO;

public interface IScheduleFilterDAO {

	//DAO에서 작업 할 내용 적음

	List<ScheduleDTO> filter_result(HashMap<String, String> map);

}
