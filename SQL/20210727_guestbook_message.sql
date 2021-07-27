-- craete table
create table project.guestbook_message (
messageID int not null auto_increment primary key,
guestName varchar(20) not null,
password varchar(guestbook_message20) not null,
message text not null,
regDate timestamp default current_timestamp
);

-- selelct
-- 가장 최근 게시물 순차대로 나열
select * from project.guestbook_message order by regDate desc;
-- limit n, m : n번째부터 m개 (index, count 기능 - 페이징 처리)
select * from project.guestbook_message order by regDate desc limit 0, 3;

-- insert
insert into project.guestbook_message (guestName, password, message)
values ('jiwon', '1111', 'Hello Stranger');

-- update
update project.guestbook_message
set guestName='goo', password='0000', message='bark!'
where messageID=1;

-- delete
delete from project.guestbook_message where messageID=10;

-- 테이블 삭제
drop table project.guestbook_message;

-- 전체 게시물의 개수
select count(*) from project.guestbook_message;

-- messageID로 게시물 검색
select * from project.guestbook_message where messageID = 1;