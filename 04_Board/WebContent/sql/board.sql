-- 테이블생성
create table board(
	board_no number(5) primary key, -- 게시물 물 번호
	board_writer varchar2(20) not null, -- 게시물 작성자
	board_title varchar2(50) not null, -- 게시물 제목
	board_cont varchar2(1000), -- 게시물 내용
	board_pwd varchar2(20) not null, -- 게시물 비밀번호
	board_hit number(5) default 0, -- 게시물 조회수(기본 값 0)
	board_regdate date 				-- 게시물 등록 날짜
);

-- board_no에 대한 시퀀스 생성  http://www.gurubee.net/lecture/1037
create sequence board_seq
start with 1
increment by 1
nocache;

--레코드 추가
insert into board values(board_seq.nextval,'홍길동','제목1','내용1','1111',default,sysdate);
insert into board values(board_seq.nextval,'이순신','제목2','이순신 내용2','2222',default,sysdate);
insert into board values(board_seq.nextval,'유관순','제목3','유관순 내용3','3333',default,sysdate);