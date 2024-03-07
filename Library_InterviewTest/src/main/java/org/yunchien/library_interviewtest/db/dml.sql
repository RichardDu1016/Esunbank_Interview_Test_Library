-- user 假資料
INSERT INTO user (phone_number, password, user_name, registration_time, last_login_time)
VALUES
    ('12345678901', '482c811da5d5b4bc6d497ffa98491e38', 'John Doe', '2023-03-01 08:00:00', '2023-03-05 12:00:00'),
    ('12345678902', '96b33694c4bb7dbd07391e0be54745fb', 'Jane Smith', '2023-03-02 09:30:00', '2023-03-06 14:30:00'),
    ('12345678903', '7d347cf0ee68174a3588f6cba31b8a67', 'Mike Brown', '2023-03-03 10:00:00', '2023-03-07 16:00:00'),
    ('12345678904', '24f33bb76676b3b694a8adae2bcfc81c', 'Lisa White', '2023-03-04 11:00:00', '2023-03-08 18:00:00'),
    ('12345678905', '31698d2b66690d88ea5e10db4463a325', 'James Green', '2023-03-05 12:00:00', NULL);



-- book 假資料
INSERT INTO book (isbn, name, author, introduction) VALUES
                                                        ('9783161484100', 'The Secret Garden', 'Frances Hodgson Burnett', 'The Secret Garden is a novel'),
                                                        ('9780141439563', 'Jane Eyre', 'Charlotte Brontë', 'Jane Eyre is a novel by English'),
                                                        ('9780679723165', 'Slaughterhouse-Five', 'Kurt Vonnegut', 'Slaughterhouse-Five, or The'),
                                                        ('9781853260275', 'Wuthering Heights', 'Emily Brontë', 'Wuthering Heights is a novel'),
                                                        ('9780743273565', 'To Kill a Mockingbird', 'Harper Lee', 'To Kill a Mockingbird is a novel'),
                                                        ('9780451524935', '1984', 'George Orwell', '1984 is a dystopian novel'),
                                                        ('9780061120084', 'The Catcher in the Rye', 'J.D. Salinger', 'The Catcher in the Rye is a novel'),
                                                        ('9780679600851', 'The Great Gatsby', 'F. Scott Fitzgerald', 'The Great Gatsby is a novel'),
                                                        ('9780679415606', 'Brave New World', 'Aldous Huxley', 'Brave New World is a dystopian novel'),
                                                        ('9781594480003', 'The Road', 'Cormac McCarthy', 'The Road is a post-apocalyptic novel');

-- inventory 假資料
INSERT INTO inventory (isbn, store_time, status) VALUES
                                                     ('9783161484100', NOW(), 'available'),
                                                     ('9780141439563', NOW(), 'available'),
                                                     ('9780679723165', NOW(), 'available'),
                                                     ('9781853260275', NOW(), 'available'),
                                                     ('9780743273565', NOW(), 'available'),
                                                     ('9780451524935', NOW(), 'available'),
                                                     ('9780061120084', NOW(), 'available'),
                                                     ('9780679600851', NOW(), 'available'),
                                                     ('9780679415606', NOW(), 'available'),
                                                     ('9781594480003', NOW(), 'available');
