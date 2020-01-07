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
    id              BIGINT NOT NULL PRIMARY KEY,
    dish            VARCHAR(255),
    price           INTEGER NOT NULL,
    date            DATE NOT NULL,
    restaurant_id   INTEGER NOT NULL,
    FOREIGN KEY (restaurant_id) REFERENCES RESTAURANTS (id) ON DELETE CASCADE
);
CREATE UNIQUE INDEX IF NOT EXISTS menus_unique_date_idx
    ON MENUS (date);

CREATE TABLE IF NOT EXISTS votes
(
    id              BIGINT NOT NULL PRIMARY KEY,
    date            DATE NOT NULL,
    user_id         INTEGER NOT NULL,
    restaurant_id   INTEGER NOT NULL,
    FOREIGN KEY (restaurant_id) REFERENCES RESTAURANTS (id) ON DELETE CASCADE,
    FOREIGN KEY (user_id) REFERENCES USERS (id) ON DELETE CASCADE
);
CREATE UNIQUE INDEX IF NOT EXISTS votes_unique_date_idx
    ON VOTES (date);