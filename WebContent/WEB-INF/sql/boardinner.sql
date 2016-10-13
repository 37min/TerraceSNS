--테라스 내부 게시판
drop table t_board_in;
create table t_board_in(
	in_no number primary key,
	in_id varchar2(100) not null,
	in_contents varchar2(1000) not null,
	in_date date not null,
	in_lock int default 0,
	in_tno number not null,
	constraint fk_in_tno foreign key(in_tno) references t_terrace(terrace_no) on delete cascade,
	constraint fk_in_id foreign key(in_id) references t_member(member_id) on delete cascade
)
--게시판 번호 시퀀스
create sequence seq_in_no nocache;
drop sequence seq_in_no;