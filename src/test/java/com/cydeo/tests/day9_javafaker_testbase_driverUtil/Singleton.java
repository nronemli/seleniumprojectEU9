package com.cydeo.tests.day9_javafaker_testbase_driverUtil;

public class Singleton {

    //Create private constructor
    public Singleton() {

    }
    //Create private static String
    //prevent access and provide a getter
    private static String word;

    //getter for the string word
    public static String getWord() {
        if (word == null) {
            System.out.println("First time call.Word object is null." +
                    "Assigning value to it now");
            word = "something";
        } else {
            System.out.println("Word already has a value");
        }
        return word;
    }


}
