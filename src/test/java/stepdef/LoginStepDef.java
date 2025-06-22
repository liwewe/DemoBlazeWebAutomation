package stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.HomePage;
import page.LoginModal;
import utils.BaseTest;

public class LoginStepDef extends BaseTest {

    LoginModal loginModal = new LoginModal(driver);
    HomePage homePage = new HomePage(driver);

    @Given("user is on the login modal")
    public void userIsLoginModal() {
//        loginModal = new LoginModal(driver);
        loginModal.openLoginModal();
    }

    @When("user inputs username with {string}")
    public void userInputsUsernameWith(String username) {
        loginModal.inputUsername(username);
    }

    @And("user inputs password with {string}")
    public void userInputsPasswordWith(String pass) {
        loginModal.inputPassword(pass);
    }

    @And("user clicks the login button")
    public void userClicksTheLoginButton() {
        loginModal.clickLoginButton();
    }

    @Then("user should see homepage with welcome message {string}")
    public void userShouldSeeHomepageWithWelcomeMessage(String expected) {
        loginModal.handleAlert();
        homePage.validateLoggedIn(expected);
    }

    @Then("alert message {string} should appear")
    public void alertMessageShouldAppear(String expectedMsg) {
        if (loginModal == null) new LoginModal(driver);
        loginModal.handleAlert(expectedMsg);
    }

    @Given("user is logged in with username {string} and password {string}")
    public void userIsLoggedInWithUsernameAndPassword(String username, String pass) {
        if(!loginModal.isLoggedIn()){
            loginModal.openLoginModal();
            loginModal.inputUsername(username);
            loginModal.inputPassword(pass);
            loginModal.clickLoginButton();
            loginModal.handleAlert();
//            loginModal.waitLoggedIn();
        }
    }


    @When("user clicks the logout button")
    public void userClicksTheLogoutButton() {
        homePage.logout();
    }

    @Then("user should be redirected to the homepage")
    public void userShouldBeRedirectedToTheHomepage() {
        if (homePage == null)
            homePage = new HomePage(driver);
        homePage.validateInHomepage();
    }

    @And("user should be logged out")
    public void userShouldBeLoggedOut() {
        homePage.validateLoggedOut();
    }
}
