package com.products.pageobject;


import com.products.apiactions.AuthenticationActions;
import com.products.apiactions.RequestActions;
import com.products.constant.FilePathConstant;
import com.products.constant.KeyConstant;
import com.products.constant.StatusCodeConstant;
import com.products.endpoint.TestFireEndpoint;
import com.products.message.MessageInfo;
import com.products.payload.TestFirePayload;
import com.products.utilities.APIUtils;
import com.products.utilities.PropertyParser;
import com.relevantcodes.extentreports.LogStatus;
import io.restassured.response.Response;

import static com.products.utilities.ReportGeneration.test;

public class AuthenticationPage {
    public PropertyParser url;
    public String token;
    public AuthenticationPage(){
        url = new PropertyParser(FilePathConstant.ROUTES);
    }

    public void postDataToGetToken(){
        String authURL = url.getPropertyValue(KeyConstant.TESTFIRE_URL);
        Response response = RequestActions.createwithMultipleParam(TestFirePayload.setupData(), TestFireEndpoint.API, TestFireEndpoint.LOGIN, authURL);
        response.then().log().all();
        token = response.path("Authorization");
        APIUtils.validateResponse(response.getStatusCode(), StatusCodeConstant.SUCCESS);
        test.log(LogStatus.INFO, MessageInfo.AUTHENTICATION, response.getStatusLine());
    }

    public void bearerAuthentication(){
        String authURL = url.getPropertyValue(KeyConstant.TESTFIRE_URL);
        Response response = AuthenticationActions.bearerAuth(token, TestFireEndpoint.API, TestFireEndpoint.LOGIN, authURL);
        response.then().log().all();
        APIUtils.validateResponse(response.statusCode(), StatusCodeConstant.SUCCESS);
        test.log(LogStatus.INFO, MessageInfo.BEARER_AUTHORIZATION, response.getStatusLine());
    }

    public void OAuth2(){
        String authURL = url.getPropertyValue(KeyConstant.TESTFIRE_URL);
        Response response = AuthenticationActions.OAuth2(token, TestFireEndpoint.API, TestFireEndpoint.LOGIN, authURL);
        response.then().log().all();
        APIUtils.validateResponse(response.statusCode(), StatusCodeConstant.SUCCESS);
        test.log(LogStatus.INFO, MessageInfo.OPEN_AUTHORIZATION, response.getStatusLine());
    }

    public void validateBadRequest(){
        String authURL = url.getPropertyValue(KeyConstant.TESTFIRE_URL);
        Response response = RequestActions.createwithMultipleParam(TestFirePayload.invalidData(), TestFireEndpoint.API, TestFireEndpoint.LOGIN, authURL);
        response.then().log().all();
        APIUtils.validateResponse(response.statusCode(), StatusCodeConstant.BAD_REQUEST);
        test.log(LogStatus.INFO, MessageInfo.BADREQUEST, response.getStatusLine());
    }

    public void validateUnauthorized(){
        String authURL = url.getPropertyValue(KeyConstant.TESTFIRE_URL);
        String token = url.getPropertyValue(KeyConstant.INVALID_TOKEN);
        Response response = AuthenticationActions.bearerAuth(token, TestFireEndpoint.API, TestFireEndpoint.LOGIN, authURL);
        response.then().log().all();
        APIUtils.validateResponse(response.statusCode(), StatusCodeConstant.UNAUTHORIZED);
        test.log(LogStatus.INFO, MessageInfo.UNAUTHORIZED, response.getStatusLine());
    }
}
