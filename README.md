#  OpenCart Automation Testing – Hybrid Framework

This project is a **Hybrid Test Automation Framework** developed for testing the OpenCart e-commerce web application.  
It integrates multiple automation design patterns and tools to ensure scalability, maintainability, and reusability of test scripts.

---

## 📌 Project Overview

The framework automates key functional flows of the OpenCart application, including:

- User Account Registration
- Login Functionality
- Data-Driven Login Testing
- Product Search
- Order Checkout
- End-to-End Purchase Flow

It follows a **Hybrid approach** combining:

- Page Object Model (POM)
- Data-Driven Testing (DDT)
- TestNG Framework
- Maven Build Management

---

##  Tech Stack

| Tool / Technology | Purpose |
|------------------|---------|
| Java | Programming language |
| Selenium WebDriver | Browser automation |
| TestNG | Test execution & reporting |
| Maven | Dependency management |
| Extent Reports | HTML reporting |
| Log4j2 | Logging |
| Apache POI | Excel data handling |
| Docker Grid | Parallel execution |

---

## 📂 Project Structure

```
OpenCart-AutomationTest-Hybrid_Framework
│
├── src/test/java
│   ├── PageObjects
│   ├── testBase
│   ├── testCases
│   └── utilities
│
├── src/test/resources
│   ├── config.properties
│   └── log4j2.xml
│
├── testData
├── reports
├── logs
├── docker-compose.yaml
├── pom.xml
└── testng XML files
```

---

##  Features

- ✔️ Page Object Model implementation  
- ✔️ Data-Driven Testing using Excel  
- ✔️ Reusable utility functions  
- ✔️ Centralized configuration management  
- ✔️ Rich Extent HTML reports  
- ✔️ Logging with Log4j2  
- ✔️ Cross-browser support  
- ✔️ Docker Selenium Grid execution  

---

##  Test Scenarios Covered

| Test Case ID | Scenario |
|--------------|----------|
| TC001 | Account Registration |
| TC002 | Login Test |
| TC003 | Login Data-Driven Test |
| TC005 | Search Product |
| TC006 | Order Checkout |
| TC007 | End-to-End Flow |

---

##  Prerequisites

Make sure you have installed:

- Java JDK 8 or higher
- Maven
- Eclipse / IntelliJ IDEA
- Chrome / Firefox browsers
- Docker (optional)

---

##  How to Run Tests


### Run via Maven
```
mvn test
```

### Run via TestNG
Run the suite XML files from your IDE.

---

## 📊 Reports & Logs

- Extent Reports → /reports/
- TestNG Reports → /test-output/
- Logs → /logs/

---

## 👤 Author

**Mahadi Hasan**  

