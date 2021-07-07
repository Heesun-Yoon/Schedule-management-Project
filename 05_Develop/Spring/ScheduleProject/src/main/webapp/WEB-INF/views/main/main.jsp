<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Main</title>

    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Do+Hyeon&family=Prompt&display=swap" rel="stylesheet">

	<link rel="stylesheet" href="resources/css/main/main.css">

</head>
<body>
     <!-- 전체 레이아웃 시작 -->
    <div id="wrap">
    <input type="hidden" id=“hid_result” value =“&{result_flag}”>
        <!-- 상단메뉴 시작 -->
        <div id=top>
            <span id="top_icon1">
                <img src="resources\images\home.png" id="img1">
            </span>
            <span id="top_icon2">
                <img src="resources\images\schedule.png" id="img2">
            </span>
            <span id="top_txt">
                Schedule M.
                <%-- <c:forEach items="${result}" var="dto">
                	<div>${dto.name}</div>
                </c:forEach> --%>
            </span>
            <span id="top_icon3">
                <img src="resources\images\alram.png" id="img3" class="top_right_img">
            </span>
            <span id="top_icon4">
                <img src="resources\images\bookmark.png" id="img4" class="top_right_img">
            </span>
            <span id="top_icon5">
                <img src="resources\images\file.png" id="img5" class="top_right_img">
            </span>
            <span id="top_icon6">
                <img src="resources\images\friends.png" id="img6" class="top_right_img">
            </span>
            <span id="top_search">
                <img src="resources\images\search.png" id="img7">
            </span>
            <span id="top_profile">
            	<img src="resources\images\user.png" id="profile_img">
            </span>
        <!-- 상단메뉴 끝 -->
        </div>

        <!-- 메뉴 시작 -->
        <div id="container">
            <div id="left">
                <!-- 좌측 메뉴 시작-->
                <div id="left_menu">
                    <span id="left_m_icon">
                        <img src="resources\images\check.png" id="img8">
                    </span>
                <!-- 좌측 메뉴 끝 -->
                </div>

                <!-- 좌측 메뉴 상세 시작 -->
                <div id="left_detail">
                    <span id="detail_menu1">
                        <img src="resources\images\people.png" id="img9">
                        <span id="detail_txt1">My Schedule List</span>
                    </span>
                        <ul id="list_ul1">
                            <li><div class="dot"></div>daily schedule</li>
                            <li><div class="dot"></div>important schedule</li>
                        </ul>
                    <span id="detail_menu2">
                        <img src="resources\images\friends.png" id="img10">
                        <span id="detail_txt1">Friends Schedule List</span>
                    </span>
                        <ul id="list_ul2">
                            <li><div class="dot"></div>f_daily schedule</li>
                            <li><div class="dot"></div>f_important schedule</li>
                        </ul>
                <!-- 좌측 메뉴 상세 끝 -->
                </div>
            </div>

            <div id="right">
                <!-- 스케줄 타이틀 시작 -->
                <div id="schedule_title">
                <!-- 스케줄 타이틀 끝 -->
                    <span id="sc_title">
                        <!-- <span id="sc_title_img">  -->
                            <img src="resources\images\bookmark.png" id="img11">
                        <!-- </span> -->
                        <span id="sc_title_txt">Daily Schedule</span>
                    </span>
                    <span id="sc_sub_title">
                        ┖ Daily plan for 2020
                    </span>
                    <span id="heart">
                        <img src="resources\images\heart.png" id="img12">
                        <span id="heart_cnt">3</span>
                    </span>
                    <span id="plus">
                        <img src="resources\images\plus.png" id="img13">
                    </span>
                    <span id="edit">
                        <img src="resources\images\edit.png" id="img14">
                    </span>
                    <span id="del">
                        <img src="resources\images\delete.png" id="img15">
                    </span>
                </div>

                <!-- 필터 시작 -->
                <div id="schedule_filter">
                    <span id="filter">
                        <span id="filter1" class="sc_filter">
                            Tag ∨
                        </span>
                        <span id="filter2" class="sc_filter">
                            Priority ∨
                        </span>
                        <span id="filter3" class="sc_filter">
                            Date ∨
                        </span>
                        <span id="filter4" class="sc_filter">
                            Color label ∨
                        </span>
                    </span>
                <!-- 필터 끝 -->
                </div>

                <!-- 스케줄 표 시작 -->
                <div id="schedule">
                    <div id="todo_section" class="sc_section">
                        <div id="todo_txt" class="sc_txt">To do (2)</div>
                        <div id="todo_add" class="sc_add">+ Add a Schedule</div>
                        <div id="todo_1" class="sc_box">
                            <span id="todo_priority1" class="sc_box_priority">
                                <img src="resources\images\minus.png" id="img16" class="priority_img">
                            </span>
                            <span id="todo_title1" class="sc_box_title">Website Renewal - main</span>
                            <div id="todo_tag1" class="sc_box_tag">Website</div>
                            <div id="todo_tag1_1" class="sc_box_tag">coding</div>
                            <div id="todo_content1" class="sc_box_content">Additional explanation.</div>
                            <div id="todo_date1" class="sc_box_date">2021.01.01 - 2021.02.03 (30days)</div>
                        </div>
                        <div id="todo_2" class="sc_box">  
                            <span id="todo_priority2" class="sc_box_priority">
                                <img src="resources\images\up.png" id="img17" class="priority_img">
                            </span>
                            <span id="todo_title2" class="sc_box_title">List of UI features</span>
                            <div id="todo_tag2" class="sc_box_tag">Mobile</div>
                            <div id="todo_content2" class="sc_box_content">Additional explanation.</div>
                            <div id="todo_date2" class="sc_box_date">2021.01.01 - 2021.02.03 (30days)</div>
                        </div>
                    </div>

                    <div id="doing_section" class="sc_section">
                        <div id="doing_txt" class="sc_txt">Doing (3)</div>
                        <div id="doing_add" class="sc_add">+ Add a Schedule</div>
                        <div id="doing_1" class="sc_box">
                            <span id="doing_priority1" class="sc_box_priority">
                                <img src="resources\images\down.png" id="img18" class="priority_img">
                            </span>
                            <span id="doing_title1" class="sc_box_title">List of UI features</span>
                            <div id="doing_tag1" class="sc_box_tag">Mobile</div>
                            <div id="doing1_content" class="sc_box_content">Additional explanation.</div>
                            <div id="doing1_date" class="sc_box_date">2021.01.01 - 2021.02.03 (30days)</div>
                        </div>
                        <div id="doing_2" class="sc_box">
                            <span id="doing_priority2" class="sc_box_priority">
                                <img src="resources\images\minus.png" id="img19" class="priority_img">
                            </span>
                            <span id="doing_title2" class="sc_box_title">List of UI features</span>
                            <div id="doing_tag2" class="sc_box_tag">Mobile</div>
                            <div id="doing2_content" class="sc_box_content">Additional explanation.</div>
                            <div id="doing2_date" class="sc_box_date">2021.01.01 - 2021.02.03 (30days)</div>
                        </div>
                        <div id="doing_3" class="sc_box">
                            <span id="doing_priority3" class="sc_box_priority">
                                <img src="resources\images\up.png" id="img20" class="priority_img">
                            </span>
                            <span id="doing_title3" class="sc_box_title">List of UI features</span>
                            <div id="doing_tag3" class="sc_box_tag">Mobile</div>
                            <div id="doing3_content" class="sc_box_content">Additional explanation.</div>
                            <div id="doing3_date" class="sc_box_date">2021.01.01 - 2021.02.03 (30days)</div>
                        </div>
                    </div>

                    <div id="done_section" class="sc_section">
                        <div id="done_txt" class="sc_txt">Done (1)</div>
                        <div id="done_add" class="sc_add">+ Add a Schedule</div>
                        <div id="done_1" class="sc_box">
                            <span id="done_priority1" class="sc_box_priority">
                                <img src="resources\images\down.png" id="img21" class="priority_img">
                            </span>
                            <span id="done_title1" class="sc_box_title">List of UI features</span>
                            <div id="done_tag1" class="sc_box_tag">Mobile</div>
                            <div id="done1_content" class="sc_box_content">Additional explanation.</div>
                            <div id="done1_date" class="sc_box_date">2021.01.01 - 2021.02.03 (30days)</div>
                        </div>
                    </div>

                <!-- 스케줄 표 끝 -->
                </div>
            </div>
        <!-- 메뉴 끝 -->
        </div>

    <!-- 전체 레이아웃 끝 -->
    </div>
       
    
</body>

    <script>
    
    if($('#hid_result').val() == "false") {
    	alert('로그인 실패');
    } 
    
    </script>

</html>