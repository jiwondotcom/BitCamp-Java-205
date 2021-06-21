--#2 요구사항에 맞는 오브젝트를 생성하는 sql을 작성하시오.
--1. 대리키 IDX, 회원 아이디, 이름, 비밀번호, 사진이름, 가입일 을 저장할 수 있는 
--   이름이 MEMBER인 테이블을 생성하세요. 
--   IDX 에는 기본키 제약을 설정하고,
--   회원 아이디에는 unique, not null 제약 설정을 하고, 
--   이름과 비밀번호에는 not null, 
--   가입일은 기본 값으로 sysdate가 입력되도록 하시오.
--2. Member 테이블에서 이름 컬럼으로 인덱스 객체를 생성하시오.
--3. MEMBER 테이블에서 회원 아이디, 이름, 사진 정보만을 출력하는 view 객체를 생성하시오.
--   view의 이름은 member_view 로 생성하시오.


create table MEMBER (
idx number(4), constraint member_idx_pk primary key,
id varchar(20) constraint member_id_nn not null unique,
name varchar(20) constraint member_name_nn not null,
pw number(6) constraint member_pw_nn not null,
picName varchar(20),
joinDate default sysdate 
);


create index MEMBER_INDEX on member(name);

Create view MEMBER_VIEW
as select id, name, picName
from MEMBER
