insert into user
(is_account_non_expired, is_account_non_locked, is_credentials_non_expired,
 is_enabled, password, user_name) values
    (true,true,true,true,'$2a$10$C0bZqToX871/NKTLB5BoEOelAhDFHCaL6XsSlvWiBjK8wbwHkFiD2','admin');

insert into user_role(name) value ('admin');



insert into user_user_roles(user_list_id, user_roles_id)
    value (1, 1)

