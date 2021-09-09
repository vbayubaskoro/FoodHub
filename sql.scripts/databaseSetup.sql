
drop table if exists TableOrdersFood;
drop table if exists MenuContainsDrink;
drop table if exists RestaurantHasIngredient;
drop table if exists FoodUsesIngredient;
drop table if exists Ingredient1;
drop table if exists Ingredient2;
drop table if exists Drink1;
drop table if exists Drink2;
drop table if exists Drink3;
drop table if exists Food1;
drop table if exists Food2;
drop table if exists Reservation;
drop table if exists TableAtRestaurant;
drop table if exists EmployeeAtRestaurant;
drop table if exists MenuAtRestaurant;
drop table if exists CustomerHasMembership;
drop table if exists RestaurantHasParking;
drop table if exists Restaurant;
drop table if exists Customer1;
drop table if exists Customer2;
drop table if exists ParkingLot;


CREATE TABLE Ingredient1 (
                             In1_Name varchar(45) not null PRIMARY KEY,
                             IngredientType varchar(20)
);

INSERT INTO Ingredient1 VALUES ('Green Onion', 'Vegetable');
INSERT INTO Ingredient1 VALUES ('Lettuce', 'Vegetable');
INSERT INTO Ingredient1 VALUES ('Chicken', 'Meat');
INSERT INTO Ingredient1 VALUES ('Beef', 'Meat');
INSERT INTO Ingredient1 VALUES ('Cheese', 'Dairy');

CREATE TABLE Ingredient2 (
                             IngredientID integer not null PRIMARY KEY,
                             In2_Name varchar(45) not null UNIQUE
);

INSERT INTO Ingredient2 VALUES (1, 'Green Onion');
INSERT INTO Ingredient2 VALUES (2, 'Lettuce');
INSERT INTO Ingredient2 VALUES (3, 'Chicken');
INSERT INTO Ingredient2 VALUES (4, 'Beef');
INSERT INTO Ingredient2 VALUES (5, 'Cheese');


CREATE TABLE Drink1 (
                        Dr1_Name varchar(20) not null PRIMARY KEY,
                        hasAlcohol bit(1)
);

INSERT INTO Drink1 VALUES ('Coffee', 0);
INSERT INTO Drink1 VALUES ('Tea', 0);
INSERT INTO Drink1 VALUES ('Water', 0);
INSERT INTO Drink1 VALUES ('Beer', 1);
INSERT INTO Drink1 VALUES ('Wine', 1);

CREATE TABLE Drink2 (
                        Dr2_Name varchar(20) not null PRIMARY KEY,
                        hasIce bit(1)
);

INSERT INTO DRINK2 VALUES ('Coffee', 0);
INSERT INTO DRINK2 VALUES ('Tea', 0);
INSERT INTO DRINK2 VALUES ('Water', 1);
INSERT INTO DRINK2 VALUES ('Beer', 1);
INSERT INTO DRINK2 VALUES ('Wine', 1);

CREATE TABLE Drink3 (
                        DrinkID integer not null PRIMARY KEY,
                        Dr3_Name varchar(20) not null UNIQUE
);

INSERT INTO Drink3 VALUES (1, 'Coffee');
INSERT INTO Drink3 VALUES (2, 'Tea');
INSERT INTO Drink3 VALUES (3, 'Water');
INSERT INTO Drink3 VALUES (4, 'Beer');
INSERT INTO Drink3 VALUES (5, 'Wine');



CREATE TABLE Food1 (
                       Fo1_Name varchar(45) not null PRIMARY KEY,
                       FoodType varchar(20)
);

INSERT INTO Food1 VALUES ('Burger', 'Other');
INSERT INTO Food1 VALUES ('Salad', 'Vegetarian');
INSERT INTO Food1 VALUES ('Soup', 'Vegan');
INSERT INTO Food1 VALUES ('Cake', 'Gluten-free');
INSERT INTO Food1 VALUES ('Omelet', 'Vegetarian');

CREATE TABLE Food2 (
                       FoodID integer not null PRIMARY KEY,
                       FO2_Name varchar(20) not null UNIQUE
);

INSERT INTO Food2 VALUES (1, 'Burger');
INSERT INTO Food2 VALUES (2, 'Salad');
INSERT INTO Food2 VALUES (3, 'Soup');
INSERT INTO Food2 VALUES (4, 'Cake');
INSERT INTO Food2 VALUES (5, 'Omelet');

