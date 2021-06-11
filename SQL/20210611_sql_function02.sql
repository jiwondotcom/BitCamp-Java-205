-- 2021.06.11

-- 그룹함수
-- 여러행을 묶어 처리하는 함수
-- sum, avg, cont, max, min

-- 사원 테이블에서
-- 1. 사원의 수
-- 2. 사원의 급여 총합
-- 3. 급여 평균
-- 4. 최대 급여
-- 5. 최소 급여
select count (*) as "사원의 수",
         sum(sal) as "급여의 총합",
         round (avg(sal), 2) as "급여 평균", -- 소수점 둘째자리까지, 셋째 자리에서 반올림 (round 함수 사용)
         max(sal) as "최대 급여",
         min(sal) as "최소 급여"
from emp
;

select sum(comm) as "커머션의 총합",
         avg(comm) as "커머션의 평균",
