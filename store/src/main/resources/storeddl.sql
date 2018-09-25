drop database if exists store;
create database store;
use store;
create table product(id bigint primary key auto_increment, name varchar(100) not null, price bigint not null);
desc product;
