drop database if exists demo;
create database demo;
use demo;

create table Employee(
     emp_id int primary key,
      emp_name varchar(10),
      emp_num varchar(10)
       );
 INSERT INTO Employee VALUES(1,"siva","9976336");
 INSERT INTO Employee VALUES(2,"siva","6635666");
 INSERT INTO Employee VALUES(3,"amma","5544333");
INSERT INTO Employee VALUES(4,"nanna","6675443");
commit;
select * from Employee;


