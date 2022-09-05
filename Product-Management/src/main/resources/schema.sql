

create table App_Product (id int Auto_increment, name varchar(255) not null, make varchar(255)not null,model int not null,cost int not null,created_Date Date not null);
create SEQUENCE HIBERNATE_SEQUENCE START WITH 1 INCREMENT BY 1;
/*ALTER TABLE App_Product AUTO_INCREMENT = 1000;*/
/*create table App_Product (id int Auto_increment, name varchar(255) not null, make varchar(255)not null,model int not null,cost int not null,created_Date Date not null);
INSERT INTO App_Product VALUES (1, 'Laptop', 'Dell','Inspiron',30000,'2021-01-01'),
(2, 'Laptop', 'Dell','Alienware',100000,'2021-09-01'),
(3, 'Laptop', 'Asus','ROG',95000,'2022-01-01'),
(4, 'Phone', 'Apple','IPhone12',80000,'2021-05-10'),
(5, 'Phone', 'Samsung','S22',80000,'2020-02-01');*/