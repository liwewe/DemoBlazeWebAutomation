package stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.hc.core5.http.Header;
import page.HeaderPage;
import page.LoginModal;
import utils.BaseTest;

public class LoginStepDef extends BaseTest {

    protected LoginModal loginModal;
    protected HeaderPage headerPage;

    @Given("user is on the login modal")
    public void userIsLoginModal() {
        loginModal = new LoginModal(driver);
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
        loginModal.handleAlertIfExists();
    }

    @Then("user should see homepage with welcome message {string}")
    public void userShouldSeeHomepageWithWelcomeMessage(String expected) {
        headerPage = new HeaderPage(driver);
        headerPage.validateLoggedIn(expected);
    }

    @Then("alert message {string} should appear")
    public void alertMessageShouldAppear(String expectedMsg) {
        loginModal.validateErrorMessage(expectedMsg);
    }
}
