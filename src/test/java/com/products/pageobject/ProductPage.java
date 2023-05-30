package com.products.pageobject;

import com.products.apiactions.RequestActions;
import com.products.constant.FilePathConstant;
import com.products.constant.KeyConstant;
import com.products.constant.StatusCodeConstant;
import com.products.endpoint.ProductEndpoint;
import com.products.message.MessageInfo;
import com.products.payload.ProductPayload;
import com.products.utilities.APIUtils;
import com.products.utilities.PropertyParser;
import com.relevantcodes.extentreports.LogStatus;
import io.restassured.response.Response;
import static com.products.utilities.ReportGeneration.test;

public class ProductPage {
    public PropertyParser propertyParser;
    public ProductPage(){
        propertyParser = new PropertyParser(FilePathConstant.ROUTES);
    }
    public void getAllProducts(){
        Response response = RequestActions.read(ProductEndpoint.BASE_ENDPOINT, propertyParser.getPropertyValue(KeyConstant.FAKESTORE_URL));
        response.then().log().all();
        APIUtils.validateResponse(response.statusCode(), StatusCodeConstant.SUCCESS);
        test.log(LogStatus.INFO, MessageInfo.GET_ALL_PRODUCTS, String.valueOf(response.getStatusLine()));
    }

    public void validateProductLimits(){
        Response response = RequestActions.readWithQueryParam(ProductEndpoint.BASE_ENDPOINT, "limit", 5, propertyParser.getPropertyValue(KeyConstant.FAKESTORE_URL));
        response.then().log().all();
        APIUtils.validateResponse(response.statusCode(),StatusCodeConstant.SUCCESS);
        test.log(LogStatus.INFO, MessageInfo.LIMIT_OF_PRODUCTS, String.valueOf(response.getStatusLine()));
    }

    public void productSorting(){
        Response response = RequestActions.readWithQueryParam(ProductEndpoint.BASE_ENDPOINT, "sort", "desc", propertyParser.getPropertyValue(KeyConstant.FAKESTORE_URL));
        response.then().log().all();
        APIUtils.validateResponse(response.statusCode(),StatusCodeConstant.SUCCESS);
        test.log(LogStatus.INFO, MessageInfo.GET_PRODUCTS_BY_SORTING, String.valueOf(response.getStatusLine()));
    }

    public void productCategories(){
        Response response = RequestActions.readWithMultiParams(ProductEndpoint.BASE_ENDPOINT, ProductEndpoint.CATEGORIES, propertyParser.getPropertyValue(KeyConstant.MULTIPATH_FAKESTORE_URL));
        response.then().log().all();
        APIUtils.validateResponse(response.statusCode(),StatusCodeConstant.SUCCESS);
        test.log(LogStatus.INFO, MessageInfo.GET_PRODUCTS_CATEGORIES, String.valueOf(response.getStatusLine()));
    }

    public void addProducts(){
        Response response = RequestActions.create(ProductEndpoint.BASE_ENDPOINT, ProductPayload.setupData(),propertyParser.getPropertyValue(KeyConstant.FAKESTORE_URL));
        response.then().log().all();
        APIUtils.validateResponse(response.statusCode(),StatusCodeConstant.SUCCESS);
        APIUtils.validateJsonSchema(response,FilePathConstant.SCHEMA_PATH);
        test.log(LogStatus.INFO, MessageInfo.ADD_PRODUCTS, String.valueOf(response.getStatusLine()));
    }

    public void updateProduct(){
        Response response = RequestActions.update(ProductEndpoint.BASE_ENDPOINT, ProductEndpoint.UPDATE_PRODUCTS, ProductPayload.updateData(), propertyParser.getPropertyValue(KeyConstant.MULTIPATH_FAKESTORE_URL) );
        response.then().log().all();
        APIUtils.validateResponse(response.statusCode(),StatusCodeConstant.SUCCESS);
        APIUtils.validateJsonSchema(response,FilePathConstant.SCHEMA_PATH);
        test.log(LogStatus.INFO, MessageInfo.UPDATE_PRODUCTS, String.valueOf(response.getStatusLine()));
    }

    public void deleteProduct(){
        Response response =RequestActions.delete(ProductEndpoint.BASE_ENDPOINT, ProductEndpoint.DELETE_PRODUCTS, propertyParser.getPropertyValue(KeyConstant.MULTIPATH_FAKESTORE_URL));
        response.then().log().all();
        APIUtils.validateResponse(response.statusCode(),StatusCodeConstant.SUCCESS);
        test.log(LogStatus.INFO, MessageInfo.DELETE_PRODUCTS, String.valueOf(response.getStatusLine()));
    }

}
