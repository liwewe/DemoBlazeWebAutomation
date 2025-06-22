# DemoBlazeWebAutomation

A web automation project using A web automation project using [demoblaze.com](https://www.demoblaze.com).  
This project was created as part of an online QA Engineer course assignment by JayJay.

## ✅ Test Coverage

This project covers automated test scenarios for the following core features of [demoblaze.com](https://www.demoblaze.com):

### 🔐 Feature: Signup

| Scenario Description                                      | Tag             | Covered Validation                                |
|-----------------------------------------------------------|-----------------|---------------------------------------------------|
| Signup with empty username and password                   | @invalid-signup | Validates required field alert                    |
| Signup with existing username                             | @invalid-signup | Validates duplicate username handling             |
| Signup with valid username but empty password             | @invalid-signup | Validates password requirement                    |
| Signup with empty username but valid password             | @invalid-signup | Validates username requirement                    |


### 🔓 Feature: Login & Logout

| Scenario Description                                      | Tag             | Covered Validation                                |
|-----------------------------------------------------------|-----------------|---------------------------------------------------|
| Login with valid credentials                              | @valid-login    | Validates successful login flow                   |
| Login with invalid credentials                            | @invalid-login  | Validates incorrect credentials handling          |
| Login with empty username and password                    | @invalid-login  | Validates required field alert                    |
| Logout from an active session                             | @logout         | Validates logout functionality                    |


### 🛒 Feature: Cart & Checkout

| Scenario Description                                      | Tag             | Covered Validation                                |
|-----------------------------------------------------------|-----------------|---------------------------------------------------|
| Cart items persist after logout and re-login              | @cart           | Validates cart state persistence                  |
| Attempt to checkout with an empty cart                    | @checkout       | Validates behavior when placing order with empty cart |

Each scenario is written using **Gherkin syntax** and executed with **Selenium & TestNG**
You can find the complete step definitions and page interactions in the corresponding test classes.

## 🛠 Technologies Used

- Java  
- Selenium
- TestNG  
- Gradle (pilih sesuai yang kamu pakai)  
- Cucumber

## ⚙️ Setup & Installation

Follow the steps below to set up and run the project locally:

### 1. Clone the Repository

```bash
git clone https://github.com/liwewe/DemoBlazeWebAutomation.git
cd DemoBlazeWebAutomation
```

### 2. Open in Your IDE

- Open the project folder using your preferred Java IDE (e.g., IntelliJ IDEA, Eclipse, VS Code).
- Make sure Java JDK (version 8 or higher) is installed and configured.
- Import the project as a Gradle project

### 3. Install Dependencies

run the following command to download dependencies:

```bash
gradle build
```
### 4. Run the Tests

✅ Run All Cucumber Tests
```bash
./gradlew cucumber
```
Or, run individual test classes directly from your IDE using the TestNG runner.

🎯 Run Tests by Tag

You can target specific scenarios using tags:

```bash
./gradlew cucumber -Ptags=@valid-login
```

#### 🏷 Available Tags

You can filter tests using the following tags:

- `@valid-login` – Valid login scenario  
- `@invalid-login` – Invalid credentials and empty login fields  
- `@logout` – Logout functionality  
- `@invalid-signup` – All negative test cases for signup  
- `@Cart` 	– Cart persistence test  
- `@Checkout` – Checkout behavior when cart is empty  

> You can combine multiple tags like this:
```bash
./gradlew cucumber -Ptags="@invalid-login or @invalid-signup"
```

✅ Requirements
- Java Development Kit (JDK) 8 or above
- Gradle
- Internet connection (for downloading dependencies)
- Chrome browser

📌 Notes
- Make sure the ChromeDriver version matches your installed Chrome browser.
- Tests are written using the Page Object Model (POM) for better maintainability.

## 📁 Project Structure

The project follows a standard structure for a Java-based automation framework using Cucumber, Selenium, and Gradle.

---

### 📄 Descriptions

- **`page/`**  
  Contains all Page Object Model (POM) classes, where each page interaction is encapsulated as methods.

- **`runners/`**  
  Contains Cucumber runner classes that trigger execution of feature files and generate reports.

- **`stepdef/`**  
  Step definition files that connect Gherkin steps to Java methods.

- **`utils/`**  
  General utility classes like WebDriverManager setup, config readers, etc.

- **`features/`**  
  Gherkin-style `.feature` files defining test scenarios in human-readable format.

- **`reports/`**  
  Stores generated test reports.  
  - `test-report.html`: HTML format for quick overview  
  - `test-report.json`: Can be used with third-party tools like Allure

---

### 📄 Reporting Integration

This project supports auto-generated reports in the `reports/` directory:

- **HTML Report** (`test-report.html`)  
  A visual summary of test execution, viewable in any browser.

- **JSON Report** (`test-report.json`)  
  Machine-readable result, commonly used as input for reporting tools like **Allure** or **ExtentReports**.

---

## Screenshot


## Acknowledgments
This project was developed as part of the QA Engineer Online Course by JayJay.
Thanks to the creators of demoblaze.com for providing the demo site.
