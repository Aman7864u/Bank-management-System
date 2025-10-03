create database if not exists bankmanagementsystem;
use bankmanagementsystem;

create table signup (
	formno varchar(20) primary key,
    name varchar(50),
    father_name varchar(20),
    dob varchar(20),
    gender varchar(20),
    email varchar(50),
    marital_status varchar(20),
    address varchar(50),
    city varchar(20),
    state varchar(50),
    pin varchar(20)
);


DELETE FROM signup;
TRUNCATE TABLE signup;
DROP TABLE signup;



SET SQL_SAFE_UPDATES = 0;


create table signupTwo(
	formno varchar(20),religion varchar(20),category varchar(20), incom varchar(20), education varchar(20), occcupation varchar(20),pan varchar(20), aadhar varchar(20), seniorcitizen varchar(20), existingaccount varchar(20)
);

show tables;
select * from signupTwo;
select * from signup;

create table signupthree(formno varchar(20), accountType varchar(40), cardnumber varchar(25), pin varchar(10), facility varchar(100));
select * from signupthree;
create table login(formno varchar(20), cardnumber varchar(25), pin varchar(10));
select * from login;

create table bank(pin varchar(10), date varchar(50), type varchar(20), amount varchar(100));
select * from bank;
drop table bank;


