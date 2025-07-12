package page.api;

import com.sun.jna.platform.win32.Netapi32Util;
import io.restassured.response.Response;
import models.api.UserData;
import utils.Constants;
import utils.ResponseValidator;
import utils.ScenarioContext;

import java.util.HashMap;
import java.util.Map;

import static models.api.ApiModels.*;

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

    public void sendPOSTRequest() {
        prepareURLFor("CREATE_USER");
        UserData currentUser = ScenarioContext.get("userRequest");
        res = sendPostRequest(currentUser, setUrl);

        if (res.getStatusCode() == 200) {
            currentUser.setId(res.jsonPath().getString("id"));
            ScenarioContext.set("userRequest", currentUser);
        }
    }

    public void sendPUTRequest(){;
        UserData user = ScenarioContext.get("userRequest");
        String userId = user.getId();

        Map<String, Object> updateBody = ScenarioContext.get("updateBody");

        prepareURLFor("GET_USER");
        provideUserId(userId);

        res = sendPutRequest(updateBody, setUrl);
    }

    public void sendDELETERequest() {
        res = sendDeleteRequest(setUrl);
    }

    public void validateStatusCode(int expectedStatusCode) {
        ResponseValidator.validateStatusCode(res, expectedStatusCode);
    }

    public void validateJsonSchema(String schema) {
        ResponseValidator.validateJsonWithSchema(res, schema);
    }

    public void validateResponseBodyContainsTheSameUserData() {
        UserData expectedUser = ScenarioContext.get("userRequest");

        // Validasi
        ResponseValidator.validateField(res, "firstName", expectedUser.getFirstName());
        ResponseValidator.validateField(res, "lastName", expectedUser.getLastName());
        ResponseValidator.validateField(res, "email", expectedUser.getEmail());
    }

    public void createUser(String firstName, String lastName, String email) {
        UserData newUser = new UserData(firstName, lastName, email);
        ScenarioContext.set("userRequest", newUser);
    }

    public void prepareUpdateBody() {
        Map<String, Object> updateBody = new HashMap<>();
        updateBody.put("firstName", "UpdatedLinjoo");

        ScenarioContext.set("updateBody", updateBody);
        ScenarioContext.set("expectedFirstName", "UpdatedLinjoo");
    }

    public void validateResponseBody(String key) {
        ResponseValidator.validateField(res,key, ScenarioContext.get("expectedFirstName"));
    }

    public void deleteCreatedUser() {
        UserData user = ScenarioContext.get("userRequest");

        prepareURLFor("GET_USER");
        provideUserId(user.getId());

        res = sendDeleteRequest(setUrl);
    }

}
