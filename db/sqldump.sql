#Drop the tables
DROP TABLE IF EXISTS OrderItems;
DROP TABLE IF EXISTS Orders;
DROP TABLE IF EXISTS ProductQA;
DROP TABLE IF EXISTS CustomerReviews;
DROP TABLE IF EXISTS Products;
DROP TABLE IF EXISTS ProductCategories;
DROP TABLE IF EXISTS CreditCards;
DROP TABLE IF EXISTS Users;

#Create the tables
CREATE TABLE Users
(
  Id INT NOT NULL AUTO_INCREMENT,
  FirstName VARCHAR(45),
  LastName VARCHAR(45),
  Address VARCHAR(45),
  City VARCHAR(45),
  State VARCHAR(45),
  PostalCode VARCHAR(45),
  EmailAddress VARCHAR(45),
  PhoneNumber VARCHAR(45),
  Birthday VARCHAR(45),
  Type TINYINT(1), /*Customer or Seller*/
  Status TINYINT(1), /*Active or In-active*/
  NumOfVisits INT(4),
  Username VARCHAR(255),
  Password VARCHAR(255),
  PRIMARY KEY (Id)
);

CREATE Table CreditCards
(
  Id INT NOT NULL AUTO_INCREMENT,
  CardHolderName VARCHAR(255),
  CreditCardNumber CHAR(20) NOT NULL,
  Balance DECIMAL(16, 2),
  CardType VARCHAR(45),
  UserId INT,
  CVV CHAR(4),
  ExpirationDate DATE,
  PRIMARY KEY (Id),
  UNIQUE (CreditCardNumber),
  FOREIGN KEY (UserId) REFERENCES Users(Id)
);

CREATE Table ProductCategories
(
  Id INT NOT NULL AUTO_INCREMENT,
  ProductCategory VARCHAR(255),
  PRIMARY KEY (Id)
);

CREATE Table Products
(
  Id INT NOT NULL AUTO_INCREMENT,
  ProductName VARCHAR(255),
  ProductCategoryIndex INT,
  ProductDescription BLOB,
  Price DOUBLE,
  AvailableQuantity INT,
  EstimatedDeliveryDays INT,
  SellerId INT,
  ProductPhotosLinks  BLOB,
  ProductVideosLinks BLOB,
  ProductThumbnail BLOB,
  PRIMARY KEY (Id),
  FOREIGN KEY (SellerId) REFERENCES Users(Id),
  FOREIGN KEY (ProductCategoryIndex) REFERENCES ProductCategories(Id)
);

CREATE Table CustomerReviews
(
  Id INT NOT NULL AUTO_INCREMENT,
  ProductId INT,
  CustomerId INT,
  ReviewDate VARCHAR(40),
  Rating TINYINT(1),
  Review VARCHAR(255),
  PRIMARY KEY (Id),
  FOREIGN KEY (ProductId) REFERENCES Products(Id),
  FOREIGN KEY (CustomerId) REFERENCES Users(Id)
);

CREATE Table ProductQA
(
  Id INT NOT NULL AUTO_INCREMENT,
  ProductId INT,
  CustomerId INT,
  Question VARCHAR(255),
  Answer VARCHAR(255),
  PRIMARY KEY (Id),
  FOREIGN KEY (ProductId) REFERENCES Products(Id),
  FOREIGN KEY (CustomerId) REFERENCES Users(Id)
);

CREATE Table Orders
(
  Id INT NOT NULL AUTO_INCREMENT,
  CustomerId INT,
  TotalCost INT,
  OrderDate VARCHAR(40),
  ShippingAddress VARCHAR(255),
  BillingAddress VARCHAR(255),
  CreditCardNumber CHAR(20),
  PRIMARY KEY (Id),
  FOREIGN KEY (CustomerId) REFERENCES Users(Id)
);

CREATE Table OrderItems
(
  Id INT NOT NULL AUTO_INCREMENT,
  OrderId INT,
  SellerId INT,
  ProductId INT,
  ProductPrice INT,
  Quantity INT,
  ShippingStatus TINYINT(1), /*Shipped or Not yet shipped*/
  ShippingRefNo INT,
  Status TINYINT(1), /*Ex: Cancelled, OrderPlaced*/
  PRIMARY KEY (Id),
  FOREIGN KEY (OrderId) REFERENCES Orders(Id),
  FOREIGN KEY (ProductId) REFERENCES Products(Id)
);


#Test Data
## Users
INSERT INTO Users (Username) VALUES ("CoolSeller123");
INSERT INTO Users (Username) VALUES ("NonbinaryParents");
INSERT INTO Users (Username) VALUES ("RadPlaidLad");

## Product Categories
INSERT INTO ProductCategories (ProductCategory) VALUES ("Camping/Hiking");
INSERT INTO ProductCategories (ProductCategory) VALUES ("Electronic");
INSERT INTO ProductCategories (ProductCategory) VALUES ("Kitchen");
INSERT INTO ProductCategories (ProductCategory) VALUES ("Office");

## Products
INSERT INTO Products (ProductName, ProductCategoryIndex, SellerId, ProductDescription, Price, AvailableQuantity, EstimatedDeliveryDays, ProductPhotosLinks, ProductThumbnail) VALUES
  ("24-Inch Desktop Monitor", 2, 1, "This desktop monitor can serve many purposes. It accepts HDMI and has HD Audio output.",159.99, 25, 7, "http://www.publicdomainpictures.net/pictures/20000/nahled/computer-monitor-isolated-113001152897GC.jpg", "http://www.publicdomainpictures.net/pictures/20000/nahled/computer-monitor-isolated-113001152897GC.jpg");

INSERT INTO Products (ProductName, ProductCategoryIndex, SellerId, ProductDescription, Price, AvailableQuantity, EstimatedDeliveryDays, ProductPhotosLinks, ProductThumbnail) VALUES
  ("Mini Desktop Tower", 2, 2, "This small tower is suitable for a child's first computer. It comes with a variety of stickers.", 79.99, 15, 7, "http://maxpixel.freegreatpicture.com/static/photo/1x/Hosting-Server-Computer-Workstation-158474.png", "http://maxpixel.freegreatpicture.com/static/photo/1x/Hosting-Server-Computer-Workstation-158474.png");

SELECT * FROM ProductCategories;
SELECT * FROM Users;
SELECT * FROM Products;

# TODO: Add full entries for all the pages.
