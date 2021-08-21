create table community
(
    id             bigint       not null auto_increment,
    community_name varchar(255) not null,
    primary key (id)
) engine = InnoDB;
create table parking_space
(
    id           bigint not null auto_increment,
    community_id bigint,
    primary key (id)
) engine = InnoDB;
create table user
(
    id                         bigint       not null auto_increment,
    is_account_non_expired     bit          not null,
    is_account_non_locked      bit          not null,
    is_credentials_non_expired bit          not null,
    is_enabled                 bit          not null,
    password                   varchar(255) not null,
    user_name                  varchar(255) not null,
    primary key (id)
) engine = InnoDB;
create table user_community_list
(
    user_list_id      bigint not null,
    community_list_id bigint not null
) engine = InnoDB;
create table user_user_roles
(
    user_list_id  bigint not null,
    user_roles_id bigint not null
) engine = InnoDB;
create table user_parking_space
(
    id               bigint      not null auto_increment,
    end              datetime(6),
    start            datetime(6) not null,
    parking_space_id bigint,
    user_id          bigint,
    primary key (id)
) engine = InnoDB;
create table user_role
(
    id   bigint       not null auto_increment,
    name varchar(255) not null,
    primary key (id)
) engine = InnoDB;
alter table user
    drop index if exists UK_lqjrcobrh9jc8wpcar64q1bfh;
alter table user
    add constraint UK_lqjrcobrh9jc8wpcar64q1bfh unique (user_name);
alter table parking_space
    add constraint FKmkb68uf2wsgh0sofb6ux5oof3 foreign key (community_id) references community (id);
alter table user_community_list
    add constraint FKjaf72a6cqil9j5qqwhwu9twb5 foreign key (community_list_id) references community (id);
alter table user_community_list
    add constraint FKb2odx6thr0g92toooamkf96ig foreign key (user_list_id) references user (id);
alter table user_user_roles
    add constraint FK60vm96njnava0xkygkeuekglu foreign key (user_roles_id) references user_role (id);
alter table user_user_roles
    add constraint FKco9xgdhneam90a0wpgdqka3es foreign key (user_list_id) references user (id);
alter table user_parking_space
    add constraint FK5sg37nwe1y75qphnaxm3djsc2 foreign key (parking_space_id) references parking_space (id);
alter table user_parking_space
    add constraint FKlsdrnxl5c75k8mg3odj44wavy foreign key (user_id) references user (id);
