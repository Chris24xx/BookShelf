
create table web_user(
user_id serial primary key,
	first_name varchar(30),
	last_name varchar(30),
	email varchar(80),
	user_password varchar(80),
	enabled_moderator boolean

);

create table media(
media_id serial primary key,
title varchar(80),
creator varchar(80),
synopsis varchar(200),
media_type varchar(100),
genre varchar(100),
status boolean,
user_id int references web_user(user_id)

);


create table review(
review_id serial primary key,
status boolean,
created_at varchar(30),
user_id int references web_user(user_id),
rating int,
user_review varchar(200),
media_id int references media(media_id) on delete cascade
);


create table contact_us(
contact_id serial primary key,
email varchar(80),
full_name varchar(80),
issue_message varchar(300),
status boolean
);









