package com.project.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogTest {
	
	//log ��ü ��������
	//getLogger�� ���ڰ����� �α׸� ���� Ŭ������� �����ְ� '.class' ����
	static Logger log = LoggerFactory.getLogger(LogTest.class);

	public static void main(String[] args) {
		new LogTest().test();
	}

	private void test() {
		
		//log4j test
		String test1 = "test start";
		String test2 = "log4j test";
		String test3 = "testing..";
		String test4 = "success";
		
		//logger level : debug < info < warn < error < fatal
		log.debug("log4j �׽�Ʈ��!");
		log.info(test1);
		log.warn(test2);
		log.error(test3);
//		log.fatal(test4);
		
		
	}


	
}
