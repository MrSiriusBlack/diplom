CREATE TABLE IF NOT EXISTS users
(
    id               INTEGER                 NOT NULL PRIMARY KEY,
    name             VARCHAR(255)            NOT NULL,
    email            VARCHAR(255)            NOT NULL,
    password         VARCHAR(255)            NOT NULL,
    registered       TIMESTAMP DEFAULT now() NOT NULL,
    enabled          BOOLEAN DEFAULT TRUE    NOT NULL
);
CREATE UNIQUE INDEX IF NOT EXISTS users_unique_email_idx
    ON USERS (email);

CREATE TABLE IF NOT EXISTS user_roles
(
    user_id INTEGER NOT NULL,
    role    VARCHAR(255),
    CONSTRAINT user_roles_idx UNIQUE (user_id, role),
    FOREIGN KEY (user_id) REFERENCES USERS (id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS restaurants
(
    id      INTEGER NOT NULL PRIMARY KEY,
    name    VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS menus
(
    id              INTEGER NOT NULL PRIMARY KEY,
    menu_date       DATE NOT NULL,
    restaurant_id   INTEGER NOT NULL,
    FOREIGN KEY (restaurant_id) REFERENCES RESTAURANTS (id) ON DELETE CASCADE
);
CREATE INDEX IF NOT EXISTS menus_menu_date_idx
    ON MENUS (MENU_DATE);

CREATE TABLE IF NOT EXISTS dishes
(
    menu_id         INTEGER NOT NULL,
    dish            VARCHAR(255) NOT NULL ,
    price           NUMERIC NOT NULL
);
CREATE INDEX IF NOT EXISTS dishes_menu_id_idx
    ON DISHES (MENU_ID);

CREATE TABLE IF NOT EXISTS votes
(
    id              INTEGER NOT NULL PRIMARY KEY,
    vote_date       DATE NOT NULL,
    user_id         INTEGER NOT NULL,
    restaurant_id   INTEGER NOT NULL,
    FOREIGN KEY (restaurant_id) REFERENCES RESTAURANTS (id) ON DELETE CASCADE,
    FOREIGN KEY (user_id) REFERENCES USERS (id) ON DELETE CASCADE
);
CREATE UNIQUE INDEX IF NOT EXISTS votes_unique_date_user_id_idx
    ON VOTES (VOTE_DATE, USER_ID);

CREATE SEQUENCE IF NOT EXISTS vote_id_seq;
CREATE SEQUENCE IF NOT EXISTS menu_id_seq;
CREATE SEQUENCE IF NOT EXISTS user_id_seq;
CREATE SEQUENCE IF NOT EXISTS restaurant_id_seq;