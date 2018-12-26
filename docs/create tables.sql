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
    `has_no_children` TINYINT(1),
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
    `description` VARCHAR(1000) NOT NULL,
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
        
INSERT INTO `Category` (`name`, `has_no_children`) VALUES 
('Mangas',false),
('Animes',false),
('Goodies',true),
('Shōnen',null),
('Shōjo',null),
('Shōnen',null),
('Seinen',null);

INSERT INTO `Hierarchy`(`main_category_id`,`sub_category_id`) VALUES
(1,4),
(1,5),
(2,6),
(2,7);

INSERT INTO `Language` (`name`) VALUES ('Français'), ('English');
   
INSERT INTO `Product` (`product_price`, `category_id`) VALUES 
(7.5,4),
(8,4),
(7,5),
(8.5,5),
(35,6),
(80,6),
(25,7),
(17,7);

INSERT INTO `ProductTranslation` (`product_id`,`language_id`,`name`,`description`) VALUES
-- Insertion des mangas 
(1, 1, 'Death note', 'Light Yagami, jeune étudiant japonais de 17 ans surdoué qui juge le monde tel qu\'il est, criminel, corrompu et noyé dans l\'injustice, trouve un beau jours, par hasard un cahier noir intituler "Death Note" (Cahier de la mort), des instruction y sont écrite, le cahier stipule "la personne dont le nom est inscrit dans ce carnet meurt".'),
(1,2,'Death Note', 'Light Yagami, a young, gifted 17-year-old Japanese student who judges the world as he is, criminal, corrupted and drowned in injustice, finds a beautiful day, by chance, a black notebook titled "Death Note" (Death Book) ), instructions are written there, the notebook stipulates "the person whose name is written in this notebook dies"'),
(2,1,'L\'attaque des titans', 'La race humaine est au bord de l\'extinction suite à l\'arrivée de géants dévorants les humains. Mais heureusement, les derniers survivants réussissent à se fortifier derrière d\'immenses murs empêchant tous géants de les atteindre. Durant plusieurs années, les humains ont pu enfin vivre en paix. Mais, un beau jour, un géant réussit à faire une brèche dans l\'enceinte. Maintenant qu\'ils sont de retour, la guerre est déclarée, Eren compte bien se venger du mal qui a été fait aux habitants de la ville et décide d\'éliminer tous ces êtres nuisibles un par un.'),
(2,2,'Attack on titans', 'The human race is on the verge of extinction following the arrival of giants devouring humans. But fortunately, the last survivors succeed in fortifying themselves behind immense walls preventing all giants from reaching them. For many years, humans have finally been able to live in peace. But, one day, a giant managed to make a breach in the enclosure. Now that they are back, the war is declared, Eren is eager to avenge the harm that has been done to the inhabitants of the city and decides to eliminate all these harmful beings one by one.'),
(3,1,'Orange','Un matin, alors qu\'elle se rend au lycée, Naho reçoit une drôle de lettre… une lettre du futur ! La jeune femme qu\'elle est devenue dix ans plus tard, rongée par de nombreux remords, souhaite aider celle qu\'elle était autrefois à ne pas faire les mêmes erreurs qu\'elle. Aussi, elle a décrit, dans un long courrier, les événements qui vont se dérouler dans la vie de Naho lors des prochains mois, lui indiquant même comment elle doit se comporter. Mais Naho, a bien du mal à y croire, à cette histoire… Et de toute façon, elle manque bien trop d\'assurance en elle pour suivre certaines directives indiquées dans ce curieux courrier. Pour le moment, la seule chose dont elle est sûre, c\'est que Kakeru, le nouvel élève de la classe, ne la laisse pas indifférent…'),
(3,2,'Orange','One morning, while she goes to high school, Naho receives a funny letter ... a letter of the future! The young woman she became ten years later, devoured by many remorse, wants to help the one she was formerly not to make the same mistakes she. She also described in a long letter the events that will take place in Naho\'s life in the coming months, even telling her how she should behave. But Naho, has a hard time believing it, this story ... And anyway, it is far too much insurance in it to follow certain guidelines indicated in this curious mail. For the moment, the only thing she is sure of is that Kakeru, the new student of the class, does not leave her indifferent ...'),
(4,1,'Ao Haru Ride', 'Alors que Futaba Yoshioka fait son entrée au lycée, elle ne garde pas de bons souvenirs du collège, où le garçon dont elle était amoureuse, Kô Tanaka, partit sans qu\'elle ait pu lui avouer ses sentiments. La chance tourne puisqu\'elle le retrouve par hasard au lycée. Cependant, il ne porte pas le même nom et sa personnalité a quelque peu changé. Avec ses nouveaux amis, elle va apprendre à l\'apprivoiser et à se rapprocher de lui, mais aussi à le connaître et à trouver de nouveau confiance en elle.'),
(4,2, 'Blue Spring Ride', 'While Futaba Yoshioka enters high school, she does not have fond memories of college, where the boy she was in love with, Ko Tanaka, left without her having to confess his feelings. Luck turns because she finds it by chance in high school. However, he does not have the same name and his personality has changed somewhat. With her new friends, she will learn to tame him and get closer to him, but also to know him and to find new confidence in her.'),
-- Insertion des animes
(5,1,'My Hero Academia (Saison 1)','Super-héros, super-pouvoirs… On a tous déjà rêvé secrètement de posséder une qualité hors du commun, de briller ou d’être LA personne la plus puissante de l’univers. Dans ce nouveau monde, ce rêve est à la portée de quasiment toute la population car les humains peuvent désormais naître avec un pouvoir : l’ « alter ».Mais certains malchanceux naissent sans alter. C’est très fâcheux si on est chétif, pleurnicheur, dépourvu de charisme et surtout si malgré tout ça, on nourrit l’ambition de devenir le méga super-héros de tous les temps. Voilà donc le profil d’Izuku Midoriya, jeune adolescent de 14 ans.Heureusement, le tableau n’est pas complètement sombre. En effet, Izuku est avant tout courageux et persévérant. Le rêve peut donc devenir réalité !Tout va basculer lorsqu’All Might, le héros de tous les héros, va choisir Izuku, contre toute attente, pour devenir son successeur. Premier challenge : intégrer la prestigieuse Hero Academia : Yuei !'),
(5,2,'My Hero Academia (Season 1)','Superhero, superpowers… We’ve all secretly dreamed of possessing extraordinary quality, shining or being THE most powerful person in the universe. In this new world, this dream is almost within the reach of the entire population because humans can now be born with a power: the “alter”. But some unlucky are born without alter. It’s very unpleasant if you’re puny, whining, charismatic, and especially if you still have the ambition to be the mega-hero of all time. So this is the profile of Izuku Midoriya, a 14-year-old teenager, and fortunately, the picture is not completely dark. Indeed, Izuku is above all courageous and persevering. The dream can therefore become reality! Everything will change when All Might, the hero of all heroes, will choose Izuku, against all odds, to become his successor. First challenge: integrate the prestigious Hero Academia: Yuei!'),
(6,1,'Fairy Tail (Saisons 1 - 4)','Parmi les guildes du royaume, il y en a une hors du commun, qui hier comme aujourd\'hui, a fait naître de nombreuses légendes. Elle a pour nom Fairy Tail. Le Royaume de Fiore. Ce pays perpétuellement neutre qui compte 17 millions d\'habitants, est aussi un monde de magie et de mystères. La magie fait partie du quotidien et son commerce y est entièrement libre. Ainsi, certains, passés maîtres, décident d\'en faire leur profession. On les appelle les Mages. Contre rétribution, ils œuvrent pour le bien de la communauté. Leur force est aussi leur nombre, ils se regroupent dans différentes guildes, disséminées un peu partout dans le royaume. Parmi celles-ci, se trouve une guilde toute particulière, qui hier comme aujourd\'hui, a fait naître de nombreuses légendes. Elle a pour nom : Fairy Tail.'),
(6,2,'Fairy Tail (Seasons 1 - 4)','Among the guilds of the realm, there is one out of the ordinary, which yesterday as today has brought forth many legends.Her name is Fairy Tail.The Kingdom of Fiore. This perpetually neutral country of 17 million people is also a world of magic and mysteries. Magic is part of everyday life and its trade is entirely free. Thus, some, past masters, decide to make it their profession. They are called the Magi. Against retribution, they work for the good of the community. Their strength is also their number, they gather in different guilds, spread throughout the kingdom. Among them is a very special guild, which yesterday as today has given rise to many legends. Her name is: Fairy Tail.'),
(7,1,'Tokyo Ghoul (Saison 1)','Dans la ville de Tokyo, des créatures nommées goules sont apparues et se nourrissent de chair humaine pour survivre. Un jour, Ken Kaneki, jeune étudiant, se fait attaquer par l\'une d\'entre elles et subit une grave blessure. Pour rester en vie, il reçoit une greffe de la goule qui l\'a attaqué et devient un hybride, mi-humain mi-goule (borgne artificielle). Rapidement, il se rend compte qu\'il ne peut plus manger les mêmes aliments qu\'auparavant. Il entre alors au service du café « L’Antique », un repaire de goules, où il apprend à se nourrir sans faire de mal aux humains. Mais il va bien vite se retrouver au cœur d\'une guerre sanglante entre le CCG (Centre de Contrôle des Goules), déterminé à retrouver et exterminer celles-ci jusqu\'à la dernière et l\'Arbre Aogiri, une organisation de goules sans merci. Il découvre que les goules ne sont pas si différentes des humains, et peu à peu il va commencer à s\'adapter.'),
(7,2,'Tokyo Ghoul (Season 1)','In the city of Tokyo, creatures named ghoules appeared and feed on human flesh to survive. One day, Ken Kaneki, a young student, was attacked by one of them and suffered a serious injury. To stay alive, he receives a transplant from the ghoul that attacked him and becomes a hybrid, half-human mid-ghoul (artificial ghoul). Quickly, he realizes that he can no longer eat the same foods as before. He then went to serve the coffee «L\'Antique», a den of ghouls, where he learned to feed himself without hurting humans. But it will soon find itself at the heart of a bloody war between the CCG (Centre de Contrôle des goules), determined to find and exterminate these until the last and the Arbre Aogiri, a merciless ghoul organization. He discovers that ghouls are not so different from humans, and little by little he will begin to adapt.'),
(8,1,'Parasite : La Maxime','Une nuit, des sphères de la taille de balles de tennis, contenant des créatures à l\'apparence de serpents, tombent en nombre inconnu partout dans le monde. Ils sont programmés pour prendre la place des cerveaux humains. Un de ceux-ci s\'attaque à un jeune homme, Shinichi, durant son sommeil, en essayant de s\'introduire par son oreille mais ne peut l\'atteindre, ce dernier ayant gardé ses écouteurs pour la nuit. Réveillé en sursaut alors que le parasite tente de s\'introduire par son nez, il essaye de se défendre mais finit par se faire perforer la main droite. Le lycéen prend alors ses écouteurs et les enroule autour de son bras, empêchant le parasite de grimper jusqu\'au cerveau. Ne pouvant quitter son bras, ce dernier fusionne finalement avec sa main droite. Pendant ce temps, d\'autres parasites, ayant réussi à prendre possession du cerveau de leur hôte, commencent à se nourrir d\'êtres humains, tandis que la créature et Shinichi sont forcés de cohabiter.'),
(8,2,'Parasyte : The Maxim','One night, spheres the size of tennis balls, containing creatures with the appearance of snakes, fall into unknown numbers all over the world. They’re programmed to take the place of human brains. One of them attacks a young man, Shinichi, during his sleep, trying to break into his ear but cannot reach him, because he kept his headphones for the night. Awakened astonishingly as the parasite tries to break through his nose, he tries to defend himself but ends up getting punctured with his right hand. The high school student then takes his headphones and wraps them around his arm, preventing the parasite from climbing to the brain. Unable to leave his arm, the latter eventually merges with his right hand. Meanwhile, other parasites, having managed to take possession of their host’s brain, begin to feed on human beings, while the creature and Shinichi are forced to cohabit.');
-- Insertion des goodies


/*
INSERT INTO `Order` (`date`, `user_id`) VALUES ();


INSERT INTO `ProductLine` (`quantity`, `orderProductPrice`, `lineNumber`, `order_id`, `product_id`) VALUES ();

INSERT INTO `Hierarchy` (`mainCategory_id`, `subCategory_id`) VALUES ();

INSERT INTO `Promotion` (`label`, `pourcent`, `startDate`, `endDate`) VALUES ();

INSERT INTO  `Promo` (`product_id`, `promotion_id`) VALUES ();


*/