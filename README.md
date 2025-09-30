# Patient Appointment Management System (PAMS)

A Command-Line Interface (CLI) application for managing patient appointments in a hospital system.

## Features

- Patient registration and management
- Patient data storage with JSON format
- Age calculation and sorting
- Executable JAR distribution
- CI/CD pipeline with GitHub Actions

## Patient Data Fields

- Patient ID
- First Name
- Last Name
- Contact Phone Number
- Email Address
- Mailing Address
- Date of Birth
- Age (calculated automatically)

## Prerequisites

- Java 17 or higher
- Maven 3.6 or higher

## Building the Project

```bash
# Clone the repository
git clone <repository-url>
cd pams

# Build the project
mvn clean compile

# Run tests
mvn test

# Create executable JAR
mvn clean package
```

## Running the Application

```bash
# Run the executable JAR
java -jar target/pams-1.0.0.jar
```

The application will:
1. Create patient data from predefined test data
2. Sort patients by age (oldest first)
3. Convert data to JSON format
4. Write the sorted patient data to `patients.json` file

## Project Structure

```
pams/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/
│   │           └── hospital/
│   │               └── pams/
│   │                   ├── Patient.java
│   │                   └── PAMSApp.java
│   └── test/
├── .github/
│   └── workflows/
│       └── ci-cd.yml
├── pom.xml
└── README.md
```

## CI/CD Pipeline

The project includes a GitHub Actions workflow that:
- Runs tests on push and pull requests
- Builds the executable JAR
- Creates releases with the JAR artifact

## Sample Output

The application processes the following patient data:

| ID | First Name | Last Name | Phone No | Email | Mailing Address | Date of Birth |
|----|------------|-----------|----------|-------|-----------------|---------------|
| 1  | Daniel     | Agar      | (641) 123-0009 | dagar@m.as | 1 N Street | 1987-1-19 |
| 2  | Ana        | Smith     | - | amsith@te.edu | - | 1948-12-5 |
| 3  | Marcus     | Garvey    | (123) 292-0018 | - | 4 East Ave | 2001-9-18 |
| 4  | Jeff       | Goldbloom | (999) 165-1192 | jgold@es.co.za | - | 1995-2-28 |
| 5  | Mary       | Washington | - | - | 30 W Burlington | 1932-5-31 |

Patients are sorted by age in descending order (oldest first) and saved to JSON format.

## Technologies Used

- Java 17
- Maven
- Jackson (JSON processing)
- GitHub Actions (CI/CD)
- Git (Version Control)

## Author

Created for Lab Assignment 2b - Patient Appointment Management System
