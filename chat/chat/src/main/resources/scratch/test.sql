
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