package com.virgingames.testbase;

import com.virgingames.utils.PropertyReader;
import io.restassured.RestAssured;
import org.junit.BeforeClass;

public class TestBase {
    public static PropertyReader propertyReader;

    @BeforeClass
    public static void init(){
        propertyReader = PropertyReader.getInstance();
        RestAssured.baseURI ="https://www.virgingames.com/";
       //  RestAssured.baseURI = propertyReader.getProperty("baseUrl");
        //RestAssured.registerParser("text/html", Parser.JSON);
    }
}
