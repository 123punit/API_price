package com.bdd.restassured.testrunner;


import org.junit.runner.RunWith;


import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
		features = "C:\\Users\\Sunit\\eclipse-workspace\\BDDRestAssured\\src\\main\\java\\com\\bdd\\restassured\\feature\\Price.feature"
		,glue = {"com.bdd.restassured.stepdefinition"},
		plugin = { "pretty", "html:test-output", "json:json_output/result.json"},		
		dryRun = false, 
		monochrome = true
		)


public class PrcieTestRunner {

}
