<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Do+Hyeon&family=Prompt&display=swap" rel="stylesheet">
    
    <link rel="stylesheet" href="resources/css/common/login.css">
</head>
<body>

   <!-- 전체 레이아웃 시작 -->
    <div id="wrap">
        <div id="container">
            <div id="login_box">
                <div id="left_box">
                    <div id="left_txt1">Welcome!</div>
                    <div id="left_txt2">Log in to use the system.</div>
                    <div id="left_txt3">
                        It is a web service that helps you manage your own schedule more effectively.
                        <br>Use your own method to manage your schedule!
                    </div>
                </div>
                <div id="right_box">
                    <div id="id_input_box">
                        ID<input id="id_input" type="text" placeholder="Please enter your id" size="25px">
                    </div>
                    <div id="pw_input_box">
                        PW<input id="pw_input" type="password" placeholder="Please enter your pw" size="25px">
                    </div>
                    <div id="login_btn">Login</div>
                    <div id="forgot_txt">Forgot Password?</div>
                </div>
            </div>
        </div>
    
    <!-- 전체 레이아웃 끝 -->
    </div>

</body>
</html>