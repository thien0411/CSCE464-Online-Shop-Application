CREATE DATABASE CSCE464OnlineShoppingDB;

USE CSCE464OnlineShoppingDB;

CREATE TABLE Users
(
Id INT,
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
Id INT,
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
Id INT,
ProductCategory VARCHAR(255),
PRIMARY KEY (Id)
);

CREATE Table Products
(
Id INT,
ProductName VARCHAR(255),
ProducCategoryIndex INT,
ProductDescription BLOB,
Price INT,
AvailableQuantity INT,
EstimatedDeliveryDays INT,
SellerId INT,
ProductPhotosLinks  BLOB,
ProductVideosLinks BLOB,
ProductThumbnail BLOB,
PRIMARY KEY (Id),
FOREIGN KEY (SellerId) REFERENCES Users(Id),
FOREIGN KEY (ProducCategoryIndex) REFERENCES ProductCategories(Id)
);


CREATE Table CustomerReviews
(
Id INT,
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
Id INT,
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
Id INT, 
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
Id INT,
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




