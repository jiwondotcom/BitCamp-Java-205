-- 2021.06.09 (WED)
-- SQL Basic

-- 계정 HR이 보유한 테이블 객체 리스트 (권한을 가지고 있는)
select * from tab;

-- 테이블의 정보를 검색 : 컬럼의 이름, null의 유무(not null or null), 타입, 사이즈
desc dept;

-- 데이터 조회를 위한 명령 : Select
-- Select { 컬럼명, ... , * } from (조회하고자 하는) 테이블 이름;
select * 
from emp
;

-- 필요한 컬럼을 출력
--  select 컬럼명, 컬럼명 from 테이블 이름
-- 사원의 사원 번호와 사원 이름을 출력하는 sql을 만들어보자.
select  ename, empno, sal, deptno -- 전체 칼럼 출력X, 컬럼 및 속성의 ""순서""는 상관없다.
from emp 
;

-- select 컬럼의 산술연산이 가능 : 컬럼과 숫자의 연산, 컬럼과 컬럼간의 연산 가능
-- 사원이름, 월 급여, 연봉 계산 결과값 (sal * 12)
select ename, sal, sal * 12 as ysal
from emp
;

-- 데이터베이스에서의 null : 값이 아직 정해지지 않았다는 의미
-- 해당 테이블의 데이터를 가지고 새로운 데이터, 표를 만들 수 있다.
select sal, comm, sal * comm, sal * 12, sal / 10, sal - 100, sal + 1000
from emp
;

-- 사원의 이름, 직급, 급여, 커미션, 연봉1(월 급여 * 12), 연봉2(급여 * 12 * 커미션)
select ename, job, sal, comm, sal * 12 as ysal1,  sal * 12 + comm as ysal2
from emp
;

-- 개선 : null 값을 0으로 치환해서 연산(고정값)
-- nvl(컬럼 이름, 기본값) 함수 : 컬럼의 값이 null 일때, 기본값으로 치환
select ename, job, sal, 
         nvl(comm, 0), sal * 12 as ysal1,  sal * 12 + nvl(comm, 0) as ysal2
from emp
;

-- 컬럼과 문자열을 붙이는 연산 || 을 이용한다.
-- sql에서 문자열 표현 => ' 작은 따옴표를 이용한다.
select ename ||  ' is a ' || job
from emp
;

-- 결과 리스트에서 중복된 값을 제거 : distinct
-- 중복되는 값을 하나씩만 출력한다.
select distinct deptno
from emp
;

select distinct deptno, job
from emp
order by job -- 정렬 : 행의 정렬
;

-- 특정 데이터를 검색하기 위해서는
-- select ~ from ~ 구문에 where절을 이용한다.
-- where 뒤에는 조건식이 정의되어야 한다.  -> where 컬럼명 : 비교연산자 값
-- where sal  >= 3000 
-- 사원이름, 사원 번호, 급여
select ename, empno, sal
from emp
where sal >= 3000
;
