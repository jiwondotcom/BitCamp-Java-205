-- 2021.06.10
-- function : 단일행 함수, 집합(다중행) 함수
-- 단일행 함수 : 하나의 행이 포함하는 특정 컬럼의 값 하나를 처리하고 반환
-- 다중행(집합) 함수 : 여러행의 특정 컬럼값들을 대상으로 연산하고 반환

-- 숫자 함수
select 'Oracle'
from dual
;

-- 절대값을 구한다.
select abs(10), abs(-10)
from dual
;

-- 소수점 밑 절산
select FLOOR(15.7)
from dual
;

-- 특정 자릿수에서 반올림한다.
select ROUND(15.193, 1), ROUND(15.193, -1)
from dual
;

-- 소수점 밑 절산 (FLOOR과 동일)
select TRUNC(15.79, 1), TRUNC(15.79)dummy
from dual
;

-- 나머지
select MOD(11, 4)
from dual
;

-- 함수는 컬럼에서만 사용한다.
select sal, MOD(sal, 4)
from emp
where mod(sal, 2) = 1
;

