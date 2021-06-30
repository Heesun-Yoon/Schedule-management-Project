package com.project.common;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class Main {
	@RequestMapping(value="/main.do")
	public String mainPage (HttpServletRequest request, HttpServletRequest response) {
		return "/main/main";
	}
}