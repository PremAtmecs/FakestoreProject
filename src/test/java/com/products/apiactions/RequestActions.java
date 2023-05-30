package com.products.apiactions;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class RequestActions {
    public static Response read(Object endpoint, String url){
        Response response = given()
                .pathParam("endpoint", endpoint)
                .when()
                .get(url);
        return response;
    }

    public static Response readWithQueryParam(Object endpoint, String queryName, Object Query,  String url){
        Response response = given()
                .pathParam("endpoint", endpoint)
                .queryParam(queryName, Query)
                .when()
                .get(url);
        return response;
    }

    public static Response readWithMultiQueryParam(Object endpoint, String queryName1, Object Query1, String queryName2, String Query2,  String url){
        Response response = given()
                .pathParam("endpoint", endpoint)
                .queryParam(queryName1, Query1)
                .queryParam(queryName2, Query2)
                .when()
                .get(url);
        return response;
    }


    public static Response readWithMultiParams(Object path, Object endpoint, String url){
        Response response = given()
                .pathParam("path", path)
                .pathParam("endpoint", endpoint)
                .when()
                .get(url);
        return response;
    }

    public static Response create(Object endpoint, Object payload, String url){
        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)
                .pathParam("endpoint", endpoint)
                .log().all()
                .when()
                .post(url);
        return response;
    }
    public static Response createwithMultipleParam(Object payload,String path, String endpoint, String postURL){
        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .pathParam("path", path)
                .pathParam("endpoint", endpoint)
                .body(payload)
                .when()
                .post(postURL);
        return response;
    }


    public static Response update(Object path, Object endpoint, Object payload, String url){
        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)
                .log().body()
                .pathParam("path", path)
                .pathParam("endpoint", endpoint)
                .when()
                .put(url);
        return response;
    }

    public static Response delete(Object path, Object endpoint, String url){
        Response response = given()
                .pathParam("path", path)
                .pathParam("endpoint", endpoint)
                .when()
                .delete(url);
        return response;
    }

}
