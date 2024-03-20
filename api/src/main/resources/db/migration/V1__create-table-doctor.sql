create table doctor (

    id bigint not null auto_increment,
    name varchar(75) not null,
    email varchar(150) not null,
    document varchar(15) not null,

    primary key (id)
);