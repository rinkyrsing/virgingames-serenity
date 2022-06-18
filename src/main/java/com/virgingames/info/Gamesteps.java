package com.virgingames.info;

import com.virgingames.constants.Path;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class Gamesteps {
    @Step("get all data")
    public ValidatableResponse getAllData() {
        return SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .when()
                .get(Path.GAME_PATH)
                .then();
    }
    @Step("Get all data")
    public Response getData() {
        return SerenityRest.given().log().all()
                .when()
                .get(Path.GAME_PATH)
                .then().log().all().extract().response();
    }
}
