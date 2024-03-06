CREATE DATABASE library;

-- user

CREATE TABLE user
(
    user_id           INT          NOT NULL PRIMARY KEY AUTO_INCREMENT,
    phone_number      VARCHAR(256) NOT NULL UNIQUE KEY,
    password          VARCHAR(256) NOT NULL,
    user_name         VARCHAR(256) NOT NULL,
    registration_time TIMESTAMP    NOT NULL,
    last_login_time   TIMESTAMP
);

-- book

CREATE TABLE book
(
    isbn              VARCHAR(256) NOT NULL PRIMARY KEY,
    name              VARCHAR(256) NOT NULL,
    author            VARCHAR(256) NOT NULL,
    introduction      LONGTEXT     NOT NULL
);


-- inventory

CREATE TABLE inventory
(
    inventory_id      INT          NOT NULL PRIMARY KEY AUTO_INCREMENT,
    isbn              VARCHAR(256) NOT NULL UNIQUE KEY,
    store_time        TIMESTAMP    NOT NULL,
    status            VARCHAR(20)  NOT NULL,

    CONSTRAINT  inventory_FOREIGN_KEY1 FOREIGN KEY (isbn) REFERENCES book(isbn)
);




-- borrowing record
CREATE TABLE borrowing_record
(
    user_id           INT          NOT NULL ,
    inventory_id      INT          NOT NULL ,
    borrowing_time    TIMESTAMP    NOT NULL ,
    return_time       TIMESTAMP    NOT NULL ,
    CONSTRAINT borrowing_record_PK PRIMARY KEY (user_id, inventory_id),
    CONSTRAINT borrowing_record_FOREIGN_KEY1 FOREIGN KEY (user_id) REFERENCES `user`(user_id),
    CONSTRAINT borrowing_record_FOREIGN_KEY2 FOREIGN KEY (inventory_id) REFERENCES inventory(inventory_id)
);


