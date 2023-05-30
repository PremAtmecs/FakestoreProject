package com.products.payload;

import com.products.pojo.TestFirePojo;

public class TestFirePayload {
    public static TestFirePojo testFire = new TestFirePojo();
    public static TestFirePojo setupData(){
        testFire.setUsername("jsmith");
        testFire.setPassword("demo1234");
        return testFire;
    }

    public static TestFirePojo invalidData(){
        testFire.setUsername("jsmith");
        testFire.setPassword("demo");
        return testFire;
    }
}
