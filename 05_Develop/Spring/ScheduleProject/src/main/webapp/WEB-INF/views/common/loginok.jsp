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

<!-- 

Redirect 
	- URL을 지시된 주소로 바꾸고 그 주소로 이동
	
Forward 
	- 최초 호출한 URL만 표시, 이동한 페이지의 URL 볼 수 없음

 -->

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
	
	
	
	<script>
	/* ajax로 main에 데이터 전송 */
	
	//login.jsp 데이터 > loginok.controller로 전달 > loginok.jsp로 전달
	
	//login_btn_in 버튼을 클릭 시 실행 
	$("#login_btn_in").click(function(){
		//json 형식으로 데이터 set
		var params = {
			/*
			name: $("#name").val()
			,sex: $("#sex").val()
			,age: $("#age").val()
			*/
		}
		
		//ajax 통신
		/*
		$.ajax({
			type:"POST", 
			url:"/test/ajax", 	//컨트롤러에서 대기중인 URL주소
			data:params, 		//JSON 형식의 데이터
			success:function(res){ //성공일 경우 
				alert(res.code);
			},
			error: function(XMLHttpRequest, textStatus, errorThrown){
				alert("통신 실패")
			} 
		});
		*/
	});
	</script>

</body>
</html>