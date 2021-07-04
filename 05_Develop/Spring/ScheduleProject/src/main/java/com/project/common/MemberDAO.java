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
		return template.selectList("member.loginCheck",map);
	}

	@Override
	public int list_cnt(HashMap<String, String> map) {
		return template.selectOne("member.loginCheck_cnt",map);
	}



}
