
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

-- adding web user--
insert into web_user values(default, 'Amanda', 'Gonzalez', 'amandue10@gmail.com', 'password', false);

insert into web_user values(default, 'Henry', 'Lionela', 'wherever@yahoo.com', 'password', false);

insert into web_user values(default, 'Jessica', 'Green', 'boonesfarm@gmail.com', 'password', false);

insert into web_user values(default, 'Elyse', 'Barnes', 'wakamole@yahoo.com', 'password', false);

insert into web_user values(default, 'Lauren', 'Jones', 'hellowworld@aol.com', 'password', true);

insert into web_user values(default, 'Jennifer', 'Hussane', 'whatever@mega.com', 'password', true);

-- adding contact request--
insert into contact_us values(default, false, 'yayasisterhood@yahoo.com', 'Jennifer Jones', 'I am having...' );

insert into contact_us values(default, false, 'sunkist@yahoo.com', 'Sally Fields', 'I am having...' );

insert into contact_us values(default, false, "prettywoman12@aol.com", 'Julia Roberts', 'I am having...' );

insert into contact_us values(default, false, "timegoeson@yahoo.com", "Robert Deniro", 'I am having...' );

--adding media--

insert into media values(default, 'Test Media', 'Test','Testing test delete.', 'Game', 'Action',false, 4);

insert into media values(default, 'Test Media', 'Test','Testing test delete.', 'Book', 'Action',false, 4);

insert into media values(default, 'Test Media', 'Test','Testing test delete.', 'Movie', 'Action',false, 4);

-- adding review to media
insert into review(default , null, 'now', 30, 1, 5,'test');

insert into review(default , null, 'now', 30, 1, 5,'test');

insert into review(default , null, 'now', 30, 1, 5,'test');










