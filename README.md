# Currier Service

The system simulates a courier company's pricing and delivery logic for Kiki "Company owner."

## Features
- Delivery cost for packages
- Applicable discounts based on offer codes
- Estimated delivery time using available vehicles

## Tech Stack
- Java 8
- Maven
- JUnit

## Setup
mvn clean install

## Run
- Compile
javac src/main/java/com/evereast/engineering/main/CourierServices.java
- Run
java src/main/java/com/evereast/engineering/main/CourierServices

## Sample Input
   Base Delivery Cost: 100
   No of Packages: 2

   Package ID 1: PKG1
   Weight 1: 50
   Distance 1: 30
   Offer Code 1: OFR001

   Package ID 2: PKG2
   Weight 2: 75
   Distance 2: 125
   Offer Code 2: OFR008

   No of Vehicles: 2
   Max Speed: 70
   Max Weight: 200

## Sample Output
   PKG1 0.0 750.0 0.0
   PKG2 0.0 1475.0 0.0


## Tests
mvn test


## Author
- Shamsan Gaber
