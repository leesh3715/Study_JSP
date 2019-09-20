-- upload 테이블 생성

create table upload(
          upload_no number(5) primary key, -- 자료실 글번호
          upload_writer varchar2(20) not null, -- 자료실 작성자
          upload_title varchar2(100) not null, -- 자료실 글
          upload_cont varchar2(1000) not null, -- 자료실 글내용
          upload_pwd varchar2(20) not null, -- 자료실 글 비밀번호
          upload_file varchar2(500), -- 자료실 파일명
          upload_hit number(5) default 0, -- 자료실 조회수
          upload_date date -- 자료실 작성일자
);

-- 자료실 시퀀스 생성
create sequence upload_seq
start with 1
increment by 1
nocache;