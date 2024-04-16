-- create database travel_web_app
create table users (
id serial Primary Key,
first_name varchar(50) not null,
last_name varchar(50) not null,
user_name varchar(50) not null,
dob DATE not null,
email varchar(50) not null,
password varchar(50) not null,
profile_photo JSONB not null,
description varchar(500) null
);

--drop table users;
--drop table trip;
--drop table blog;
--drop table host;
--
--delete from trip;
--delete from blog;
--delete from host;
--
--drop sequence trip_id_seq;
--drop sequence host_id_seq;
--drop sequence blog_id_seq;
--drop sequence blog_id_seq;

create table trip (
id serial Primary Key,
destination_country varchar(50) not null,
destination_city varchar(50) not null,
start_date date not null,
end_date date not null,
budget money not null,
type_name varchar(50) not null,
transport_name varchar(50) not null,
description varchar(500) null,
user_id int not null,
FOREIGN KEY (user_id) references users(id) on delete cascade
);


create table blog (
id serial Primary Key,
title varchar(50) not null,
country varchar(50) not null,
city varchar(50) not null,
season_visited varchar(50) not null,
description varchar(500) null,
user_id int not null,
FOREIGN KEY (user_id) references users(id) on delete cascade
);

create table host (
id serial Primary Key,
country varchar (50) not null,
city varchar (50) not null,
available_start_date date not null,
available_end_date date not null,
house_type varchar(50) null,
user_id int not null,
FOREIGN KEY (user_id) references users(id) on delete cascade
);
