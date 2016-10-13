--대학 테이블
drop table univ;
create table univ(
	univ_name varchar2(100) primary key,
	univ_loc varchar2(100) not null,
	univ_email varchar2(100) not null
)
select * from univ;
insert into univ(,)
--멤버 테이블
drop table t_member;
create table t_member(
	member_id varchar2(100) primary key,
	member_pass varchar2(100) not null,
	member_name varchar2(100) not null,
	member_univ varchar2(100) not null,
	member_dept varchar2(100) not null,
	member_no varchar2(100) unique,
	member_phone varchar2(100),
	member_orgimg varchar2(500),
	member_newimg varchar2(500),
	member_sleep number default 0,
	constraint fk_member_univ foreign key(member_univ) references univ(univ_name) on delete cascade
)
insert into univ(univ_name,univ_loc,univ_email) values('아주대학교','경기도','@ajou.ac.kr');
select * from t_member;
delete from t_member where member_id='1234@ajou.ac.kr';
select count(*) from t_member where member_no='20';
