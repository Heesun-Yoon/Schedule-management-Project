package com.project.common;

import java.util.HashMap;
//import java.util.List;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class MainController {
	
	@Autowired
	private IMemberDAO dao;
	
	@RequestMapping(value="/main.do", method = {RequestMethod.POST, RequestMethod.GET})
	public String mainPage (HttpServletRequest request, HttpServletRequest response, String id, String pw) {
		

		//1. 데이터 가져오기 (로그인한 사람의 id,pw) 
		//2. DB에서 가져온 데이터와 비교
		//3. DTO 반환 -> JSP 호출
		
		//반환값O
		//1. 단일값 반환 : 단일 레코드 + 단일 컬럼 : int or double or String
		//2. 다중값 반환 : 단일 레코드 + 다중 컬럼 : DTO
		//3. 다중값 반환 : 다중 레코드 + 단일 컬럼 : List<String>
		//4. 다중값 반환 : 다중 레코드 + 다중 컬럼 : List<DTO>
		
		boolean result_flag = false;
		
//		System.out.println(id);
//		System.out.println(pw);
				
		HashMap<String,String> map = new HashMap<String,String>();
		
		map.put("id", id);
		map.put("pw", pw);
		
//		System.out.println("id "+map.get("id"));
//		System.out.println("pw "+map.get("pw"));
		
		List<MemberDTO> result = dao.list(map);		
		int result_cnt = dao.list_cnt(map);		

		
		

//		System.out.println("result seq: "+ result.get(0).getSeq());
//		System.out.println("result name: "+ result.get(0).getName());
//		System.out.println("result id: "+ result.get(0).getId());
//		System.out.println("result pw: "+ result.get(0).getPw());
//		System.out.println("result address: "+ result.get(0).getAddress());
//		System.out.println("result delflag: "+ result.get(0).getDelflag());
//		System.out.println("result: "+ result.get(0).toString());
		//result: com.project.common.MemberDTO@50834168
		
//		if((result.get(0).getSeq()) > 0) {
//			System.out.println("결과 존재");
//		}else {
//			System.out.println("결과 미존재");
//		}
//		

		request.setAttribute("result", result);

		if(result_cnt > 0) {
//		if(result.get(0)==null) {
			//로그인 성공
			request.setAttribute("result", result);
			return "/main/main";
		} else {
			request.setAttribute("result", result_flag);
			return "/common/login";
		}

//		return "/main/main";
	}

}
