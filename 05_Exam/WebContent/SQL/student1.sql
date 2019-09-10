create table student1(
	hakbun number(8) primary key,
	name varchar2(20) not null, 
	id varchar2(20), 
	pwd varchar2(20),
	tel varchar2(20),
	major varchar2(30), 
	grade number(1),
	reg_date date
);

-- 학번 시퀀스 작업
create sequence student1_seq
start with 20190001
increment by 1
nocache;

insert into student1 values(student1_seq.nextval,'홍길동','hong','1111','010-1111-1111','경제학과',3,sysdate);
insert into student1 values(student1_seq.nextval,'이순신','lee','2222','010-2222-2222','해양학과',4,sysdate);
insert into student1 values(student1_seq.nextval,'유관순','yoo','3333','010-3333-3333','회계학과',1,sysdate);