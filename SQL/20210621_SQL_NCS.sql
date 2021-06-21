-- 2021.06.21 (MON)
--NCS SQL 활용 포트폴리오


--#1 아래 요구사항에 맞도록 기본 SQL 문을 작성하시오.
--
--1. 아래 조건에 맞는 DDL을 작성하시오.
--===== 전화번호 부( 테이블 이름 : Contact )
-------- 기본정보(not null)
---- 대리키 : 일련번호 -> pIdx 기본키로 설정
---- 이름, 전화번호, 주소, 이메일
---- 주소값과 이메일은 입력이 없을 때 기본값 입력
---- 친구의 타입 (카테고리) : univ, com, cafe 세가지 값만 저장 가능
-------- 선택 정보
---- 전공, 학년
---- 회사이름, 부서이름, 직급
---- 모임이름, 닉네임
--=============================


CREATE TABLE contact (
pidx NUMBER(4) CONSTRAINT contact_pidx_pk PRIMARY KEY,
NAME VARCHAR2(20) CONSTRAINT contact_name_nn NOT NULL,
phNum VARCHAR2(20) CONSTRAINT contact_phNum_nn NOT NULL,
address VARCHAR2(20) DEFAULT 'SEOUL' CONSTRAINT contact_address_nn NOT NULL,
email VARCHAR2(30) DEFAULT 'NON' CONSTRAINT contact_email_nn NOT NULL, 
ftype VARCHAR2(4) CONSTRAINT contact_ftype_ck CHECK (ftype IN('univ', 'com', 'cafe')) NOT NULL,
major VARCHAR2(10),
grade NUMBER(1),
cpname VARCHAR2(20),
dname VARCHAR2(10),
dgrade VARCHAR2(10),
groupname VARCHAR2(20),
nickname VARCHAR2(20)
);
