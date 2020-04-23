CREATE TABLE if not exists  customers ( 
   id BIGINT auto_increment PRIMARY KEY,
   emailid VARCHAR(50) NOT NULL, 
   password VARCHAR(100) NOT NULL,
   role_id BIGINT
);
   

CREATE TABLE if not exists States (  
   stateID VARCHAR(50) PRIMARY KEY,
   state_name VARCHAR(100) NOT NULL,
   creation_date DATE,
   modified_date DATE
);

create table if not exists city (
city_name varchar(100) not null,
c_stateid varchar(100) not null,
primary key (city_name, c_stateid));


create table if not exists roles (
role_id BIGINT,
rolename varchar(100),
creation_date DATE,
modified_date DATE,
primary key (role_id));
