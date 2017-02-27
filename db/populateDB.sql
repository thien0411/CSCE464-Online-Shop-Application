INSERT INTO Users (Username) VALUES ("CoolSeller123");
INSERT INTO Users (Username) VALUES ("NonbinaryParents");
INSERT INTO Users (Username) VALUES ("RadPlaidLad");

INSERT INTO ProductCategories (ProductCategory) VALUES ("Camping/Hiking");
INSERT INTO ProductCategories (ProductCategory) VALUES ("Electronic");
INSERT INTO ProductCategories (ProductCategory) VALUES ("Kitchen");
INSERT INTO ProductCategories (ProductCategory) VALUES ("Office");

SELECT * FROM ProductCategories;
SELECT * FROM Users;

INSERT INTO Products (ProductName, ProductCategoryIndex, SellerId, ProductDescription,
  Price, AvailableQuantity)
  VALUES ("24-Inch Desktop Monitor", 2, 1,
  "This desktop monitor can serve many purposes. It accepts HDMI and has HD Audio output.",
  159.99, 25);

INSERT INTO Products (ProductName, ProductCategoryIndex, SellerId, ProductDescription,
  Price, AvailableQuantity)
  VALUES ("Mini Desktop Tower", 2, 2,
  "This small tower is suitable for a child's first computer. It comes with a variety of stickers.",
  79.99, 15);

SELECT * FROM Products;

# TODO: Add full entries for all the pages.