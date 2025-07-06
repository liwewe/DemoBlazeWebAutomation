package page.api;

import io.restassured.response.Response;
import utils.Constants;
import utils.ResponseValidator;

import static org.hamcrest.MatcherAssert.assertThat;
import static utils.ApiModels.sendGetRequest;

public class UserApiPage {

    String setUrl;
    Response res;

    public void prepareURLFor(String url) {
        switch (url) {
            case "GET_USER":
                setUrl = Constants.GET_USER;
                break;
            case "CREATE_USER":
                setUrl = Constants.CREATE_USER;
                break;
            default:
                System.out.println("input right URL");
        }
    }

    public void provideUserId(String userId) {
        setUrl += "/" + userId;
    }

    public void sendGETRequest() {
        res = sendGetRequest(setUrl);
    }

    public void validateStatusCode(int expectedStatusCode) {
        ResponseValidator.validateStatusCode(res, expectedStatusCode);
    }

    public void validateJsonSchema(String schema) {
        ResponseValidator.validateJsonWithSchema(res, schema);
    }

    public void validateUserDetails() {
    }
}
