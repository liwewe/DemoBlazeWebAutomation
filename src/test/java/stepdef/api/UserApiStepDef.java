package stepdef.api;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.api.UserData;
import page.api.UserApiPage;
import utils.ScenarioContext;

import static utils.Helper.generateRandomEmail;

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

    @When("send POST request")
    public void sendPOSTRequest() {
        userApiPage.sendPOSTRequest();
    }

    @And("send PUT request")
    public void sendPUTRequest() {
        userApiPage.sendPUTRequest();
    }

    @Then("validate status code is {int}")
    public void validateStatusCode(int statusCode) {
        userApiPage.validateStatusCode(statusCode);
    }

    @And("validate response json with JSONSchema {string}")
    public void validateResponseJsonWithJSONSchema(String schema) {
        userApiPage.validateJsonSchema(schema);
    }

    @And("provide user first name {string} and last name {string} and random email")
    public void provideUserFirstNameAndLastNameAndRandomEmail(String firstName, String lastName) {
        String email = generateRandomEmail(firstName, lastName);
        userApiPage.createUser(firstName, lastName, email);
    }

    @And("provide valid user ID")
    public void provideValidUserID() {
        UserData existingUser = ScenarioContext.get("userRequest");
        userApiPage.provideUserId(existingUser.getId());
    }

    @And("validate response body contains the same user data")
    public void validateResponseBodyContainsTheSameUserData() {
        userApiPage.validateResponseBodyContainsTheSameUserData();
    }

    @Given("a new user is created")
    public void aNewUserIsCreated() {
        provideUserFirstNameAndLastNameAndRandomEmail("Linjoo", "Update");
        userApiPage.sendPOSTRequest();
    }


    @When("the user is updated with new data")
    public void theUserIsUpdatedWithNewData() {
        userApiPage.prepareUpdateBody();
    }

    @And("validate response body contains the updated data")
    public void validateResponseBodyContainsTheUpdatedData() {
        userApiPage.validateResponseBody("firstName");
    }

    @When("the user is deleted")
    public void theUserIsDeleted() {
        userApiPage.deleteCreatedUser();
    }

    @When("send DELETE request")
    public void sendDELETERequest() {
        userApiPage.sendDELETERequest();
    }
}
