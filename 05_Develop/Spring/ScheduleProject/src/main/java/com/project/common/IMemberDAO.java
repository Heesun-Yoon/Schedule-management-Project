package com.project.common;

import java.util.HashMap;
import java.util.List;

public interface IMemberDAO {
	
	List<MemberDTO> list(HashMap<String, String> map);


}
