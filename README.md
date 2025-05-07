       MAIN PROJECT

Title :ADACTIN HOTEL APPLICATION
URL :https://adactinhotelapp.com/

Abstract :
This project presents an end-to-end automation framework for the Adactin Hotel Booking web application using a modular, maintainable approach. The automation is built with Selenium WebDriver and designed following the Page Object Model (POM) for separation of concerns and code reuse.
TestNG is used as the test management framework, offering capabilities like parallel execution, grouping, and reporting. The framework supports data-driven testing, enabling validation of multiple test scenarios by fetching inputs from external sources such as Excel.
The framework validates core functionalities of the Adactin application including hotel search, selection, booking, and order verification in the Booked Itinerary section. Assertions ensure the correctness of data flow across pages. Comprehensive reporting is achieved using Extent Reports for visual feedback on test execution.
The automation suite is integrated with Jenkins to enable Continuous Integration/Continuous Testing (CI/CT). Jenkins triggers tests on code commits or at scheduled intervals, helping maintain a stable and reliable release pipeline.
This project demonstrates the use of best practices in test automation to ensure quality, scalability, and maintainability for web-based hotel reservation systems.

📌 1. Project Overview
 Objective: Automate and validate the "Search Hotel" functionality of Adactin Hotel App using Selenium WebDriver, TestNG, Maven, and Excel-based data.
 Tools & Frameworks:
Selenium WebDriver


TestNG (Testing framework)


Apache POI (Excel reading)


Maven (Build and dependency management)
Build Tool: Maven


Jenkins (for CI/CD)


Design Pattern: Page Object Model (POM)
Reporting: Extent Reports
Browser: Chrome (via ChromeDriver),FireFox,Edge etc.
a 8+ and JDK21

MainProject/
│
├── src/
│   ├── main/
│   │   └── java/
│   └── test/
│       ├── java/
│       │   ├── com.qa.base/              // Base classes (e.g., driver setup)
│       │   ├── com.qa.pages/             // Page classes (POM)
│       │   ├── com.qa.utils/             // Utility classes (Excel, configs)
│       │   └── com.qa.testcases/         // TestNG test cases
│       └── resources/
│           └── testdata.xlsx             // Excel test data file
│
├── pom.xml                               // Maven config
└── testng.xml                            // TestNG suite

<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
 <modelVersion>4.0.0</modelVersion>
 <groupId>org.guvi</groupId>
 <artifactId>MainProject</artifactId>
 <version>0.0.1-SNAPSHOT</version>
  
 <dependencies>
  <!-- https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java -->
<dependency>
   <groupId>org.seleniumhq.selenium</groupId>
   <artifactId>selenium-java</artifactId>
   <version>4.31.0</version>
</dependency>
	<dependency>
			<groupId>org.testng</groupId>
			<artifactId>testng</artifactId>
			<version>7.8.0</version>
			<scope>test</scope>
		</dependency>
<!-- https://mvnrepository.com/artifact/org.apache.poi/poi -->
		<dependency>
			<groupId>org.apache.poi</groupId>
			<artifactId>poi</artifactId>
			<version>5.4.0</version>
		</dependency>
		<!-- https://mvnrepository.com/artifact/org.apache.poi/poi-ooxml -->
		<dependency>
			<groupId>org.apache.poi</groupId>
			<artifactId>poi-ooxml</artifactId>
			<version>5.4.0</version>
		</dependency>
 	<dependency>
			<groupId>com.aventstack</groupId>
			<artifactId>extentreports</artifactId>
			<version>5.1.2</version>
		</dependency>
		<!-- https://mvnrepository.com/artifact/com.aventstack/extentreports -->
		<!-- Log4j2 API -->
		<dependency>
			<groupId>org.apache.logging.log4j</groupId>
			<artifactId>log4j-api</artifactId>
			<version>2.20.0</version> <!-- Latest stable version -->
		</dependency>
		<!-- Log4j2 Core -->
		<dependency>
			<groupId>org.apache.logging.log4j</groupId>
			<artifactId>log4j-core</artifactId>
			<version>2.20.0</version> <!-- Latest stable version -->
		</dependency>
		<!-- Log4j2 SLF4J Binding (optional if using SLF4J) -->
		<dependency>
			<groupId>org.apache.logging.log4j</groupId>
			<artifactId>log4j-slf4j-impl</artifactId>
			<version>2.20.0</version> <!-- Latest stable version -->
		</dependency>
		<dependency>
   <groupId>io.github.bonigarcia</groupId>
   <artifactId>webdrivermanager</artifactId>
   <version>5.7.0</version>
