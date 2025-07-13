# Automation Testing Framework
This project is a final assignment for JayJay Online School, showcasing an integrated automation framework for both Web UI and API testing.
🌐 Web Testing using [demoblaze.com](https://www.demoblaze.com)  
🔌 API Testing using [dummyapi.io](https://dummyapi.io/docs)  
🧪 Built with Java, Selenium, Rest Assured, Cucumber, TestNG, and Gradle  
⚙️ Includes Gherkin-based test cases, separated folders for Web and API, and GitHub Actions for CI

## ✅ Test Coverage

### WEB Automation
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
| Attempt to checkout                                       | @checkout       | Validates behavior when placing order             |


### API Automation
This project covers automated test scenarios for the following core features of [dummyapi.io](https://dummyapi.io/docs):

### 👤 User API
| Scenario Description                    | Tag            | Covered Validation                     |
|-----------------------------------------|----------------|----------------------------------------|
| Get user by ID                          | @get-user      | Validates successful user retrieval    |
| Create new user                         | @create-user   | Validates user creation flow           |
| Update existing user                    | @update-user   | Validates user update functionality    |
| Delete user                             | @delete-user   | Validates user deletion process        |


### 🏷️ Tag API
| Scenario Description                    | Tag          | Covered Validation                     |
|-----------------------------------------|--------------|----------------------------------------|
| Get list of all tags                    | @get-tag     | Validates tag list retrieval           |

Each scenario is written using **Gherkin syntax** and executed with **Selenium & TestNG**
You can find the complete step definitions and page interactions in the corresponding test classes.

## 🛠 Technologies Used

- Java  
- Selenium
- Rest Assured
- TestNG  
- Gradle
- Cucumber
- Github Actions

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

✅ Run Web Tests
```bash
./gradlew web
```
✅ Run API Tests
```bash
./gradlew api
```
Or, run individual test classes directly from your IDE using the TestNG runner.

🎯 Run Tests by Tag

You can target specific scenarios using tags:
For web test:
```bash
./gradlew web -Ptags=@valid-login
```
or for API test:
```bash
./gradlew api -Ptags=@negative
```


#### 🏷 Available Tags

You can filter tests using the following tags:
##### Web Tags
- `@valid-login` – Valid login scenario  
- `@invalid-login` – Invalid credentials and empty login fields  
- `@logout` – Logout functionality  
- `@invalid-signup` – All negative test cases for signup  
- `@Cart` 	– Cart persistence test  
- `@Checkout` – Checkout behavior

##### API Tags
- `@positive` – Positive scenarios
- `@negative` – Negative scenarios

You can combine multiple tags like this:  

> 💻 Di Windows CMD atau PowerShell:
```bash
./gradlew web "-Ptags=@invalid-login or @invalid-signup"
```
> 💻 Di Unix (Linux/macOS):
```bash
./gradlew web '-Ptags=@cart or @checkout'
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
  - `api/api-report.html`: API Test Report in HTML format for quick overview  
  - `api/api-report.json`: API Test Report in JSON format, can be used with third-party tools like Allure
  - `web/web-report.html`: WEB Test Repoert in HTML format for quick overview  
  - `web/web-report.json`: WEB Test Report in JSON format, can be used with third-party tools like Allure

---

### 📄 Reporting Integration

This project supports auto-generated reports in the `reports/` directory:

- **HTML Report** (`web/web-report.html`)  
  A visual summary of test execution, viewable in any browser.

- **JSON Report** (`api/api-report.json`)  
  Machine-readable result, commonly used as input for reporting tools like **Allure** or **ExtentReports**.

---

## 🧪 CI/CD
Tests run on:  
•	Manual trigger  
•	Pull request event  
Reports uploaded as GitHub Actions artifacts.

## Screenshot
<img src="https://github.com/user-attachments/assets/290733b9-70f0-49b5-8af1-7614646d3a8c" height="150" alt="Web Terminal Run"/>
<img src="https://github.com/user-attachments/assets/095d7e75-8457-44ee-b1c7-928232d43817" height="150" alt="Web HTML Reports"/>
<img src="https://github.com/user-attachments/assets/47cc57bb-4b36-4bb2-8380-e79f6bad71b6" height="150" alt="API Terminal Run"/>
<img src="https://github.com/user-attachments/assets/b980df4d-64d6-4fe6-b4e0-ad9e0b8ee406" height="150" alt="API HTML Reports"/>

## Acknowledgments
This project was developed as Final Project of the QA Engineer Online Course by JayJay.  
Thanks to the creators of demoblaze.com and dummyapi.io for providing the demo site.
