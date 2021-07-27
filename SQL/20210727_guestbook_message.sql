-- craete table
create table project.guestbook_message (
messageid int not null auto_increment primary key,
guestname varchar(20) not null,
password varchar(20) not null,
message text not null,
regdate timestamp default current_timestamp
);

-- selelct
-- 가장 최근 게시물 순차대로 나열
select * from project.guestbook_message order by regdate desc;
-- limit n, m : n번째부터 m개 (index, count 기능 - 페이징 처리)
select * from project.guestbook_message order by regdate desc limit 0, 3;
