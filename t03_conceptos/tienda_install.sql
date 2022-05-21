drop database tienda;

create database tienda;

use tienda;

create table productos (
  id int primary key auto_increment,
  nombre varchar(100) not null unique,
  description varchar(255) default 'Sin descripción',
  precio double not null,
  existencias int not null default 0,
  create_at timestamp not null default now(),
  update_at timestamp
);