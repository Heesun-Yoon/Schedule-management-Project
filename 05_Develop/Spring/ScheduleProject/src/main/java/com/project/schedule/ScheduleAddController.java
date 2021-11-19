package com.project.schedule;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class ScheduleAddController {
	
	@Autowired
	private IScheduleAddDAO dao;

	
	//ajax에서 응답을 받기 위한 어노테이션 (안적으면 ajax에서 success로 안넘어감)
	@ResponseBody
	@RequestMapping(value="/schedule/scheduleadd.do", method = {RequestMethod.POST, RequestMethod.GET} )
	public void scheduleAdd (HttpServletRequest request, HttpServletRequest response, ScheduleDTO dto) {
		
		//main modal창에서 넘어온 데이터를 DB에 insert 
		
		System.out.println("추가 페이지");  	
		
		//세션 생성 
		HttpSession session = request.getSession();

		//loginOk Controller에서 넘어온 데이터
		String userid =(String) session.getAttribute("userid");
		String userpw =(String) session.getAttribute("userpw");
//		int seq = (int) session.getAttribute("seq");
//		String seq = "1";
//		String seq = session.getAttribute("seq")+"";
		String member_seq = Integer.toString((Integer) session.getAttribute("seq"));
		
		System.out.println("추가"+userid);
		System.out.println("추가"+userpw);
		System.out.println("추가"+member_seq);

		
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String tag = request.getParameter("tag");
		String startdate = request.getParameter("startdate");
		String enddate = request.getParameter("enddate");
		String priority = request.getParameter("priority");
		//cost 입력값 안받았음 ㅠㅠ 0으로 넣자 
		String cost = "0";
		String state = "";
		String delflag = "0";
		
		
		//시작,끝 날짜 입력받은 그대로 따로 저장하기 위한 변수 
		// - string 가공 때문에 중간에 변형됨
		String pre_startdate = "";
		String pre_enddate = "";
		
		System.out.println("스케줄 add 시작: "+pre_startdate);	
		System.out.println("스케줄 add 끝: "+pre_enddate);	
		
		
		System.out.println(title);
		System.out.println(content);
		System.out.println(tag);
		System.out.println(startdate);
		System.out.println(enddate);
		System.out.println(priority);
		
		
		
		//state 
		//날짜별로 분기 시켜야 함 
		//todo : 오늘날짜보다 start 날짜가 큰 경우
		//doing : 오늘날짜보다 start 날짜가 작고, end 날짜가 큰 경우
		//done : 오늘날짜보다 end 날짜가 작은 경우
		
		//오늘날짜 구하기
		Calendar cal = Calendar.getInstance();
//		System.out.println(cal);
		String year = cal.get(Calendar.YEAR) + "";
		String month = (cal.get(Calendar.MONTH) + 1) + "";
		String day = cal.get(Calendar.DAY_OF_MONTH) + "";
		
		System.out.println(year);
		System.out.println(month);
		System.out.println(day);
		
		//최종 날짜형식 
		String date = (year.concat(month)).concat(day);
		System.out.println(date);	//20211022
		
		//regdate insert를 위한 날자형식
		String regdate = year + "." + month + "." + day;
		System.out.println("메인 regdate  "+regdate);
		

		//start, end date "." replace 작업
		pre_startdate = startdate.replace(".","");
		pre_enddate = enddate.replace(".", "");
		
		//숫자 비교 위해 String -> int 
		int tmp_startdate = Integer.parseInt(pre_startdate);
		int tmp_enddate = Integer.parseInt(pre_enddate);
		int tmp_date = Integer.parseInt(date);
		
		System.out.println(tmp_startdate);
		System.out.println(tmp_enddate);
		
		//state return 위한 날짜 비교
		if(tmp_date < tmp_startdate) {
			state = "todo";
		} else if(tmp_date > tmp_startdate && tmp_date < tmp_enddate) {
			state = "doing";
		} else if(tmp_date > tmp_enddate || tmp_date == tmp_enddate) {
			state = "done";
		}  else {
			state = "error";
		}
		
		System.out.println("메인 state::" + state);
		
		System.out.println("add insert start: "+startdate);
		System.out.println("add insert end: "+enddate);
		
		
		HashMap<String,String> saddmap = new HashMap<String,String>(); 
		saddmap.put("member_seq", member_seq);
		saddmap.put("title",title);
		saddmap.put("content",content);
		saddmap.put("startdate",startdate);
		saddmap.put("enddate",enddate);
		saddmap.put("priority",priority);
		saddmap.put("tag",tag);
		saddmap.put("cost", cost);
		saddmap.put("state", state);
		saddmap.put("regdate", regdate);
		saddmap.put("delflag", delflag);

		

		
		//insert 작업 
		//임시 주석 (insert X)
		//사용 X
//		List<ScheduleDTO> saddmap_ok = dao.scheduleAdd(saddmap);
		//사용 O
		int saddmap_ok = dao.scheduleAdd(saddmap);
		//정상 insert 완료되면 반환값 1
		System.out.println("saddmap_ok"+saddmap_ok);
		
		
		request.setAttribute("saddmap", saddmap);
		
		
//		return "/main/main";
		
	}

}
