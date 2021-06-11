-- 2021.06.10 (THU)
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



=========================================================


-- 2021.06.11 (FRI)

-- 형변환 함수
-- 날짜->문자, 숫자->문자
-- 문자->숫자, 문자->날짜
-- to_char(날짜 데이터, '패턴'), to_char(숫자, '패턴')
select sysdate, to_char(sysdate, 'YYYY.MM.DD.  HH24:MI:SS')
from dual
;

select ename, hiredate, to_char(hiredate, 'YYYY.MM.DD.')
from emp
;

select * from orders;
select orderid, orderdate, to_char(orderdate, 'YYYY.MM.DD')
from orders
;


-- 숫자 -> 문자
select to_char(123456, '0,000,000,000'), to_char(123456, 'L9,999,999,999')
from dual
;


-- 이번달 사원 급여지급내역
select empno, ename, sal, to_char(sal*1100, 'L999,999,999')
from emp
;


-- '1,000,000'  + 100000

-- 문자->숫자
-- to_number 함수 (문자열)
-- 숫자를 가지고 있는 문자열이어야 한다.
select TO_NUMBER('1,000,000', '9,999,999'),
         TO_NUMBER('1,000,000', '9,999,999') + 100000
from dual
;


-- 문자->날짜
-- to_date (문자열, 패턴)
-- 특정 사용자의 생일을 알면 오늘 날짜를 기준으로 사용자의 만나이를 뽑아낼 수 있다.
select to_date('2012.05.17', 'YYYY.MM.DD'), 
          trunc ( (sysdate-to_date('2012.05.17', 'YYYY.MM.DD')) / 365 )
from dual;


-- decode 함수 : 분기를 위해 사용, 자바의 switch-case와 유사
-- decode (컬럼, = 조건1 값, 조건1이 참일때 사용할 값
--              , 조건2 값, 조건2의 참일때 사용할 값
--              , ... )

-- emp 테이블에서 부서번호에 맞는 부서이름 출력
select  * from dept;

-- 10 ACCOUNTING
-- 20 RESEARCH
-- 30 SALES
-- 40 OPERATIONS

select ename, deptno,
        decode (deptno, 10, 'ACCOUNTING',
                                20, 'RESEARCH',
                                30, 'SALES',
                                40, 'OPERATIONS' 
                    ) AS DNAME
from emp
order by dname
;


--  8. 직급에 따라 급여를 인상하도록 하자.
-- 직급이 'ANALYST'인 사원은 5%
--           'SALESMAN'인 사원은 10%
--           'MANAGER'인 사원은 15%
--           'CLERK'인 사원은 20% 인상한다.

select ename, sal,
         decode(job, 'ANALYST', sal * 1.05,     -- 5% 인상
                    job, 'SALESMAN', sal * 1.1,    -- 10% 인상
                    job, 'MANAGER', sal * 1.15,   -- 15% 인상
                    job, 'CLERK', sal * 1.2           -- 20% 인상
                    ) as UPSAL
from emp
;

-- case 함수도 분기할 때 사용
-- case when 조건식 then이 참일때 값
-- case로 시작 END로 마감
select ename, deptno,
         case when deptno = 10 then 'ACCOUNTING'
                when deptno = 20 then 'RESEARCH'
                when deptno = 30 then 'SALES'
                when deptno = 40 then 'OPERATIONS'
        END as deptname
from emp
;


<<<<<<< HEAD

=======
>>>>>>> 414c378bb7472c55a3ee411aac1249f32f884671
