create table project_user(
	p_user varchar2(10 char) primary key,
	p_password varchar2(10 char) not null,
	p_name varchar2(10 char) not null,
	p_grade varchar2(10 char) not null,
	p_photo varchar2(100 char) not null,
	p_birthday date not null
);

drop table project_user;

select * from PROJECT_USER;
select * from PROJECT_movie;

--select * from project_user where p_user = 'abc';

insert into project_movie
values('https://img.movist.com/?img=/x00/05/83/10_p1.jpg', '가디언즈 오브 갤럭시: Volume3', '2023-05-05', 'Action', 'James Gunn');

update PROJECT_USER set p_grade = 'True' where p_name = 'zxcv';

-- pmrc_board_seq
SELECT * FROM all_sequences;
select * from pmrc_board;

select pb_no, pb_writer, pb_title, pb_count, pb_date
		from (
			select *
			from (
				select rownum as rn, pb_no, pb_writer, pb_title, pb_count, pb_date
				from (
					select * from pmrc_board
					where pb_writer like '%'||#{search}||'%' or pb_title like '%'||#{search}||'%'
					order by pb_date desc
				)
			)
			where rn &gt;= #{start} and rn &lt;= #{end}
		)
		order by pb_date desc

select * from pmrc_board;
		


insert into pmrc_board(pb_no, pb_title, pb_content, pb_writer) values(pmrc_board_seq.nextval, '제목2', '내용내용', 'abc');
insert into pmrc_board(pb_no, pb_title, pb_content, pb_writer) values(pmrc_board_seq.nextval, '제목3', '내용내용', 'abc');
insert into pmrc_board(pb_no, pb_title, pb_content, pb_writer) values(pmrc_board_seq.nextval, '제목4', '내용내용', 'abc');
insert into pmrc_board(pb_no, pb_title, pb_content, pb_writer) values(pmrc_board_seq.nextval, '제목5', '내용내용', 'abc');
insert into pmrc_board(pb_no, pb_title, pb_content, pb_writer) values(pmrc_board_seq.nextval, '제목6', '내용내용', 'abc');
insert into pmrc_board(pb_no, pb_title, pb_content, pb_writer) values(pmrc_board_seq.nextval, '제목7', '내용내용', 'abc');
insert into pmrc_board(pb_no, pb_title, pb_content, pb_writer) values(pmrc_board_seq.nextval, '제목8', '내용내용', 'abc');
insert into pmrc_board(pb_no, pb_title, pb_content, pb_writer) values(pmrc_board_seq.nextval, '제목9', '내용내용', 'abc');
insert into pmrc_board(pb_no, pb_title, pb_content, pb_writer) values(pmrc_board_seq.nextval, '제목10', '내용내용', 'abc');
insert into pmrc_board(pb_no, pb_title, pb_content, pb_writer) values(pmrc_board_seq.nextval, '제목11', '내용내용', 'abc');
insert into pmrc_board(pb_no, pb_title, pb_content, pb_writer) values(pmrc_board_seq.nextval, '제목12', '내용내용', 'abc');
insert into pmrc_board(pb_no, pb_title, pb_content, pb_writer) values(pmrc_board_seq.nextval, '제목13', '내용내용', 'abc');
insert into pmrc_board(pb_no, pb_title, pb_content, pb_writer) values(pmrc_board_seq.nextval, '제목14', '내용내용', 'abc');
insert into pmrc_board(pb_no, pb_title, pb_content, pb_writer) values(pmrc_board_seq.nextval, '제목15', '내용내용', 'abc');
insert into pmrc_board(pb_no, pb_title, pb_content, pb_writer) values(pmrc_board_seq.nextval, '제목2', '내용내용', 'abc');
insert into pmrc_board values(pmrc_board_seq.nextval, '제목2', '내용내용', 'abc');


insert into pmrc_board(pb_no, pb_title, pb_content, pb_writer) values(pmrc_board_seq.nextval, '특별', '다른 내용입니다', 'abc');

select * from pmrc_sns_reply;


insert into pmrc_sns_reply(pmrc_sns_reply_seq.nextval, 게시글번호, 댓글작성자, 댓글내용, 디폴트날짜, 댓글작성자프사)


select * from pmrc_sns_reply where psr_ps_no like 54 order by psr_date;

<<<<<<< HEAD

select * from project_movie;

select * from project


select pm_code, pm_pyear, pm_name, pm_genre, pm_director, pm_url
		from (
			select *
			from (
				select rownum as rn, pm_code, pm_pyear, pm_name, pm_director, pm_genre, pm_url
				from (
					select * from project_movie
					where pm_name like '%범죄도시2'
					order by pm_pyear desc
				)
			)
			where rn >= 1 and rn <= 10
		)
		order by pm_pyear desc
		
		
		
		
select 
	count(Distinct pm_genre) as genre
	from project_movie
	
	
select distinct pm_genre from project_movie

update project_movie set pm_pyear = To_Date(
	(select pm_pyear from project_movie where pm_code='20231931')
	, 'YYYY/MM/DD');
	
select pm_pyear from project_movie where pm_code='20231931'

update pm_pyear from project_movie where pm_code
=======
select * from project_movie;

update project_movie set pm_pyear = To_Date(
	(select pm_pyear from project_movie where pm_code='20231931';)
,'YYYY');

select pm_pyear from project_movie where pm_code='20231931';

drop table project_movie;



drop table project_movie;

create table project_movie(
	pm_code varchar2(100 char) primary key,
	pm_pyear varchar2(100 char) not null,
	pm_name varchar2(200 char) not null,
	pm_genre varchar2(100 char) not null,
	pm_director varchar2(100 char) not null,
	pm_acc number(10) not null,
	pm_url varchar2(200 char) not null
);

select count(*) from project_movie;


select * from project_movie;


select * from pmrc_board, project_user where pb_no = 2 and pb_writer like p_user


create table project_movie_review(
	pmr_no number primary key,
	pmr_pm_code number not null,
	pmr_writer varchar2(100 char) not null,
	pmr_grade number(2) not null,
	pmr_date date not null,
	pmr_txt varchar2(200 char) not null
);

create sequence pmrc_movie_reply_seq;

drop table movie_review;

insert into project_movie_review values(pmrc_movie_reply_seq.nextval, '20230081', #{pm_writer}, #{pmr_grade}, sysdate, #{pmr_txt});

insert into project_movie_review values(pmrc_movie_reply_seq.nextval, #{pm_code}, #{pm_writer}, #{pmr_grade}, sysdate, #{pmr_txt});

select * from project_movie_review

select distinct pm_genre from project_movie;

select pm_name, pm_pyear, pm_genre, pm_director, pm_acc, pm_url
		from (
			select *
			from (
				select rownum as rn, pm_name, pm_pyear, pm_genre, pm_director, pm_acc, pm_url
				from (
					select * from project_movie
					where pm_genre like '사극'
					order by pm_acc desc
				)
			)
			where rn >= 1 and rn <= 10
		)
		order by pm_acc desc 
		
delete from project_movie 
where pm_name = '알라딘';


select count(*)
from project_movie
where pm_name like '범죄 도시'

