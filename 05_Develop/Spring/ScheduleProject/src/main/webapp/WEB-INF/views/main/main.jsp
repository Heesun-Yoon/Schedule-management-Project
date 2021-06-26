<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Main Page</title>

    <!-- <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap" rel="stylesheet"> -->

    <style>

    @font-face {
        font-family: 'IBMPlexSansKR-Regular';
        src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_20-07@1.0/IBMPlexSansKR-Regular.woff') format('woff');
        font-weight: normal;
        font-style: normal;
    }
        /* css 작업 */
        html,body {
            margin: 0;
            width: 100%;
            height: 100%;
            /* font-family: 'Nanum Gothic', sans-serif; */
            font-family: 'IBMPlexSansKR-Regular';
        }

        #wrap {
            width: 100%;
            min-height: 100%;
            display: flex;
            flex-direction: column;
        }

        #container,
        #top {
            display: flex;
            flex-direction: row;
        }
        #top {
            border: 1px solid black;
            flex: 0.1;
        }

        #container {
            flex: 4;
        }

        #left {
            display: flex;
            flex: 1;
            flex-direction: row;
        }

        #right {
            display: flex;
            flex: 4;
            flex-direction: column;
        }      

        #left_menu {
            border: 1px solid black;
            flex: 1;
        }

        #left_detail {
            border: 1px solid black;
            flex: 2;
        }

        #schedule_title {
            border: 1px solid black;
            flex: 0.1;
            height: 100px;
        }

        #schedule_filter {
            border: 1px solid black;
            flex: 0.05;
        }
        

        #img1 {
            width: 30px;
            height: 30px;
        }


        
    </style>
</head>
<body>
	
    <!-- 전체 레이아웃 시작 -->
    <div id="wrap">
        <!-- 상단메뉴 시작 -->
        <div id=top>
            <div id="top_icon"><img src="resources/images/time.png" id="img1"></div>
        <!-- 상단메뉴 끝 -->
        </div>

        <!-- 메뉴 시작 -->
        <div id="container">
            <div id="left">
                <!-- 좌측 메뉴 시작-->
                <div id="left_menu">
                <!-- 좌측 메뉴 끝 -->
                </div>

                <!-- 좌측 메뉴 상세 시작 -->
                <div id="left_detail">
                <!-- 좌측 메뉴 상세 끝 -->
                </div>
            </div>

            <div id="right">
                <!-- 스케줄 타이틀 시작 -->
                <div id="schedule_title">
                <!-- 스케줄 타이틀 끝 -->
                </div>

                <!-- 필터 시작 -->
                <div id="schedule_filter">
                <!-- 필터 끝 -->
                </div>

                <!-- 스케줄 표 시작 -->
                <div id="schedule">
                <!-- 스케줄 표 끝 -->
                </div>
            </div>
        <!-- 메뉴 끝 -->
        </div>

    <!-- 전체 레이아웃 끝 -->
    </div>

</body>
</html>