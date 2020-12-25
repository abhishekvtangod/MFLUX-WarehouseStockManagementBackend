SET FOREIGN_KEY_CHECKS=0;

/* Creating the database */

create Schema DBMS_Project;
use DBMS_Project;Goods
/* Creating the tables */

create table Warehouse(
	Wid INT Not Null,
	is_functional TINYINT Not Null,
	company VARCHAR(45),
	address VARCHAR(150),
	
	primary key (Wid)
);

create table Employee(
	empid INT NOT NULL,
	emp_name VARCHAR(65) NOT NULL,
	emp_shift VARCHAR(1) NOT NULL,
	emp_sal INT NOT NULL,
	wid INT,
	
	foreign key (wid) references Warehouse(Wid)
);

alter table Warehouse add supervisor_id INT;
alter table Warehouse add constraint fk_supervisor foreign key (supervisor_id) references employee(empid);

create table Vehicle(
	reg_num VARCHAR(10) NOT NULL,
	model VARCHAR(15) NOT NULL,
	type VARCHAR(10),
	last_maintainence DATE,
	in_wh INT NOT NULL,
	
	primary key (reg_num),
	foreign key (in_wh) references Warehouse(Wid)
);

create table Supplier(
	supplier_id INT NOT NULL,
	supplier_name VARCHAR(45) NOT NULL UNIQUE,
	phone VARCHAR(10) NOT NULL UNIQUE,
	email VARCHAR(30) NOT NULL UNIQUE,
	
	primary key (supplier_id)
);

create table Consumer(
	consumer_id int not null,
	consumer_name varchar(45) not null unique,
	phone varchar(10) not null unique,
	email varchar(30) not null unique,
	
	primary key (consumer_id)
);

create table Category(
	category_name VARCHAR(15) not null,
	
	primary key (category_name)
);

create table Logistics(
	logistics_id INT not null,
	start_addr VARCHAR(100) not null,
	end_addr VARCHAR(100) not null,
	dispatch_datetime datetime,
	receive_datetime datetime,
	vehicle VARCHAR(10),
	
	primary key (logistics_id),
	foreign key (vehicle) references Vehicle(reg_num) 
);

create table Goods(
	goods_id INT not null,
	goods_name VARCHAR(45) not null,
	is_sensitive tinyint not null,
	storage INT,
	weight int,
	cost int,
	category VARCHAR(15),
	arrival INT,
	supplier INT,
	departure INT,
	consumer INT,
	wid int,
	bin int,
	
	primary key (goods_id),

	foreign key (category) references Category(category_name),
	foreign key (arrival) references Logistics(logistics_id),
	foreign key (departure) references Logistics(logistics_id),
	foreign key (supplier) references Supplier(supplier_id),
	foreign key (consumer) references Consumer(consumer_id),
	foreign key (wid) references Warehouse(Wid)
);


/* Insert Queries */

INSERT INTO `DBMS_Project`.`Warehouse` (`Wid`, `is_functional`, `company`, `address`) VALUES ('5', '1', 'ASDF', 'Chennai');

INSERT INTO `DBMS_Project`.`Employee` (`empid`, `emp_name`, `emp_shift`, `emp_sal`, `wid`) VALUES ('11', 'Kaustubh', 'M', '50000', '3');

INSERT INTO `DBMS_Project`.`Vehicle` (`reg_num`, `model`, `type`, `last_maintainence`, `in_wh`) VALUES ('ka16zx3201', 'Mahindra', 'van', '2020-05-06', '3');

INSERT INTO `DBMS_Project`.`Logistics` (`logistics_id`, `start_addr`, `end_addr`, `dispatch_datetime`, `receive_datetime`, `vehicle`) VALUES ('5', 'Pune', 'Banglore', '2020-12-14 14:15:00', '2020-12-16 18:00:00', 'mh18cs0027');

INSERT INTO `DBMS_Project`.`Consumer` (`consumer_id`, `consumer_name`, `phone`, `email`) VALUES ('6', 'Microsoft', '43254', 'billgates@microsoft.com');

INSERT INTO `DBMS_Project`.`Supplier` (`supplier_id`, `supplier_name`, `phone`, `email`) VALUES ('6', 'Microsoft', '43254', 'billgates@microsoft.com');

INSERT INTO `DBMS_Project`.`Goods` (`goods_id`, `goods_name`, `is_sensitive`, `weight`, `cost`, `category`, `arrival`, `supplier`, `wid`, `bin`) VALUES ('7', 'Sari', '0', '700', '200000', 'Other', '5', '6', '5', '1');

INSERT INTO `DBMS_Project`.`Category` (`category_name`) VALUES ('Other');


/* Update Queries */


UPDATE `DBMS_Project`.`Warehouse` SET `supervisor_id` = '11' WHERE (`Wid` = '5');

UPDATE `DBMS_Project`.`Goods` SET `departure` = '5', `Consumer` = '1' WHERE (`goods_id` = '1');

UPDATE `DBMS_Project`.`Consumer` SET `phone` = '15234', `email` = 'mngmnt@msrit.edu' WHERE (`consumer_id` = '1');

UPDATE `DBMS_Project`.`Supplier` SET `phone` = '52344', `email` = 'elon@tesla.com' WHERE (`supplier_id` = '3');

/* Delete Queries */

