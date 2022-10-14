create table user(
    id bigint not null auto_increment primary key,
    username varchar(100) not null
);

create table address(
    id bigint auto_increment primary key,
    user_id bigint not null,
    street varchar(2000) null,
    zip_code varchar(6) null,
    city varchar(2000) null
);

alter table address
    add constraint address_user_id
    foreign key (user_id) references user(id)