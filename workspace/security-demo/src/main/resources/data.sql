insert into users (username, password, enabled) values ('jack', '$2a$12$Mhs4J4tHTmBjj5SAaq2NTuhHc.y.9S49RkUHZUP0.hSCQc9IQnSh6', 1);
insert into users (username, password, enabled) values ('jane', '$2a$12$McH1HLCndTSoyi3M1OTpTOt2TSXyeu3PCjpbXX4yS7XHjGjWW0A8K', 1);

insert into authorities(username, authority) values('jack', 'ROLE_USER');
insert into authorities(username, authority) values('jane', 'ROLE_USER');
insert into authorities(username, authority) values('jane', 'ROLE_ADMIN');