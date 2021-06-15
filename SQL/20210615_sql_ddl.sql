-- 2021.06.16 (TUE)

-- DDL : 데이터 정의어

-- 테이블 생성 : creat table
-- 테이블 수정 : alter table
-- 테이블 삭제 : drop table

-- creat table (
--                컬럼이름 타입 (사이즈) 제약조건 정의, 
--                 , .....
--  )

-- creat table (
--                컬럼이름 타입 (사이즈) ,
--                 , .....
--                제약조건 정의,
--                 , ...
--  )

-- 사원 테이블과 유사한 구조의
-- 사원번호, 사원이름, 급여 3개의 칼럼으로 구성된
-- EMP01 테이블을 생성해보자. (테이블 이름 : EMP01)

create table emp01 (
    empno number (4), -- 사원번호
    ename VARCHAR2 (20), -- 사원 이름
    sal number (6, 2) 
);


-- 서브 쿼리를 이용해서 기존 테이블의 구조를 복사하고 해상 튜플도 복사 가능하다.
create table emp02
as
select * from emp
;


select * from emp02;


create table emp03 -- 서브쿼리를 emp03 형식으로 복사한다.
as
select empno, ename, sal from emp
;


create table emp04
as select * from emp where deptno = 30
;

select * from emp04;


create table emp05
as
select * from emp where 1 = 2
;


select * from emp05; -- 데이터 없이 구조만 복사해온다.


-- 테이블의 변경 : alter table
-- alter table (테이블 이름) add
-- alter table (테이블 이름) modify
-- alter table (테이블 이름) drop (컬럼 이름)


-- emp01 테이블에 job 컬럼을 추가해보자
alter table emp01
add (  job   varchar2(9)  ) -- 9자리 문자
;

desc emp01;


-- emp01 테이블의 job 컬럼의 사이즈를 수정해보자. ( 9 -> 30 )
-- 컬럼 제약조건 형식을 똑같이 정의해주어야 한다
-- (새롭게 추가하는 개념이 아닌, ""재정의"" 하는 개념)
alter table emp01
modify (  job varchar2(30) ) -- 30자리 문자 
;

alter table emp01
modify (  job varchar2(30) not null ) -- not null 추가
;


-- emp01 테이블의 job컬럼을 삭제
alter table emp01
drop column job
;


-- 테이블 삭제
drop table emp01;


-- 새로운 테이블 생성
create table emp01
as
select * from emp
;
select * from emp02;


-- 모든 행을 삭제 :  truncate : DDL은 롤백이 불가능하다.
truncate table emp02;


-- 테이블의 이름 변경 : rename 현재이름 to 새로운 이름
rename emp01 to test;
desc emp01;
desc test;


create table emp02
as
select empno, ename, sal,  job from emp where 1=0
;

create table emp02 (
            empno number(4) constraint emp02_empno_pk primary key, --not null unique, 
            ename varchar2(20) constraint emp02_ename_nn not null,
            sal number(6, 2) constraint emp02_sal_chk check (sal > 500 and sal < 5000),
            job varchar(20) default '미지정', -- 문자열 type
            deptno number constraint emp02_deptno_fk REFERENCES dept (deptno) --외래키
);


desc emp02;

drop table emp02;


-- 순서대로 값 기입
insert into emp02 (empno, ename, sal, job) values (1000, 'SON', 3000, 'MANAGER') ;
insert into emp02 values (null, null, 10000, 'MANAGER');
insert into emp02 (empno, ename, sal) values (1000, 'SON', 3000) ;

insert into emp02 (empno, ename, sal, job, deptno)
            values (3000, 'SON', 3000, 'MANAGER', 60);
            -- 외래키 제약
insert into emp02 values (null, null, 10000, 'MANAGER');

select * from emp02;