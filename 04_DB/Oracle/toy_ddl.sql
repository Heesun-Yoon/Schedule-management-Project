-- toy_Project db 

/*회원(완료)*/
CREATE TABLE TBL_MEMBER (
  SEQ NUMBER PRIMARY KEY, 			    /*번호*/
  NAME VARCHAR2(20) NOT NULL, 		    /*이름*/
  ID VARCHAR2(50) NOT NULL,			    /*ID*/
  PW VARCHAR2(50) NOT NULL,		        /*PW*/
  ADDRESS VARCHAR2(200) NOT NULL, 		/*ADDRESS*/
  DELFLAG NUMBER DEFAULT 0 NOT NULL 	/*삭제*/
);

select * from tbl_member;


/*친구요청(완료)*/
CREATE TABLE TBL_FRIEND_REQ (
  SEQ NUMBER PRIMARY KEY,					            /*번호*/
  REQMEM_SEQ NUMBER NOT NULL,
  RESMEM_SEQ NUMBER NOT NULL,
  CONSTRAINT FK_REQMEM FOREIGN KEY (REQMEM_SEQ) REFERENCES TBL_MEMBER(SEQ) ON DELETE CASCADE,	/*요청회원번호*/
  CONSTRAINT FK_RESMEM FOREIGN KEY (RESMEM_SEQ) REFERENCES TBL_MEMBER(SEQ) ON DELETE CASCADE,	/*수락회원번호*/
  STATE VARCHAR2(5) NOT NULL,				            /*상태*/
  COMPLETE_DATE VARCHAR2(50) NOT NULL		        /*완료날짜*/
);

SELECT * FROM TBL_FRIEND_REQ;

/*친구(완료)*/
CREATE TABLE TBL_FRIEND (
  SEQ NUMBER PRIMARY KEY,					                /*번호*/		
  FNDREQ_SEQ NUMBER NOT NULL,
  CONSTRAINT FK_FNDREQ FOREIGN KEY (FNDREQ_SEQ) REFERENCES TBL_FRIEND_REQ(SEQ) ON DELETE CASCADE	/*요청회원번호*/
);

SELECT * FROM TBL_FRIEND;

/*일정(완료)*/
CREATE TABLE TBL_SCHEDULE (
  SEQ NUMBER PRIMARY KEY,					            /*번호*/	
  MEMBER_SEQ NUMBER NOT NULL,
  CONSTRAINT FK_MEMBER FOREIGN KEY (MEMBER_SEQ) REFERENCES TBL_MEMBER(SEQ) ON DELETE CASCADE,	/*회원번호*/
  TITLE VARCHAR2(200) NOT NULL,				            /*제목*/
  CONTENT VARCHAR2(2000) NOT NULL,				        /*내용*/
  START_TIME VARCHAR2(20) NOT NULL,				        /*시작날짜*/
  END_TIME VARCHAR2(20) NOT NULL,				        /*끝날짜*/
  IMPORTANT NUMBER NOT NULL,				            /*중요도*/
  TAG VARCHAR2(100) NOT NULL,				            /*태그*/
  COST NUMBER NOT NULL,					                /*비용*/
  STATE VARCHAR2(50) NOT NULL,				            /*상태*/
  REGDATE VARCHAR2(50) NOT NULL,				        /*등록일*/
  DELFLAG NUMBER NOT NULL				                /*삭제*/
);




-- seq 1번 회원이 등록한 게시물 
select * from tbl_schedule where member_seq = 1;

select * from tbl_schedule where seq = (select seq from tbl_member where id='HeeSun' and pw='1234');

select * from tbl_member where id='HeeSun' and pw='1234';



-- 회원이 등록한 게시물 상태조건 추가
-- mapper > scheduleList
select seq, member_seq, title, content, start_time, end_time, important, tag, cost, regdate, delflag,
        CASE 
        WHEN start_time > SYSDATE THEN 'TODO' 
        WHEN start_time < SYSDATE AND end_time > SYSDATE THEN 'DOING'
        WHEN end_time < SYSDATE THEN 'DONE'
        END as state        
from tbl_schedule where member_seq = (select seq from tbl_member where id='HeeSun' and pw='1234');

