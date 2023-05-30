package com.products.tests;

import com.products.pageobject.ProductPage;
import com.products.utilities.ReportGeneration;
import org.testng.annotations.Test;

public class Scenario1 extends ReportGeneration {
    public ProductPage product;

    //Created a constructor method to initiate the object.
    public Scenario1(){
       product = new ProductPage();
    }

    @Test (priority = 1)
    public void tesGetAllProducts(){
        product.getAllProducts();
    }

    @Test (priority = 2)
    public void testDeleteProduct(){
        product.deleteProduct();
    }

    @Test (priority = 3)
    public void testAddProduct(){
        product.addProducts();
    }
}
