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

CREATE TABLE customers ( 
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
