package com.cydeo.tests.day7_webTables_utilities;

import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadingProperties {

    @Test
    public void reading_from_properties_test() throws IOException {
        //1- create the object of properties
        Properties properties = new Properties();
        //2- open the file in java memory using FileInputStream
        FileInputStream file= new FileInputStream("configuration.properties");
        //3- Load the properties object using FileInputStream object
        properties.load(file);
        //4- use "propeties" object  to read value

        System.out.println("properties.getProperty(\"browser\") = " + properties.getProperty("browser"));
        System.out.println("properties.getProperty(\"env\") = " + properties.getProperty("env"));
        System.out.println("properties.getProperty(\"username\") = " + properties.getProperty("username"));

    }


}
