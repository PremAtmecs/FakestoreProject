package com.products.payload;

import com.products.constant.FilePathConstant;
import com.products.constant.KeyConstant;
import com.products.pojo.TestFirePojo;
import com.products.utilities.PropertyParser;

import java.io.File;

public class TestFirePayload {
    public static TestFirePojo testFire = new TestFirePojo();
    public static PropertyParser userData = new PropertyParser(FilePathConstant.TESTFIRE_USERDATA_PATH);
    public static TestFirePojo setupData(){
        testFire.setUsername(userData.getPropertyValue(KeyConstant.VALID_USERNAME));
        testFire.setPassword(userData.getPropertyValue(KeyConstant.VALID_PASSWORD));
        return testFire;
    }

    public static TestFirePojo invalidData(){
        testFire.setUsername(userData.getPropertyValue(KeyConstant.INVALID_USERNAME));
        testFire.setPassword(userData.getPropertyValue(KeyConstant.INVALID_PASSWORD));
        return testFire;
    }
}
