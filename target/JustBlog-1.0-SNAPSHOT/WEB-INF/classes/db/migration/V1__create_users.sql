create table if not exists users(
id serial primary key,
	username varchar(100),
	password varchar(100)
)