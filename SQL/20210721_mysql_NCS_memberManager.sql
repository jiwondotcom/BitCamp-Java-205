CREATE TABLE member.memberInfo (
  `USERID` varchar(14) COLLATE utf8_bin DEFAULT NULL ,
  `USERPW` varchar(14) COLLATE utf8_bin DEFAULT NULL,
  `USERNAME` varchar(14) COLLATE utf8_bin DEFAULT NULL,
  `REGDATE` date,
  PRIMARY KEY(`USERID`)
  );
  
  drop table member.memberInfo;
  
  insert into member.memberInfo values ('jiwon', 2568, '황지원', sysdate);