

create table course
(
cno varchar(10) primary key,
cname varchar(20),
credit double 
);

create table student
(
sid varchar(10)  primary key,
sname varchar(20),
smajor varchar(20),
sclass varchar(30),
tcredit double,
tcreditjd double,
ocredit double,
acredit double,
egrade double,
majorpm int,
classpm int,
scode varchar(9)
);

create table sc
(
id int auto_increment primary key,
sid varchar(10),
sname varchar(20),
cno varchar(10),
cname varchar(20),
tid varchar(10),
credit double,
pscore double,
lscore double,
escore double,
scorejd double,
mc int
);

create table teacher
(
tid varchar(10) primary key,
tname varchar(20),
tcode varchar(9)
);

create table tc
(
id int auto_increment primary key,
tid varchar(10),
tname varchar(20),
cno varchar(10),
cname varchar(20),
credit double,
avscore double,
maxscore double,
minscore double,
cteachno int,
clocation varchar(30),
ctime varchar(20),
cmax int,
csel int,
sub int
);

create table user
(
id varchar(10) primary key,
name varchar(20),
code varchar(20),
kind varchar(15)
);

create table record
(mid int auto_increment primary key,
id varchar(10),
name varchar(20),
content varchar(1000),
date varchar(50)
);



insert into user(id,name,code,kind) values('1','admin','1','admin');
insert into user(id,name,code,kind) values('07001419','huanghd','123','student');
--insert into record(id,name,content,date) values('07002520','huanghd','网站课程设计','2010-12-31');
--insert into record(id,name,content,date) values('07001418','huangd','WEB SITE','2010-12-29');
--insert into course(cno,cname,credit) values('001','JAVA EE','3');
insert into tc(tid,tname,cno,cname,cteachno,ctime,cmax,csel) values('0003','郑阿奇','001','JAVA EE','2124','2010-12-2','20','3');
insert into student(sid,sname,smajor,sclass,tcredit) values('07001419','huanghd','计算机','计算机0701','185');
insert into student(sid,sname,smajor,sclass,tcredit) values('07001420','huangd','软件','计算机0702','185');