create table users (
    id bigint,
    username varchar(150) not null,
    password varchar(150) not null,
    email varchar(150) not null,
    created_at timestamp not null,
    primary key (id)
);

create sequence user_sequence as integer increment 1;


create table rol (
    id integer,
    name varchar(100) not null,
    primary key (id)

);
create sequence rol_sequence as integer increment 1;

create table user_detail (
    id bigint,
    first_name varchar(100) not null,
    last_name varchar(100) not null,
    age integer,
    birth_day date,
    user_id bigint unique,
    primary key (id)
);
create sequence user_detail_sequence as integer increment 1;


create table user_rol (
    id integer,
    active boolean not null,
    created_at timestamp not null,
    user_id bigint,
    rol_id integer,
    primary key (id)
);
create sequence user_rol_sequence as integer increment 1;


alter table user_rol add constraint user_rol_user_id_fk foreign key (user_id) references "users" (id)
    on delete restrict on update restrict;

alter table user_rol add constraint user_rol_rol_id_fk foreign key (rol_id) references rol (id)
    on delete restrict on update restrict;

alter table user_detail add constraint user_detail_user_id_fk foreign key (user_id) references "users" (id);

