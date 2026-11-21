# Railway Reservation System (Java Console Project)

A backend-only Java console application for train search, seat availability, ticket reservations, PNR lookup, cancellation, and FIFO waiting-list promotion.

## 1. Project Overview

The Railway Reservation System is a Java-based console application designed to manage railway reservations.

The application allows users to search for trains, check seat availability, book tickets, view booking details using PNR numbers, cancel tickets, and manage waiting lists.

The entire application runs in a single console using Java. No frontend, GUI, database, or external libraries are required.

## 2. Features

- View all available trains.
- Search trains by source and destination.
- Check seat availability.
- Book railway tickets.
- Generate unique PNR numbers.
- View ticket details using PNR.
- Cancel booked tickets.
- Maintain a waiting list when seats are unavailable.
- Automatically promote waiting-list passengers when seats become available.
- View booking history.
- Handle invalid inputs and application-specific exceptions.

## 3. Technologies Used

- **Programming Language:** Java
- **JDK:** Java 17 or newer (Java 21 recommended)
- **IDE:** Visual Studio Code
- **Version Control:** Git
- **Repository Hosting:** GitHub
- **Input Handling:** Scanner
- **Collections:** ArrayList, HashMap, HashSet
- **Data Structure:** Custom FIFO Queue

## 4. Project Structure

```text
RailwayReservationSystem/
│
├── docs/
│   └── COMMIT_GUIDE.md
│
├── src/
│   └── main/
│       └── java/
│           │
│           ├── app/
│           │   └── Main.java
│           │
│           ├── datastructures/
│           │   └── WaitingListQueue.java
│           │
│           ├── exceptions/
│           │   ├── BookingNotFoundException.java
│           │   ├── InvalidTrainException.java
│           │   └── SeatNotAvailableException.java
│           │
│           ├── model/
│           │   ├── Admin.java
│           │   ├── Booking.java
│           │   ├── Passenger.java
│           │   ├── Train.java
│           │   └── User.java
│           │
│           ├── service/
│           │   ├── BookingService.java
│           │   ├── ReservationService.java
│           │   ├── SeatService.java
│           │   └── TrainService.java
│           │
│           └── util/
│               └── PNRGenerator.java
│
├── .gitignore
└── README.md
```

## 5. Object-Oriented Programming Concepts

The project implements all four pillars of Object-Oriented Programming.

### 5.1 Encapsulation

- Class variables are maintained using appropriate access modifiers.
- Getters and setters provide controlled access to object data.
- Passenger, Train and Booking information is encapsulated within their respective classes.

### 5.2 Inheritance

- Passenger and Admin classes inherit from the abstract User class.
- Common user properties and behaviours are reused through inheritance.

### 5.3 Polymorphism

- Method overriding is used to provide different implementations of common methods in subclasses.
- Objects can be handled through their common parent class.

### 5.4 Abstraction

- The User class provides a common abstract structure.
- Implementation details are provided by the respective subclasses.

## 6. Custom Exception Handling

The application implements custom exceptions to handle application-specific errors.

| Exception | Purpose |
|---|---|
| SeatNotAvailableException | Handles situations where seats are unavailable |
| InvalidTrainException | Handles invalid train selection |
| BookingNotFoundException | Handles requests for non-existing bookings |

These exceptions are handled using Java try-catch mechanisms.

## 7. Data Structures and Collections

### 7.1 Self-Implemented Queue

The project implements its own FIFO (First In, First Out) Queue for waiting-list management.

The Queue provides the following operations:

- **enqueue():** Adds a passenger to the waiting list.
- **dequeue():** Removes the passenger at the front.
- **peek():** Returns the next passenger without removing them.
- **isEmpty():** Checks whether the Queue is empty.

The Queue is implemented without directly relying on Java's built-in Queue implementation.

### 7.2 Java Collections Framework

| Collection | Usage |
|---|---|
| ArrayList | Stores trains and booking records |
| HashMap | Stores booking records using PNR as the key |
| HashSet | Maintains unique PNR numbers |

## 8. Application Menu

The application provides the following console menu:

```text
========================================
       RAILWAY RESERVATION SYSTEM
========================================

1. View All Trains
2. Search Train
3. Check Seat Availability
4. Book Ticket
5. View Ticket Details (PNR)
6. Cancel Ticket
7. View Waiting List
8. View All Bookings
9. Exit

Enter your choice:
```

## 9. Installation and Execution

### Prerequisites

Install Java Development Kit (JDK 17 or newer).

Verify the installation:

```bash
java -version
javac -version
```

### Step 1: Clone the Repository

```bash
git clone https://github.com/pallavikundapur23-hub/RailwayReservationSystem.git
```

### Step 2: Navigate to the Project

```bash
cd RailwayReservationSystem
```

### Step 3: Compile the Java Files

For Windows PowerShell:

```powershell
$files = Get-ChildItem -Recurse src/main/java -Filter *.java |
ForEach-Object { $_.FullName }

javac -d out $files
```

### Step 4: Run the Application

```bash
java -cp out app.Main
```

The entire application runs through one console using Main.java as the entry point.

## 10. GitHub Version Control

The project follows a feature-branch-based Git workflow with four Pull Requests.

| Pull Request | Branch | Implementation |
|---|---|---|
| PR 1 | feature/project-oop | Project setup and OOP implementation |
| PR 2 | feature/train-booking | Train search, seat availability and booking |
| PR 3 | feature/exceptions-dsa | Custom exceptions and Queue implementation |
| PR 4 | feature/cancellation-testing | Cancellation, waiting-list promotion and final console workflows |

### GitHub Contributions

- 15 planned development commits.
- 4 feature branches.
- 4 Pull Requests.
- All 4 Pull Requests successfully merged into the main branch.

The Git history also includes four merge commits created when merging the Pull Requests.

## 11. Testing Checklist

The following functionalities should be tested before submission:

- Application starts successfully in one console.
- All trains are displayed.
- Train search works correctly.
- Seat availability is displayed.
- Ticket booking generates a unique PNR.
- PNR lookup retrieves booking information.
- Custom exceptions handle invalid operations.
- Waiting-list Queue follows FIFO order.
- Ticket cancellation works correctly.
- Waiting-list promotion works when a seat becomes available.
- Booking history is displayed.
- Invalid user inputs are handled.


## 12. Conclusion

The Railway Reservation System demonstrates the practical implementation of Java Object-Oriented Programming, custom exception handling, Java Collections Framework and a self-implemented Queue data structure.

The project provides a console-based approach to railway reservation management, including train search, ticket booking, PNR generation, cancellation and waiting-list handling.

It also demonstrates collaborative software development practices through Git, feature branches, meaningful commits and GitHub Pull Requests.


