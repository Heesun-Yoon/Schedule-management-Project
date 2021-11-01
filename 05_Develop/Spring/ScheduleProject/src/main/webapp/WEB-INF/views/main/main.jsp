<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Main</title>

    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Do+Hyeon&family=Prompt&display=swap" rel="stylesheet">

	<link rel="stylesheet" href="resources/css/main/main.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

</head>
<body>
     <!-- 전체 레이아웃 시작 -->
    <div id="wrap">
    <%-- <input type="hidden" id="hid_result" value ="${result}"> --%>
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
                <!-- <div id="left_menu">
                    <span id="left_m_icon">
                        <img src="resources\images\check.png" id="img8">
                    </span> -->
                <!-- 좌측 메뉴 끝 -->
                <!-- </div> -->

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
                        <img src="resources\images\bookmark.png" id="img11">
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

                <!-- 필터 클릭시 나타나는 부분 -->
                <div id="filter1_click" class="filter_click">
                    <textarea placeholder="검색어를 입력하세요" cols="30" rows="1"></textarea>
                    <div>검색</div>
                </div>
                <div id="filter2_click" class="filter_click"></div>
                <div id="filter3_click" class="filter_click"></div>
                <div id="filter4_click" class="filter_click"></div>

                <!-- 스케줄 표 시작 -->
                <div id="schedule">
                    <div id="todo_section" class="sc_section">
                    <c:forEach items="${sche_cnt}" var="sche_cnt">
                        <div id="todo_txt" class="sc_txt">To do (${sche_cnt.todo_cnt})</div>
                    </c:forEach>
                        <div id="todo_add" class="sc_add">+ Add a Schedule</div>
                        
                         <!-- todo 상태인 게시물만 출력 -->
                        <c:forEach items="${s_result}" var="state_dto">
                        <c:if test="${state_dto.state eq 'TODO'}">
	                        <div id="doing_1" class="sc_box">
	                            <span id="doing_priority1" class="sc_box_priority">
	                            <c:forEach items="${s_result}" var="dto">
	                            <c:choose>
	                            	<c:when test="${dto.important eq 1}">
			                            <!-- 중요도에 따라 이미지 달라짐  -->
			                            <!-- 1 (down.png) , 2/3 (minus.png) , 4/5 (up.png) -->
		                                <img src="resources\images\down.png" id="img18" class="priority_img">
		                       		</c:when>
		                       		
		                       		<c:when test="${dto.important eq 2 || dto.important eq 3}">
			                            <!-- 중요도에 따라 이미지 달라짐  -->
			                            <!-- 1 (down.png) , 2/3 (minus.png) , 4/5 (up.png) -->
		                                <img src="resources\images\minus.png" id="img18" class="priority_img">
		                       		</c:when>
		                       		
		                       		<c:when test="${dto.important eq 4 || dto.important eq 5}">
			                            <!-- 중요도에 따라 이미지 달라짐  -->
			                            <!-- 1 (down.png) , 2/3 (minus.png) , 4/5 (up.png) -->
		                                <img src="resources\images\up.png" id="img18" class="priority_img">
		                       		</c:when>
		                       		
		                        </c:choose>
		                        </c:forEach>
	                            </span>
	                            <c:forEach items="${s_result}" var="dto">
		                            <span id="doing_title1" class="sc_box_title">${dto.title}</span>
		                            <div id="tag_div">
		                            <c:forEach items="${tag_list}" var="tag_list">
		                            	<span class="sc_box_tag">${tag_list}</span>
		                            </c:forEach>
		                            </div>
		                            <div id="doing1_content" class="sc_box_content">${dto.content}</div>
		                            <div id="doing1_date" class="sc_box_date">${dto.start_time} - ${dto.end_time}</div>
		                         </c:forEach>
	                        </div>
                        </c:if>
                        </c:forEach>
                        <!-- <div id="todo_1" class="sc_box">
                            <span id="todo_priority1" class="sc_box_priority">
                                <img src="resources\images\minus.png" id="img16" class="priority_img">
                            </span>
                            <span id="todo_title1" class="sc_box_title">Website Renewal - main</span>
                            <div id="todo_tag1" class="sc_box_tag">Website</div>
                            <div id="todo_tag1_1" class="sc_box_tag">coding</div>
                            <div id="todo_content1" class="sc_box_content">Additional explanation.</div>
                            <div id="todo_date1" class="sc_box_date">2021.01.01 - 2021.02.03 (30days)</div>
                        </div> -->
                        <!-- <div id="todo_2" class="sc_box">  
                            <span id="todo_priority2" class="sc_box_priority">
                                <img src="resources\images\up.png" id="img17" class="priority_img">
                            </span>
                            <span id="todo_title2" class="sc_box_title">List of UI features</span>
                            <div id="todo_tag2" class="sc_box_tag">Mobile</div>
                            <div id="todo_content2" class="sc_box_content">Additional explanation.</div>
                            <div id="todo_date2" class="sc_box_date">2021.01.01 - 2021.02.03 (30days)</div>
                        </div> -->
                    </div>

                    <div id="doing_section" class="sc_section">
                    <c:forEach items="${sche_cnt}" var="sche_cnt">
                        <div id="doing_txt" class="sc_txt">Doing (${sche_cnt.doing_cnt})</div>
                    </c:forEach>
                        <div id="doing_add" class="sc_add">+ Add a Schedule</div>
                        
                        <!-- doing 상태인 게시물만 출력 -->
                        <!-- 잠시 주석(원본) -->
                        <%-- <c:forEach items="${s_result}" var="state_dto"> --%>
                        <c:forEach items="${s_result}" var="dto">
                        <%-- <c:set var="${s_result}" value="state_dto" /> --%>
                        <!-- 잠시 주석(원본) -->
                        <%-- <c:if test="${state_dto.state eq 'DOING'}"> --%>
                        <c:if test="${dto.state eq 'DOING'}">
                        
	                        <!-- <div id="doing_1" class="sc_box"> -->
	                        <div class="sc_box">
	                            <span id="doing_priority1" class="sc_box_priority">
	                            <%-- <c:forEach items="${s_result}" var="dto"> --%>
	                            
	                            <c:choose>
	                            	<c:when test="${dto.important eq 1}">
			                            <!-- 중요도에 따라 이미지 달라짐  -->
			                            <!-- 1 (down.png) , 2/3 (minus.png) , 4/5 (up.png) -->
		                                <img src="resources\images\down.png" id="img18" class="priority_img">
		                       		</c:when>
		                       		
		                       		<c:when test="${dto.important eq 2 || dto.important eq 3}">
			                            <!-- 중요도에 따라 이미지 달라짐  -->
			                            <!-- 1 (down.png) , 2/3 (minus.png) , 4/5 (up.png) -->
		                                <img src="resources\images\minus.png" id="img18" class="priority_img">
		                       		</c:when>
		                       		
		                       		<c:when test="${dto.important eq 4 || dto.important eq 5}">
			                            <!-- 중요도에 따라 이미지 달라짐  -->
			                            <!-- 1 (down.png) , 2/3 (minus.png) , 4/5 (up.png) -->
		                                <img src="resources\images\up.png" id="img18" class="priority_img">
		                       		</c:when>
		                       		
		                        </c:choose>
		                        <%-- </c:forEach> --%>
	                            </span>
	                            <%-- <c:forEach items="${s_result}" var="dto"> --%>
		                            <span id="doing_title1" class="sc_box_title">${dto.title}</span>
		                            <div id="tag_div">
		                            <c:forEach items="${tag_list}" var="tag_list">
		                            	<span class="sc_box_tag">${tag_list}</span>
		                            </c:forEach>
		                            </div>
		                            <div id="doing1_content" class="sc_box_content">${dto.content}</div>
		                            <div id="doing1_date" class="sc_box_date">${dto.start_time} - ${dto.end_time}</div>
		                         <%-- </c:forEach> --%>
	                        </div>
                        </c:if>
                       </c:forEach>
                        <!-- <div id="doing_2" class="sc_box">
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
                    </div> -->

                    <div id="done_section" class="sc_section">
                    <c:forEach items="${sche_cnt}" var="sche_cnt">
                        <div id="done_txt" class="sc_txt">Done (${sche_cnt.done_cnt})</div>
                    </c:forEach>
                        <div id="done_add" class="sc_add">+ Add a Schedule</div>
                        
                         <!-- done 상태인 게시물만 출력 -->
                         <!-- 주석(원본) -->
                        <%-- <c:forEach items="${s_result}" var="state_dto"> --%>
                        <c:forEach items="${s_result}" var="dto">
                        <!-- 주석(원본) -->
                        <%-- <c:if test="${state_dto.state eq 'DONE'}"> --%>
                        <c:if test="${dto.state eq 'DONE'}">
	                        <!-- <div id="doing_1" class="sc_box"> -->
	                        <div class="sc_box">
	                            <span id="doing_priority1" class="sc_box_priority">
	                            <%-- <c:forEach items="${s_result}" var="dto"> --%>
	                            <c:choose>
	                            	<c:when test="${dto.important eq 1}">
			                            <!-- 중요도에 따라 이미지 달라짐  -->
			                            <!-- 1 (down.png) , 2/3 (minus.png) , 4/5 (up.png) -->
		                                <img src="resources\images\down.png" id="img18" class="priority_img">
		                       		</c:when>
		                       		
		                       		<c:when test="${dto.important eq 2 || dto.important eq 3}">
			                            <!-- 중요도에 따라 이미지 달라짐  -->
			                            <!-- 1 (down.png) , 2/3 (minus.png) , 4/5 (up.png) -->
		                                <img src="resources\images\minus.png" id="img18" class="priority_img">
		                       		</c:when>
		                       		
		                       		<c:when test="${dto.important eq 4 || dto.important eq 5}">
			                            <!-- 중요도에 따라 이미지 달라짐  -->
			                            <!-- 1 (down.png) , 2/3 (minus.png) , 4/5 (up.png) -->
		                                <img src="resources\images\up.png" id="img18" class="priority_img">
		                       		</c:when>
		                       		
		                        </c:choose>
		                        <%-- </c:forEach> --%>
	                            </span>
	                            <%-- <c:forEach items="${s_result}" var="dto"> --%>
		                            <span id="doing_title1" class="sc_box_title">${dto.title}</span>
		                            <div id="tag_div">
		                            <c:forEach items="${tag_list}" var="tag_list">
		                            	<span class="sc_box_tag">${tag_list}</span>
		                            </c:forEach>
		                            </div>
		                            <div id="doing1_content" class="sc_box_content">${dto.content}</div>
		                            <div id="doing1_date" class="sc_box_date">${dto.start_time} - ${dto.end_time}</div>
		                         <%-- </c:forEach> --%>
	                        </div>
                        </c:if>
                        </c:forEach>
                        <!-- <div id="done_1" class="sc_box">
                            <span id="done_priority1" class="sc_box_priority">
                                <img src="resources\images\down.png" id="img21" class="priority_img">
                            </span>
                            <span id="done_title1" class="sc_box_title">List of UI features</span>
                            <div id="done_tag1" class="sc_box_tag">Mobile</div>
                            <div id="done1_content" class="sc_box_content">Additional explanation.</div>
                            <div id="done1_date" class="sc_box_date">2021.01.01 - 2021.02.03 (30days)</div> 
                        </div> -->
                    </div> 
                 </div>

                <!-- 스케줄 표 끝 -->
                </div>
            </div>
        <!-- 메뉴 끝 -->
        </div>
        
        
         <!-- modal popup -->
        <!-- <form method="POST" action='/common/scheduleadd.do'> -->
        <div class="container"> 
            <div class="popup-wrap" id="popup"> 
              <div class="popup">	
                <div class="popup-head">	
                    <span class="head-title">Add a Schedule</span>
                </div>
                <div class="popup-body">	
                  <div class="body-content">
                    <div class="body-titlebox">
                      <span>Title</span><textarea placeholder="Please enter a title" name="title" id="modal_title"></textarea>
                    </div>
                    <div class="body-contentbox">
                        <span>Content</span><textarea placeholder="Please enter a content" rows="10" name="content" id="modal_content"></textarea>
                    </div>
                    <div class="body-contentbox">
                        <span>Tag</span><textarea placeholder="Please separate them with ','" rows="2" name="tag" id="modal_tag"></textarea>
                    </div>
                    <div class="body-datebox">
                        <div>Date</div><textarea placeholder="Start-date" rows="2" cols="5" name="startdate" id="modal_startdate"></textarea>
                        <textarea placeholder="End-date" rows="2" cols="5" name="enddate" id="modal_enddate"></textarea>
                    </div>

                    <div>Priority</div>
                    <select name="priority" style="width: 200px; height: 30px;" required id="modal_priority">
                        <option value="">Priority</option>
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                        <option value="5">5</option>
                    </select>
                  </div>
                </div>
                <div class="popup-foot">
                    <span class="pop-btn close" id="close">창 닫기</span>
                  <!-- <span class="pop-btn confirm" id="confirm">등록</span> -->
                  <input type="submit" value="등록" class="pop-btn confirm" id="confirm">
                
                </div>
              </div>
          </div>
          </div>
        <!-- </form> -->
        
        

    <!-- 전체 레이아웃 끝 -->
    </div>
       
    
