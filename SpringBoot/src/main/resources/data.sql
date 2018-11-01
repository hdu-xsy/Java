insert into sys_user (id,username,password) value (1,"xsy","xsy");;
insert into sys_user (id,username,password) value (2,"springboot","springboot");

insert into sys_role (id,name) values (1,'ROLE_ADMIN');
insert into sys_role (id,name) values (2,'ROLE_USER');

insert into sys_user_roles(SYS_USER_ID,ROLES_ID) values (1,1);
insert into sys_user_roles(SYS_USER_ID,ROLES_ID) values (2,2);

