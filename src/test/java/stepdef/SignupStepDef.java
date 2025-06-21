package stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.SignupModal;
import utils.BaseTest;

public class SignupStepDef extends BaseTest {

    protected SignupModal signupModal;

    @Given("user is on signup modal")
    public void userIsOnSignupModal() {
        signupModal = new SignupModal(driver);
        signupModal.openSignupModal();
    }

    @When("user input username text box with {string}")
    public void userInputUsernameTextBoxWith(String username) {
        signupModal.inputUsername(username);
    }

    @And("user input password text box with {string}")
    public void userInputPasswordTextBoxWith(String pass) {
        signupModal.inputPassword(pass);
    }

    @And("user click signup button")
    public void userClickSignupButton() {
        signupModal.clickSignupButton();
    }

    @Then("popup message {string} appears")
    public void popupMessageAppears(String msg) {
        signupModal.validateErrorMessage(msg);
    }
}
