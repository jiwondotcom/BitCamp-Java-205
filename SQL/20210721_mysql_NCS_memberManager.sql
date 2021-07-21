CREATE TABLE member.memberInfo (
  `USERID` varchar(14) COLLATE utf8_bin NOT NULL,
  `USERPW` varchar(14) COLLATE utf8_bin NOT NULL,
  `USERNAME` varchar(14) COLLATE utf8_bin NOT NULL,
  `REGDATE` varchar(50) COLLATE utf8_bin NOT NULL
  );
  
  drop table member.memberInfo;

  
  insert into member.memberInfo values ('jiwon', 2568, '황지원', sysdate());
  
  
  commit;