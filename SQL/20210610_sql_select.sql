-- 2021.06.10

-- 특정 데이터 검색 : 행 검색 -> 컬럼 선택

-- 10번 부서의 사원리스트 출력
-- 10번 부서 -> where dept = 10 / 동등비교 사용

select *
from emp
where deptno=10
;

-- 이름이 'SCOTT'인 사원을 출력
select *
from emp
where ename='SCOTT' -- 따옴표 안의 키워드(데이터)는 대소문자를 구분해야한다.
;

-- 날짜타입의 데이터 비교시에도 작은 따옴표를 이용해야한다.
select *
from emp
where hiredate = '96/11/17'
;

-- 논리연산자 : and, or, not
-- 10번 부서의 관리자(manager)를 찾아 출력
select *
from emp
where deptno=10 and job='MANAGER'
;

-- 10번 부서의 직원들과 관리자들의 리스트를 출력
select *
from emp

-- 10번 부서의 직원을 제외한 나머지 직원들을 출력
-- 20번, 30번, 40번
select *
from emp
-- where deptno=20 or deptno=30 or deptno=40
where not deptno=10 
;

-- 범위 연산을 할때 -> 논리연산자 이용 & between a and b 연산자 이용 가능
-- between a and b : a 이상 b 이하 (미만을 하게 될 경우엔 +1)

-- 2000 이상 3000 이하의 급여를 받는 직원의 리스트를 출력해보자. (직원 이름, 급여, 직업)

-- 논리연산자 이용
select ename, sal, job
from emp
where deptno=10 or job='MANAGER'
;
-- where sal >= 2000 and sal <= 3000
-- between 연산자 이용
where sal between 2000 and 3000 -- 3000만원 미만일 경우엔 2999
;

-- between 연산자는 날짜의 연산도 가능하다.
-- 1981년에 입사한 사원들의 리스트를 출력해보자.
select *
from EMP
-- where hiredate >= '81/01/01' and hiredate <= '81/12/31'
where HIREDATE between '81/01/01' and '81/12/31'
order by HIREDATE -- 내림차순 desc
;

-- 연산자 in -> 여러개의 or 연산자 사용시 대체 할 수 있다. 
-- 커미션이 300 또는 500 또는 1400
select *
from emp
-- where comm=300 or comm=500 or comm=1400
where comm in (300, 500, 1400)
;

-- 패턴 검색 : 키워드 검색 많이 사용 (게시판)
-- 컬럼 like '%'
-- ename like 'F%' -> F로 시작하는 문자열을 검색
-- ename like '%F' -> F로 끝나는 문자열을 검색
-- ename like '%F%' -> F를 포함하는 문자열을 검색
-- 'java' 단어를 포함하는지 체크 -> title like '%java%'

-- F로 시작하는 이름을 가진 사원을 검색
select ename
from emp
where ename like 'F%'
--where ename like '%ES'
--where ename like '%S%'
--where ename like '%A%'
;

-- 자리수 패턴 : 컬럼의 값이 자리수가 정해져있고 값에 패턴이 있는 경우

select *
from emp
--where ename like '_A%' -- 이름의 두번쨰 문자에 A를 포함하는 사원의 리스트
--where ename like '__A%' -- 이름의 세번째 문자가 A인 사원의 리스트
where ename not like '__A%' -- 이름의 세번째 문자에 A가 들어가지않은 사원의 리스트
;

-- null 값을 확인하는 연산자 -> is null, is not null
-- 커미션이 등록되어 있지 않은 사원의 리스트
select *
from emp
where comm is null
order by comm
--where comm is not null -- 커미션이 등록되어 있는 사원의 리스트
;

-- 결과 행의 정렬 : order by 컬럼 [asc | desc] 
-- 대괄호 : 선택으로 쓸 수 있다.
-- asc : 오름차순 / desc : 내림차순
-- 정렬방식을 지정하지 않은 경우에는 디폴트로 오름차순으로 정렬

-- 급여가 적은 사원부터 출력 : 오름차순 -> asc
select ename, sal
from emp
order by sal asc -- 정렬의 기본은 오름차순이다.
;

-- 급여가 큰 사원부터 출력
select *
from emp
order by sal desc
;

-- 급여가 큰 사원부터 출력하되, 급여가 같은 사원들은 이름을 기준으로 오름차순으로 정렬
select *
from emp
order by sal desc, ename asc
;


