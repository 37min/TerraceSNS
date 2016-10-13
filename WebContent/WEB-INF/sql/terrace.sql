--테라스 기본 테이블
drop table t_terrace;
create table t_terrace(
	terrace_no number primary key,
	terrace_name varchar2(500) not null,
	terrace_intro varchar2(1000) not null,
	terrace_admin varchar2(200) not null,
	terrace_lock number default 0,
	terrace_register number default 1,
	terrace_category varchar2(500) not null,
	terrace_joinlist varchar2(500) not null,
	terrace_icon_orgimg varchar2(500),
	terrace_icon_newimg varchar2(500),
	terrace_cover_orgimg varchar2(500),
	terrace_cover_newimg varchar2(500)
)
--기본 테라스 번호 시퀀스
create sequence seq_terrace_no nocache;
drop sequence seq_terrace_no;

--마이테라스 테이블
drop table t_myterrace;
create table t_myterrace(
	myterrace_id varchar2(500) not null,
	myterrace_tno number not null,
	constraint fk_myterrace_id foreign key(myterrace_id) references t_member(member_id) on delete cascade,
	constraint fk_myterrace_tno foreign key(myterrace_tno) references t_terrace(terrace_no) on delete cascade,
	constraint pk_myterrace primary key(myterrace_id,myterrace_tno)
)

-------------------------------------------------------------------------------
select * from t_terrace

select * from t_terrace where terrace_category='동아리' and terrace_lock=0

insert into t_terrace(terrace_no,terrace_name,terrace_intro,terrace_admin,terrace_lock,
	terrace_register,terrace_category,terrace_joinlist,terrace_icon_orgimg,terrace_icon_newimg,
	terrace_cover_orgimg,terrace_cover_newimg) 
	values(seq_terrace_no.nextval,'현대자동차','취업준비','bagette112@ajou.ac.kr',0,1,
	'동아리','/','terIconDefault.jpg','terIconDefault.jpg','terCoverDefault.jpg','terCoverDefault.jpg');
insert into t_terrace(terrace_no,terrace_name,terrace_intro,terrace_admin,terrace_lock,
	terrace_register,terrace_category,terrace_joinlist,terrace_icon_orgimg,terrace_icon_newimg,
	terrace_cover_orgimg,terrace_cover_newimg) 
	values(seq_terrace_no.nextval,'고래','아주대학교 애니메이션 동아리','bagette112@ajou.ac.kr',0,1,
	'동아리','/','terIconDefault.jpg','terIconDefault.jpg','terCoverDefault.jpg','terCoverDefault.jpg');
insert into t_terrace(terrace_no,terrace_name,terrace_intro,terrace_admin,terrace_lock,
	terrace_register,terrace_category,terrace_joinlist,terrace_icon_orgimg,terrace_icon_newimg,
	terrace_cover_orgimg,terrace_cover_newimg) 
	values(seq_terrace_no.nextval,'KOSTA','아주대학교 개발자들','bagette112@ajou.ac.kr',1,1,
	'아이티','/','terIconDefault.jpg','terIconDefault.jpg','terCoverDefault.jpg','terCoverDefault.jpg');
	