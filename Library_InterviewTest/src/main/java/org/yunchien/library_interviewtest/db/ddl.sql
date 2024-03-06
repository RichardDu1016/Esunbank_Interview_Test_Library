CREATE DATABASE library;

-- user

CREATE TABLE user
(
    user_id           INT          NOT NULL PRIMARY KEY AUTO_INCREMENT,
    phone_number      VARCHAR(256) NOT NULL UNIQUE KEY,
    password          VARCHAR(256) NOT NULL,
    user_name         VARCHAR(256) NOT NULL,
    registration_time TIMESTAMP    NOT NULL,
    last_login_time TIMESTAMP      NOT NULL
);

-- inventory

CREATE TABLE inventory
(
    inventory_id      INT          NOT NULL PRIMARY KEY,
    isbn              VARCHAR(256) NOT NULL UNIQUE KEY,
    store_time        TIMESTAMP    NOT NULL,
    status            VARCHAR(20) NOT NULL
);

-- book

CREATE TABLE book
(
    isbn              INT          NOT NULL PRIMARY KEY,
    name              VARCHAR(256) NOT NULL,
    author            VARCHAR(256) NOT NULL,
    introduction      LONGTEXT     NOT NULL
);


-- borrowing record
CREATE TABLE borrowing_record
(
    user_id           INT          NOT NULL PRIMARY KEY,
    inventory_id      VARCHAR(256) NOT NULL PRIMARY KEY,
    borrowing_time    TIMESTAMP    NOT NULL,
    return_time       TIMESTAMP    NOT NULL
);