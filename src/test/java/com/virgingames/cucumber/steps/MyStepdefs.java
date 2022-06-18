package com.virgingames.cucumber.steps;

import com.virgingames.info.Gamesteps;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.builder.ResponseBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.junit.Assert;

import java.util.List;

public class MyStepdefs {

        static ValidatableResponse actualresponse;
        static Response response;

        @When("^User sends a GET request$")
        public void userSendsAGETRequest() {
            actualresponse = new Gamesteps().getAllData();
        }

        @And("^User must get back a valid status code (\\d+)$")
        public void userMustGetBackAValidStatusCode(int arg0) {
            actualresponse.statusCode(200);
        }

        @Then("^User should verify 'defaultGameFrequency' value should be '(\\d+)'$")
        public void userShouldVerifyDefaultGameFrequencyValueShouldBe(int arg0) {
             response=new Gamesteps().getData();

            ResponseBuilder responseBuilder=new ResponseBuilder().clone(response);
            responseBuilder.setContentType("application/json; charset=UTF-8");
            Response finalresponse =responseBuilder.build();

            // First get the JsonPath object instance from the Response interface
            JsonPath jsonPathEvaluator = finalresponse.jsonPath();
            List<Integer> defaultGameFrequency_List =jsonPathEvaluator.get("bingoLobbyInfoResource.streams.defaultGameFrequency");
            System.out.println("Default time : >>" +defaultGameFrequency_List);

            for (int i=0;i<defaultGameFrequency_List.size();i++) {
                Assert.assertNotNull("defaultGameFrequency has null value",defaultGameFrequency_List.get(i));
                int actual =defaultGameFrequency_List.get(i);
                int expected =300000;
                Assert.assertTrue(actual==expected);
            }
}

    @Then("^User should verify all startTime is future timestamp$")
    public void userShouldVerifyAllStartTimeIsFutureTimestamp() {
         response=  new Gamesteps().getData();

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
}

