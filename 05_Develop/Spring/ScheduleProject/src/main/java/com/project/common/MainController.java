package com.project.common;

import java.util.ArrayList;
import java.util.Arrays;
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
import com.project.schedule.ScheduleCountDTO;
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
	public String mainPage (MemberDTO dto, ScheduleCountDTO scdto, HttpServletRequest request, HttpServletRequest response, String id, String pw) {
		
		
//		int session_seq = 0;
		
		//세션 생성 
		HttpSession session = request.getSession();
		
		//
		
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
		HashMap<String,String> cntmap = new HashMap<String,String>();
		
		map.put("id", id);
		map.put("pw", pw);
		
//		smap.put("seq", session_seq+"");
		smap.put("id", id);
		smap.put("pw", pw);

		cntmap.put("id", id);
		cntmap.put("pw", pw);
		
		
//		System.out.println("main smap id "+smap.get("id"));
//		System.out.println("main smap pw "+smap.get("pw"));
		
		List<MemberDTO> result = dao.list(map);		
		int result_cnt = dao.list_cnt(map);		

		List<ScheduleDTO> s_result = sdao.scheduleList(map);
//		List<ScheduleDTO> s_result = dao.scheduleList(smap);
//		System.out.println("main (s_result > content) "+s_result.get(0).getContent());
		
		//tag 를 ","로 분리하여 동적 태그 추가해야 함,,
		
//		System.out.println(s_result.get(0).getTag());
		
		//tag 컬럼값을 ","으로 나눔
//		String[] tag_list = {};
//		String[] tag_list = s_result.get(0).getTag().split(",");
//		ArrayList<String> tag_list = (ArrayList<String>) Arrays.asList(s_result.get(0).getTag().split(","));
		ArrayList<String> tag_list = new ArrayList<String>(Arrays.asList(s_result.get(0).getTag().split(",")));
//		tag_list = s_result.get(0).getTag().split(",");
		
//		System.out.println("main split complete : "+tag_list[0]);
//		System.out.println("main split complete toString: "+tag_list.toString());
//		System.out.println("main split complete 0 : "+tag_list.get(0));
//		System.out.println("main split complete 1 : "+tag_list.get(1));
		
		
		//To do, Doing, Done 게시물 갯수 
		//scdto 사용 (ScheduleCountDTO.java)
		//매개변수 (member_seq) = 로그인 seq 
		System.out.println("메인임!! 로그인 seq "+session.getAttribute("seq"));
		String cnt_memseq = (Integer)session.getAttribute("seq") + 1 + "";
		System.out.println("메인 cnt_memseq  "+cnt_memseq);
		
		cntmap.put("member_seq", cnt_memseq);
		
		
		List<ScheduleCountDTO> list_cnt = sdao.scheduleList_cnt(cntmap);
		
//		System.out.println("메인에서 list_cnt "+ list_cnt.get(0).getTodo_cnt());
//		System.out.println("메인에서 list_cnt "+ list_cnt.get(0).getDoing_cnt());
//		System.out.println("메인에서 list_cnt "+ list_cnt.get(0).getDone_cnt());
		
		request.setAttribute("sche_cnt", list_cnt);
		
		
//		System.out.println(s_result.get(0).getContent());

		request.setAttribute("result", result);

		if(result_cnt > 0) {
			//로그인 성공 > main page 이동
			request.setAttribute("result", !result_flag);
			request.setAttribute("tag_list", tag_list);
			request.setAttribute("s_result", s_result);
			return "/main/main";
		} else {
			request.setAttribute("result", result_flag);
			return "/common/login";
		} 


	}

}
