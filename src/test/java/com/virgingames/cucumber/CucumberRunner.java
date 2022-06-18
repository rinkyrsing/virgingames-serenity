package com.virgingames.cucumber;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features ="src/test/java/resources/feature/",
        glue = "com/virgingames",
        tags ={})
public class CucumberRunner {
}
