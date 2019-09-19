-- jsp_bbs 테이블 생성
-- BBS(Bulletin Board System)
-- 게시판 필드(컬럼) 구성

	-- 번호
	-- 제목
	-- 작성자
	-- 작성일
	-- 조회수
	-- 글내용
	-- 답변 그룹
	-- 답변글의 단계
	-- 답변글의 들여쓰기

create table jsp_bbs(
          board_no number(5) primary key, -- 게시판 글 번호
          board_writer varchar2(20) not null, -- 게시판 작성자
          board_title varchar2(100) not null, -- 게시판 글 제목
          board_cont varchar2(1000) not null, --게시판 글 내용
          board_pwd varchar2(20) not null, -- 게시판 비밀번호
          board_hit number(5) default 0, -- 게시판 조회수
          board_date date, --  게시판 글 작성 일자
          board_group number(4), --  게시판 글 그룹
          board_step number(4), -- 게시판 답변 단계
          board_indent number(4) -- 게시판 답변글 들여쓰기
);
create sequence bbs_seq
start with 1
increment by 1
nocache;

-- 게시판 번호와 게시판 글 그룹 번호를 맞춰줌, currval
insert into jsp_bbs values(bbs_seq.nextval,'홍길동','제목1','내용1','1111',default,sysdate,bbs_seq.currval,0,0);
insert into jsp_bbs values(bbs_seq.nextval,'이순신','순신 글','순신 글 내용','2222',default,sysdate,bbs_seq.currval,0,0);
insert into jsp_bbs values(bbs_seq.nextval,'유관순','제목3','내용3','3333',default,sysdate,bbs_seq.currval,0,0);
insert into jsp_bbs values(bbs_seq.nextval,'김유신','유신님 글',' 김유신님 글','4444',default,sysdate,bbs_seq.currval,0,0);
insert into jsp_bbs values(bbs_seq.nextval,'김연아','연아언니 글','김연아님 글','5555',default,sysdate,bbs_seq.currval,0,0);