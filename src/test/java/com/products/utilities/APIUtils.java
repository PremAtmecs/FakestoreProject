package com.products.utilities;

import com.products.constant.FilePathConstant;
import io.restassured.RestAssured;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import org.testng.Assert;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class APIUtils {
    public static void validateResponse(Object actual, Object expected){
        boolean status = false;
        try {
            Assert.assertEquals(actual, expected);
            status = true;
            System.out.println("PASS - Actual Result ::" +actual+ "==" +"Expected Result ::" +expected);
        }
        catch (AssertionError assertionError){
            System.out.println("FAIL - Actual Result ::" +actual+ "==" +"Expected Result ::" +expected);
        }

    }

    public static String getValueByJsonPath(String json, String jsonPathExpression) {
        JsonPath jsonPath = new JsonPath(json);
        return jsonPath.getString(jsonPathExpression);
    }

    public static boolean validateJsonSchema(Response response, String schemaPath) {
        try {
            response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(new File(schemaPath)));
            return true;
        } catch (AssertionError e) {
            return false;
        }
    }

    public static void filterRequestResponseLogging() {
        PrintStream logStream;
        try {
            logStream = new PrintStream(new FileOutputStream(FilePathConstant.LOG_FILE_PATH));
        } catch (FileNotFoundException exception) {
            throw new RuntimeException("Failed to create log file: " + FilePathConstant.LOG_FILE_PATH, exception);
        }

        FilterableRequestSpecification requestSpec = (FilterableRequestSpecification) RestAssured.given()
                .filter(new RequestLoggingFilter(LogDetail.ALL, logStream))
                .filter(new ResponseLoggingFilter(LogDetail.ALL, logStream));

        RestAssured.requestSpecification = requestSpec;
    }
}
