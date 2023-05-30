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


    public static Response readWithMultiParams(Object endpoint1, Object endpoint2, String url){
        Response response = given()
                .pathParam("endpoint1", endpoint1)
                .pathParam("endpoint2", endpoint2)
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
    public static Response createwithMultipleParam(Object payload,String endpoint1, String endpoint2, String postURL){
        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .pathParam("endpoint1", endpoint1)
                .pathParam("endpoint2", endpoint2)
                .body(payload)
                .when()
                .post(postURL);
        return response;
    }

    public static Response update(Object endpoint1, Object endpoint2, Object payload, String url){
        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)
                .log().body()
                .pathParam("endpoint1", endpoint1)
                .pathParam("endpoint2", endpoint2)
                .when()
                .put(url);
        return response;
    }

    public static Response delete(Object endpoint1, Object endpoint2, String url){
        Response response = given()
                .pathParam("endpoint1", endpoint1)
                .pathParam("endpoint2", endpoint2)
                .when()
                .delete(url);
        return response;
    }

}
