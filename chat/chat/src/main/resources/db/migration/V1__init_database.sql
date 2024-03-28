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


insert into roles (name) values
                             ('EDITOR'),
                             ('ADMIN'),
                             ('READER'),
                             ('AUTHOR');

insert into users (username, password, email) values
                                                  ('A1', '77de38e4b50e618a0ebb95db61e2f42697391659d82c064a5f81b9f48d85ccd5', 'test1@soap.com'),
                                                  ('A2', '77de38e4b50e618a0ebb95db61e2f42697391659d82c064a5f81b9f48d85ccd5', 'test2@soap.com'),
                                                  ('A3', '77de38e4b50e618a0ebb95db61e2f42697391659d82c064a5f81b9f48d85ccd5', 'test3@soap.com'),
                                                  ('A4', '77de38e4b50e618a0ebb95db61e2f42697391659d82c064a5f81b9f48d85ccd5', 'test4@soap.com');

insert into users_roles (user_id, role_id) values
                                               (1, 1), (2, 2), (3, 3), (4, 4);
