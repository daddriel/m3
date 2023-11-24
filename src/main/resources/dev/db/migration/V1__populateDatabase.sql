insert into users (id, username, password, email, created_at) values
                                                                  (nextval('user_sequence'), 'supermichi', 'michi123', 'supermichi@gatunos.com', current_timestamp),
                                                                  (nextval('user_sequence'), 'dongato', 'dongato123', 'dongato@gatunos.com', current_timestamp);



insert into rol (id, name) values
                               (nextval('rol_sequence'), 'FelinoSoldado'),
                               (nextval('rol_sequence'), 'FelinoEmperador'),
                               (nextval('rol_sequence'), 'FelinoCiudadano');



insert into user_rol (id, active, created_at, user_id, rol_id) values
                                                                   (nextval('user_rol_sequence'), true, current_timestamp, 1, 1),
                                                                   (nextval('user_rol_sequence'), true, current_timestamp, 2, 2);




insert into user_detail (id, first_name, last_name, age, birth_day, user_id) values
                                                                                 (nextval('user_detail_sequence'), 'Mr. Michi', 'Gatuno', 5, '2018-06-12', 1),
                                                                                 (nextval('user_detail_sequence'), 'Don Gato', 'Felino', 8, '2015-01-11', 2);