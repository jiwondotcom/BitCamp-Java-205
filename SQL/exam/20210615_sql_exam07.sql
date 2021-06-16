-- 2021.06.15 (TUE)
-- exam07
-- DDL

-- PhoneBook DDL : 테이블 정의서 를 참고 해서 DDL 장성한다.
create table phoneinfo_basic (
    idx number(6) constraint pi_basic_idx_pk primary key,
    fr_name varchar2(20) not null,
    fr_phonenumber varchar2(20) not null,
    fr_email varchar2(20) ,
    fr_address varchar2(20),
    fr_regdate date default sysdate
);
create table phoneinfo_univ (
    idx number(6),
    fr_u_major varchar2(20) default 'N' not null,
    fr_u_year number(1) default 1  not null, --check (fr_u_year between 1 and 4),
    fr_ref number(6) not null,
    constraint pi_univ_idx_pk primary key (idx),
    constraint chk check (fr_u_year between 1 and 4), -- 테이블 레벨에서 check  제약 설정 
    constraint pi_univ_ref_fk foreign key (fr_ref) references phoneinfo_basic (idx)
);
-- phoneinfo_com
create table phoneinfo_com (
    idx number(6) constraint pi_com_idx_pk primary key,
    fr_c_company varchar2(20) default 'N' not null,
    fr_ref number(6) not null constraint pi_com_ref_fk references phoneinfo_basic (idx)
);
