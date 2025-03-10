CREATE TABLE Vendor (
    VendorID INT NOT NULL,
    Name VARCHAR(255) NOT NULL,
    MinimumPurchaseRequirement INT NOT NULL,
  	CONSTRAINT VendorID_PK PRIMARY KEY (VendorID));

CREATE TABLE Size (
  SizeID INT NOT NULL,
  Description VARCHAR(50) NOT NULL,
  CONSTRAINT SizeID_PK Primary KEY (SizeID));

CREATE TABLE Product (
    ProductID INT NOT NULL,
    Color VARCHAR(50) NOT NULL,
    Shape VARCHAR(50) NOT NULL,
    SizeID INT NOT NULL,
    Function VARCHAR(255) NOT NULL,
    VendorID INT NOT NULL,
  	CONSTRAINT ProductID_PK PRIMARY KEY (ProductID),
    CONSTRAINT VendorID_FK FOREIGN KEY (VendorID) REFERENCES Vendor(VendorID),
  	CONSTRAINT SizeID_FK FOREIGN KEY (SizeID) REFERENCES Size(SizeID));
