-- 2021.06.11 (FRI)

-- JOIN

-- CROSS JOIN
-- 스키마의 합 ; 집합의 곱 연산과 같다.
-- 외래키와 참조하고 있는 기본키의 값을 비교연산하여 처리한다.
-- 조인 결과가 의미를 가지려면 조건을 반드시 설정해야 한다.
select  * 
from emp, dept
where emp.deptno = dept.deptno
;


-- 출력해야 하는 컬럼을 가지는 테이블을 확인해보자.
-- 이름 : emp, 부서명 : dept
-- 몇개의 테이블을 조인하냐에 따라 조건의 개수가 달라진다.
select e.ename, d.dname
from emp e, dept d -- 간단하게 축약 가능
where e.deptno = d.deptno 
-- e테이블의 deptno, d테이블의 deptno
-- 이름이 SCOTT인 사람의 where e.ename = 'SCOTT'
-- e.ename에서 'e' 생략 가능 (겹치는 컬럼이 없기 때문)
order by d.dname, e.ename -- 부서가 같을 경우 이름 알파벳 순서대로 정렬
;