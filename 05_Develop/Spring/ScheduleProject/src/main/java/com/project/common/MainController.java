package com.project.common;

import java.util.HashMap;
//import java.util.List;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.schedule.IScheduleDAO;
import com.project.schedule.ScheduleDTO;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class MainController {
	
	@Autowired
	private IMemberDAO dao;
	@Autowired
	private IScheduleDAO sdao;
	
	@RequestMapping(value="/main.do", method = {RequestMethod.POST, RequestMethod.GET})
	public String mainPage (MemberDTO dto, HttpServletRequest request, HttpServletRequest response, String id, String pw) {
		
		
//		int session_seq = 0;
		
		HttpSession session = request.getSession();
		
		//세션 유지시간 설정 (30분)
		session.setMaxInactiveInterval(1800);
		
//		session.setAttribute("seq", dto.getSeq());
//		session.setAttribute("id", dto.getSeq());
//		session.setAttribute("pw", dto.getPw());
		
//		session_seq = (Integer)session.getAttribute("seq");
//		
//		System.out.println("main seq"+session_seq);

		//1. 데이터 가져오기 (로그인한 사람의 id,pw) 
		//2. DB에서 가져온 데이터와 비교
		//3. DTO 반환 -> JSP 호출
		
		//반환값O
		//1. 단일값 반환 : 단일 레코드 + 단일 컬럼 : int or double or String
		//2. 다중값 반환 : 단일 레코드 + 다중 컬럼 : DTO
		//3. 다중값 반환 : 다중 레코드 + 단일 컬럼 : List<String>
		//4. 다중값 반환 : 다중 레코드 + 다중 컬럼 : List<DTO>
		
		boolean result_flag = false;
		
		System.out.println("main "+id);
		System.out.println("main "+pw);
				
		HashMap<String,String> map = new HashMap<String,String>();
		HashMap<String,String> smap = new HashMap<String,String>();
		
		map.put("id", id);
		map.put("pw", pw);
		
//		smap.put("seq", session_seq+"");
		smap.put("id", id);
		smap.put("pw", pw);
		
//		System.out.println("main smap id "+smap.get("id"));
//		System.out.println("main smap pw "+smap.get("pw"));
		
		List<MemberDTO> result = dao.list(map);		
		int result_cnt = dao.list_cnt(map);		

		List<ScheduleDTO> s_result = sdao.scheduleList(map);
//		List<ScheduleDTO> s_result = dao.scheduleList(smap);
		System.out.println("main (s_result > content) "+s_result.get(0).getContent());
		

		System.out.println(s_result.get(0).getTitle());
		System.out.println(s_result.get(0).getContent());

		request.setAttribute("result", result);

		if(result_cnt > 0) {
			//로그인 성공 > main page 이동
			request.setAttribute("result", !result_flag);
			request.setAttribute("s_result", s_result);
			return "/main/main";
		} else {
			request.setAttribute("result", result_flag);
			return "/common/login";
		} 


	}

}
