create table school (
    id serial primary key,
    name varchar,
    description varchar
);

insert into school (name, description) values ('school a', 'school a description');
insert into school (name, description) values ('school b', 'school b description');
insert into school (name, description) values ('school c', 'school c description');