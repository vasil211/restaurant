drop database if exists restaurant;
create database restaurant;
use restaurant;

CREATE TABLE tables (
    id INT AUTO_INCREMENT PRIMARY KEY,
    chairCount INT NOT NULL
);

CREATE TABLE orderState (
    id INT AUTO_INCREMENT PRIMARY KEY,
    state VARCHAR(50) NOT NULL
);

CREATE TABLE role (
    id INT AUTO_INCREMENT PRIMARY KEY,
    roleName VARCHAR(20) NOT NULL
);



CREATE TABLE menu (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) UNIQUE NOT NULL,
    foodType VARCHAR(250) NOT NULL,
    description VARCHAR(250),
    price DOUBLE NOT NULL
);

CREATE TABLE user (
    id INT AUTO_INCREMENT PRIMARY KEY,
    role_id INT DEFAULT 01,
    uname VARCHAR(50) NOT NULL,
    password VARCHAR(100) NOT NULL,
    firstName VARCHAR(50) NOT NULL,
    lastName VARCHAR(50) NOT NULL,
    phone INT UNIQUE,
    EGN INT NOT NULL UNIQUE,
    email VARCHAR(50) NOT NULL UNIQUE,
    registration DATETIME DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT FOREIGN KEY (role_id)
        REFERENCES role (id)
);

CREATE TABLE orders (
    id INT AUTO_INCREMENT PRIMARY KEY,
    table_id INT NOT NULL,
    timeOfOrder TIME NOT NULL,
    timeOfCook Time null,
    timeOfPaymet Time null,
    date DATE NOT NULL,
    user_id INT NOT NULL,
    orderState_id INT NOT NULL,
    CONSTRAINT FOREIGN KEY (user_id)
        REFERENCES user (id),
    CONSTRAINT FOREIGN KEY (orderState_id)
        REFERENCES orderState (id),
    CONSTRAINT FOREIGN KEY (table_id)
        REFERENCES tables (id)
);

CREATE TABLE menu_orders (
    menu_id INT NOT NULL,
    orders_id INT NOT NULL,
    PRIMARY KEY (menu_id , orders_id),
    CONSTRAINT FOREIGN KEY (menu_id)
        REFERENCES menu (id),
    CONSTRAINT FOREIGN KEY (orders_id)
        REFERENCES orders (id)
);


insert into role(id,roleName)
values(01,'admin');

insert into role(id,roleName)
values(02,'user');

insert into role(id,roleName)
values(03,'cook');

insert into role(id,roleName)
values(04,'waiter');

insert into orderstate(id,state)
values(01,'onQueue');

insert into orderstate(id,state)
values(02,'readyToGo');

insert into orderstate(id,state)
values(03,'finished');

insert into tables(id,chairCount)
values(01,4);

insert into tables(id,chairCount)
values(02,5);

insert into tables(id,chairCount)
values(03,4);

insert into user(role_id,uname,firstName,lastName,phone,EGN,email,password)
values(01,'admin','stoqn','petkov','08545296','025585234','asdfd@abv.bg','21232f297a57a5a743894a0e4a801fc3');

insert into user(role_id,uname,firstName,lastName,phone,EGN,email,password)
values(02,'user','stoqn','stoyanov','0854324296','034893558','asddddd@abv.bg','ee11cbb19052e40b07aac0ca060c23ee');

insert into user(role_id,uname,firstName,lastName,phone,EGN,email,password)
values(03,'cook','stoqn','stoyanov','0854342936','034355585','asdddad@abv.bg','e3e90fd6d2a7c4661a1a3acf2f60bc6d');

insert into user(role_id,uname,firstName,lastName,phone,EGN,email,password)
values(04,'waiter','stoqn','stoyanov','0854234296','03435385','asdnd@abv.bg','f64cff138020a2060a9817272f563b3c');
