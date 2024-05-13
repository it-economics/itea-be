CREATE TABLE PRODUCT_TYPE
(
    ID   INT AUTO_INCREMENT PRIMARY KEY,
    NAME VARCHAR(250) NOT NULL
);

CREATE TABLE PRODUCT
(
    ID              INT AUTO_INCREMENT PRIMARY KEY,
    NAME            VARCHAR(250) NOT NULL,
    IMAGE_NAME       VARCHAR(250),
    DESCRIPTION     CLOB,
    PRODUCT_TYPE_ID INT          NOT NULL,
    FOREIGN KEY (PRODUCT_TYPE_ID) REFERENCES PRODUCT_TYPE (id)
);

CREATE TABLE PART
(
    ID    INT AUTO_INCREMENT PRIMARY KEY,
    NAME  VARCHAR(250)   NOT NULL,
    PRICE DECIMAL(10, 2) NOT NULL
);

CREATE TABLE PRODUCT_PARTS
(
    PRODUCT_ID INT NOT NULL,
    PART_ID    INT NOT NULL,
    QUANTITY   INT NOT NULL,
    FOREIGN KEY (PRODUCT_ID) REFERENCES PRODUCT (id),
    FOREIGN KEY (PART_ID) REFERENCES PART (id),
    PRIMARY KEY (PRODUCT_ID, PART_ID)
);


INSERT INTO PRODUCT_TYPE (ID, NAME) VALUES
    (1,'Picture'),
    (2,'Table'),
    (3,'Chair'),
    (4,'Wardrobe'),
    (5,'Closet');


