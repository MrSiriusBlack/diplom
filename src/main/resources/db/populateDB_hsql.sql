INSERT INTO users (id, name, email, password) VALUES
(1, 'Chip', 'chip@asd.ru', 'user'),
(2, 'Dale', 'dale@asd.ru', 'user'),
(3, 'Shrek', 'shrek@asd.ru', 'admin');

INSERT INTO user_roles (role, user_id) VALUES
('ROLE_USER', 1),
('ROLE_USER', 2),
('ROLE_ADMIN', 3),
('ROLE_USER', 3);

INSERT INTO restaurants (id, name) VALUES
(1, 'Высокий дуб'),
(2, 'Нора Кролика');