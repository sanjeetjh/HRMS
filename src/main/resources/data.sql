insert into APP_USER(ID, PASSWORD, USERNAME) values(1, '$2a$10$emWVpGsajnCXM8ooPxe5GOwUQjk/mXzwWg8rSnrSZKqvsXPvtkY3K', 'sanjeet');
insert into USER_ROLE(APP_USER_ID, ROLE) values(1, 'ADMIN');
insert into USER_ROLE(APP_USER_ID, ROLE) values(1, 'EMP');
SELECT setval('app_user_id_seq', (SELECT MAX(id) FROM APP_USER));