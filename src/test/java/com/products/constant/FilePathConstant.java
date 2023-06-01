package com.products.constant;

import java.io.File;

public class FilePathConstant {
    public static String USER_DIRECTORY = System.getProperty("user.dir");
    public static String EXTENT_PATH = USER_DIRECTORY + File.separator + "reports" + File.separator + "Extent_Reports.html";
    public static final String RESOURCE_PATH = USER_DIRECTORY+ File.separator + "src" + File.separator + "test" + File.separator + "resources";
    public static final String ROUTES = RESOURCE_PATH + File.separator + "testdata" + File.separator + "routes.properties";
    public static final String PRODUCT_DATA_PATH = RESOURCE_PATH + File.separator + "testdata" + File.separator + "productdata.properties";
    public static final String TESTFIRE_USERDATA_PATH = RESOURCE_PATH + File.separator + "testdata" + File.separator + "testfire-userdata.properties";
    public static final String SCHEMA_PATH = RESOURCE_PATH + File.separator + "schema" + File.separator + "product_schema.json";
    public static final String LOG_FILE_PATH = "logs/request_response_logs.txt";
}
