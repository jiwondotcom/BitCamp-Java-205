-- 2021.06.14 (MON)
-- exam05
-- 부속질의

--43. 사원 번호가 7788인 사원과 담당 업무가 같은 사원을 표시
--(사원 이름과 담당업무)하시오.
select ename "사원 이름", job "담당 업무"
from emp
where job in (select job from emp where empno = '7788')
;


--44. 사원번호가 7499인 사원보다 급여가 많은 사원을 표시하시오.
--사원이름과 담당 업무
select ename "사원 이름", job "담당 업무"
from emp
where sal > (select sal from emp where empno = '7499')
;
​

--45. 최소급여를 받는
--사원의
--이름, 담당업무 및 급여를 표시하시오. (그룹함수 사용)
select ename, job, sal
from emp
where sal in (select min(sal) from emp)
;
​
-- emp 테이블의 급여를 ""모두"" 비교한다 -- ALL 사용
select ename, job, sal
from emp
where sal <= ALL (select sal from emp)
;

--46. 평균 급여가 가장 적은 직급의
--직급 이름과 직급의 평균을 구하시오.
select job "직급 이름", avg(sal) "평균 직급"
from emp
group by job
having avg(sal) = (select min(avg(sal))
                        from emp 
                        group by job)
;


--47. 각 부서의 최소 급여를 받는
--사원의 이름, 급여, 부서번호를 표시하시오.
--select ename "사원 이름", sal "급여", deptno "부서 번호"
--from emp
--where sal in
--                (select min(sal)
--                from emp 
--                group by deptno)
--order by deptno;

select *
from emp e1
where sal in (select min(sal)
                from emp e2
                where e1.deptno = e2.deptno
                group by deptno)
;

--48. 담당업무가 ANALYST 인 사원보다
--급여가 적으면서
--업무가 ANALYST가 아닌 사원들을 표시
--(사원번호, 이름, 담당 업무, 급여)하시오.
select empno, ename, job, sal
from emp
where sal < ALL(select sal from emp where job = 'ANAYLST')
                and job != 'ANAYLST'
order by sal
;


--49. 부하직원이 없는 사원의 이름을 표시하시오.
--(본인이 매니저가 아님)
select ename "사원 이름"
from emp
where empno not in (select distinct mgr from emp where mgr is not null)
;


--50. 부하직원이 있는 사원의 이름을 표시하시오.
select ename "사원 이름"
from emp
where empno in (select distinct mgr from emp)
;
​

--51. BLAKE와 동일한 부서에 속한
--사원의 이름과 입사일을 표시하는 질의를 작성하시오.
--( 단 BLAKE는 제외 )
select ename, hiredate
from emp 
where deptno in (select deptno from emp where ename = 'BLAKE')
and ename != 'BLAKE'
order by ename
;
​

--52. 급여가 평균 급여보다 많은 사원들의
--사원 번호와 이름을 표시하되 결과를
--급여에 대해서 오름차순으로 정렬하시오.
select empno "사원 번호", ename "사원 이름", sal "급여"
from emp
where sal > (select avg(sal) from emp)
order by sal
;


--53. 이름에 K가 포함된 사원과
-- 같은 부서에서 일하는 사원의 사원 번호와 이름을 표시하시오.
select deptno "부서 번호", empno "사원 번호", ename "사원 이름"
from emp
where deptno in (select deptno from emp where ename like '%K%')
;

​
--54. 부서위치가 DALLAS인
--사원의 이름과 부서번호 및 담당업무를 표시하시오.

-- sub query
select ename "사원 이름", deptno "부서 번호", job "담당 업무"
from emp
where deptno = (select deptno from dept where loc = 'DALLAS')
;
​

--55. KING에게 보고하는 사원의 이름과 급여를 표시하시오.
--상관 번호를 KING 으로 두고 있는 사원

--상관 번호 KING : empno 7839
--select empno
--from emp
--where ename = 'KING';

--select ename, job
--from emp
--where mgr = '7839';

select ename, job, mgr
from emp
where mgr = (select empno from emp where ename = 'KING')
;


--56. RESEARCH 부서의 사원에 대한
--부서번호, 사원이름 및 담당 업무를 표시하시오.

--(1)
select deptno "부서 번호", ename "사원 이름", job "담당 업무"
from emp
where deptno = (select deptno
                        from dept
                        where dname = 'RESEARCH')
order by ename
;

--(2)
select d.deptno "부서 번호", e.ename "사원 이름", e.job "담당 업무"
from emp e, dept d
where e.deptno = d.deptno
         and dname = 'RESEARCH'
order by ename
;

--(3)
select deptno "부서 번호", ename "사원 이름", job "담당 업무"
from emp natural join dept
where dname = 'RESEARCH'
order by ename
;


--57. 평균 급여보다 많은 급여를 받고 
--이름에 M이 포함된 사원과 같은 부서에서 근무하는 사원의 
--사원 번호, 이름, 급여를 표시하시오.

--select avg(sal) from emp;
--평균 급여 : 2073

select empno "사원 번호", ename "사원 이름", sal "급여"
from emp
where sal > (select avg(sal)
                 from emp) 
        and deptno in (select deptno
                             from emp
                             where ename like '%M%')
order by sal
;


--58. 평균급여가 가장 적은 업무를 찾으시오.
select job "업무명", avg(sal) "평균 급여"
from emp
having avg(sal) =(select min(avg(sal))
                         from emp
                         group by job)
group by job
;​
​

--59. 담당업무가 MANAGER 인 사원이
--소속된 부서와 동일한 부서의 사원을 표시하시오.
select ename "사원 이름", job "담당 업무"
from emp
where deptno in (select deptno
                        from emp
                        where job = 'MANAGER')
order by ename
;


