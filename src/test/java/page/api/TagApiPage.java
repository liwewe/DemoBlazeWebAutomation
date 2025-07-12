package page.api;

import io.restassured.response.Response;
import utils.Constants;
import utils.ResponseValidator;

import java.util.Objects;

import static models.api.ApiModels.sendGetRequest;

public class TagApiPage {

    String setUrl;
    Response res;

    public void prepareURLFor(String url) {
        if (Objects.equals(url, "GET_TAG")) {
            setUrl = Constants.GET_TAG;
        } else {
            System.out.println("input right URL");
        }
        System.out.println(setUrl);
    }

    public void sendGETRequest() {
        res = sendGetRequest(setUrl);
    }

    public void validateDataExistAndContainStringItems() {
//        System.out.println("response " + res);
        ResponseValidator.validateFieldNotNull(res,"data");
        ResponseValidator.validateNonEmptyArray(res, "data");
    }


    public void validateStatusCode(int expectedStatusCode) {
        ResponseValidator.validateStatusCode(res, expectedStatusCode);
    }
}
