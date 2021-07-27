-- craete table
create table project.guestbook_message (
messageid int not null auto_increment primary key,
guestname varchar(20) not null,
password varchar(20) not null,
message text not null,
regdate timestamp default current_timestamp
);

-- selelct
select * from project.guestbook_message limit 0, 3;
-- limit n, m : n번째부터 m개 (index, count 기능)