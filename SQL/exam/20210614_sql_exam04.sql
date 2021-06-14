-- 2021.06.14 (MON)
-- exam04

-- 32. EQUI 조인을 사용하여 SCOTT 사원의 부서번호와 부서 이름을 출력하시오.
select e.deptno as "부서 번호", ename as "사원 이름", dname as "부서명"
from emp e, dept d
where d.deptno = e.deptno 
         and e.ename = 'SCOTT'
;
​

-- ANSI JOIN
select e.deptno as "부서 번호", e.ename as "사원 이름", d.dname as "부서명"
from emp e inner join dept d -- inner 생략 가능
on e.deptno = d.deptno
where e.ename = 'SCOTT'
;


--33. INNER JOIN과 ON 연산자를 사용하여 사원 이름과 함께
--그 사원이 소속된 부서이름과 지역 명을 출력하시오.
select e.ename, d.dname, d.loc
from dept d inner join emp e
on d.deptno = e.deptno -- join의 조건
where e.ename = 'SCOTT' -- 행을 선택하는 조건
;


--36. 조인과 WildCARD를 사용하여
--이름에 ‘A’가 포함된 모든 사원의 이름과 부서명을 출력하시오.
select e.ename, d.dname
from emp e, dept d
where e.deptno = d.deptno and ename like '%A%'
;
​

-- ANSI JOIN
select e.ename, d.dname
from emp e join dept d
on e.deptno = d.deptno
where e.ename like '%A%'
;


--37. JOIN을 이용하여 NEW YORK에 근무하는
--모든 사원의 이름, 업무, 부서번호 및 부서명을 출력하시오.
select e.ename, e.job, e.deptno, d.dname
from emp e, dept d
where e.deptno= d.deptno
and d.loc ='NEW YORK'
;


-- ANSI JOIN
select e.ename, e.job, d.deptno, d.dname
from emp e inner join dept d
on e.deptno = d.deptno
where d.loc = 'NEW YORK'
;

​
--38. SELF JOIN을 사용하여 사원의 이름 및 사원번호, 관리자 이름을 출력하시오.
select e.ename, e.empno, m.ename as "매니저 이름"
from emp e, emp m
where e.mgr = m.empno
;
​

-- ANSI JOIN
select e.ename, e.empno, m.ename as "매니저 이름"
from emp e inner join emp m
on e.mgr = m.empno
;


--39. OUTER JOIN, SELF JOIN을 사용하여 관리자가 없는 사원을 포함하여 사원번호를 기준으로 내림차순 정렬하여 출력하시오.
select e.ename, e.empno, m.ename as "매니저 이름"
from emp e, emp m
where e.mgr = m.empno(+)
order by e.empno desc
;
​

-- ANSI JOIN
select e.ename, e.empno, m.ename as "매니저 이름"
from emp e left outer join emp m
on e.mgr = m.empno
order by empno desc
;


--40. SELF JOIN을 사용하여 지정한 사원의 이름, 부서번호,
--지정한 사원과 동일한 부서에서 근무하는 사원을 출력하시오. ( SCOTT )
select ename from emp where deptno = 20;


select e.deptno, e.deptno, s.ename
from emp e, emp s
where e.deptno = s.deptno and e.ename = 'SCOTT' 
;
​

-- ANSI JOIN
select e.deptno, e.deptno, s.ename
from emp e inner join emp s
on e.deptno = s.deptno
where e.ename = 'SCOTT' and not s.ename = 'SCOTT'
;


select * from emp;

--41. SELF JOIN을 사용하여 WARD 사원보다 늦게 입사한 사원의 이름과 입사일을 출력하시오.
select e.ename, e.hiredate
from emp e, emp w
where w.ename = 'WARD'
and e.hiredate > w.hiredate
order by e.hiredate
;
​

-- ANSI JOIN
select e.ename, e.hiredate
from emp e inner join emp w
on e.hiredate > w.hiredate
where w.ename = 'WARD'
order by e.hiredate
;


--42. SELF JOIN 을 사용하여 관리자보다 먼저 입사한 모든 사원의
--이름 및 입사일을 관리자의 이름 및 입사일과 함께 출력하시오.
select e.ename, e.hiredate, m.ename as "매니저 이름", m.hiredate as "매니저 입사일"
from emp e, emp m -- self join
where e.mgr = m.empno and e.hiredate < m.hiredate -- 매니저번호 = 사원번호
order by e.hiredate
; 


-- ANSI JOIN
select e.ename, e.hiredate, m.ename, m.hiredate
from emp e inner join emp m
on e.mgr = m. empno
where e.hiredate < m.hiredate
;


