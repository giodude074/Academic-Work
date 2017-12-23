-- DROP DATABASE Todo;
-- CREATE DATABASE Todo;
USE cs3220stu59;

DROP TABLE IF EXISTS Todo;

CREATE TABLE Todo (
	ID int NOT NULL PRIMARY KEY AUTO_INCREMENT,
	Title varchar(200) NOT NULL,
	Done boolean DEFAULT false,
	Archive boolean DEFAULT false
);

INSERT INTO Todo VALUES(null, 'Check pokebank', true, false);
INSERT INTO Todo VALUES(null, 'finish hw', true, false);
INSERT INTO Todo VALUES(null, 'catch em all', true, false);
INSERT INTO Todo VALUES(null, 'beat the elite 4', true, false);
INSERT INTO Todo VALUES(null, 'make cookies', false, false);
INSERT INTO Todo VALUES(null, 'finish designs', true, false);
INSERT INTO Todo VALUES(null, 'draw logos', true, false);
INSERT INTO Todo VALUES(null, 'study for final', true, false);
INSERT INTO Todo VALUES(null, 'do hw', true, false);
INSERT INTO Todo VALUES(null, 'make chai tea', true, true);
INSERT INTO Todo VALUES(null, 'go exercise', false, false);
INSERT INTO Todo VALUES(null, 'buy winter clothes', false, false);
INSERT INTO Todo VALUES(null, 'buy christmas presents', false, false);