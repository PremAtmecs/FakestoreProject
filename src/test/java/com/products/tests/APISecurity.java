package com.products.tests;

import com.products.pageobject.AuthenticationPage;
import com.products.utilities.ReportGeneration;
import org.testng.annotations.Test;

public class APISecurity extends ReportGeneration {

    public AuthenticationPage auth;

    public APISecurity(){
        auth = new AuthenticationPage();
    }

    @Test(priority = 1)
    public void testGetAccessToken(){
        auth.postDataToGetToken();
    }

    @Test (priority = 2, dependsOnMethods = "testGetAccessToken")
    public void testBearerAuthorization(){
        auth.bearerAuthentication();
    }

    @Test (priority = 3, dependsOnMethods = "testGetAccessToken")
    public void testOpenAuthorization(){
        auth.OAuth2();
    }

    @Test(priority = 4)
    public void testBadRequest(){
        auth.validateBadRequest();
    }

    @Test(priority = 5)
    public void testUnauthorized(){
        auth.validateUnauthorized();
    }
}

