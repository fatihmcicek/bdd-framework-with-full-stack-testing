# BDD Web Test Automation Framework

This project is a BDD (Behavior Driven Development) test automation framework built for [Automation Exercise](https://automationexercise.com/), implementing best practices in test automation.

## 🔧 Technologies & Tools

![](https://img.shields.io/badge/Java-21-orange)
![](https://img.shields.io/badge/Selenium-4.15.0-green)
![](https://img.shields.io/badge/Cucumber-7.14.0-brightgreen)
![](https://img.shields.io/badge/TestNG-7.8.0-yellow)
![](https://img.shields.io/badge/Maven-3.11.0-red)

## 🏗️ Project Architecture

```plaintext
src
├── main
│   └── java
│       └── com
│           └── automation
│               ├── config
│               │   ├── ConfigReader.java
│               │   └── DriverConfig.java
│               ├── context
│               │   └── TestContext.java
│               ├── pages
│               │   ├── BasePage.java
│               │   ├── HomePage.java
│               │   └── ...
│               └── utils
│                   └── Helper.java
├── test
│   ├── java
│   │   └── com
│   │       └── automation
│   │           ├── runners
│   │           │   └── TestRunner.java
│   │           └── steps
│   │               ├── CommonSteps.java
│   │               └── ...
│   └── resources
│       ├── config
│       │   ├── config.properties
│       │   └── log4j2.xml
│       └── features
│           ├── TC01_register.feature
│           └── ...
└── test-output
    ├── cucumber-reports
    ├── extent-reports
    └── testng-reports
```

## 🎯 Test Scenarios

| Test Case ID | Description | Category | Priority |
|--------------|-------------|-----------|----------|
| TC01 | User Registration | Regression, Smoke | High |
| TC02 | Login with Valid Credentials | Regression, Smoke | High |
| TC03 | Login with Invalid Credentials | Regression | Medium |
| TC04 | Contact Us Form | Regression | Medium |
| TC05 | Test Cases Page Verification | Regression | Low |

## 🚀 Getting Started

### Prerequisites
- Java JDK 21
- Maven 3.8+
- Chrome/Firefox Browser
- IDE (IntelliJ IDEA recommended)

### Setup & Installation

1. Clone the repository:
```bash
git clone https://github.com/fatihmcicek/bdd-framework-with-full-stack-testing.git
```

2. Install dependencies:
```bash
mvn clean install -DskipTests
```

### Running Tests

#### All Tests:
```bash
mvn clean test
```

#### Specific Test Tags:
```bash
# Run Smoke Tests
mvn test -Dcucumber.filter.tags="@smoke"

# Run Regression Tests
mvn test -Dcucumber.filter.tags="@regression"
```

#### Using TestNG XML:
```bash
mvn test -DsuiteXmlFile=testng.xml
```

## 📊 Test Reports

Reports are generated in the `test-output` directory:

```plaintext
test-output/
├── cucumber-reports/
│   └── cucumber-pretty.html
├── extent-reports/
│   └── ExtentReport.html
└── testng-reports/
    └── index.html
```

## 🔍 Key Features

- Page Object Model Design Pattern
- BDD Framework with Cucumber
- Data Driven Testing
- Parallel Test Execution
- Detailed Reporting
- Screenshot Capture on Failure
- Cross Browser Testing Support
- Configuration Management

## 👥 Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 🔑 Contact

Fatih Mehmet ÇİÇEK - [LinkedIn](https://www.linkedin.com/in/fatihmcicek/) - [GitHub](https://github.com/fatihmcicek)

## ⭐ Show your support

Give a star if this project helped you!