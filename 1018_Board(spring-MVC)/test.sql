select * from all_tables;
select * from board2;
select * from client;

-- ------------------------------------------------------------------------
create table board2(
	id int primary key,
	title varchar(30),
	writer varchar(15),
	content varchar(100),
	wdate date default sysdate
);

create table client(
	id varchar(15) primary key,
	password varchar(15),
	name varchar(15)
);
-- ------------------------------------------------------------------------

INSERT INTO BOARD2 (ID,TITLE,WRITER,CONTENT) VALUES(1,'Á¦¸ñ','±è¾¾','±Û ³»¿ë');


drop table client;
drop table board2;