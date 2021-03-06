-- 2021.06.14 (MON)

-- subsquery

-- 스칼라 부속 질의 : select절 이후에 사용
-- 단일 행 & 단일 열 값이 사용된다. 
select o.custid, (
        select c.name
        from customer c
        where o.custid = c.custid
        ) as name
from orders o
;


--emp 테이블만 사용해서 사원 이름, 부서이름 출력
select e.ename, (
        select  d.dname 
        from dept d
        where e.deptno = d.deptno
        ) as dname
from emp e
;


select ename, dname
from emp, dept
where emp.deptno = dept.deptno
;


-- 마당서점의
-- 고객별
-- 판매액을 출력하세요
-- (결과는 고객 이름과 고객별 판매액을 출력)
select c.custid, c.name, sum(o.saleprice)
from orders o, customer c
where o.custid = c.custid
group by c.custid, c.name
;

select * from orders;

-- 스칼라 부속질의 이용
select custid, (
        select name
        from customer c
        where o.custid = c.custid
        ) as name,
        sum(o.saleprice) as "구매액"
from orders o
group by custid
;

-- 인라인 뷰 : from절 뒤에 사용되는 부속질의, 가상 테이블 처럼 사용
-- 고객번호가 2 이하인 고객의 -> customer
-- 판매액을 출력하세요. -> orders
-- (결과는 고객이름과 고객별 판매액 출력)
select o.custid, c.name, sum(saleprice)
from (select * from customer where custid <= 2) c, orders o
where c.custid = o.custid
group by o.custid, c.name
;


-- 중첩질의 : where 절 뒤에 사용되는 부속질의
-- 비교연산자를 이용할 때는 단일행 단일열의 결과를 갖는 부속질의 사용
-- > < = != >= <=
-- 평균 급여보다
-- 더많은 급여를 받는 사원을 검색 -- 메인쿼리
select *
from emp
where sal  > (select avg(sal) from emp) --> 평균 급여
order by sal
;

--> 평균 급여
select avg(sal) from emp;


-- 부속질의가 반드시 단일 행, 단일 열을 반환해야 하며, 아닐 경우 질의를 처리할 수 없음.
-- 평균 주문금액 이하의 주문에 대해서
-- 주문번호와 금액을 보이시오. --> orders 
select *
from orders
where saleprice <= (select avg(saleprice) from orders)
order by saleprice
;

-- 평균 주문 금액
select avg(saleprice) from orders; 


-- 각 고객의 평균 주문금액보다
-- 큰 금액의 주문 내역에 대해서
-- 주문번호, 고객번호, 금액을 보이시오. --> customers, orders
select *
from orders o1
where saleprice > 
                        (select avg(saleprice) from orders o2 where o2.custid = o1.custid)
;
select avg(saleprice) from orders where custid = 3;
select avg(saleprice) from orders o2 where o2.custid = o1.custid;


-- 다중행 연산자 IN
-- 3000 이상 받는 사원이 소속된 부서와 동일한 부서에서 근무하는 사원의 리스트를 출력한다.
select distinct deptno from emp where deptno (10, 20)
from emp
where sal >= 3000
;

select * 
from emp
where deptno in (10, 20)
;


-- 대한민국에 거주하는 고객에게 판매한 도서의 총 판매액을 구하시오.
select sum(saleprice) as "도서 총 판매액"
from orders
where custid in 
                        (select custid
                        from customer
                        where address like '%대한민국%');
                        
-- 대한민국에 거주하는 고객의 고객번호
select custid from customer where address like '%대한민국%'; 


-- 3번 고객이 주문한 도서의 최고 금액보다
-- 더 비싼 도서를 구입한 주문의 주문번호와 금액을 보이시오.
select orderid, saleprice
from orders
where saleprice > ALL -- 모두 참이어야 한다.
                            (select saleprice
                            from orders
                            where custid = '3');
                            
-- 3번 고객이 주문한 도서의 금액들
select saleprice from orders where custid = '3'; 

--select MAX(saleprice)
--from orders
--where saleprice > (select max(saleprice)
--                        from orders
--                        where custid = '3');


-- 다음은 부서번호가 30번인 사원들의 급여 중
-- 가장 작은 값(950)보다 많은 급여를 받는 
-- 사원의 이름, 급여를 출력하는 예제를 작성해 봅시다.
select ename, sal
from emp
where sal > any
                (select sal
                from emp
                where deptno = 30);

-- 부서번호가 30번인 사원들의 급여
select sal from emp where deptno = 30;


-- EXISTS 연산자로
-- 대한민국에 거주하는 고객에게 판매한 도서의 총 판매액을 구하시오.
select sum(saleprice) as "TOTAL"
from orders o
where exists (
                    select *
                    from customer c
                    where c.custid = o.custid 
                    and address like '%대한민국%'
                    )
;

select * from customer c where c.custid = o.custid and address like '%대한민국%';
