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

		//loginOk Controller에서 넘어온 데이터
		String userid =(String) session.getAttribute("userid");
		String userpw =(String) session.getAttribute("userpw");
//		int seq = (int) session.getAttribute("seq");
//		String seq = "1";
//		String seq = session.getAttribute("seq")+"";
		String seq = Integer.toString((Integer) session.getAttribute("seq"));
		
		
		System.out.println("Ok > main 데이터 : "+userid);
		System.out.println("Ok > main 데이터 : "+userpw);
		System.out.println("Ok > main 데이터 : "+seq);
//		System.out.println("메인 ::: "+request.getAttribute("login_map"));
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
		
//		System.out.println("main "+id);
//		System.out.println("main "+pw);
				
		HashMap<String,String> map = new HashMap<String,String>();
		HashMap<String,String> smap = new HashMap<String,String>();
		HashMap<String,String> cntmap = new HashMap<String,String>();
		HashMap<String,String> user_info = new HashMap<String,String>();
		
		
		map.put("id", userid);
		map.put("pw", userpw);
		
//		smap.put("seq", session_seq+"");
		smap.put("id", userid);
		smap.put("pw", userpw);

		cntmap.put("id", userid);
		cntmap.put("pw", userpw);
		
		user_info.put("id",userid);
		user_info.put("pw",userpw);
		
		
		System.out.println("메인 필터위한 id " + user_info.size());
		System.out.println("메인 필터위한 id " + user_info);
		System.out.println("메인 필터위한 id " + user_info.get("id"));
		System.out.println("메인 필터위한 id " + user_info.get("pw"));

		
		
//		System.out.println("main smap id "+smap.get("id"));
//		System.out.println("main smap pw "+smap.get("pw"));
		
//		List<MemberDTO> result = dao.list(map);		
//		int result_cnt = dao.list_cnt(map);		

		List<ScheduleDTO> s_result = sdao.scheduleList(map);
		System.out.println("메인: "+s_result.size());
		System.out.println("메인 태그: "+s_result.get(0).getTag());
		System.out.println("메인 태그: "+s_result.get(1).getTag());
		System.out.println("메인 태그: "+s_result.get(2).getTag());
		
		System.out.println("메인 state 값: "+s_result.get(0).getState());
		
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
		
		
		
		//게시물 상태(todo,doing,done 구분)
		
		
		
		
		//To do, Doing, Done 게시물 갯수 
		//scdto 사용 (ScheduleCountDTO.java)
		//매개변수 (member_seq) = 로그인 seq 
		System.out.println("메인임!! 로그인 seq "+session.getAttribute("seq"));
//		String cnt_memseq = (Integer)session.getAttribute("seq") + 1 + "";
//		String cnt_memseq = session.getAttribute("seq");
		System.out.println("메인 cnt_memseq  "+seq);
		
		cntmap.put("member_seq", seq);
		
		
		List<ScheduleCountDTO> list_cnt = sdao.scheduleList_cnt(cntmap);
		
//		System.out.println("메인에서 list_cnt "+ list_cnt.get(0).getTodo_cnt());
//		System.out.println("메인에서 list_cnt "+ list_cnt.get(0).getDoing_cnt());
//		System.out.println("메인에서 list_cnt "+ list_cnt.get(0).getDone_cnt());
		
		request.setAttribute("sche_cnt", list_cnt);
		
		
//		System.out.println(s_result.get(0).getContent());

//		request.setAttribute("result", result);

//		if(result_cnt > 0) {
//			//로그인 성공 > main page 이동
//			request.setAttribute("result", !result_flag);
//			request.setAttribute("tag_list", tag_list);
//			request.setAttribute("s_result", s_result);
//			return "/main/main";
//		} else {
//			request.setAttribute("result", result_flag);
//			return "/common/login";
//		} 

		
		request.setAttribute("result", !result_flag);
		request.setAttribute("tag_list", tag_list);
		request.setAttribute("s_result", s_result);
		//map (id,pw 담겨있음) 보내면 filter 진행시 select 필요 정보로 사용 가능
		request.setAttribute("user_info", user_info);
		return "/main/main";


	}

}
