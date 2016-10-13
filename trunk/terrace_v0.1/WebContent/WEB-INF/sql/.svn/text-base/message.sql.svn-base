--조인메세지
drop table t_msg_join;
create table t_msg_join(
	join_no number primary key,
	join_send_tno number not null,
	join_receive_tno number not null,
	join_send_members varchar2(4000) not null,
	join_send_title varchar2(1000) not null,
	join_send_msg varchar2(4000) not null,
	join_date date not null,
	constraint fk_join_receive_tno foreign key(join_receive_tno) references t_terrace(terrace_no) on delete cascade
)
--조인 메세지 번호 시퀀스
create sequence seq_join_no nocache;
drop sequence seq_join_no;

--초대메세지
drop table t_msg_invite;
create table t_msg_invite(
	invite_no number primary key,
	invite_send_tno number not null,
	invite_send_id varchar2(100) not null,
	invite_receive_id varchar2(100) not null,
	invite_date date not null,
	constraint fk_invite_receive_id foreign key(invite_receive_id) references t_member(member_id) on delete cascade,		
	constraint fk_invite_send_tno foreign key(invite_send_tno) references t_terrace(terrace_no) on delete cascade
)
--초대 메세지 번호 시퀀스
create sequence seq_invite_no nocache;
drop sequence seq_invite_no;


--가입 승인 메세지
drop table t_msg_reg_confirm;
create table t_msg_reg_confirm(
	confirm_no number primary key,
	confirm_send_tno number not null,
	confirm_send_id varchar2(100) not null,
	confirm_receive_id varchar2(100) not null,
	comfirm_confirm number not null,
	confirm_date date not null,
	constraint fk_confirm_send_tno foreign key(confirm_send_tno) references t_terrace(terrace_no) on delete cascade,		
	constraint fk_confirm_send_id foreign key(confirm_send_id) references t_member(member_id) on delete cascade
)

--가입 메세지 번호 시퀀스
create sequence seq_confirm_no nocache;
drop sequence seq_confirm_no;

--가입 요청 메세지
drop table t_msg_reg_request;
create table t_msg_reg_request(
	request_no number primary key,
	request_tno number not null,
	request_send_id varchar2(100) not null,
	request_date date not null,
	constraint fk_request_tno foreign key(request_tno) references t_terrace(terrace_no) on delete cascade,		
	constraint fk_request_send_id foreign key(request_send_id) references t_member(member_id) on delete cascade
)

--가입 요청 번호 시퀀스
create sequence seq_request_no nocache;
drop sequence seq_request_no;
