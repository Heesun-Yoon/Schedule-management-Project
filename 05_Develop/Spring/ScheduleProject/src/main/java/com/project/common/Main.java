package com.project.common;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class Main {
	@RequestMapping(value="/main.do", method = RequestMethod.POST)
	public String mainPage (HttpServletRequest request, HttpServletRequest response, String id, String pw) {
		
		System.out.println(id);
		System.out.println(pw);
		
		return "/main/main";
	}
}
