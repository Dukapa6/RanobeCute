-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: ranobecute
-- ------------------------------------------------------
-- Server version	8.0.36

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `chapters`
--

DROP TABLE IF EXISTS `chapters`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chapters` (
  `idchapters` int NOT NULL AUTO_INCREMENT,
  `novel_id` int NOT NULL,
  `volume_number` int NOT NULL,
  `chapter_number` int NOT NULL,
  `title` varchar(255) NOT NULL,
  `pathtext` text NOT NULL,
  PRIMARY KEY (`idchapters`),
  CONSTRAINT `novel_id` FOREIGN KEY (`idchapters`) REFERENCES `novels` (`idnovels`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chapters`
--

LOCK TABLES `chapters` WRITE;
/*!40000 ALTER TABLE `chapters` DISABLE KEYS */;
INSERT INTO `chapters` VALUES (1,0,1,1,'Том 1 Глава 1','src/main/resources/ranoberead/Принц Демонов отправляется в Академию (Новелла)/Том 1 Глава 1.txt'),(2,0,1,2,'Том 1 Глава 2','src/main/resources/ranoberead/Принц Демонов отправляется в Академию (Новелла)/Том 1 Глава 2.txt'),(3,0,1,3,'Том 1 Глава 3','src/main/resources/ranoberead/Принц Демонов отправляется в Академию (Новелла)/Том 1 Глава 3.txt');
/*!40000 ALTER TABLE `chapters` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `novels`
--

DROP TABLE IF EXISTS `novels`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `novels` (
  `idnovels` int NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `author` varchar(255) NOT NULL,
  `genre` varchar(100) NOT NULL,
  `description` text NOT NULL,
  `status` varchar(45) NOT NULL,
  `image` varchar(255) NOT NULL,
  `type` varchar(45) NOT NULL,
  `year` int NOT NULL,
  `chapters` int DEFAULT NULL,
  PRIMARY KEY (`idnovels`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `novels`
--

LOCK TABLES `novels` WRITE;
/*!40000 ALTER TABLE `novels` DISABLE KEYS */;
INSERT INTO `novels` VALUES (0,'Принц Демонов отправляется в Академию (Новелла)','Geul Jengi S','Фэнтези ','Кажется, я стал Принцем Демонов. Всё бы ничего, но только мой папаша, Король Демонов, мёртв, остальные демоны повержены в главной схватке, а я не наделён никакими могущественными силами, которые были у моего папочки. И как мне выжить в таких условиях?','Онгоинг','src/main/resources/ranobeimg/The-Demon-Prince-goes-to-the-Academy.jpeg','Корея',2021,NULL),(1,'Я подружился со второй самой привлекательной девушкой в ​​моем классе (WN) (Новелла)','Takata','Романтика','Маехара Маки – человек, не имеющий ни знакомых, ни друзей в старшей школе. Однако, спустя время, он наконец-то нашёл кого-то, с кем может проводить время за стенами школьного учреждения – девушка.','Онгоинг','src/main/resources/ranobeimg/Class_de_2-ban_Me_ni_Kawaii_Onna_no_Ko_to_Tomodachi_ni_Natta_LN_volume_1.png','Япония',2020,NULL),(2,'Я женился на однокласснице, которую ненавидел (Новелла)','Amano Seiju','Романтика','Старшеклассник Ходзё Сайто женился на своей однокласснице Сакурамори Аканэ, девушке, которая была его злейшим врагом в школе.','Онгоинг','src/main/resources/ranobeimg/Kurasu-no-Daikiraina-Joshi-to-Kekkon-Suru-Koto-ni-Natta.jpg','Япония',2020,NULL),(3,'Низкоуровневый персонаж Томозаки-кун (Новелла)','Yaku Yuuki','Повседневность','«Жизнь — плохая видеоигра» — эта общеизвестная фраза, к сожалению, является правдой. Однако жизнь не имеет простых понятных правил. Чего в ней полно, так это иррациональности и неравенства. Сильные говорят, что у них много свободы, но у слабых нет иного выбора, кроме как прожить в своем большинстве с неблагоприятным образом жизни. Поэтому это плохая игра. В этом нет никаких сомнений, и я, лучший геймер в Японии, заявляю, что это шлак. Тем не менее есть человек, который находится на том же уровне, что и я, и утверждает: «Жизнь — отличная игра». Это идеальная волевая героиня школы Хинами Аой. Более того, она говорит:','Онгоинг','src/main/resources/ranobeimg/Bottom_Tier_Character_Tomozaki_Kun_Visual_2.png','Япония',2016,NULL),(4,'Розовая пора моей школьной жизни сплошной обман (LN) (Новелла)','Wataru Watari','Повседневность','Хатиман Хикигая — старшеклассник, который уже успел разочароваться в жизни. И по его мнению, он сейчас переживает самый худший период в жизни человека — юность. Иллюзию, сотканную из обмана, неудач и лицемерия. Однако, когда он описывает это в школьном сочинении, его учительницу не устраивает такое положение дел, и она отправляет его на \"перевоспитание\" в клуб волонтёров — место, участники которого помогают другим ученикам в решении их проблем. Как же справится наш герой с просьбами других людей, и смогут ли ему помочь в этом клубе?','Завершён','src/main/resources/ranobeimg/oregairu.jpg','Япония',2011,NULL),(5,'Ферма творения (Новелла)','Phuton','Мистика','Сверхъестественный мир, где проживают множество чудовищ, не ведом простым людям. В этом месте нет места слабости. Что делать по ту сторону реальности, когда ты просто друг парня, напоминающего главного героя гаремника, а из особенностей у тебя... Ферма? Ферма?!','Онгоинг','src/main/resources/ranobeimg/Ферма творения (Новелла).jpg','Авторский',2023,NULL),(6,'Добро пожаловать в класс превосходства (LN) (Новелла)','KINUGASA Shougo','Психология','Старшая школа Кодо Икусей – престижное учебное заведение с непревзойденной статистикой. 100% выпускников этой школы поступают в университеты или находят работу. Учащимся позволено ходить с любыми прическами и приносить любые личные вещи. На первый взгляд, эта школа словно рай, однако все вышесказанное применимо только к самым выдающимся ученикам.','Онгоинг','src/main/resources/ranobeimg/Добро пожаловать в класс превосходства.jpg','Япония',2015,NULL),(7,'123','123','123','123','Ongoing','src/main/resources/ranobeimg/123.png','Japan',123,NULL);
/*!40000 ALTER TABLE `novels` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `idusers` int NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`idusers`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'admin','admin@mail.ru','1234');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'ranobecute'
--

--
-- Dumping routines for database 'ranobecute'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-09-17 21:05:44
