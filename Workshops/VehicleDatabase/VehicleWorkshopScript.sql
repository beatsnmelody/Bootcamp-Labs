CREATE TABLE dealerships(
	dealershipID INT NOT NULL auto_increment,
    dealershipName VARCHAR(50),
    dealershipAddress VARCHAR(50),
    dealershipPhone VARCHAR(12),
    PRIMARY KEY (dealershipID)
);

CREATE TABLE vehicles(
	VIN INT NOT NULL,
    vehicleYear INT,
    make VARCHAR(50),
    model VARCHAR(50),
    vehicleType VARCHAR(20),
    color VARCHAR(50),
    odometer INT,
    price FLOAT,
    isSold BIT,
    isLeased BIT,
    PRIMARY KEY (VIN)
);

CREATE TABLE inventory(
	dealershipID INT,
    VIN INT,
    FOREIGN KEY (dealershipID) REFERENCES dealerships(dealershipID)
);

CREATE TABLE salescontracts(
	salesContractID INT NOT NULL auto_increment,
	VINOfVehicleSold INT,
	dateOfContract DATE,
    customerName VARCHAR(255),
    customerEmail VARCHAR(100),
    totalPrice FLOAT,
    salesTaxAmount FLOAT,
    recordingFee FLOAT,
    processingFee FLOAT,
    isFinanced BIT,
    monthlyPayment FLOAT,
    PRIMARY KEY (salesContractID),
    FOREIGN KEY (VINOfVehicleSold) REFERENCES vehicles (VIN)
);

CREATE TABLE leasecontracts(
	leaseContractID INT NOT NULL auto_increment,
    VINOfVehicleLeased INT,
    dateOfContract DATE,
    customerName VARCHAR(255),
    customerEmail VARCHAR(100),
    totalPrice FLOAT,
    monthlyPayment FLOAT,
    expectedEndingValue FLOAT,
    leaseFee FLOAT,
    PRIMARY KEY (leaseContractID),
    FOREIGN KEY (VINOfVehicleLeased) REFERENCES vehicles (VIN)
);

INSERT INTO dealerships(dealershipName, dealershipAddress, dealershipPhone)
VALUES('D & B Used Cars', '111 Old Benbrook Rd', '817-555-5555'),
('Sleazy Os Pre-Owned', '1997 Cyber St', '782-892-1997');

SELECT *
FROM dealerships;

INSERT INTO vehicles(VIN, vehicleYear, make, model, vehicleType, color, odometer, price, isSold, isLeased)
VALUES(10112, 1993, 'Ford', 'Explorer', 'SUV', 'Red', 525123, 995.00, 1, 0),
(37846, 2001, 'Ford', 'Ranger', 'Truck', 'Yellow', 172544, 1995.00, 0, 0),
(44901, 2012, 'Honda', 'Civic', 'SUV', 'Gray', 103221, 6995.00, 0 , 0),
(12345, 2018, 'Dodge', 'Charger', 'Car', 'Red', 123456, 50000.00, 0, 0),
(51245, 2019, 'Dodge', 'Challenger', 'Car', 'Gray', 205, 70000.00, 0 , 0),
(38393, 2021, 'Chevrolet', 'Silverado', 'Truck', 'Black', 2750, 31995.00, 0, 1);

SELECT *
FROM vehicles;

INSERT INTO inventory(dealershipID, VIN)
VALUES(1, 10112),
(1, 37846),
(1, 44901),
(1, 12345),
(1, 51245),
(1, 38393);

SELECT *
FROM inventory;

INSERT INTO salescontracts(VINOfVehicleSold, dateOfContract, customerName, customerEmail, totalPrice, salesTaxAmount, recordingFee, processingFee, isFinanced, monthlyPayment)
VALUES(10112, '2021-09-28', 'Dana Wyatt', 'dana@texas.com', 1439.75, 49.75, 100.00, 295.00, 0, 0.00);

SELECT *
FROM salescontracts;

INSERT INTO leasecontracts(VINOfVehicleLeased, dateOfContract, customerName, customerEmail, totalPrice, monthlyPayment, expectedEndingValue, leaseFee)
VALUES (38393, '2021-09-28', 'Zachary Westly', 'zach@texas.com', 18337.15, 541.39, 15997.50, 2239.65);

SELECT *
FROM leasecontracts;

