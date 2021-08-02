<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>loginok</title>
</head>
<body>

	<%
	
	String userid = request.getParameter("id");
	String userpw = request.getParameter("pw");
	
	System.out.println("loginok.jsp 페이지 "+userid);
	System.out.println("loginok.jsp 페이지 "+userpw);
	
	if(userid != null){
		session.setAttribute("userid",userid);
		session.setAttribute("userpw",userpw);
		System.out.println("loginok.jsp 페이지 id "+session.getAttribute("userid"));
		System.out.println("loginok.jsp 페이지 pw "+session.getAttribute("userpw"));
		


	}

	
	%>

</body>
</html>