	insert into Roles (role_id,rolename,creation_date,modified_date)
values(1000,'ADMIN',curdate(),curdate());

insert into Roles (role_id,rolename,creation_date,modified_date)
values (1001,'USER',curdate(),curdate());


insert into States  (stateID,state_name,creation_date,modified_date)
values ('KA','KARNATAKA',curdate(),curdate());

insert into States (stateID,state_name,creation_date,modified_date)
values ('MH','MAHARASHTRA',curdate(),curdate());

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