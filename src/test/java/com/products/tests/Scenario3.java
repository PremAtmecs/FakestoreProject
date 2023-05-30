package com.products.tests;

import com.products.pageobject.Userpage;
import com.products.utilities.ReportGeneration;
import org.testng.annotations.Test;

public class Scenario3 extends ReportGeneration {

    /*
    *Scenario3: Get All the user,Update the existing user,
    * Delete the existing user and Add a new user with deleted user details
    */

    public Userpage user;

    public Scenario3(){
      user = new Userpage();
    }
    @Test(priority = 1)
    public void testGetAllUsers(){
        user.getAllUsers();
    }

    @Test(priority = 2)
    public void testUpdateUser(){
        user.updateUser();
    }

    @Test (priority = 3)
    public void testAddUser(){
        user.addUser();
    }

    @Test (priority = 4)
    public void testDeleteUser(){
        user.deletUser();
    }

}
