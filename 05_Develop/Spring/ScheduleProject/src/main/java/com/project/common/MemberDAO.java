package com.project.common;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberDAO implements IMemberDAO{
	
	@Autowired
	private SqlSessionTemplate template;

	@Override
	public List<MemberDTO> list(HashMap<String, String> map) {
		// TODO Auto-generated method stub
		return null;
	}

}
