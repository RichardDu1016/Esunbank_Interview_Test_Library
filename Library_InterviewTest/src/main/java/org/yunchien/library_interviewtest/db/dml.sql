
-- book 假資料
INSERT INTO book (isbn, name, author, introduction) VALUES
                    ("9783161484100", "The Secret Garden", "Frances Hodgson Burnett", "The Secret Garden is a novel"),
                    ("9780141439563", "Jane Eyre", "Charlotte Brontë", "Jane Eyre is a novel by English"),
                    ("9780679723165", "Slaughterhouse-Five", "Kurt Vonnegut", "Slaughterhouse-Five, or The"),
                    ("9781853260275", "Wuthering Heights", "Emily Brontë", "Wuthering Heights is a novel"),
                    ("9780743273565", "To Kill a Mockingbird", "Harper Lee", "To Kill a Mockingbird is a novel"),
                    ("9780451524935", "1984", "George Orwell", "1984 is a dystopian novel"),
                    ("9780061120084", "The Catcher in the Rye", "J.D. Salinger", "The Catcher in the Rye is a novel"),
                    ("9780679600851", "The Great Gatsby", "F. Scott Fitzgerald", "The Great Gatsby is a novel"),
                    ("9780679415606", "Brave New World", "Aldous Huxley", "Brave New World is a dystopian novel"),
                    ("9781594480003", "The Road", "Cormac McCarthy", "The Road is a post-apocalyptic novel");


-- inventory 假資料
INSERT INTO inventory (isbn, store_time, status) VALUES
                     ("9783161484100", NOW(), "available"),
                     ("9780141439563", NOW(), "available"),
                     ("9780679723165", NOW(), "available"),
                     ("9781853260275", NOW(), "available"),
                     ("9780743273565", NOW(), "available"),
                     ("9780451524935", NOW(), "available"),
                     ("9780061120084", NOW(), "available"),
                     ("9780679600851", NOW(), "available"),
                     ("9780679415606", NOW(), "available"),
                     ("9781594480003", NOW(), "available");