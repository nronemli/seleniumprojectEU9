package com.cydeo.tests.day5_testNG_intro_dropdowns;

import org.testng.Assert;
import org.testng.annotations.*;

public class TestNG_Intro {
    //annotation @
    //test runs alphabetical order
   @Test (priority = 1)
   public void test1(){
       System.out.println("Test 1 is running...");
       //assert equals: compare 2 of the same things
       String actual= "apple";
       String expected="apple";
       Assert.assertEquals(actual,expected);
   }
   //priority = 2
   //test: makes it runnable
   @Test (priority = 2)
   public void test2(){
       System.out.println("Tess 2 is running");
       String actual= "apple";
       String expected="apple";
       //AssertTrue
       Assert.assertTrue(actual.equals(expected));
   }

   //Runs one time before each test
   @BeforeMethod
   public void setUpMethod(){
       System.out.println("--->Before Method is running ");
   }

   //Runs one time after each test
   @AfterMethod
   public void tearDownMethod(){
       System.out.println("--->After Method is running");
   }

    @BeforeClass
    public void setupMethod() {
        System.out.println("---->Before class is running");
    }

    @AfterClass
    public void tearDownClass(){
        System.out.println("----> After class is running");
    }


}
