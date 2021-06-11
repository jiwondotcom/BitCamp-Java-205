-- 2021.06.11 (FRI)

-- 그룹함수
-- 여러행을 묶어 처리하는 함수
-- sum, avg, cont, max, min

-- 사원 테이블에서
-- 1. 사원의 수
-- 2. 사원의 급여 총합
-- 3. 급여 평균
-- 4. 최대 급여
-- 5. 최소 급여
select count(*) as "사원의 수", 
         sum(sal) as "급여의 총합",
         round(avg(sal), 2) as "급여 평균",
         max(sal) as "최대 급여",
         min(sal) as "최소 급여",
         sum(comm) as "커미션의 총합", -- 그룹함수는 null 값을 제외하고 연산
         round (avg(comm), 0) as "커미션의 평균",
         count(comm) as "커미션 받는 사원의 수"
from emp;


-- distinct를 이용해서 중복된 개수 제거
select count(distinct job) -- distinct 전엔 14개(중복된 직급들 포함)
from emp
;


--마당서적 book 테이블에 책을 납품하는 출판사
select count (distinct publisher) -- 중복된 출판사는 제거한 출판사의 개수 출력
--select distinct publisher -- 중복된 출판사는 제거한 출판사 리스트 출력
from book
order by publisher
;


-- 특정 컬럼을 이용해서 그룹핑하기 -> group by
-- 특정 조건을 기준으로 그룹핑하여 해당 특정 raw 데이터들을 다룬다. 
-- select 그룹핑할 기준의 컬럼, 그룹함수
-- from 테이블
-- where
-- group by 그룹핑할 기준의 컬럼
-- *** 위치와 순서 중요!
select avg(sal) from emp where deptno = 10;
select avg(sal) from emp where deptno = 20;
select avg(sal) from emp where deptno = 30;

-- 부서번호 그룹별
select deptno as "부서 번호", count(*) as "부서별 인원", sum(sal) as "부서별 급여 총합", 
          trunc (avg(sal)) as "부서별 급여 평균", max(sal) as "부서별 최대 급여액", min(sal) as "부서별 최소 급여액"
from emp
group by deptno -- 부서번호로 그룹핑한다.
order  by deptno -- 부서번호로 정렬
;

select *
from emp
order by deptno
;


-- 직급별
-- group by 대상 : job

--select count(distinct job) from emp;
select distinct job -- 중복을 제외한 직급 : 5개
from emp
;
-- 그룹핑이 5개가 된다. 

select job as "직급", count(*) as "직급별 인원"
from emp
group by job
order by job
;

-- '부서별'로 그룹핑 : group by deptno
-- 부서별 사원수와 커미션을 받는 부서별 사원들의 수를 계산해서 출력
-- null값은 계산의 대상이 되지 않는다.
select deptno as "부서 번호", count(*) as "부서별 인원",  count(comm) as "커미션을 받는 인원" 
from emp
group by deptno
order by deptno -- 부서별 정렬 (기본 오름차순)
;


-- (select 절에 조건을 사용하여 결과를 제한할때는 where절 사용)

-- having 절 : 그룹핑 group by 활용 후, 그룹의 결과를 제한할때 사용
-- group by의 그룹함수의 결과를 비교시에는 having절을 이용한다. 

-- select
-- from
--where
-- group by 
-- having 그룹함수 연산자 값 (=, !=, >, <, >=, <= 비교연산자 모두 가능)
-- ** 순서 중요 **

-- 부서별로 그룹지은 후(GROUP BY),
-- 그룹 지어진 부서별 평균 급여가 2000 이상인(HAVING)
-- 부서번호와 부서별 평균 급여를 출력
select deptno as "부서 번호", avg(sal) as "부서별 평균 급여"
from emp
group by deptno
having avg(sal) >= 2000
;


-- 부서의 급여 최대값과 최소값을 구하되
-- 최대 급여가 2900이상인 부서만 출력합니다.
select deptno as  "부서 번호", max(sal) as "부서별 급여 최대값", min(sal) as "부서별 급여 최소값"
from emp
group by deptno
having max(sal) > 2900
order by deptno
;