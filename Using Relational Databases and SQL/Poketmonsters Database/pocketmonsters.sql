DROP DATABASE pocketmonsters;
CREATE DATABASE pocketmonsters;
Use pocketmonsters;

drop table if exists Trainers;
drop table if exists XrefPokemon;
drop table if exists Regions;


CREATE TABLE Trainers (
	TrainerID int NOT NULL PRIMARY KEY ,
	TrainerName varchar (50) NOT NULL ,
	City varchar (25) ,
	Town varchar (25) ,
	Region varchar (15) ,
	Gender char (1) ,
	Age int
	 
);

Insert Into Trainers Values(1,'Ash Ketchum','NULL','Pallet Town','Kanto','M',10);
Insert Into Trainers Values(2,'Green','NULL','Pallet Town','Kanto','M',11);
Insert Into Trainers Values(3,'Blue','NULL','Pallet Town','Kanto','F',11);
Insert Into Trainers Values(4,'Red','NULL','Pallet Town','Kanto','M',11);
Insert Into Trainers Values(5,'Misty','Cerulean City','NULL','Kanto','F',12);


CREATE TABLE Regions (
	RegionID int NOT NULL PRIMARY KEY ,
	RegionName varchar (20) ,
	PkmnProfessor varchar (50) ,
	RegionalVillains varchar (50) ,
	Population int
);

Insert Into Regions Values(1,'Kanto','Oak','Team Rocket',391);
Insert Into Regions Values(2,'Johto','Elm','Team Rocket',452);
Insert Into Regions Values(3,'Hoenn','Birch','Team Aqua_Magma',598);
Insert Into Regions Values(4,'Sinnoh','Rowan','Team Galactic',755);
Insert Into Regions Values(5,'Unova','Juniper','Team Plasma',949);
Insert Into Regions Values(6,'Kalos','Sycamore','Team Flare',868);


CREATE TABLE XrefPokemon (
	DexID int ,
	PkmnName varchar (50) NOT NULL ,
	WeightLBS REAL(5,1) NOT NULL ,
	Types varchar (50) ,
	RegionID int NOT NULL ,
	TrainerID int NOT NULL 
	 
);

Insert Into XrefPokemon Values(001,'Bulbasaur','15.2','Grass_Poison',1,1);
Insert Into XrefPokemon Values(094,'Gengar','89.3','Ghost_Poison',1,1);
Insert Into XrefPokemon Values(129,'Magikarp','22.0','Water',1,5);
Insert Into XrefPokemon Values(133,'Eevee','14.3','Normal',1,5);
Insert Into XrefPokemon Values(151,'Mew','8.8','Psychic',1,null);
Insert Into XrefPokemon Values(157,'Typhlosion','175.3','Fire',2,5);
Insert Into XrefPokemon Values(160,'Feraligatr','195.8','Water',2,3);
Insert Into XrefPokemon Values(257,'Blaziken','114.6','Fire_Fighting',3,2);
Insert Into XrefPokemon Values(302,'Sableye','24.3','Dark_Ghost',3,5);
Insert Into XrefPokemon Values(386,'Deoxys','134.0','Psychic',3,1);
Insert Into XrefPokemon Values(491,'Darkrai','1.5','Dark',4,4);
Insert Into XrefPokemon Values(493,'Arceus','705.5','Normal',4,null);
Insert Into XrefPokemon Values(610,'Axew','39.7','Dragon',5,4);
Insert Into XrefPokemon Values(675,'Pangoro','299.8','Dark_Fighting',6,4);
Insert Into XrefPokemon Values(719,'Diance','19.4','Rock_Fairy',6,5);

