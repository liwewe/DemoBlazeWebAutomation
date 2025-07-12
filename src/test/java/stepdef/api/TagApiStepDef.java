package stepdef.api;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.api.TagApiPage;

public class TagApiStepDef {
    TagApiPage tagApiPage;

    public TagApiStepDef() {
        this.tagApiPage = new TagApiPage();
    }

    @Given("prepare URL for {string} to tag endpoint")
    public void prepareURLForToTagEndpoint(String url) {
        tagApiPage.prepareURLFor(url);
    }

    @And("^validate data field exists and contains string items")
    public void validateDataExistAndContainStringItems() {
        tagApiPage.validateDataExistAndContainStringItems();
    }

    @When("send GET request to tag endpoint")
    public void sendGETRequestToTagEndpoint() {
        tagApiPage.sendGETRequest();
    }

    @Then("validate status code is {int} to tag endpoint")
    public void validateStatusCodeIsToTagEndpoint(int statusCode) {
        tagApiPage.validateStatusCode(statusCode);
    }
}
