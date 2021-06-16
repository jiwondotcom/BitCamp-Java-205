-- 2021.06.16 (WED)
-- exam07 DML

--앞에서 생성한 전화번호부 테이블을 기준으로 DML 을 작성해봅시다.

-- 테이블 정보
desc phoneInfo_basic;
-- 현재 테이블 입력값
select * from phoneInfo_basic;
rollback;

--1. phoneInfo_basic 테이블의 SELECT, UPDATE, DELETE, INSERT 하는 SQL
-- INSERT : reate
insert into phoneInfo_basic
                values (1, '화이자', '010-0001-2345', '234@gg.com', 'BUSAN', SYSDATE);
insert into phoneInfo_basic (idx, fr_name, fr_phonenumber)
                values (2, '아스트라', '010-000-0000');
insert into phoneInfo_basic (idx, fr_name, fr_phonenumber, fr_address)
                values (3, '모더나', '010-1112222-3456', 'INCHEON');
insert into phoneInfo_basic
                values (4, '얀센', '010-3333-4567', '789@gg.com', 'DAEGU', SYSDATE);
                
-- SELECT : read
select * from phoneInfo_basic;

-- UPDATE
-- 이메일 & 주소 업데이트
update phoneInfo_basic
set fr_email = 'aaa@gg.com', fr_address = 'BUCHEON'
where idx = 2;
-- fr_name : 아스트라 (동명이인일 가능성을 고려하여 idx값으로 업데이트하는 것을 추천)

-- DELETE
-- 일정 행을 삭제한다.
delete from phoneInfo_basic
where idx = 1;


--2. phoneinfo_univ 테이블의 SELECT, UPDATE, DELETE, INSERT 하는 SQL
select * from phoneInfo_univ;

insert into phoneInfo_univ
                values(2, 'PHOTO', 3, 3);
-- INSERT
-- SELECT
select *
from phoneInfo_basic pb, phoneInfo_univ pu
where pb.idx = pu.fr_ref
;

-- UPDATE : 데이터 수정
-- 전공과 학년을 수정, idx 또는 참조키(외래키)
-- 대한친구의 정보를 입력한다.
update phoneInfo_univ
set fr_u_major = 'ENG', fr_u_year = 3
where fr_ref = 2;

-- DELETE : 데이터 삭제
delete from phoneInfo_univ
where fr_ref = 2;

--3. phoneinfo_com 테이블의 SELECT, UPDATE, DELETE, INSERT 하는 SQL





-- 전체 친구 정보
select *
from phoneInfo_basic pb, phoneInfo_univ pu, phoneInfo_com pc
where pb.idx = pc.fr_ref(+) and pb.idx = pc.fr_ref
;
