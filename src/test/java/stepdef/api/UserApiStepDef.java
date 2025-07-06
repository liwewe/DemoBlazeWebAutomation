package stepdef.api;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.api.UserApiPage;

public class UserApiStepDef {

    UserApiPage userApiPage;

    public UserApiStepDef() {
        this.userApiPage = new UserApiPage();
    }

    @Given("prepare URL for {string}")
    public void prepareURLFor(String url) {
        userApiPage.prepareURLFor(url);
    }

    @And("provide user id {string}")
    public void provideUserId(String userId) {
        userApiPage.provideUserId(userId);
    }

    @When("send GET request")
    public void sendGETRequest() {
        userApiPage.sendGETRequest();
    }

    @Then("validate status code is {int}")
    public void validateStatusCode(int statusCode) {
        userApiPage.validateStatusCode(statusCode);
    }

    @And("validate response body contain user details")
    public void validateResponseBodyContainUserDetails() {
        userApiPage.validateUserDetails();
    }

    @And("validate response json with JSONSchema {string}")
    public void validateResponseJsonWithJSONSchema(String schema) {
        userApiPage.validateJsonSchema(schema);
    }
}
