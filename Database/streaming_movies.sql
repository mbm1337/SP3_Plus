-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: localhost    Database: streaming
-- ------------------------------------------------------
-- Server version	8.0.33

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
-- Table structure for table `movies`
--

DROP TABLE IF EXISTS `movies`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movies` (
  `ID` int NOT NULL,
  `title` text,
  `year` int DEFAULT NULL,
  `genre` text,
  `rating` float DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movies`
--

LOCK TABLES `movies` WRITE;
/*!40000 ALTER TABLE `movies` DISABLE KEYS */;
INSERT INTO `movies` VALUES (1,'The Godfather',1972,' Crime. Drama',9.2),(2,'The Shawshank Redemption',1994,' Drama',9.3),(3,'Schindler\'s List',1993,' Biography. Drama. History',8.9),(4,'Raging Bull',1980,' Biography. Drama. Sport',8.2),(5,'Casablanca',1942,' Drama. Romance. War',8.5),(6,'Citizen Kane',1941,' Drama. Mystery',8.4),(7,'Gone With The Wind',1939,' Drama. History. Romance',8.2),(8,'The Wizard Of Oz',1939,' Adventure. Family. Fantasy',8),(9,'One Flew Over The Cuckoo\'s Nest',1975,' Drama',8.7),(10,'Lawrence Of Arabia',1962,' Adventure. Biography. Drama',8.3),(11,'Vertigo',1958,' Mystery. Romance. Thriller',8.3),(12,'Psycho',1960,' Horror. Mystery. Thriller',8.5),(13,'The Godfather part II',1974,' Crime. Drama',9),(14,'On The Waterfront',1954,' Crime. Drama. Thriller',8.2),(15,'Sunset Boulevard',1950,' Drama. Film-Noir',8.4),(16,'Forrest Gump',1994,' Drama. Romance',8.8),(17,'The Sound Of Music',1965,' Biography. Drama. Family. Musical',8),(18,'12 Angry Men',1957,' Crime. Drama',8.9),(19,'West Side Story',1961,' Crime. Drama',7.6),(20,'Star Wars',1977,' Action. Adventure. Family',8.6),(21,'2001 A Space Odyssey',1968,' Adventure. Sci-fi',8.3),(22,'ET',1982,' Family. Sci-fi',7.9),(23,'The Silence Of The Lambs',1991,'Crime. Drama. Thriller',8.6),(24,'Chinatown',1974,' Drama. Mystery. Thriller',8.2),(25,'The Bridge Over The River Kwai',1957,' Adventure. Drama. War',8.2),(26,'Singin\' In The Rain',1952,' Comedy. Musical. Romance',8.3),(27,'It\'s A Wonderful Life',1946,' Drama. Family. Fantasy',8.6),(28,'Dr. Strangelove Or How I Learned To Stop Worrying And Love The Bomb',1964,' Comedy. War',8.4),(29,'Some Like It Hot',1959,' Comedy. Romance',8.2),(30,'Ben Hur',1959,' Adventure. Drama. History',8.1),(31,'Apocalypse Now',1979,' Drama. War',8.5),(32,'Amadeus',1984,' Biography. Drama. History',8.3),(33,'Lord Of The Rings - The Return Of The King',2003,' Action. Adventure. Drama',8.9),(34,'Gladiator',2000,' Action. Adventure. Drama',8.5),(35,'Titanic',1997,' Drama. Romance',7.8),(36,'From Here To Eternity',1953,' Drama. Romance. War',7.7),(37,'Saving Private Ryan',1998,' Drama. War',8.6),(38,'Unforgiven',1992,' Drama. Western',8.2),(39,'Raiders Of The Lost Ark',1981,' Action. Adventure',8.5),(40,'Rocky',1976,' Drama. Sport',8.1),(41,'A Streetcar Named Desire',1951,' Drama',8),(42,'A Philadelphia Story',1940,' Comedy. Romance',8),(43,'To Kill A Mockingbird',1962,' Crime. Drama',8.3),(44,'An American In Paris',1951,' Drama. Musical. Romance',7.2),(45,'The Best Years Of Our Lives',1946,' Drama. Romance. War',8.1),(46,'My Fair Lady',1964,' Drama. Family. Musical',7.9),(47,'A Clockwork Orange',1971,' Crime. Drama. Sci-fi',8.3),(48,'Doctor Zhivago',1965,' Drama. Romance. War',8),(49,'The Searchers',1956,' Adventure. Drama. Western',8),(50,'Jaws',1975,' Adventure. Drama. Thriller',8),(51,'Patton',1970,' Biography. Drama. War',8),(52,'Butch Cassidy And The Sundance Kid',1969,' Biography. Crime. Drama',8.1),(53,'The Treasure Of The Sierra Madre',1948,' Adventure. Drama. Western',8.3),(54,'The Good. The Bad And The Ugly',1966,' Western',8.9),(55,'The Apartment',1960,' Comedy. Drama. Romance',8.3),(56,'Platoon',1986,' Drama. War',8.1),(57,'High Noon',1952,' Action. Drama. Thriller',8),(58,'Braveheart',1995,' Biography. Drama. History',8.4),(59,'Dances With Wolves',1990,' Adventure. Drama. Western',8),(60,'Jurassic Park',1993,' Adventure. Sci-fi. Thriller',8.1),(61,'The Exorcist',1973,' Horror',8),(62,'The Pianist',2002,' Biography. Drama. Music',8.5),(63,'Goodfellas',1990,' Crime. Drama',8.7),(64,'The Deer Hunter',1978,' Drama. War',8.1),(65,'All Quiet On The Western Front',1930,' Drama. War',8.1),(66,'Bonny And Clyde',1967,' Action. Biography. Crime',7.9),(67,'The French Connection',1971,' Action. Crime. Drama',7.8),(68,'City Lights',1931,' Comedy. Drama. Romance',8.5),(69,'It Happened One Night',1934,' Comedy. Romance',8.1),(70,'A Place In The Sun',1951,' Drama. Romance',7.8),(71,'Midnight Cowboy',1969,' Drama',7.9),(72,'Mr Smith Goes To Washington',1939,' Comedy. Drama',8.2),(73,'Rain Man',1988,' Drama',8),(74,'Annie Hall',1977,' Comedy. Romance',8),(75,'Fargo',1996,' Crime. Drama. Thriller',8.1),(76,'Giant',1956,' Drama. Western',7.7),(77,'Shane',1953,' Drama. Western',7.7),(78,'Grapes Of Wrath',1940,' Drama. History',8.1),(79,'The Green Mile',1999,' Crime. Drama. Fantasy',8.5),(80,'Close Encounters',1977,' Drama. Sci-fi',7.7),(81,'Nashville',1975,' Comedy. Drama. Music',7.8),(82,'Network',1976,' Drama',8.1),(83,'The Graduate',1967,' Comedy. Drama. Romance',8),(84,'American Graffiti',1973,' Comedy. Drama',7.5),(85,'Pulp Fiction',1994,' Crime. Drama',8.9),(86,'Terms of Endearment',1983,' Comedy. Drama',7.4),(87,'Good Will Hunting',1997,' Drama. Romance',8.3),(88,'The African Queen',1951,' Adventure. Drama. Romance',7.9),(89,'Stagecoach',1939,' Adventure. Western',7.9),(90,'Mutiny On The Bounty',1935,' Adventure. Biography. Drama',7.8),(91,'The Great Dictator',1940,' Comedy. Drama. War',8.5),(92,'Double Indemnity',1944,' Crime. Drama. Film-Noir',8.3),(93,'The Maltese Falcon',1941,' Film-Noir. Mystery',8.1),(94,'Wuthering Heights',1939,' Drama. Romance',7.7),(95,'Taxi Driver',1976,' Crime. Drama',8.3),(96,'Rear Window',1954,' Mystery. Thriller',8.5),(97,'The Third Man',1949,' Film-Noir. Mystery. Thriller',8.2),(98,'Rebel Without A Cause',1955,' Drama',7.8),(99,'North By Northwest',1959,' Adventure. Mystery. Thriller',8.3),(100,'Yankee Doodle Dandy',1942,' Biography. Drama. Musical',7.7);
/*!40000 ALTER TABLE `movies` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-05-04 10:10:37