INSERT INTO PRODUCT (ID, NAME, IMAGE_NAME, PRODUCT_TYPE_ID, DESCRIPTION) VALUES
    (1, 'Picture "Finland"', 'pictureFinland.png', 1, 'The ''Picture of Finland'' is more than just a piece of art; it''s a window to a world of tranquility and wonder.\n\nWhether you''re looking to add a touch of Nordic charm to your living room, bedroom, or office, this exquisite artwork is the perfect choice. Its vibrant colors and intricate design will effortlessly complement any décor style, adding a sense of sophistication and elegance to your space.\n\nTransform your home into a sanctuary of beauty and serenity with the ''Picture of Finland'' – where every glance is a journey into the captivating landscapes of this enchanting country.'),
    (2, 'Picture "Oslo"', 'pictureOslo.png', 1, 'Introducing our newest masterpiece, a captivating portrayal of Oslo''s allure captured in every brushstroke. This exquisite picture invites you to immerse yourself in the vibrant essence of Norway''s capital city, where modernity meets timeless charm.\n\nAs a destination for premium home furnishings, we take pride in curating pieces that elevate your living space. Our Oslo-inspired picture is no exception, offering a window into the city''s dynamic streets, iconic landmarks, and picturesque waterfront.\n\nWhether adorning your living room, study, or hallway, this artwork adds a touch of cosmopolitan elegance to any room. Its rich colors and intricate details evoke a sense of wanderlust and sophistication, making it a conversation piece that ignites your imagination and sparks curiosity.\n\nElevate your home decor with the allure of Oslo – where every glance at this captivating picture is a journey through the heart of Norway''s captivating capital.'),
    (3, 'Picture "Sweden"', 'pictureSweden.png', 1, 'Introducing our newest addition, a captivating depiction of Sweden''s enchanting landscapes and vibrant culture. This exquisite picture invites you to explore the beauty and charm of this Scandinavian gem from the comfort of your home.\n\nAs purveyors of premium home furnishings, we curate pieces that inspire and elevate your living space. Our Sweden-inspired picture captures the essence of the country''s lush forests, serene lakes, and historic architecture, transporting you to a world of natural beauty and timeless elegance.\n\nWhether displayed in your living room, bedroom, or office, this artwork adds a touch of Scandinavian sophistication to any setting. Its harmonious blend of colors and intricate details creates a captivating focal point that sparks conversation and invites admiration.\n\nTransform your home into a sanctuary of Scandinavian style and tranquility with our Sweden-inspired picture – a tribute to the captivating allure of this enchanting country.'),
    (4, 'Table "Lola"', 'tableLola.png', 2, 'Meet Lola – the epitome of contemporary elegance and functional design in our furniture collection. Lola features a sleek glass tabletop delicately supported by sturdy wooden legs, combining sophistication with practicality for a truly stunning addition to your home.\n\nCrafted with meticulous attention to detail, Lola is not just a table; it''s a statement piece that effortlessly elevates any space. The transparent glass tabletop creates a sense of openness and lightness, perfect for showcasing your favorite decor accents or enjoying meals with loved ones.\n\nThe wooden legs of Lola add warmth and texture, blending seamlessly with a range of interior styles from modern to transitional. Whether used as a dining table, a stylish workspace, or a focal point in your living room, Lola brings a touch of timeless beauty and functionality to your home.\n\nUpgrade your living experience with Lola – where contemporary design meets everyday versatility, making every moment spent around this table a delightful experience.'),
    (5, 'Table "Lotta"', 'tableLotta.png',2,'Introducing Lotta – a symbol of artistic craftsmanship and timeless elegance in our table collection. Lotta''s unique design features a round tabletop divided into two exquisite halves: one showcasing the natural beauty of wood with its rich, warm color, while the other half gleams with a pristine white varnish, creating a striking contrast that captivates the eye.\n\nSupported by three sleek wooden legs, Lotta exudes a sense of modern sophistication and luxury. Its minimalist yet bold silhouette makes it a standout piece in any room, adding a touch of contemporary flair to your home decor.\n\nPerfect for intimate gatherings or as a stylish accent in your living space, Lotta combines functionality with aesthetic appeal. The balanced fusion of wood and white varnish creates a harmonious visual impact, making every meal or gathering around Lotta a memorable experience.\n\nElevate your home with Lotta – where innovative design meets impeccable craftsmanship, delivering a table that''s not just furniture but a work of art that enhances your lifestyle.'),
    (6,'Chair "Olaf"', 'chairOlaf.png',3, 'Step into a realm of extraordinary luxury with Olaf, our latest masterpiece in seating elegance. Designed to captivate and delight, Olaf is not just a chair – it''s a statement of unparalleled artistry and comfort.\n\nImmerse yourself in the wild elegance of Olaf, a chair that brings the untamed spirit of the ice bear directly into your living space. Crafted with artificial ice bear fur, Olaf embodies the essence of nature''s grandeur, offering a unique blend of style and coziness.\n\nExperience the Arctic''s allure firsthand with Olaf, a chair that transcends the ordinary to become a captivating focal point in any room. From its lifelike ice bear face to its plush comfort, Olaf invites you to relax in style while adding a touch of whimsical charm to your home.'),
    (7, 'Chair "Knut"', 'chairKnut.png', 3, 'Step into the future of seating comfort with Knut, a chair that seamlessly blends modern design with ergonomic excellence. Its sleek, rounded silhouette gives it an appearance that''s perfectly suited for contemporary spaces, while its innovative leg structure, reminiscent of a tripod but with four legs, adds a touch of architectural intrigue.\n\nKnut isn''t just a chair; it''s a statement of forward-thinking style and functionality. Its unique design not only catches the eye but also provides stability and support, making it a comfortable seating option for long hours of relaxation or work.\n\nExperience the harmony of form and function with Knut, where every curve and angle is crafted to enhance your seating experience. Whether placed in a living room, office, or study, Knut adds a touch of modern sophistication while ensuring unparalleled comfort for every sitter.'),
    (8, 'Chair "Lars"','chairLars.png', 3,'Introducing Lars, the epitome of Viking-inspired luxury in our chair collection. With its ancient yet regal appearance, Lars exudes a sense of Nordic grandeur, blending traditional Viking style with modern comfort.\n\nCrafted with a generous amount of colored fur, Lars is not just a chair; it''s a statement piece that commands attention and admiration. Its unique design captures the essence of Viking culture, offering a luxurious seating experience that transports you to a world of rugged beauty and timeless charm.\n\nWhether placed in a cozy reading nook, a majestic study, or as a standout piece in your living room, Lars adds a touch of Nordic elegance and warmth to your home decor. Embrace the spirit of the Vikings with Lars, where comfort meets heritage in a chair that embodies strength, style, and sophistication.'),
    (9, 'Wardrobe "Ingeborg"', 'wardrobeIngeborg.png', 4, 'Discover the epitome of practicality and style with Ingeborg, our versatile wardrobe designed to meet your storage needs with ease. Featuring six smaller compartments and two larger cases, Ingeborg combines functionality with a sleek, minimalist aesthetic, making it a perfect addition to any modern living space.\n\nIngeborg isn''t just a wardrobe; it''s a storage solution that embodies practical elegance. Its clean lines and well-organized compartments offer ample space to keep your clothes, accessories, and essentials neatly arranged and easily accessible.\n\nExperience the convenience and sophistication of Ingeborg, where practicality meets contemporary design to elevate your storage experience. Say goodbye to clutter and hello to a well-organized, stylish space that reflects your impeccable taste.'),
    (10, 'Closet "Ragnarök"', 'closetRagnarok.png', 5, 'Embark on a journey through time and myth with Ragnarok, our extraordinary closet that channels the mystique of ancient gods and legends. Its design transports you to a bygone era, where the whispers of old gods and the echoes of epic tales linger in every detail.\n\nRagnarok isn''t just a closet; it''s a living artifact that captures the essence of ancient craftsmanship and mythical allure. With its intricate design and robust structure, Ragnarok stands as a testament to enduring strength and timeless elegance.\n\nWhile some may speak of whispers and legends, Ragnarok is a symbol of sophistication and functionality, offering ample storage space while adding a touch of mythical charm to your living space.\n\nEmbrace the mystic aura of Ragnarok, where the lines between reality and myth blur, inviting you to store your belongings in a piece that feels like a relic from a forgotten age.');

