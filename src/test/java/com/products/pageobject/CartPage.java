package com.products.pageobject;

import com.products.apiactions.RequestActions;
import com.products.constant.FilePathConstant;
import com.products.constant.KeyConstant;
import com.products.constant.StatusCodeConstant;
import com.products.endpoint.CartEndpoint;
import com.products.message.MessageInfo;
import com.products.utilities.APIUtils;
import com.products.utilities.PropertyParser;
import com.relevantcodes.extentreports.LogStatus;
import io.restassured.response.Response;

import static com.products.utilities.ReportGeneration.test;

public class CartPage {
    public PropertyParser propertyParser;

    //Created a constructor method to initiate the object
    public CartPage(){
        propertyParser = new PropertyParser(FilePathConstant.ROUTES);
    }

    public void validateCartLimits(){
        Response response = RequestActions.readWithQueryParam(CartEndpoint.BASE_ENDPOINT, CartEndpoint.LIMIT, CartEndpoint.LIMIT_VALUE, propertyParser.getPropertyValue(KeyConstant.FAKESTORE_URL));
        response.then().log().all();
        APIUtils.validateResponse(response.statusCode(), StatusCodeConstant.SUCCESS);
        test.log(LogStatus.INFO, MessageInfo.LIMIT_OF_CART, String.valueOf(response.getStatusLine()));
    }

    public void sortResult(){
        Response response = RequestActions.readWithQueryParam(CartEndpoint.BASE_ENDPOINT, CartEndpoint.SORT, CartEndpoint.SORTING_TYPE, propertyParser.getPropertyValue(KeyConstant.FAKESTORE_URL));
        response.then().log().all();
        APIUtils.validateResponse(response.statusCode(),StatusCodeConstant.SUCCESS);
        test.log(LogStatus.INFO, MessageInfo.GET_CART_BY_SORTING, String.valueOf(response.getStatusLine()));
    }

    public void dateRange(){
        Response response = RequestActions.readWithMultiQueryParam(CartEndpoint.BASE_ENDPOINT,CartEndpoint.START_DATE, CartEndpoint.BEGINNING_DATE, CartEndpoint.END_DATE, CartEndpoint.ENDING_DATE, propertyParser.getPropertyValue(KeyConstant.FAKESTORE_URL));
        response.then().log().all();
        APIUtils.validateResponse(response.statusCode(),StatusCodeConstant.SUCCESS);
        test.log(LogStatus.INFO, MessageInfo.GET_CART_DATE_RANGE, String.valueOf(response.getStatusLine()));
    }
}
