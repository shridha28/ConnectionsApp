Create Table IF NOT EXISTS Roles(
   id BIGINT PRIMARY KEY,
   rolename VARCHAR(50) NOT NULL,
   creation_date DATE,
   modified_date DATE
);


insert into Roles (id,rolename,creation_date,modified_date)
values(1000,'ADMIN',SYSDATE,SYSDATE);

insert into Roles (id,rolename,creation_date,modified_date)
values (1001,'USER',SYSDATE,SYSDATE);

CREATE TABLE if not exists  customers ( 
   id BIGINT auto_increment PRIMARY KEY, 
   password VARCHAR(100) NOT NULL,
   emailid VARCHAR(50) NOT NULL,
   role_id BIGINT, 
   creation_date DATE,
   modified_date DATE
);


 ALTER TABLE customers
    ADD FOREIGN KEY (role_id) 
    REFERENCES Roles(id);

    

CREATE TABLE if not exists States (  
   stateID VARCHAR(50) PRIMARY KEY,
   state_name VARCHAR(100) NOT NULL,
   creation_date DATE,
   modified_date DATE
);

insert into States  (stateID,state_name,creation_date,modified_date)
values ('KA','KARNATAKA',SYSDATE,SYSDATE);

insert into States (stateID,state_name,creation_date,modified_date)
values ('MH','MAHARASHTRA',SYSDATE,SYSDATE);

insert into City (c_stateID,city_name) 
values ('KA','Bangalore');

insert into City (c_stateID,city_name) 
values ('KA','Mysore');
insert into City (c_stateID,city_name) 
values ('KA','Belgaum');
insert into City (c_stateID,city_name) 
values ('KA','Dharwad');

insert into City (c_stateID,city_name) 
values ('MH','Sangli');
insert into City (c_stateID,city_name) 
values ('MH','Bombay');