INSERT INTO PART (ID, NAME, PRICE) VALUES
        (1, 'Picture "Finland"', 14.99),
        (2, 'Picture "Oslo"', 9.99),
        (3, 'Picture "Sweden"', 12.99),
        (4, 'Table "Lola" leg', 30.00),
        (5, 'Table "Lola" tableTop', 10.00),
        (6, 'Table "Lotta" leg', 10.00),
        (7, 'Table "Lotta" tableTop', 10.00),
        (8, 'Chair "Olaf" leg', 5.00),
        (9, 'Chair "Olaf" seat', 5.00),
        (10, 'Chair "Olaf" ice bear back rest', 5.00),
        (11, 'Chair "Knut" leg', 4.00),
        (12, 'Chair "Knut" seat', 10.00),
        (13, 'Chair "Knut" back rest', 15.00),
        (14, 'Chair "Lars" leg', 2.00),
        (15, 'Chair "Lars" seat', 20.00),
        (16, 'Chair "Lars" back rest', 30.00),
        (17, 'Wardrobe "Ingeborg"', 249.99),
        (18, 'Closet "Ragnarök"', 329.99);


INSERT INTO PRODUCT_PARTS (PRODUCT_ID, PART_ID, QUANTITY) VALUES
        (1, 1, 1),
        (2,2,1),
        (3,3,1),
        (4,4,4),
        (4,5,1),
        (5,6,4),
        (5,7,1),
        (6,8,4),
        (6,9,1),
        (6,10,1),
        (7,11,4),
        (7,12,1),
        (7,13,1),
        (8,14,4),
        (8,15,1),
        (8,16,1),
        (9,17,1),
        (10,18,1);



