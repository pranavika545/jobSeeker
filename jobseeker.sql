drop database if exists jobseeker;
create database if not exists jobseeker;
use jobseeker;

create table users
( firstName varchar(30) not null,
	lastName varchar(30) not null,
    email varchar(40) not null unique,
    pass varchar(40) not null,
    role varchar(10) not null,
    
    primary key (email)
    );
    insert into users values('sam','keating','sam.keating@gmail.com','pass','Admin');
    insert into users values ('jane', 'doe', 'jane.doe@gmail.com', 'pass', 'SEEKER');
    insert into users values ('wes', 'gibs', 'wes.gibsson@gmail.com', 'pass', 'SEEKER');
    
    update users set firstName = 'Johnny', lastName = 'Dawson' where email = 'john.doe@gmail.com';
    
    delete from users where email = 'wes.gibsson@gmail.com';
    select * from users;