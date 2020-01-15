INSERT INTO users (id, name, email, password) VALUES
(1, 'Chip', 'chip@asd.ru', '{bcrypt}$2a$10$EblZqNptyYvcLm/VwDCVAuBjzZOI7khzdyGPBr08PpIi0na624b8.'),
(2, 'Dale', 'dale@asd.ru', '{noop}user'),
(3, 'Shrek', 'shrek@asd.ru', '{noop}admin');

ALTER SEQUENCE user_id_seq RESTART WITH 4;

INSERT INTO user_roles (role, user_id) VALUES
('ROLE_USER', 1),
('ROLE_USER', 2),
('ROLE_ADMIN', 3);

INSERT INTO restaurants (id, name) VALUES
(1, 'Высокий дуб'),
(2, 'Нора Кролика'),
(3, 'У Винни');

ALTER SEQUENCE restaurant_id_seq RESTART WITH 4;

INSERT INTO menus (id, menu_date, restaurant_id) VALUES
(1, '2020-01-12', 1),
(2, '2020-01-12', 2),
(3, '2020-01-12', 3),
(4, '2020-01-13', 1),
(5, '2020-01-13', 2),
(6, '2020-01-13', 3);

ALTER SEQUENCE menu_id_seq RESTART WITH 7;

insert into DISHES (MENU_ID, DISH, PRICE) VALUES
(1, 'Яичница с колбасками', 210.00),
(1, 'Свекла с сыром', 190.00),
(2, 'Ростбиф', 350.00),
(2, 'Цезарь с креветками', 320.00),
(3, 'Лосось слабосоленый', 390.00),
(3, 'Авокадо с помидорами', 230.00),
(4, 'Брускетта с беконом', 270.00),
(4, 'Овощи с сыром фета', 190.00),
(5, 'Яичница с языком', 250.00),
(5, 'Цезарь с курицей', 230.00),
(6, 'Стейк на косточке', 290.00),
(6, 'Руккола с языком', 290.00);

INSERT INTO votes (ID, VOTE_DATE, USER_ID, RESTAURANT_ID) VALUES
(1, '2020-01-12', 1, 3),
(2, '2020-01-12', 2, 3),
(3, '2020-01-12', 3, 1),
(4, '2020-01-13', 1, 2),
(5, '2020-01-13', 3, 3);

ALTER SEQUENCE vote_id_seq RESTART WITH 6;