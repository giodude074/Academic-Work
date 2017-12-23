DROP DATABASE pokemart;
CREATE DATABASE pokemart;
Use pokemart;

drop table if exists Products;
drop table if exists Suppliers;


CREATE TABLE Products (
	ItemNumber int NOT NULL PRIMARY KEY AUTO_INCREMENT ,
	ItemName varchar (50) NOT NULL ,
	Price REAL(5,2) NOT NULL ,
	SupplierID int NOT NULL
	
);

Insert Into Products Values(0,'CharizardTSHIRT','10.99',1);
Insert Into Products Values(0,'GengarPLUSH','7.99',3);
Insert Into Products Values(0,'PokeballTSHIRT','9.99',1);
Insert Into Products Values(0,'MewTwoMUG','5.49',2);
Insert Into Products Values(0,'JigglypuffPLUSH','5.99',3);



CREATE TABLE Suppliers (
	SupplierID int NOT NULL PRIMARY KEY AUTO_INCREMENT ,
	SupplierName varchar (50) NOT NULL ,
	ContactPhone varchar (12) NOT NULL
	
);

Insert Into Suppliers Values(0,'PokeMonica','323-592-1803');
Insert Into Suppliers Values(0,'Giodude','323-821-3232');
Insert Into Suppliers Values(0,'PokemonCenter','323-780-1012');



SELECT SupplierName, COUNT(DISTINCT(ItemNumber)) AS ProductsSupplied
FROM products left join suppliers using (SupplierID)
GROUP BY SupplierID;

ALTER TABLE products
ADD CONSTRAINT uniq
UNIQUE (ItemName);

ALTER TABLE Products
ADD COLUMN Description VARCHAR(100);

  BEGIN;
  UPDATE Products
  SET Description = 'Black Tee with a Charizard graphic design, 100% Cotton, unisex'
  WHERE ItemName = 'CharizardTSHIRT';
  
  UPDATE Products
  SET Description = 'A Gengar plush toy, 5ft tall, machine washable'
  WHERE ItemName = 'GengarPLUSH';
  
  UPDATE Products
  SET Description = 'Black Tee with a Pokeball graphic design, 100% Cotton, unisex'
  WHERE ItemName = 'PokeballTSHIRT';
  
  UPDATE Products
  SET Description = 'Ceramic mug with MewTwo design'
  WHERE ItemName = 'MewTwoMug';
  
  UPDATE Products
  SET Description = 'A JigglyPuff plush toy, 5ft tall, machine washable'
  WHERE ItemName = 'JigglypuffPLUSH';

COMMIT;

Begin;

ALTER TABLE Products
CHANGE ItemNumber ProductID VARCHAR(32) NOT NULL;

COMMIT;

Begin;

DELETE FROM Suppliers
WHERE SupplierID = 1;

COMMIT;