# BDD Web & API Test Automation Framework

This project is a comprehensive BDD (Behavior Driven Development) test automation framework built for [Automation Exercise](https://automationexercise.com/), implementing best practices in both Web UI and API testing.

## 🔧 Technologies & Tools

![](https://img.shields.io/badge/Java-21-orange)
![](https://img.shields.io/badge/Selenium-4.15.0-green)
![](https://img.shields.io/badge/Cucumber-7.14.0-brightgreen)
![](https://img.shields.io/badge/TestNG-7.8.0-yellow)
![](https://img.shields.io/badge/REST_Assured-5.3.2-blue)
![](https://img.shields.io/badge/Maven-3.11.0-red)

## 🏗️ Project Architecture

```plaintext
src
├── main
│   └── java
│       └── com
│           └── automation
│               ├── api
│               │   └── client
│               │       └── ApiClient.java
│               ├── config
│               │   ├── ConfigReader.java
│               │   └── DriverConfig.java
│               ├── context
│               │   └── TestContext.java
│               └── pages
│                   ├── BasePage.java
│                   ├── HomePage.java
│                   └── ...
├── test
│   ├── java
│   │   └── com
│   │       └── automation
│   │           ├── runners
│   │           │   └── TestRunner.java
│   │           └── steps
│   │               ├── api
│   │               │   └── ApiSteps.java
│   │               ├── CommonSteps.java
│   │               └── ...
│   └── resources
│       ├── config
│       │   └── config.properties
│       └── features
│           ├── UI Tests
│           │   ├── TC01_register.feature
│           │   └── ...
│           └── API Tests
│               ├── TC06_api_product_list.feature
│               └── ...
└── test-output
    ├── cucumber-reports
    ├── extent-reports
    └── testng-reports
```

## 🎯 Test Scenarios

### UI Test Cases

| Test Case ID | Description | Category | Priority |
|--------------|-------------|-----------|----------|
| TC01 | User Registration | Regression, Smoke | High |
| TC02 | Login with Valid Credentials | Regression, Smoke | High |
| TC03 | Login with Invalid Credentials | Regression | Medium |
| TC04 | Contact Us Form | Regression | Medium |
| TC05 | Test Cases Page Verification | Regression | Low |

### API Test Cases

| Test Case ID | Description | Endpoint | Methods |
|--------------|-------------|----------|----------|
| TC06 | Product List Operations | /productsList | GET, POST |
| TC07 | Brands List Operations | /brandsList | GET, POST |
| TC08 | Search Product | /searchProduct | POST |
| TC09 | Verify Login | /verifyLogin | POST |
| TC10 | Create Account | /createAccount | POST |

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

#### Specific Test Categories:
```bash
# Run UI Tests
mvn test -Dcucumber.filter.tags="@ui"

# Run API Tests
mvn test -Dcucumber.filter.tags="@api"

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
│   └── cucumber-pretty.html      # Detailed test execution report
├── extent-reports/
│   └── ExtentReport.html        # Rich HTML report with graphs
└── testng-reports/
    └── index.html               # TestNG execution report
```

## 🔍 Key Features

- Page Object Model Design Pattern
- BDD Framework with Cucumber
- REST Assured for API Testing
- Data Driven Testing
- Parallel Test Execution
- Detailed HTML Reports
- Screenshot Capture on Failure
- Cross Browser Testing Support
- Configuration Management
- API Response Validation

## 🧪 Testing Approach

### UI Testing
- Selenium WebDriver for browser automation
- Page Object Model for maintainability
- TestNG for test execution
- Cucumber for BDD scenarios

### API Testing
- REST Assured for API automation
- JSON response validation
- Status code verification
- Schema validation
- Data driven tests

## 👥 Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 🔑 Contact

Fatih Mehmet ÇİÇEK
- [LinkedIn](https://www.linkedin.com/in/fatihmcicek/)
- [GitHub](https://github.com/fatihmcicek)

## ⭐ Show your support

Give a star if this project helped you!