create table if not exists comments(
commentid serial primary key,
	comment varchar(1000),
	likes int,
	dislikes int,
	postid int,
	userid int,
	Foreign key(postid) references posts(postid),
	foreign key(userid) references users(id)
)