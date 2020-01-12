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

INSERT INTO menus (id, dish, price, menu_date, restaurant_id) VALUES
(1, 'Яичница с колбасками', 21000, '2020-01-12', 1),
(2, 'Свекла с сыром', 19000, '2020-01-12', 1),
(3, 'Ростбиф', 35000, '2020-01-12', 2),
(4, 'Цезарь с креветками', 32000, '2020-01-12', 2),
(5, 'Лосось слабосоленый', 39000, '2020-01-12', 3),
(6, 'Авокадо с помидорами', 23000, '2020-01-12', 3),
(7, 'Брускетта с беконом', 27000, '2020-01-13', 1),
(8, 'Овощи с сыром фета', 19000, '2020-01-13', 1),
(9, 'Яичница с языком', 25000, '2020-01-13', 2),
(10, 'Цезарь с курицей', 23000, '2020-01-13', 2),
(11, 'Стейк на косточке', 29000, '2020-01-13', 3),
(12, 'Руккола с языком', 29000, '2020-01-13', 3);

ALTER SEQUENCE menu_id_seq RESTART WITH 13;

INSERT INTO votes (ID, VOTE_DATE, USER_ID, RESTAURANT_ID) VALUES
(1, '2020-01-12', 1, 3),
(2, '2020-01-12', 2, 3),
(3, '2020-01-12', 3, 1),
(4, '2020-01-13', 1, 2),
(5, '2020-01-13', 3, 3);

ALTER SEQUENCE vote_id_seq RESTART WITH 6;