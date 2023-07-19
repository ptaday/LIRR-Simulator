# LIRR-Simulator

> A java application to model a Long Island Rail Road (LIRR) morning service with first and second-class passengers, and calculate average wait times and the number of passengers served.

## Table of Contents

- [Description](#description)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Usage](#usage)
- [Required Classes](#required-classes)
  - [Passenger](#passenger)
  - [PassengerQueue](#passengerqueue)
  - [BooleanSource](#booleansource)
  - [Station](#station)
  - [Train](#train)
  - [LIRRSimulator](#lirrsimulator)
- [Contributing](#contributing)
- [License](#license)
- [Contact](#contact)

## Description

The LIRR-Simulator project models the Long Island Rail Road (LIRR) morning service with two classes of passengers - first and second class. It aims to calculate the average wait time for passengers of each class at different stations and the number of passengers served. The simulation considers passenger arrivals at stations with probabilities for first and second-class passengers. Trains start at Huntington every 5 minutes and take 5 minutes between stations. The simulation also allows specifying a time when passengers stop showing up for the morning commute.

## Prerequisites
To run the DeliveryListManager project, ensure you have the following installed on your computer:

Java Development Kit (JDK) 1.8 or later
Git (optional, for cloning the repository)


## Installation

1. Clone the LIRR-Simulator repository to your local machine (if you haven't already).

```bash
$ git clone https://github.com/yourusername/LIRR-Simulator.git
$ cd LIRR-Simulator
```
## Usage
To compile 
```bash
$ javac LirrSimulator.java
```
Run the DeliveryListManager application from the command line.
```bash
$ java LirrSimulator
```
Follow the on-screen prompts to provide input for passenger probabilities, train schedule, and other simulation parameters.

The simulation will calculate the average wait time for first and second-class passengers at each station and display the number of passengers served.

Keep in my mind to create a package name and include the package name in all the classes.

## Required Classes
### Passenger
A fully-documented class named Passenger which contains an integer id, the arrival time, and a boolean for isFirstClass. This class contain methods that allow the user to manipulate the instance variables (getters, setters, etc.).

### PassengerQueue
A fully-documented class called PassengerQueue that has all the regular queue methods. It may have its own class using an array or a linked list, or extend a class implementing the List<T> interface (ie: ArrayList or LinkedList). 

### BooleanSource
Basically an object is constructed with a probability p between 0 and 1 and then the occurs() method returns true p*100% of the time.

### Station
A fully-documented class that simulates a station. It must contain two queues, two boolean source instances - one to generate arrivals for first class, and one to generate arrivals for the second class.

### Train
A fully-documented class called Train to simulate trains. It will contain a queue (or another data structure) of the stations the train has to visit (at time%5==0, a new station is dequeued, the list of stations is initialized to contain all the stations on the line, in order). It will also contain a method to simulate station arrival, where passengers are dequeued.

### LIRRSimulator
A fully-documented class called LIRRSimulator. It should have some sort of list of stations, some list of trains currently on the line, and some global variables for the number of passengers served, and other useful statistics (see sample I/O for expected end-of-run statistics).

## Contributing
Contributions to LIRR-Simulator are welcome! If you find any issues or have suggestions for improvements, please feel free to open an issue or submit a pull request.

## License
This project is licensed under the MIT License.

## Contact
If you have any questions or feedback, you can contact the project maintainer at:

Email: pmtaday@gmail.com
GitHub: @ptaday
