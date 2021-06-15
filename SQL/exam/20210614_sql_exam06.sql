-- 2021.06.14 (MON)
-- exam05
-- join & sub query 

--마당서점의 고객이 요구하는 다음 질문에 대해 SQL문을 작성하시오.

--(5) 박지성이 구매한 도서의 출판사 수
--distinct : 중복 출판사 제거
select count(distinct publisher) as "구매도서 출판사 수"
from orders o, customer c, book b
where name = '박지성'
and o.custid = c.custid and o.bookid = b.bookid
;


select count (distinct publisher)
from book
where bookid in ( 
        select distinct o.bookid
        from orders o, customer c
        where o.custid = c.custid and c.name = '박지성');


--(6) 박지성이 구매한 -- customer, orders
-- 도서의 이름, 가격, 정가와 -- book
-- 판매가격의 차이 -- orders

--(1)
select name as "구매자",
        bookname as "도서명",
        saleprice as "판매가",
        (price - saleprice) as "정가-판매가격"
from book b, customer c, orders o
where c.name = '박지성'
        and c.custid = o.custid and  b.bookid = o.bookid
order by bookname;

--(2) 조인 2개 사용(고객번호)
select b.bookname, b.price, (b.price-o.saleprice)
from orders o, book b
where o.bookid = b.bookid
            and custid= (select custid
                                from customer
                                where name = '박지성')
;


--(7) 박지성이 구매하지 않은 도서의 이름
select publisher, bookname
from book
where bookid not in (select bookid from orders where custid = 
                            (select custid from customer where name = '박지성'))
order by bookname;


-- 2 마당서점의 운영자와 경영자가 요구하는 다음 질문에 대해 SQL문을 작성하시오.

-- (8) 주문하지 않은 고객의 이름 (부속질의 사용)
select name as "미주문자"
from customer
where custid not in
                (select distinct custid
                from orders)
;

select *
from orders o, customer c
where o.custid(+) = c.custid
and o.orderid is null
;


--select distinct custid
--from orders
--order by custid
--;

--(9) 주문금액의 총액과 주문의 평균 금액
select sum(saleprice) as "주문금액의 총액", avg(saleprice) as "주문 평균 금액"
from orders
;


--(10) 고객의 이름과 고객별 구매액 -- customer, order
select c.name, sum(o.saleprice) as "주문금액의 총액"
from customer c, orders o
where o.custid = c.custid
group by c.name
;
​

--(11) 고객의 이름과 - customer
--고객이 구매한 도서 목록 - book, orders
select c.name, b.bookname
from customer c, orders o, book b
where o.custid = c.custid and o.bookid = b.bookid
order by c.name
;


--(12) 도서의 가격(Book 테이블)과 판매가격(Orders 테이블)의 차이가 가장 많은 주문
select o.orderid as "주문번호", (b.price - o.saleprice) as "정가-판매가격"
from book b, orders o
where b.bookid = o.bookid
and (b.price - o.saleprice) =
                                    (select MAX (price - saleprice)
                                    from book natural join orders);
                            

--(13) 도서의 판매액 평균보다 -- avg(saleprice) / orders
-- 자신의 구매액 평균이 더 높은 고객의 이름 -- avg(saleprice) group by name / customer

--1. 도서의 판매 평균을 먼저 구한다. (서브쿼리)
select avg(saleprice) from orders.

--2. 고객의 구매 평균을 구한다. (고객별 : group by)
--고객의 구매평균을 having절에서 비교한다.
select name
from orders natural join customer
--from orders o, customer c
--where o.custid = c.custid
having avg(saleprice) > (select avg(saleprice) from orders)
group by name
;


--3. 마당서점에서 다음의 심화된 질문에 대해 SQL 문을 작성하시오.

--(1) 박지성이 구매한 도서의 출판사와 같은 출판사에서 도서를 구매한 고객의 이름
select name as "고객 이름"
from book natural join customer natural join orders
where publisher in (select publisher
                            from book natural join customer natural join orders
                            where name = '박지성')
and name != '박지성'
;


--(2) 두 개 이상의 서로 다른 출판사에서 -- book / distinct 사용(중복 제거) 
--도서를 구매한 고객의 이름 -- orders, customer
select name as "고객 이름",  count(distinct publisher) as "구매 출판사 수"
from book natural join customer natural join orders
group by name
having count(distinct publisher) >= 2
;



​