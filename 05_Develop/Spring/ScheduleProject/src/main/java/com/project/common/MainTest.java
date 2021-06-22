package com.project.common;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class MainTest {
	//메소드 에서만 사용
	@RequestMapping(value="/maintest.do")
	public String test(HttpServletRequest request, HttpServletRequest response) {
		//JSP 호출
		return "/maintest";
	}

}
