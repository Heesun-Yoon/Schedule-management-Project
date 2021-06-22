package com.project.test;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

//해당 class가 controller 역할을 하는 class임을 명시
@Controller
@Log4j
@RequestMapping(value = "/maintest.do")
public class MainTest {
	
	public String test(HttpServletRequest request, HttpServletRequest response) {
		//JSP 호출
		return "maintest";
	}

}
