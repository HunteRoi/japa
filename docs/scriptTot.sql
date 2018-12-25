/*DROP TABLES
DROP TABLE `ProductTranslation`;
DROP TABLE `Language`;
DROP TABLE `Promo`;
DROP TABLE `Promotion`;
DROP TABLE `Hierarchy`;
DROP TABLE `ProductLine`;
DROP TABLE `Product`;
DROP TABLE `Category`;
DROP TABLE `Order`;
DROP TABLE `User`;*/

/*CREATE TABLES*/
CREATE TABLE `User` (
	`user_id` INT(5) UNSIGNED AUTO_INCREMENT NOT NULL PRIMARY KEY,
	`username` VARCHAR(50) NOT NULL UNIQUE,
    `password` VARCHAR(200) NOT NULL,
    `first_name` VARCHAR(50) NOT NULL,
    `last_name` VARCHAR(50) NOT NULL,
    `email` VARCHAR(100) NOT NULL UNIQUE CHECK (`email` LIKE '%@%.%'),
    `is_male` TINYINT(1) DEFAULT NULL,
    `birthdate` DATE NOT NULL,
	`address` VARCHAR(100) NOT NULL,
    `authorities` VARCHAR(500) DEFAULT NULL,
    `non_expired` TINYINT(1) DEFAULT NULL,
    `non_locked` TINYINT(1) DEFAULT NULL,
    `credentials_non_expired` TINYINT(1) DEFAULT NULL,
    `enabled` TINYINT(1) DEFAULT NULL
) ENGINE = InnoDB, DEFAULT CHARSET = utf8;

CREATE TABLE `Order` (
	`order_id` INT(5) UNSIGNED AUTO_INCREMENT NOT NULL PRIMARY KEY,
    `order_date` DATE NOT NULL CHECK (`date` >= STR_TO_DATE('01/01/1970', '%d/%m/%Y')),
    `purchase_date` DATE CHECK (`date` >= STR_TO_DATE('01/01/1970', '%d/%m/%Y')),
    `user_id` INT(5) UNSIGNED NOT NULL REFERENCES `User` (`user_id`)
) ENGINE = InnoDB, DEFAULT CHARSET = utf8;

CREATE TABLE `Category` (
	`category_id` INT(5) UNSIGNED AUTO_INCREMENT NOT NULL PRIMARY KEY,
    `name` VARCHAR(50) NOT NULL
) ENGINE = InnoDB, DEFAULT CHARSET = utf8;

CREATE TABLE `Product` (
	`product_id` INT(5) UNSIGNED AUTO_INCREMENT NOT NULL PRIMARY KEY,
    `product_price` NUMERIC(8,3) NOT NULL,
    `category_id` INT(5) UNSIGNED NOT NULL REFERENCES `Category` (`category_id`)
) ENGINE = InnoDB, DEFAULT CHARSET = utf8;

CREATE TABLE `ProductLine` (
	`product_line_id` INT(5) UNSIGNED AUTO_INCREMENT NOT NULL PRIMARY KEY,
    `quantity` INT(3) UNSIGNED NOT NULL,
    `order_product_price` NUMERIC(8,3) NOT NULL,
    `line_number` INT(3) UNSIGNED NOT NULL,
    `order_id` INT(5) UNSIGNED NOT NULL REFERENCES `Order` (`order_id`),
    `product_id` INT(5) UNSIGNED NOT NULL REFERENCES `Produt` (`product_id`)
) ENGINE = InnoDB, DEFAULT CHARSET = utf8;

CREATE TABLE `Hierarchy` (
	`main_category_id` INT(5) UNSIGNED NOT NULL REFERENCES `Category` (`category_id`),
    `sub_category_id` INT(5) UNSIGNED NOT NULL REFERENCES `Category` (`category_id`),
    /*CONSTRAINT PRIMARY KEY (`mainCategory_id`, `subCategory_id`)*/
    `hierarchy_id` INT(5) UNSIGNED AUTO_INCREMENT NOT NULL PRIMARY KEY,
    CONSTRAINT `hierchary_uk` UNIQUE (`main_category_id`, `sub_category_id`)
) ENGINE = InnoDB, DEFAULT CHARSET = utf8;

CREATE TABLE `Promotion` (
	`promotion_id` INT(5) UNSIGNED AUTO_INCREMENT NOT NULL PRIMARY KEY,
    `label` VARCHAR(50) NOT NULL,
    `pourcent` NUMERIC(5,2) NOT NULL,	
    `start_date` DATE NOT NULL CHECK (`startDate` >= STR_TO_DATE('01/01/1970', '%d/%m/%Y')),
    `end_date` DATE CHECK (`endDate` >= `startDate`)
) ENGINE = InnoDB, DEFAULT CHARSET = utf8;

CREATE TABLE `Promo` (
	`product_id` INT(5) UNSIGNED NOT NULL REFERENCES `Product` (`product_id`),
    `promotion_id` INT(5) UNSIGNED NOT NULL REFERENCES `Promotion` (`promotion_id`),
    /*CONSTRAINT PRIMARY KEY (`product_id`, `promotion_id`)*/
    `promo_id` INT(5) UNSIGNED AUTO_INCREMENT NOT NULL PRIMARY KEY,
    CONSTRAINT `promo_uk` UNIQUE (`product_id`, `promotion_id`)
) ENGINE = InnoDB, DEFAULT CHARSET = utf8;

