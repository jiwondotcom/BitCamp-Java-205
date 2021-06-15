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