CREATE TABLE Restaurant (
                            RestaurantID integer not null,
                            RestaurantName varchar(45) not null UNIQUE,
                            RestaurantLocation varchar(20),
                            TypeOfCuisine varchar(20),
                            primary key (RestaurantID, RestaurantName)
);

INSERT INTO Restaurant VALUES (1, 'Sushi Mura', '123 Street Ave', 'Japanese');
INSERT INTO Restaurant VALUES (2, 'Tacofino', '123 Street Ave', 'Mexican');
INSERT INTO Restaurant VALUES (3, 'Ramen Dunbo', '123 Street Ave', 'Japanese');
INSERT INTO Restaurant VALUES (4, 'Cactus Club', '123 Street Ave', 'Italian');
INSERT INTO Restaurant VALUES (5, 'Crusty Crab', '123 Street Ave', 'Chinese');



CREATE TABLE Customer1 (
                           Cu1_Name varchar(45) not null,
                           Cu1_Phone integer not null,
                           CustomerAddress varchar(45) not null,
                           primary key (Cu1_Name, Cu1_Phone)

);
INSERT INTO Customer1 VALUES ('Miley Cyrus', 123, '123 Malibu');
INSERT INTO Customer1 VALUES ('Sponge Bob', 123, '123 Malibu');
INSERT INTO Customer1 VALUES ('David Beckham', 123, '123 Malibu');
INSERT INTO Customer1 VALUES ('Snoop Dog', 123, '123 Malibu');
INSERT INTO Customer1 VALUES ('Billie Jean', 123, '123 Malibu');

CREATE TABLE Customer2 (
                           CustomerID integer not null PRIMARY KEY,
                           Cu2_Name varchar(45) not null unique,
                           Cu2_Phone integer not null
);

INSERT INTO Customer2 VALUES (10, 'Miley Cyrus', 123);
INSERT INTO Customer2 VALUES (11, 'Sponge Bob', 123);
INSERT INTO Customer2 VALUES (12,'David Beckham', 123);
INSERT INTO Customer2 VALUES (13,'Snoop Dog', 123);
INSERT INTO Customer2 VALUES (14, 'Billie Jean', 123);



CREATE TABLE ParkingLot (
                            LotID integer not null PRIMARY KEY,
                            HourlyRate integer not null,
                            TotalSpots integer not null,
                            AvailableSpots integer not null
);

INSERT INTO ParkingLot VALUES (1, 1, 10, 3);
INSERT INTO ParkingLot VALUES (2, 2, 8, 3);
INSERT INTO ParkingLot VALUES (3, 3, 10, 2);
INSERT INTO ParkingLot VALUES (4, 1, 7, 3);
INSERT INTO ParkingLot VALUES (5, 1, 10, 1);

CREATE TABLE EmployeeAtRestaurant (
                                      EmployeeID integer not null PRIMARY KEY,
                                      EmployeeName varchar(45) not null unique,
                                      EmployeeRole varchar(20) not null,
                                      RestaurantID integer not null,
                                      EmployeeSalary integer not null,
                                      EmployeeHours integer not null,
                                      foreign key (RestaurantID) references Restaurant(RestaurantID) ON DELETE CASCADE
);

INSERT INTO EmployeeAtRestaurant VALUES (20, 'Ben', 'Server', 1, 11,20);
INSERT INTO EmployeeAtRestaurant VALUES (21, 'Lesley', 'Server', 2, 10,20);
INSERT INTO EmployeeAtRestaurant VALUES (22, 'Irina', 'Manager', 3, 20,40);
INSERT INTO EmployeeAtRestaurant VALUES (23, 'Sammy', 'Server', 4, 18,20);
INSERT INTO EmployeeAtRestaurant VALUES (24, 'Grace', 'Manager', 5, 30,40);
INSERT INTO EmployeeAtRestaurant VALUES (25, 'Vanessa', 'Cook', 1, 11,40);
INSERT INTO EmployeeAtRestaurant VALUES (26, 'Lucas', 'Cook', 1, 10,35);
INSERT INTO EmployeeAtRestaurant VALUES (27, 'Aathavan', 'Server', 1, 9,40);
INSERT INTO EmployeeAtRestaurant VALUES (28, 'Shu Ting', 'Server', 1, 12,35);
INSERT INTO EmployeeAtRestaurant VALUES (29, 'Mark', 'Cook', 1, 11,39);

