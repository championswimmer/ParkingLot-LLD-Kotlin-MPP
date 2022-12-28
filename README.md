# Parking Lot (CLI) - Kotlin Multiplatform

[![Test](https://github.com/championswimmer/ParkingLot-LLD-Kotlin-MPP/actions/workflows/test.yml/badge.svg)](https://github.com/championswimmer/ParkingLot-LLD-Kotlin-MPP/actions/workflows/test.yml)
[![Build (and Release)](https://github.com/championswimmer/ParkingLot-LLD-Kotlin-MPP/actions/workflows/build.yml/badge.svg)](https://github.com/championswimmer/ParkingLot-LLD-Kotlin-MPP/actions/workflows/build.yml)
[![GitHub release (latest by date)](https://img.shields.io/github/v/release/championswimmer/ParkingLot-LLD-Kotlin-MPP)](https://github.com/championswimmer/ParkingLot-LLD-Kotlin-MPP/releases)

A CLI-based parking lot (low-level-design case study) implemented 
with Kotlin Multiplatform. 

This compiles down to the following platforms 

- JVM (Java 17) - fat jar file bat/sh script to execute 
- JS (NodeJS) - single `.js` file to execute
- Native (MacOS) - single binary to execute
- Native (Linux) - single binary to execute
- Native (Windows) - single binary to execute


## Usage

### CLI Operations

#### Create a parking lot

```shell
Parking Lot Program Started
How many floors are there in the parking lot?: 
> 1
How many CAR slots are there on floor 0?: 
> 5
How many TRUCK slots are there on floor 0?: 
> 5
How many BIKE slots are there on floor 0?: 
> 5
------------------------------
Lot 0 Status:
---------------
Floor 0 Status:
Type       Empty
CAR       5
TRUCK       5
BIKE       5
```
#### Park A Vehicle 

```shell
Pick an opertation: (enter the number) 
1. Park a vehicle
2. Unpark a vehicle
3. Get status of the parking lot: 
> 1
What type of vehicle is it? CAR | TRUCK | BIKE: 
> CAR
What is the registration number of the vehicle?: 
> KA-01-4545
What is the color of the vehicle? WHITE | BLACK | RED | BLUE | GREEN | YELLOW | ORANGE | PURPLE | BROWN | GREY | PINK: 
> RED
What is the brand of the vehicle?: 
> Mahindra
What is the model of the vehicle?: 
> Thar
MESSAGE: Vehicle parked successfully with at 0-0-0
```

#### Print Status of Parking Lot 

```shell
Pick an opertation: (enter the number) 
1. Park a vehicle
2. Unpark a vehicle
3. Get status of the parking lot: 
> 3
------------------------------
Lot 0 Status:
---------------
Floor 0 Status:
Type       Empty
CAR       4
TRUCK       5
BIKE       5
```

#### Unpark a Vehicle 

```shell
Pick an opertation: (enter the number) 
1. Park a vehicle
2. Unpark a vehicle
3. Get status of the parking lot: 
> 2
Enter the registration number of the vehicle to unpark: 
> KA-01-4545
MESSAGE: Vehicle found
Vehicle(registrationNumber=KA-01-4545, color=RED, type=CAR, brand=Mahindra, model=Thar)
Confirm unpark? Y/N (default: N): 
> Y
MESSAGE: Vehicle unparked successfully
```