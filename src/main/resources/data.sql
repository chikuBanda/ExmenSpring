truncate table users_roles;
delete from users where username = 'adminuser';
delete from roles where name = 'ADMIN';

insert into roles (name) values ('ADMIN');
insert into users (username, password, enabled) values ('adminuser', '$2y$12$2/f3s8BBfHiMBaEniK5A9OO4xMFnzzgeq2uWzt6kULElF17Wlopoy', 1);
insert into users_roles (user_id, role_id)
select u.user_id, r.role_id
from users u, roles r
where u.username = 'adminuser' and r.name = 'ADMIN' LIMIT 1;

--username: adminuser, password: TESTtest