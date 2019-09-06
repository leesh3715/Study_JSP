-- member1 테이블 생성
create table member1(
	id varchar2(20) primary key,
	pwd varchar2(20) not null,
	name varchar2(20) not null,
	reg_date date, -- 날짜는 문자열로 저장
);


--member1 테이블에 레코드 추가

insert into member1 values("hong",'1234','홍길동',sysdate);
insert into member1 values("lee",'2345','이순신',sysdate);
insert into member1 values("yoo",'3456','유관순',sysdate);