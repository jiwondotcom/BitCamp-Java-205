-- 2021.06.14 (MON)
-- exam05


--마당서점의 고객이 요구하는 다음 질문에 대해 SQL문을 작성하시오.

--(5) 박지성이 구매한 도서의 출판사 수
select count(publisher)
from orders o, customer c, book b
where name = '박지성'
and o.custid = c.custid and o.bookid = b.bookid
;


--(6) 박지성이 구매한 -- customer, order
-- 도서의 이름, 가격, -- book
-- 정가와 판매가격의 차이 -- book, order
select o.bookid as "도서번호",
        bookname as "도서명",
        price as "정가",
        saleprice as "판매가격",
        (price - saleprice) as "정가와 판매가격 차이"
from book b, orders o, customer c
where c.name = '박지성'
        and c.custid = o.custid
        and b.bookid = o.bookid
order by b.bookid
;


select * from orders;
select * from customer;
​

--(7) 박지성이 구매하지 않은 도서의 이름
select bookname
from book b, orders o, customer c
where b.bookid = o.bookid ;


​
 
-- 2 마당서점의 운영자와 경영자가 요구하는 다음 질문에 대해 SQL문을 작성하시오.

-- (8) 주문하지 않은 고객의 이름(부속질의사용)


​

​

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
​
--(11) 고객의 이름과 - customer
--고객이 구매한 도서 목록 - book, orders
select c.name, b.bookname
from customer c, orders o, book b
where o.custid = c.custid and o.bookid = b.bookid
order by c.name
;


--(12) 도서의 가격(Book 테이블)과 판매가격(Orders 테이블)의 차이가 가장 많은 주문
select (select max (b.price - o.saleprice)
            from book b, orders o
            where b.bookid = o.bookid) as "정가와 판매가격 차이"
from book b, orders o
group by o.custid;


select b.price - o.saleprice
from book b, orders o
where b.bookid = o.bookid;

select * from book
order by bookid;
select bookid, saleprice from orders
order by bookid;
--(13) 도서의 판매액 평균보다 자신의 구매액 평균이 더 높은 고객의 이름


​

​

​

3. 마당서점에서 다음의 심화된 질문에 대해 SQL 문을 작성하시오.

(1) 박지성이 구매한 도서의 출판사와 같은 출판사에서 도서를 구매한 고객의 이름


​

​

(2) 두 개 이상의 서로 다른 출판사에서 도서를 구매한 고객의 이름


​