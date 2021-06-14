-- 2021.06.11 (FRI)
-- 2021.06.14 (MON)

-- JOIN

-- CROSS JOIN
-- 스키마의 합 ; 집합의 곱 연산과 같다.
-- 외래키와 참조하고 있는 기본키의 값을 비교연산하여 처리한다.
-- 조인 결과가 의미를 가지려면 조건을 반드시 설정해야 한다.
select  * 
from emp, dept
where emp.deptno = dept.deptno
;


select * from orders;
select * from customer;
select * from book;


-- 구매내역(orders) 출력 -> 구매자 이름(customer), 책 이름(book) 함께 출력
-- custid, bookid와 함께 연결하여 붙인다.
select o.orderid, c.name, b.bookname
from orders o, customer c, book b
where o.custid = c.custid and o.bookid = b.bookid
order by o.orderid
;


-- ANSI -> inner join
-- 오라클 EQUI JOIN
select *
from emp e inner join dept d
on e.deptno = d.deptno
where e.ename = 'SCOTT'
;


-- on절을 생략하고 -> using을 이용하면 조건식을 간략하게 처리할 수 있다.
-- 단, 비교하는 컬럼의 이름이 같을때!
select *
from emp e inner join dept d
-- on e.deptno = d.deptno
using (deptno)
where e.ename = 'SCOTT'
;


-- NATURAL JOIN
select *
from emp NATURAL JOIN dept
;


-- ANSI cross join
select *
from emp cross join dept
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


-- self JOIN : 자기 자신을 조인 (참조)
-- emp -> mgr 컬럼이 emp.empno 참조
select e.empno, e.ename, e.mgr, m.ename
from emp e, emp m
where e.mgr = m.empno (+)
-- 만족하지 않는 결과가 있어 누락될 경우 : outer join(+) 하여 출력값에 포함시킨다.
;


-- outer JOIN
select e.empno, e.ename, e.mgr, m.ename
from emp e, emp m
where e.mgr = m.empno (+)
-- 표현하고자 하는 컬럼이 테이블의 반대쪽, 즉 null값을 가지는 위치에 (+)를 넣어준다.
;


-- [ left | right | full ] outer join
select e.ename, e.mgr, m.ename as "관리자"
--from emp e left outer join emp m
from emp m right outer join emp e
on e.mgr = m.empno -- 컬럼이름이 틀리기 때문에 natural join, using 사용 불가
;


select * from salgrade;


select e.ename, e.sal, s.grade, s.losal, s.hisal
from emp e, salgrade s 
--where e.sal >= s.losal and e.sal <= s.hisal
where sal between s.losal and s.hisal 
order by e.ename
;


-- 회원별 구매 내역 출력
-- 구매고객에 대한 통계정보 출력이 가능해진다.
select c.name, count(o.orderid) as "구매횟수", avg(saleprice)
from orders o, customer c
where o.custid(+) = c.custid
group by c.name
order by c.name
;