--수정 테스트 
select seq, member_seq, title, content, start_time, end_time, important, tag, cost, regdate, delflag,
        CASE 
        WHEN to_date(start_time,'yyyy-mm-dd') > SYSDATE THEN 'TODO' 
        WHEN to_date(start_time,'yyyy-mm-dd') < SYSDATE AND to_date(end_time,'yyyy-mm-dd') > SYSDATE THEN 'DOING'
        WHEN to_date(end_time,'yyyy-mm-dd') < SYSDATE THEN 'DONE'
        END as state        
from tbl_schedule where member_seq = (select seq from tbl_member where id='HeeSun' and pw='1234');



--수정 테스트 
select seq, member_seq, title, content, start_time, end_time, important, tag, cost, regdate, delflag,
        CASE 
        WHEN start_time > to_char(SYSDATE,'yyyymmdd') THEN 'TODO' 
        WHEN start_time < to_char(SYSDATE,'yyyymmdd') AND end_time > to_char(SYSDATE,'yyyymmdd') THEN 'DOING'
        WHEN end_time < to_char(SYSDATE,'yyyymmdd') THEN 'DONE'
        END as state        
from tbl_schedule where member_seq = (select seq from tbl_member where id='HeeSun' and pw='1234');




--11.03 수정 테스트 (start,end 날짜에 "." 수정 후)
select seq, member_seq, title, content, start_time, end_time, important, tag, cost, regdate, delflag,
        CASE 
        WHEN start_time > to_char(SYSDATE,'yyyy.mm.dd') THEN 'TODO' 
        WHEN start_time < to_char(SYSDATE,'yyyy.mm.dd') AND end_time > to_char(SYSDATE,'yyyy.mm.dd') THEN 'DOING'
        WHEN end_time < to_char(SYSDATE,'yyyy.mm.dd') THEN 'DONE'
        END as state        
from tbl_schedule where member_seq = (select seq from tbl_member where id='HeeSun' and pw='1234');


--11.05
--filter 기능 위한 select
select seq, member_seq, title, content, start_time, end_time, important, tag, cost, regdate, delflag,
        CASE 
        WHEN start_time > to_char(SYSDATE,'yyyy.mm.dd') THEN 'TODO' 
        WHEN start_time < to_char(SYSDATE,'yyyy.mm.dd') AND end_time > to_char(SYSDATE,'yyyy.mm.dd') THEN 'DOING'
        WHEN end_time < to_char(SYSDATE,'yyyy.mm.dd') THEN 'DONE'
        END as state        
from tbl_schedule where member_seq = (select seq from tbl_member where id='HeeSun' and pw='1234') and tag LIKE '%java%';








/*파일(완료)*/
CREATE TABLE TBL_FILE (
  SEQ NUMBER PRIMARY KEY,					            /*번호*/	
  SCHE_SEQ NUMBER NOT NULL,
  CONSTRAINT FK_SCHE FOREIGN KEY (SCHE_SEQ) REFERENCES TBL_SCHEDULE(SEQ) ON DELETE CASCADE,    /*일정번호*/
  NAME VARCHAR2(200) NOT NULL,				            /*파일명*/
  EXTENSION VARCHAR2(50) NOT NULL,				        /*확장자*/
  REGDATE VARCHAR2(50) NOT NULL,				        /*등록날짜*/
  DOWNDATE VARCHAR2(50) NOT NULL				        /*다운로드날짜*/
);

SELECT * FROM TBL_FILE;--(완료)



/*즐겨찾기(완료)*/
CREATE TABLE TBL_BOOKMARK (
  SEQ NUMBER PRIMARY KEY,					            /*번호*/	
  SCHE_SEQ NUMBER NOT NULL,
  CONSTRAINT FK_SCHE_BM FOREIGN KEY (SCHE_SEQ) REFERENCES TBL_SCHEDULE(SEQ) ON DELETE CASCADE	/*일정번호*/
);



/*댓글(완료)*/
CREATE TABLE TBL_COMMENT (
  SEQ NUMBER PRIMARY KEY,					            /*번호*/	
  SCHE_SEQ NUMBER NOT NULL,
  CONSTRAINT FK_SCHE_CMT FOREIGN KEY (SCHE_SEQ) REFERENCES TBL_SCHEDULE(SEQ) ON DELETE CASCADE,	/*일정번호*/
  CONTENT VARCHAR2(1000) NOT NULL,				        /*내용*/
  ID VARCHAR2(50) NOT NULL,					            /*아이디*/
  PW VARCHAR2(50) NOT NULL				                /*비밀번호*/
);