</dependency>
		<!-- SLF4J binding for Logback -->
		<dependency>
			<groupId>ch.qos.logback</groupId>
			<artifactId>logback-classic</artifactId>
			<version>1.4.11</version>
		</dependency>
  </dependencies>
  <build>
<pluginManagement><!-- lock down plugins versions to avoid using Maven defaults (may be moved to parent pom) -->
<plugins>
<plugin>
<groupId>org.apache.maven.plugins</groupId>
<artifactId>maven-surefire-plugin</artifactId>
<version>3.2.5</version>
<configuration>
<suiteXmlFiles>
<suiteXmlFile>testngCompleteTests.xml</suiteXmlFile>
</suiteXmlFiles>
</configuration>
</plugin>
</plugins>
</pluginManagement>
</build>
   <name>Automation Testing Project</name>
   <description>UI automation framework using Selenium and TestNG</description>
 
</project>







✅ Key Features :
Modular test scripts following best practices
Custom utility classes for reusable wait methods and browser handling
Clear separation of concerns using POM
Data-driven testing capability (Excel/Properties files)
Detailed logging and Extent reporting with screenshots on failure
🔧 Installation Steps : To run the test automation suite for the Demoblaze application, follow the steps below:
Prerequisites: Java 21 or above installed on your system.
Maven for dependency management.
Eclipse IDE or any other Java IDE (like IntelliJ IDEA).
Chrome Browser (other browsers can be configured based on requirements).
ChromeDriver: Ensure you have the appropriate version of ChromeDriver that matches your browser version.
Project Flow for Maven Selenium TestNG Framework with Page Object Model (POM) and Utilities :
The framework will include several components such as base classes, utilities, page classes, and test cases, as well as mechanisms for logging, reporting, and data handling. Project Components Selenium WebDriver:
Selenium is used for automating the interaction with the browser. It drives the browser and performs actions like clicking buttons, entering text, and verifying page elements to ensure that the web application is functioning as expected.
TestNG:
TestNG is a testing framework for Java that helps in organizing and running test cases. It provides several advanced features such as grouping tests, prioritizing tests, and generating reports. It also supports parallel execution, making it easier to execute tests on multiple browsers or configurations simultaneously.
Page Object Model (POM):
The Page Object Model is a design pattern that creates an object-oriented class to serve as an interface to a web page. POM improves test maintainability by separating the logic of interactions with web elements from the actual test scripts, making it easier to update and scale tests when the application UI changes.
Reporting and Utility:
ExtentReports is used for generating detailed HTML reports with visual and textual insights about the test execution. This allows developers and testers to get a clear understanding of which tests passed, failed, and any issues that occurred.
Utilities like Excel Reader, Waits, Alerts, and Screenshot Capture are created to handle specific tasks, such as reading data from an Excel sheet for data-driven testing, adding synchronization (waits), handling pop-ups, and capturing screenshots when test failures occur.
3)Project Components in Quick view
a. Base Class (ProjectSpecificationMethods) The base class is used for WebDriver initialization, managing browser setups, and basic test setup.
b. Page Object Model (POM) Classes Page Object Model classes represent different pages in your application and encapsulate actions that can be performed on those pages. For example, LoginPage.java, HomePage.java.
c. Test Classes Test classes are responsible for performing the actual test actions by interacting with Page Objects. They are typically located in the test package.
Utility Classes
The utility package contains helper classes for tasks like waiting for elements, handling alerts, taking screenshots, and reading data from Excel files.
Listener Class for Reporting
TestNG Listeners are used to perform actions like logging, reporting, or taking screenshots when certain events occur during test execution. The listener class can be implemented to hook into the ITestListener interface.
Extent Report for Test Execution Reports To integrate ExtentReports for generating visually rich reports, create a utility method to initialize the report, log test results, and generate the report after test execution.
Create a testng.xml File
Create a testng.xml file in your src/test/resources folder (or anywhere under src). Right click on project or test class Convert To Testng. The testng.xml file will list the classes and methods that TestNG should run.
8)Run the Test from Eclipse If we using Eclipse, you can follow these steps to run your tests from within the IDE:
Right-click on the testng.xml file in the src/test/resources folder.
Select Run As > TestNG Suite.
This will execute all the tests defined in the testng.xml file.
8)To View Reports
After running the tests, you can check the output in your target directory for TestNG reports or ExtentReports (if you've configured ExtentReports in your utilities).
TestNG Report: After running the tests, TestNG will generate an HTML report in the test-output directory (e.g., test-output/index.html).
Extent Report: If you've configured ExtentReports, the report will be generated at the path defined in your report utility (e.g., ./Reports/extentReport.html).
To view report -It will create the file --> folder created under test resources
Example Note:This is the screenshot of the report :
C:\Users\ADMIN\eclipse-workspace1\MainProject\src\test\resources\Data\HotelAppTestData.xlsx



Failed screen shots 


Also Project --->test-output ----> emailable report -->Here also we can see the test report
Key Benefits of This Automation Approach Separation of Concerns (POM):
The Page Object Model makes tests easier to maintain. The separation of the page's UI interactions and the tests ensures that UI changes (like changing element locators) only require changes in the page object class, not in each individual test.
Scalability:
The framework is scalable and can handle multiple test cases across different pages. Adding new test cases, page classes, and test scenarios is simple.
With TestNG’s support for parallel execution, tests can be executed on different browsers simultaneously, reducing execution time.
Maintainability:
The utility classes and base classes (like ProjectSpecificationMethods) provide reusable code for repetitive tasks, such as initializing the WebDriver, handling waits, and reporting.
This minimizes code duplication and makes the codebase cleaner and more maintainable.
Cross-browser Compatibility:
The WebDriver setup supports multiple browsers, and the framework can be easily extended to support cross-browser testing (e.g., Chrome, Firefox, Edge).
Data-driven Testing:
With ExcelReader, data can be fed into the tests dynamically, allowing the same test case to run with different sets of data, ensuring better test coverage.
Error Handling and Reporting:
Screenshots on failure and detailed reports provide valuable insights into test execution, making it easier to debug issues.
Efficient Test Execution:
Using TestNG's parallel="true" attribute and properly configuring tests to run in parallel can drastically reduce the overall execution time for a large test suite.
Jenkins Integration


Jenkins is an open-source automation server used to build, test, and deploy software projects continuously. It supports Continuous Integration (CI) and Continuous Delivery (CD), helping teams detect problems early and release updates faster with fewer errors.
💡 Benefits of Jenkins in This Project
✅ 1. Continuous Integration (CI)
Automatically triggers test execution when code is pushed to Git.


Helps identify failures early in the development cycle.


🕒 2. Time-Saving
No need to manually run tests each time.


Tests can be scheduled (e.g., daily regression runs).


📄 3. Auto-Generated Reports
Jenkins can archive and display TestNG HTML reports.


You get immediate visibility into which tests passed/failed.


🔄 4. Parameterized Builds
Jenkins supports test parameterization (e.g., running tests on different browsers).


Useful when using @Parameters("browser") in your TestNG tests.


🔔 5. Notifications & Logs
Jenkins can send email/Slack notifications on build/test results.


Stores console output for troubleshooting failed test cases.


🔌 6. Integration with Other Tools
Works seamlessly with GitHub, Maven, Docker, Allure, etc.


Supports plugins for code coverage, linting, and advanced reporting.




OUTPUT SCREENS :JENKINS









Link :http://localhost:8080/job/MainProject/org.guvi$MainProject/
Console output:

Extent Report :































CONCLUSION
This project successfully automates the hotel search functionality of the Adactin Hotel App using a robust Page Object Model (POM) framework. The automation is powered by Selenium WebDriver, managed through Maven, executed via TestNG, and continuously integrated using Jenkins.
By structuring the test framework around the POM design, we ensured:
Separation of test logic and UI structure, making the tests easier to maintain.


Reusability of page classes for different test scenarios (valid inputs, missing mandatory fields, etc.).


Scalability to extend testing for other modules like Login, Booking, and Logout.


Integration with Jenkins enabled:
Automated test execution triggered on code changes or scheduled times.


Consistent test reporting, aiding rapid feedback for developers.


Early detection of failures, improving code quality and reliability.


This automation framework helps ensure that the search hotel feature works reliably across various input scenarios, reducing manual testing effort and aligning with CI/CD best practices.






Acknowledgment and Gratitude :
I am truly grateful for the resources, expertise, and opportunities that GUVI has provided me throughout this Project.