CREATE TABLE TableAtRestaurant (
                                   TableID integer not null,
                                   NumberOfSeats integer not null,
                                   InsideOrOutside bit(1) not null,
                                   RestaurantID integer not null,
                                   primary key (TableID, RestaurantID),
                                   foreign key (RestaurantID) references Restaurant(RestaurantID) ON DELETE CASCADE

);

INSERT INTO TableAtRestaurant VALUES (1, 4, 0,1);
INSERT INTO TableAtRestaurant VALUES (2, 5, 1,1);
INSERT INTO TableAtRestaurant VALUES (3, 3, 0,1);
INSERT INTO TableAtRestaurant VALUES (4, 2, 1,1);
INSERT INTO TableAtRestaurant VALUES (5, 10, 0,1);
INSERT INTO TableAtRestaurant VALUES (6, 6, 1,2);
INSERT INTO TableAtRestaurant VALUES (7, 4, 0,2);
INSERT INTO TableAtRestaurant VALUES (8, 4, 1,3);
INSERT INTO TableAtRestaurant VALUES (9, 10, 0,3);
INSERT INTO TableAtRestaurant VALUES (10, 4, 0,4);
INSERT INTO TableAtRestaurant VALUES (11, 4, 0,4);
INSERT INTO TableAtRestaurant VALUES (12, 4, 0,5);
INSERT INTO TableAtRestaurant VALUES (13, 4, 0,5);


CREATE TABLE MenuAtRestaurant (
                                  MenuID integer not null PRIMARY KEY,
                                  MenuType varchar(20) not null,
                                  NumberOfItems integer not null,
                                  RestaurantID integer not null,
                                  foreign key (RestaurantID) references Restaurant(RestaurantID) ON DELETE CASCADE


);

INSERT INTO MenuAtRestaurant VALUES (1, 'Lunch', 3, 1);
INSERT INTO MenuAtRestaurant VALUES (2, 'Dinner', 3, 2);
INSERT INTO MenuAtRestaurant VALUES (3, 'Lunch', 3, 3);
INSERT INTO MenuAtRestaurant VALUES (4, 'Lunch', 3, 4);
INSERT INTO MenuAtRestaurant VALUES (5, 'Brunch', 3, 5);

CREATE TABLE Reservation (
                             CustomerID integer not null,
                             TableID integer not null,
                             ReservationDay varchar(20) not null,
                             primary key (CustomerID, TableID),
                             foreign key (CustomerID) references Customer2(CustomerID) ON DELETE CASCADE,
                             foreign key (TableID) references TableAtRestaurant(TableID) ON DELETE CASCADE
);

INSERT INTO Reservation VALUES (10, 1, '2021-03-01-15');
INSERT INTO Reservation VALUES (10, 2, '2021-03-04-12');
INSERT INTO Reservation VALUES (10, 3, '2021-03-06-9');
INSERT INTO Reservation VALUES (10, 4, '2021-03-09-11');
INSERT INTO Reservation VALUES (10, 5, '2021-03-11-20');
INSERT INTO Reservation VALUES (11, 6, '2021-03-25-22');
INSERT INTO Reservation VALUES (11, 7, '2021-03-11-21');
INSERT INTO Reservation VALUES (11, 8, '2021-03-11-12');
INSERT INTO Reservation VALUES (11, 9, '2021-03-13-19');
INSERT INTO Reservation VALUES (11, 10, '2021-03-11-14');
INSERT INTO Reservation VALUES (11, 11, '2021-03-11-17');
INSERT INTO Reservation VALUES (11, 12, '2021-03-21-20');
INSERT INTO Reservation VALUES (11, 13, '2021-03-11-20');

CREATE TABLE FoodUsesIngredient (
                                    FoodID integer not null,
                                    IngredientID integer not null,
                                    IngredientQuantity integer not null,
                                    primary key (FoodID, IngredientID),
                                    foreign key (FoodID) references Food2(FoodID) ON DELETE CASCADE,
                                    foreign key (IngredientID) references Ingredient2(IngredientID) ON DELETE CASCADE
);