</body>

    <script>
    
    if($('#hid_result').val() == "false") {
    	alert('로그인 실패');
    } 
    
    /* 페이지 로드시 바로 적용 */
    /* $(document).ready(function(){
    	var tag = "<div id='doing_tag1' class='sc_box_tag'>${dto.tag}</div>";
    	$('#doing_title1').append(tag);
    }); */
    
    
    /* modal */
    $(function(){
        $("#confirm").click(function(){
            modalClose(); //모달 닫기 함수 호출
            
        		//json 형식으로 데이터 set
        		
        		var params = {
        			title: $("#modal_title").val()
        			,content: $("#modal_content").val()
        			,tag: $("#modal_tag").val()
        			,startdate: $("#modal_startdate").val()
        			,enddate: $("#modal_enddate").val()
        			,priority: $("#modal_priority").val()
        		}
        		
            
        		alert($("#modal_priority").val());
        		
        		//ajax 통신
        		$.ajax({
        			type:"POST", 
        			url:"schedule/scheduleadd.do", 	//컨트롤러에서 대기중인 URL주소
        			data:params, 		//JSON 형식의 데이터 
        			success:function(res){ //성공일 경우 
        				alert("성공");
        			},
        			error: function(XMLHttpRequest, textStatus, errorThrown){
        				alert("실패")
        			} 
        		});
        		
        		
        	//값 초기화
        	$('#modal_title').val('');
        	$('#modal_content').val('');
        	$('#modal_tag').val('');
        	$('#modal_startdate').val('');
        	$('#modal_enddate').val('');
        	$('#modal_priority').val("Priority").prop("selected", true);
        	
   
        //컨펌 이벤트 처리
        });
        
        
        //modal 팝업처리
        $(".sc_add").click(function(){        
            $("#popup").css('display','flex').hide().fadeIn();
            //팝업을 flex속성으로 바꿔준 후 hide()로 숨기고 다시 fadeIn()으로 효과
        });
        $("#close").click(function(){
            modalClose(); //모달 닫기 함수 호출
            
        	//값 초기화
        	$('#modal_title').val('');
        	$('#modal_content').val('');
        	$('#modal_tag').val('');
        	$('#modal_startdate').val('');
        	$('#modal_enddate').val('');
        	$('#modal_priority').val("Priority").prop("selected", true);
        	
        });
        function modalClose(){
            $("#popup").fadeOut(); //페이드아웃 효과
        }
    });
    
    
    

    
    
    
    
    
    </script>

</html>