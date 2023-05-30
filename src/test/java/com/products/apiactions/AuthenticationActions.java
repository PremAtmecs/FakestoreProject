package com.products.apiactions;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class AuthenticationActions {
    public static Response basicAuthentication(String username, String password, String endpoint, String authenticationURL){
        Response response = given()
                .auth().basic(username, password)
                .pathParam("endpoint", endpoint)
                .when()
                .get(authenticationURL);
        return response;
    }

    public static Response digestAuthentication(String username, String password, String endpoint, String authenticationURL){
        Response response = given()
                .auth().digest(username, password)
                .pathParam("endpoint", endpoint)
                .when()
                .get(authenticationURL);
        return response;
    }

    public static Response bearerAuth(String token, String path, String endpoint, String authorizationURL){
        Response response = given()
                .header("Authorization", "Bearer "+token)
                .pathParam("path", path)
                .pathParam("endpoint", endpoint)
                .when()
                .get(authorizationURL);
        return response;
    }

    public static Response OAuth2(String token, String path, String endpoint, String authorizationURL){
        Response response = given()
                .auth().oauth2(token)
                .pathParam("path", path)
                .pathParam("endpoint", endpoint)
                .when()
                .get(authorizationURL);
        return response;
    }


}