CREATE TABLE `Language` (
	`language_id` INT(5) UNSIGNED AUTO_INCREMENT NOT NULL PRIMARY KEY,
    `name` VARCHAR(50) NOT NULL
) ENGINE = InnoDB, DEFAULT CHARSET = utf8;

CREATE TABLE `ProductTranslation` (
	`product_id` INT(5) UNSIGNED NOT NULL REFERENCES `Product` (`product_id`),
    `language_id` INT(5) UNSIGNED NOT NULL REFERENCES `Language` (`language_id`),
    `name` VARCHAR(50) NOT NULL,
    `description` VARCHAR(500) NOT NULL,
    /*CONSTRAINT PRIMARY KEY (`product_id`, `language_id`)*/
    `product_translation_id` INT(5) UNSIGNED AUTO_INCREMENT NOT NULL PRIMARY KEY,
    CONSTRAINT `product_t	ranslation_uk` UNIQUE (`product_id`, `language_id`)
) ENGINE = InnoDB, DEFAULT CHARSET = utf8;

/*INSERT INTO TABLES
 RAPPEL >> valeurs à insérer !!! 
	mdp : dubisy
    -> $2a$10$nE/U91pBn6g34B.8beU9JeOBHQC0X7SUkm/mrIpaT1VCTcRWpodym
		$2a$10$rLJlEUJu.iuFlDVKRbh2HuHvik7H9TFMbUkosqkwR0EsNuKgq70DC
	mdp : imnoot
    -> $2a$10$nLE6PRvIY1QYBUSCaf6/qOblYppw3au.9O8v5aDBba.2cUdkfAABa
	mdp : hunteroi
    -> $2a$10$Xg6X9Npr6xpAUMly50KqsO3tPfdWHh2t8e4CU9y4aYUv65jHL2XCK
	mdp : root
    -> $2a$10$H4aD/r6TKjrpeKz4HN7xYeqC6Gt38.jEQtw4s.sS6VR3ZILbXYyce
 */
INSERT INTO `User` (`username`, `password`, `first_name`, `last_name`, `email`, `is_male`, `birthdate`, `address`, 
`authorities`, `non_expired`, `non_locked`, `credentials_non_expired`, `enabled`) 
	VALUES 
		('mdpdubfr','$2a$10$nE/U91pBn6g34B.8beU9JeOBHQC0X7SUkm/mrIpaT1VCTcRWpodym','Françoise','Dubisy','francoise.dubisy@henallux.be',false,STR_TO_DATE('01/01/1990','%d/%m/%Y'),'Rue Joseph Calozet, 19 - 5000 Namur',
		 'ROLE_USER', true, true, true, true
        ),
        ('imnoot','$2a$10$nLE6PRvIY1QYBUSCaf6/qOblYppw3au.9O8v5aDBba.2cUdkfAABa','Guillaume','Servais','guillaume.servais.01@student.henallux.be',true,STR_TO_DATE('17/09/1998','%d/%m/%Y'),'Rue de Matagne, 16A - 5351 OHEY',
         'ROLE_ADMIN', true, true, true, true
        ),
        ('hunteroi','$2a$10$Xg6X9Npr6xpAUMly50KqsO3tPfdWHh2t8e4CU9y4aYUv65jHL2XCK','Tinaël','Devresse','tinael.devresse.01@student.henallux.be',true,STR_TO_DATE('21/09/1999','%d/%m/%Y'),'Avenue Schlögel, 75 - 5590 Ciney',
		 'ROLE_ADMIN', true, true, true, true
        ),
        ('root','$2a$10$H4aD/r6TKjrpeKz4HN7xYeqC6Gt38.jEQtw4s.sS6VR3ZILbXYyce','Root','User','root@japa.com',null,STR_TO_DATE('01/01/2019','%d/%m/%Y'),'Some Address, CA 90810 - 3481 Some Place',
		 'ROLE_ADMIN', true, true, true, true
        )
        ;
        
INSERT INTO `Category` (`name`) VALUES 
('Mangas'),
('Animes'),
('Goodies'),
('Shōnen'),
('Shōjo'),
('Shōnen'),
('Josei'),
('Mangas'),
('Animes');

INSERT INTO `Hierarchy`(`main_category_id`,`sub_category_id`) VALUES
(1,4),
(1,5),
(2,6),
(2,7),
(3,8),
(3,9);
        
/*
INSERT INTO `Order` (`date`, `user_id`) VALUES ();


INSERT INTO `Product` (`productPrice`, `category_id`) VALUES ();

INSERT INTO `ProductLine` (`quantity`, `orderProductPrice`, `lineNumber`, `order_id`, `product_id`) VALUES ();

INSERT INTO `Hierarchy` (`mainCategory_id`, `subCategory_id`) VALUES ();

INSERT INTO `Promotion` (`label`, `pourcent`, `startDate`, `endDate`) VALUES ();

INSERT INTO  `Promo` (`product_id`, `promotion_id`) VALUES ();

INSERT INTO `Language` (`name`) VALUES ('Français'), ('English');

INSERT INTO `ProductTranslation` (`product_id`,`language_id`,`name`,`description`) VALUES ();*/