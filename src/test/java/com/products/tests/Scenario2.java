package com.products.tests;

import com.products.pageobject.CartPage;
import com.products.utilities.ReportGeneration;
import org.testng.annotations.Test;

public class Scenario2 extends ReportGeneration {

    //Scenario2: Limit result, sort the result, get in date range


    public CartPage cart;

    public Scenario2(){
        cart = new CartPage();
    }

    @Test (priority = 1)
    public void testGetLimitCart(){
        cart.validateCartLimits();
    }

    @Test(priority = 2)
    public void testSortCartResult(){
        cart.sortResult();
    }

    @Test(priority = 3)
    public void testDateRange(){
        cart.dateRange();
    }
}
