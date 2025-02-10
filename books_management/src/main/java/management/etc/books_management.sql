drop database if exists books_management;
create database books_management;
use books_management;

# 테이블 생성
create table books(
	# 책번호(자동)
    id int unsigned auto_increment,
    # 출판사
    publisher varchar(30) not null,
    # 도서명
    name varchar(30) not null,
    # 저자
    author varchar(15) not null,
    # 생성일
    cdate datetime default now(),
    # 수정일
    udate datetime default now(),
    # PK
    constraint primary key(id)
);

# 샘플데이터 추가
insert into books(publisher, name, author) values ('창비', '소년이 온다', '한강');
insert into books(publisher, name, author) values ('포레스트북스', '초역 부처의 말', '코이케 류노스케');
insert into books(publisher, name, author) values ('창비', '채식주의자', '한강');
insert into books(publisher, name, author) values ('문학동네', '작별하지 않는다', '한강');
insert into books(publisher, name, author) values ('쓰다', '모순', '양귀자');

select * from books;