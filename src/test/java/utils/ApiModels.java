package utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ApiModels {

    private static RequestSpecification myRequest;

    public static void setupHeaders() {
        myRequest = RestAssured.given()
                .header("Content-Type","application/json")
                .header("Accept","application/json")
                .header("app-id","63a804408eb0cb069b57e43a");
    }

    public static Response sendGetRequest(String url) {
        setupHeaders();
        return myRequest.when().get(url);
    }

//    public static Response sendPostRequest(String url) {
//
//    }
}
