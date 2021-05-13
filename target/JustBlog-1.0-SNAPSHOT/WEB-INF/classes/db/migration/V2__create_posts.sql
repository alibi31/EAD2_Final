create table if not exists posts(
postid serial primary key,
	theme varchar(250),
	body varchar(1000),
	userid int,
	foreign key(userid) references users(id)
)