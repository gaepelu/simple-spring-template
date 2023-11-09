create table school (
    id serial primary key,
    name varchar,
    description varchar,
    user_insert       varchar(255) NULL,
    user_update       varchar(255) NULL,
    insert_datetime   timestamptz  NULL,
    update_datetime   timestamptz  NULL
);

insert into school (name, description,user_insert,insert_datetime) values ('school a', 'school a description','admin',now());
insert into school (name, description,user_insert,insert_datetime) values ('school b', 'school b description','admin',now());
insert into school (name, description,user_insert,insert_datetime) values ('school c', 'school c description','admin',now());