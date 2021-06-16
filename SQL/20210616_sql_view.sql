-- 2021.06.16 (WED)
-- SQL VIEW


-- 자주 사용되는
-- 30번 부서에 소속된 사원들의 사번과 이름과 부서번호를 출력하기 위한
-- SELECT문을 하나의 뷰로 정의해봅시다. 

create or replace view emp_view30
as
select empno, ename, deptno
from emp
where deptno = 30
;

select * from emp_view30; --서브쿼리를 view로 만들어 출력 가능

select * from emp_view30
where ename = 'JAMES'
;

-- view 삭제
drop view emp_view30;

-- 인라인 뷰를 이용한 입사일 TOP3 구하기
select rownum, ename -- 입력된 순서
from emp
order by hiredate
;

select rownum, ename
from (select * from emp order by ename)
;

-- 입사일이 빠른 사람 5명만 (TOP-N)을 얻어오기
select rownum, ename, hiredate
from (select * from emp order by hiredate)
where rownum < 6 ;
-- rownum이 6보다 작으면 TOP5 추출 가능

select rownum, ename, hiredate
from (select * from emp order by hiredate desc);


-- view를 활용하여 입사일이 빠른 사람 5명 얻어오기
-- CREATE
create or replace view view_HIRE
as
select * from emp order by hiredate;

select rownum, ename, hiredate from view_HIRE;

-- SELECT
select rownum, ename, hiredate
from view_HIRE
where rownum < 6
;