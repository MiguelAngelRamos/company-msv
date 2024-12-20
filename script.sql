-- Crear tabla de compañías
CREATE TABLE IF NOT EXISTS `company` (
    `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(32) NOT NULL UNIQUE,
    `founder` VARCHAR(128),
    `logo` VARCHAR(255),
    `foundation_date` DATE
    );

-- Crear índice para el nombre de la compañía
CREATE INDEX `name_company` ON `company`(`name`);

-- Crear tabla de sitios web
CREATE TABLE IF NOT EXISTS `web_site` (
    `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `id_company` BIGINT UNSIGNED,
    `name` VARCHAR(32) NOT NULL UNIQUE,
    `url` VARCHAR(255),
    `category` VARCHAR(32) NOT NULL,
    `description` TEXT,
    CONSTRAINT `fk_company`
    FOREIGN KEY (`id_company`)
    REFERENCES `company`(`id`)
    ON DELETE CASCADE
    );

-- Insertar datos en la tabla de compañías
INSERT INTO `company`(`name`, `founder`, `logo`, `foundation_date`)
VALUES
    ('Facebook', 'Mark Zuckerberg', 'facebook.jpg', '2004-02-04'),
    ('Google', 'Larry Page', 'google.png', '1998-09-04'),
    ('Amazon', 'Jeff Bezos', 'amazon.jpg', '1994-07-05'),
    ('Microsoft', 'Bill Gates', 'microsoft.png', '1975-04-04'),
    ('Apple', 'Steve Jobs', 'apple.jpg', '1976-04-01'),
    ('TikTok', 'Zhang Yiming', 'tiktok.jpg', '2016-09-05'),
    ('Steam', 'Gabe Newell', 'steam.png', '2003-09-12'),
    ('Oracle', 'Lawrence J', 'oracle.png', '1977-06-16'),
    ('Cisco', 'Leonard Bosack', 'cisco.png', '1984-12-10'),
    ('Samsung', 'Lee Byung-chull', 'samsung.png', '1938-03-01'),
    ('Sony', 'Masaru Ibuka', 'sony.jpg', '1946-05-07'),
    ('Nintendo', 'Fusajiro Yamauchi', 'nintendo.jpg', '1889-09-23');

-- Insertar datos en la tabla de sitios web
INSERT INTO `web_site`(`id_company`, `name`, `url`, `category`, `description`)
VALUES
    (1, 'Facebook', 'https://www.facebook.com', 'SOCIAL_NETWORK', 'Is an American online social media and social networking service owned by Facebook, Inc.'),
    (1, 'Instagram', 'https://www.instagram.com', 'SOCIAL_NETWORK', 'Is an American online social media and social networking service owned by Facebook, Inc.'),
    (1, 'Whatsapp', 'https://www.whatsapp.com', 'SERVICES', 'Is an American chat service owned by Facebook, Inc.'),
    (2, 'Gmail', 'https://mail.google.com', 'SERVICES', 'Is an American email service owned by Google, Inc.'),
    (2, 'Youtube', 'https://www.youtube.com', 'STREAMING', 'Is an American online streaming service owned by Google, Inc.'),
    (2, 'Google Cloud Platform', 'https://cloud.google.com', 'CLOUD_COMPUTING', 'Is an American cloud computing service owned by Google, Inc.'),
    (3, 'Amazon Store', 'https://www.amazon.com', 'SERVICES', 'Is an American store service owned by Amazon, Inc.'),
    (3, 'AWS', 'https://aws.amazon.com', 'CLOUD_COMPUTING', 'Is an American cloud computing service owned by Amazon, Inc.'),
    (3, 'Amazon Prime', 'https://www.primevideo.com', 'STREAMING', 'Is an American streaming service owned by Amazon, Inc.'),
    (4, 'Windows', 'https://www.microsoft.com/windows', 'SERVICES', 'Is an operating system owned by Microsoft, Inc.'),
    (4, 'Xbox', 'https://www.xbox.com', 'DEVICES', 'Is a gaming console owned by Microsoft, Inc.'),
    (5, 'iPhone', 'https://www.apple.com/iphone', 'DEVICES', 'Is a product by Apple.'),
    (5, 'Mac', 'https://www.apple.com/mac', 'DEVICES', 'Is a product by Apple.'),
    (5, 'iPad', 'https://www.apple.com/ipad', 'DEVICES', 'Is a product by Apple.'),
    (6, 'TikTok', 'https://www.tiktok.com', 'STREAMING', 'Is a streaming service.'),
    (7, 'Steam', 'https://store.steampowered.com', 'SERVICES', 'Is a digital distribution platform for video games.'),
    (8, 'Java', 'https://www.java.com', 'SERVICES', 'Is a programming language.'),
    (8, 'Oracle Cloud', 'https://www.oracle.com/cloud', 'CLOUD_COMPUTING', 'Is a cloud computing service.'),
    (9, 'Cisco Networks', 'https://www.cisco.com', 'SERVICES', 'Is a networking service.'),
    (10, 'Smartphone', 'https://www.samsung.com/smartphones', 'DEVICES', 'Is a communication device.'),
    (11, 'PlayStation', 'https://www.playstation.com', 'DEVICES', 'Is a gaming console by Sony.'),
    (12, 'Nintendo', 'https://www.nintendo.com', 'DEVICES', 'Is a gaming console by Nintendo.');

-- Consultar todas las compañías
SELECT * FROM `company`;
