package utils;

import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

import java.io.File;

import static utils.Constants.BASE_SCHEMA_PATH;

public class ResponseValidator {

    public static void validateStatusCode(Response response, int expectedStatusCode) {
        response.then().statusCode(expectedStatusCode);
    }

    public static void validateField(Response response, String fieldPath, Object expectedValue) {
        response.then().body(fieldPath, org.hamcrest.Matchers.equalTo(expectedValue));
    }

    public static void validateFieldNotNull(Response response, String fieldPath) {
        response.then().body(fieldPath, org.hamcrest.Matchers.notNullValue());
    }

    public static void validateFieldContains(Response response, String fieldPath, String expectedSubstring) {
        response.then().body(fieldPath, org.hamcrest.Matchers.containsString(expectedSubstring));
    }

    public static void validateJsonWithSchema(Response res, String schemaName) {
        File schemaFile = new File(BASE_SCHEMA_PATH + schemaName);

        if (!schemaFile.exists()) {
            throw new AssertionError("Schema file not found: " + schemaFile.getAbsolutePath());
        }

        res.then().assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(schemaFile));
    }
}
