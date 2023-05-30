package com.products.pageobject;

import com.products.apiactions.RequestActions;
import com.products.constant.FilePathConstant;
import com.products.constant.KeyConstant;
import com.products.constant.StatusCodeConstant;
import com.products.endpoint.UsersEndpoint;
import com.products.message.MessageInfo;
import com.products.payload.UserPayload;
import com.products.utilities.APIUtils;
import com.products.utilities.PropertyParser;
import com.relevantcodes.extentreports.LogStatus;
import io.restassured.response.Response;

import static com.products.utilities.ReportGeneration.test;
import static io.restassured.RestAssured.given;

public class Userpage {
    public PropertyParser propertyParser;

    //Created a constructor method to initiate the object
    public Userpage(){
        propertyParser = new PropertyParser(FilePathConstant.ROUTES);
    }

    public void getAllUsers(){
        Response response = RequestActions.read(UsersEndpoint.BASE_ENDPOINT, propertyParser.getPropertyValue(KeyConstant.FAKESTORE_URL));
        response.then().log().all();
        APIUtils.validateResponse(response.statusCode(), StatusCodeConstant.SUCCESS);
        test.log(LogStatus.INFO, MessageInfo.GET_ALL_USER, String.valueOf(response.getStatusLine()));
    }

    public void addUser(){
        Response response = RequestActions.create(UsersEndpoint.BASE_ENDPOINT, UserPayload.setUserData(), propertyParser.getPropertyValue(KeyConstant.FAKESTORE_URL));
        response.then().log().all();
        APIUtils.validateResponse(response.statusCode(),StatusCodeConstant.SUCCESS);
        test.log(LogStatus.INFO, MessageInfo.ADD_USER, String.valueOf(response.getStatusLine()));
    }

    public void updateUser(){
        Response response = RequestActions.update(UsersEndpoint.BASE_ENDPOINT, UsersEndpoint.UPDATE_USER, UserPayload.setUserData(), propertyParser.getPropertyValue(KeyConstant.MULTIPATH_FAKESTORE_URL));
        response.then().log().all();
        APIUtils.validateResponse(response.statusCode(),StatusCodeConstant.SUCCESS);
        test.log(LogStatus.INFO, MessageInfo.UPDATE_USER, String.valueOf(response.getStatusLine()));
    }

    public void deletUser(){
        Response response = RequestActions.delete(UsersEndpoint.BASE_ENDPOINT, UsersEndpoint.DELETE_USER, propertyParser.getPropertyValue(KeyConstant.MULTIPATH_FAKESTORE_URL));
        response.then().log().all();
        APIUtils.validateResponse(response.statusCode(),StatusCodeConstant.SUCCESS);
        test.log(LogStatus.INFO, MessageInfo.DELETE_USER, String.valueOf(response.getStatusLine()));
    }

}
