package com.products.utilities;

import com.products.constant.FilePathConstant;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;

public class ReportGeneration {
    public static ExtentReports extent;
    public static ExtentTest test;
    @BeforeSuite
    public void beforeSuite() {
        extent = new ExtentReports(FilePathConstant.EXTENT_PATH);
        APIUtils.filterRequestResponseLogging();
    }

    @BeforeMethod
    public void beforeMethod(Method method){
        test = extent.startTest((this.getClass().getSimpleName()+"::"+method.getName()),method.getName());
    }

    @AfterMethod
    public void afterMethod() {
        extent.endTest(test);
    }

    @AfterSuite
    public void afterSuite(){
        extent.flush();
        extent.close();
    }
}