INSERT INTO FoodUsesIngredient VALUES (1,1,1);
INSERT INTO FoodUsesIngredient VALUES (2,2,1);
INSERT INTO FoodUsesIngredient VALUES (3,3,1);
INSERT INTO FoodUsesIngredient VALUES (4,4,1);
INSERT INTO FoodUsesIngredient VALUES (5,5,1);

CREATE TABLE MenuContainsDrink (
                                   DrinkID integer not null,
                                   MenuID integer not null,
                                   DrinkPrice integer not null,
                                   primary key (DrinkID, MenuID),
                                   foreign key (DrinkID) references Drink3(DrinkID) ON DELETE CASCADE,
                                   foreign key (MenuID) references MenuAtRestaurant(MenuID) ON DELETE CASCADE
);

INSERT INTO MenuContainsDrink VALUES (1,1,3);
INSERT INTO MenuContainsDrink VALUES (1,2,3);
INSERT INTO MenuContainsDrink VALUES (1,3,3);
INSERT INTO MenuContainsDrink VALUES (1,4,3);
INSERT INTO MenuContainsDrink VALUES (1,5,3);

CREATE TABLE RestaurantHasIngredient (
                                         IngredientID integer not null,
                                         RestaurantID integer not null,
                                         RestockDay varchar(20) not null,
                                         primary key (IngredientID, RestaurantID),
                                         foreign key (IngredientID) references Ingredient2(IngredientID) ON DELETE CASCADE,
                                         foreign key (RestaurantID) references Restaurant(RestaurantID) ON DELETE CASCADE

);

INSERT INTO RestaurantHasIngredient VALUES (1,1, '2021-04-05');
INSERT INTO RestaurantHasIngredient VALUES (1,2, '2021-04-05');
INSERT INTO RestaurantHasIngredient VALUES (1,3, '2021-04-05');
INSERT INTO RestaurantHasIngredient VALUES (1,4, '2021-04-05');
INSERT INTO RestaurantHasIngredient VALUES (1,5, '2021-04-05');

CREATE TABLE CustomerHasMembership (
                                       RestaurantID integer not null,
                                       CustomerID integer not null,
                                       MembershipTier varchar(20),
                                       primary key (RestaurantID, CustomerID),
                                       foreign key (RestaurantID) references Restaurant(RestaurantID) ON DELETE CASCADE,
                                       foreign key (CustomerID) references Customer2(CustomerID) ON DELETE CASCADE
);

INSERT INTO CustomerHasMembership Values (1,10,'Silver');
INSERT INTO CustomerHasMembership Values (1,11,'Silver');
INSERT INTO CustomerHasMembership Values (1,12,'Silver');
INSERT INTO CustomerHasMembership Values (1,13,'Silver');
INSERT INTO CustomerHasMembership Values (1,14,'Silver');

CREATE TABLE TableOrdersFood (
                                 TableID integer not null,
                                 FoodID integer not null,
                                 OrderTime integer not null,
                                 primary key (TableID, FoodID),
                                 foreign key (TableID) references TableAtRestaurant(TableID) ON DELETE CASCADE,
                                 foreign key (FoodID) references Food2(FoodID) ON DELETE CASCADE

);

INSERT INTO TableOrdersFood VALUES (1,2,3);
INSERT INTO TableOrdersFood VALUES (2,2,4);
INSERT INTO TableOrdersFood VALUES (3,2,5);
INSERT INTO TableOrdersFood VALUES (4,2,6);
INSERT INTO TableOrdersFood VALUES (5,2,7);

CREATE TABLE RestaurantHasParking (
                                      RestaurantID integer not null,
                                      LotID integer not null,
                                      DistanceFromRestaurant integer not null,
                                      primary key (RestaurantID, LotID),
                                      foreign key (RestaurantID) references Restaurant(RestaurantID) ON DELETE CASCADE,
                                      foreign key (LotID) references ParkingLot(LotID) ON DELETE CASCADE

);

INSERT INTO RestaurantHasParking VALUES (1,1,3);
INSERT INTO RestaurantHasParking VALUES (2,1,6);
INSERT INTO RestaurantHasParking VALUES (3,1,3);
INSERT INTO RestaurantHasParking VALUES (4,1,8);


show tables;




