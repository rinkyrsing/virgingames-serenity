package com.virgingames.testinfo;

import com.virgingames.info.Gamesteps;
import com.virgingames.testbase.TestBase;
import io.restassured.builder.ResponseBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Assert;
import org.junit.runner.RunWith;

import java.util.List;

@RunWith(SerenityRunner.class)
public class Test extends TestBase {

    @Steps
    Gamesteps gameSteps;


    @Title("This test will verify startTime should always be a future timestamp ")
    @org.junit.Test
    public void test001(){
        Response response= gameSteps.getData();

        ResponseBuilder responseBuilder=new ResponseBuilder().clone(response);
        responseBuilder.setContentType("application/json; charset=UTF-8");
        Response finalresponse =responseBuilder.build();

        // First get the JsonPath object instance from the Response interface
        JsonPath jsonPathEvaluator = finalresponse.jsonPath();
        Long timestamp = jsonPathEvaluator.get("timestamp");
        List<Long> startTime_List = jsonPathEvaluator.get("bingoLobbyInfoResource.streams.startTime");
        System.out.println("check time : >>>"+startTime_List);
        System.out.println(timestamp);

        for (int i=0;i<startTime_List.size();i++) {
            Assert.assertTrue("startTime is not future time", timestamp < startTime_List.get(i));
        }
    }

    @Title("This test will verify defaultGameFrequency value should be '300000' ")
    @org.junit.Test
    public void test002(){
        Response response= gameSteps.getData();

        ResponseBuilder responseBuilder=new ResponseBuilder().clone(response);
        responseBuilder.setContentType("application/json; charset=UTF-8");
        Response finalresponse =responseBuilder.build();

        // First get the JsonPath object instance from the Response interface
        JsonPath jsonPathEvaluator = finalresponse.jsonPath();
        List<Integer> defaultGameFrequency_List =jsonPathEvaluator.get("bingoLobbyInfoResource.streams.defaultGameFrequency");
        System.out.println("Default time : >>" +defaultGameFrequency_List);

        for (int i=0;i<defaultGameFrequency_List.size();i++) {
            int actual =defaultGameFrequency_List.get(i);
            int expected =300000;
            Assert.assertTrue(actual==expected);
            Assert.assertNotNull("defaultGameFrequency has null value",defaultGameFrequency_List.get(i));
        }

    }
}