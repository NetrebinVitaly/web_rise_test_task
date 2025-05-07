create table users
(
    id          uuid    not null,
    first_name  varchar(45),
    last_name   varchar(45),
    middle_name varchar(45),
    is_enabled  boolean not null default true,
    constraint pk_users primary key (id)
);

create table subscriptions
(
    id       uuid         not null,
    user_id  uuid         not null,
    service varchar(30),
    constraint pk_accounts primary key (id)
);

alter table subscriptions
    add constraint fk_users_subscriptions foreign key (user_id) references users (id);

