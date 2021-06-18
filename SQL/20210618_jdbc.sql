-- 2021.06.18 (FRI)

-- JDBC

select * from dept01;

insert into dept01 values (DEPT01_DEPTNO_SEQ.nextval, 'dev', 'SEOUL');

-- dept01 테이블의 deptno에 입력할 일련 번호 -> sequence
create sequence dept01_deptno_seq
start with 10
INCREMENT by 10
;
