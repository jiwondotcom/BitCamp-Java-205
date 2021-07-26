create table member.memberinfo (
	`index` int auto_increment,
    userID varchar(14) not null,
    userPW varchar(20) not null,
    userName varchar(20) not null,
    regDate timestamp default current_timestamp,
    constraint memberinfo_index_pk primary key (`index`),
    constraint memberinfo_userID_uq unique (userID)        
); 

  
drop table member.memberInfo;
delete from member.memberinfo where `index` = 3;
select * from member.memberinfo where `index` = 3;
  
  insert into member.memberInfo values (default, 'jiwon', 2568, '황지원', sysdate());
  select * from member.memberinfo where `index` = 8;
  
  
update memberinfo set `userid` = 'goo', `userpw` = 'goo', `userName` = 'goo' where `index` = 10;
  commit;