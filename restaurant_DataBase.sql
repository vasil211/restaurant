drop database if exists restaurant;
create database restaurant;
use restaurant;

CREATE TABLE tables (
    id INT AUTO_INCREMENT PRIMARY KEY,
    ChairCount INT NOT NULL
);

CREATE TABLE orderState (
    id INT AUTO_INCREMENT PRIMARY KEY,
    State VARCHAR(50) NOT NULL
);

CREATE TABLE roles (
    id INT AUTO_INCREMENT PRIMARY KEY,
    Roles VARCHAR(20) NOT NULL
);



CREATE TABLE menu (
    id INT AUTO_INCREMENT PRIMARY KEY,
    Name INT UNIQUE NOT NULL,
    FoodType INT NOT NULL,
    Description VARCHAR(250),
    Price INT NOT NULL
);

CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    roles_id INT DEFAULT 01,
    Uname VARCHAR(50) NOT NULL,
    Password VARCHAR(100) NOT NULL,
    FirstName VARCHAR(50) NOT NULL,
    LastName VARCHAR(50) NOT NULL,
    Phone INT UNIQUE,
    EGN INT NOT NULL UNIQUE,
    Email VARCHAR(50) NOT NULL UNIQUE,
    Registration DATETIME DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT FOREIGN KEY (roles_id)
        REFERENCES roles (id)
);

CREATE TABLE orders (
    id INT AUTO_INCREMENT PRIMARY KEY,
    Tables_id INT NOT NULL,
    Time TIME NOT NULL,
    Date DATE NOT NULL,
    user_id INT NOT NULL,
    orderState_id INT NOT NULL,
    CONSTRAINT FOREIGN KEY (user_id)
        REFERENCES users (id),
    CONSTRAINT FOREIGN KEY (orderState_id)
        REFERENCES orderState (id),
    CONSTRAINT FOREIGN KEY (tables_id)
        REFERENCES tables (id)
);

CREATE TABLE menu_orders (
    id INT AUTO_INCREMENT PRIMARY KEY,
    menu_id INT NOT NULL,
    orders_id INT NOT NULL,
    CONSTRAINT FOREIGN KEY (menu_id)
        REFERENCES menu (id),
    CONSTRAINT FOREIGN KEY (orders_id)
        REFERENCES orders (id)
);


insert into Roles(id,Roles)
values(01,'admin');

insert into Roles(id,Roles)
values(02,'user');

insert into Roles(id,Roles)
values(03,'cook');

insert into Roles(id,Roles)
values(04,'waiter');

insert into Orderstate(id,State)
values(01,'onQueue');

insert into Orderstate(id,State)
values(02,'readyToGo');

insert into Orderstate(id,State)
values(03,'finished');

insert into Tables(id,ChairCount)
values(01,4);

insert into Tables(id,ChairCount)
values(02,5);

insert into Tables(id,ChairCount)
values(03,4);

insert into users(roles_id,Uname,FirstName,LastName,Phone,EGN,Email,Password)
values(01,'admin','petko','petkov','085296','0255852','asd@abv.bg','21232f297a57a5a743894a0e4a801fc3');

insert into users(roles_id,Uname,FirstName,LastName,Phone,EGN,Email,Password)
values(02,'user','tom','stoyanov','085434296','034355852','asdddd@abv.bg','ee11cbb19052e40b07aac0ca060c23ee');
