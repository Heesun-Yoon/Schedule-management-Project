package com.project.test;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

//�ش� class�� controller ������ �ϴ� class���� ���
@Controller
@Log4j
@RequestMapping(value = "/maintest.do")
public class MainTest {
	
	public String test(HttpServletRequest request, HttpServletRequest response) {
		//JSP ȣ��
		return "maintest";
	}

}
