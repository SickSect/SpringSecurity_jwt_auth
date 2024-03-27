create schema if not exists chat_schema;

create table if not exists users (
                       id                    bigserial not null primary key,
                       username              varchar(30) not null unique,
                       password              varchar(80) not null,
                       email                 varchar(50) unique
);

create table if not exists roles (
                       id                   serial not null primary key,
                       name                  varchar(50) not null
);

CREATE TABLE if not exists users_roles (
                             user_id               bigint not null,
                             role_id               int not null,
                             primary key (user_id, role_id),
                             foreign key (user_id) references users (id),
                             foreign key (role_id) references roles (id)
);