CREATE SEQUENCE SEQ_MEMBER; --(완료)
CREATE SEQUENCE SEQ_FRIEND_REQ; --(완료)
CREATE SEQUENCE SEQ_FRIEND; --(완료)
CREATE SEQUENCE SEQ_SCHEDULE; --(완료)
CREATE SEQUENCE SEQ_FILE; --(완료)
CREATE SEQUENCE SEQ_BOOKMARK; --(완료)
CREATE SEQUENCE SEQ_COMMENT; --(완료)



--------------------------------------------------------------------------------------------------------------------------------
-- 회원 test 
insert into TBL_MEMBER (seq, name, id, pw, address, delflag) values (SEQ_MEMBER.nextVal, 'HeeSun Yoon', 'HeeSun' ,'1234', '경기도 구리시', 0 );

select * from tbl_member;
select seq,name,id,pw,address,delflag from tbl_member where id='HeeSun' and pw=1234;

select count(*) as cnt from tbl_member where id='HeeSun' and pw=1234;

insert into TBL_SCHEDULE (seq, member_seq,title, content, start_time, end_time, important, tag, cost, state, regdate, delflag) values (seq_schedule.nextVal, 1, 'Programming Study', 'Java, Oracle, JavaScript Study', '2021-06-22','2021-07-26',4,'study,coding',0,'doing','2021-07-08',0);

select * from tbl_schedule;

--commit;
select * from tbl_schedule where seq = (select seq from tbl_member where id='HeeSun' and pw='1234');
select * from tbl_schedule where seq = (select seq from tbl_member where id='HeeSun' and pw='1234');

-- 21.07.27 수정
update tbl_schedule set start_time = '2021.06.22' where member_seq = 1;
update tbl_schedule set end_time = '2021.09.26' where member_seq = 1;

select * from tbl_schedule;

-- 21.07.28
-- To do, Doing, Done 에 해당하는 게시물 개수 (서브쿼리 사용) 
select
    (select count(*) from tbl_schedule where member_seq = 1 and start_time > sysdate) as todo_cnt , 
    (select count(*) from tbl_schedule where member_seq = 1 and start_time < sysdate and end_time > sysdate) as doing_cnt , 
    (select count(*) from tbl_schedule where member_seq = 1 and end_time < sysdate) as done_cnt  
from tbl_member where id='HeeSun' and pw=1234;


select seq,name,id,pw,address,delflag from tbl_member where id='HeeSun' and pw=1234;

insert into TBL_SCHEDULE (seq, member_seq,title, content, start_time, end_time, important, tag, cost, state, regdate, delflag) values ()


-- 2021.10.22 수정 
alter table TBL_SCHEDULE modify cost NUMBER default 0;
alter table TBL_SCHEDULE modify regdate VARCHAR2(50) default sysdate;
alter table TBL_SCHEDULE modify DELFLAG NUMBER default 0;
select * from tbl_schedule;
commit;


insert into TBL_SCHEDULE (seq, member_seq,title, content, start_time, end_time, important, tag, cost, state, regdate, delflag) 
values (seq_schedule.nextVal,1,'Javasciprt Study','Javasciprt Study,Programmers Question','20211022','20211106',4,'Javasciprt',0,'doing','2021.10.23',0)

delete from TBL_SCHEDULE where title='Javasciprt Study';
select * from tbl_schedule;

--commit;



--2021.10.31
-- ORA-01861: literal does not match format string 에러로 혹시 '!' 때문에 그런건지 ㅠㅠ 
-- > 아니였네 ㅠㅠ (sysdate랑 varchar2 문자형인 start,end date와 비교할 때 오류였음)
update TBL_SCHEDULE set content = 'Toy Project in progress' where title = 'Toy Project';

--11월 31일 날짜 없음. 30일로 수정 
update TBL_SCHEDULE set END_TIME = '20211129' where title = 'Toy Project';


--delete from TBL_SCHEDULE where title='Toy Project';

select * from TBL_SCHEDULE;

--commit;


--2021.11.03
-- start, end date 날짜에 "." 추가수정
--update TBL_SCHEDULE set START_TIME = '2021.08.01' where title = 'Toy Project';
--update TBL_SCHEDULE set END_TIME = '2021.11.20' where title = 'Toy Project';













