create table users (
    id bigserial primary key,
    created_at timestamp,
    updated_at timestamp,
    name varchar(100) not null,
    surname varchar(100) not null,
    email varchar(150) not null unique,
    username varchar(255) not null unique,
    password varchar(255) not null,
    role varchar(50) not null
);
