package com.cydeo.tests.day9_javafaker_testbase_driverUtil;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class JavaFakerPractice {



    @Test
    public void test1(){

        //Creating faker object to reach methods
        Faker faker= new Faker();
        System.out.println("faker.name().firstName() = " + faker.name().firstName());
        System.out.println("faker.name().lastName() = " + faker.name().lastName());
        System.out.println("faker.address().buildingNumber() = " + faker.address().buildingNumber());
        System.out.println("faker.address().fullAddress() = " + faker.address().fullAddress());
        System.out.println("faker.animal().name() = " + faker.animal().name());
        System.out.println("faker.address().streetName() = " + faker.address().streetName());
        System.out.println("faker.numerify(\"###-####-####\") = " + faker.numerify("###-####-####"));
        faker.numerify("312-###-####");
        System.out.println("faker.letterify(\"???-????\") = " + faker.letterify("???-????"));
        System.out.println("faker.finance().creditCard() = " + faker.finance().creditCard());


    }

}
