package com.bdd.restassured.stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

public class PriceStepDefinition {
	public static Response response = null;
	public static String url = "https://open.er-api.com/v6/latest/USD";
	public static String url_invalid404 = "https://open.er-api.com/v6/latest/USD1";
	public static String url_valid200 = "https://open.er-api.com/v6/latest/US";

	@Given("^Hit the rquest endpoint$")
	public void hit_request_endpoint() {
		response = RestAssured.get(url);
		System.out.println(response.getStatusCode());
		System.out.println(response.getBody().asString());
		

	}

	@When("^Check API return successful response$")
	public void check_API_Response() {
		System.out.println(response.getTime());
		System.out.println(response.then().assertThat().statusCode(200));
	}

	@Given("^Hit the invalid request endpoint with USD1$")
	public void hit_Invalid_Request_Response_USD1Code() {
		Response url = RestAssured.get(url_invalid404);
		System.out.println(url.getBody().asString());
		int Statuscode = url.getStatusCode();
		if (Statuscode == 404) {
			System.out.println(url);
		} else {
			System.out.println("Url is valid");
		}
	}

	@When("^Hit the invalid request endpoint with US$")
	public void hit_Invalid_Request_Response_UDCode() {
		Response url = RestAssured.get(url_valid200);
		System.out.println(url.getBody().asString());
		int Statuscode = url.getStatusCode();
		if (Statuscode == 200) {
			System.out.println(url.getBody().asString());
		} else {
			System.out.println("Url is valid");
		}
	}

	@Given("^Hit the request endpoint$")
	public void hit_request() {
		Response res = RestAssured.get(url);
		System.out.println(res.getBody().asString());
	}

	@When("^Verify USD price against AED and check the prince range between 3.6 and 3.7$")
	public void usd_Price_AED() {
		Response res = RestAssured.get(url);
		System.out.println(res.getBody().asString());
		Float value = res.jsonPath().getFloat("rates.AED");
		if (!(value < 3.6 && value > 3.7)) {
			System.out.println("value is = " + value);
		} else {
			System.out.println("Value is greater than 3.7 and less than 3.6");
		}
	}

	@Then("^Check 162 currency pair display in the response$")
	public void check_TotalCountry() {
		Response res = RestAssured.get(url);
		System.out.println(res.getBody().asString());
		String[] count = res.jsonPath().get("rates").toString().split(",");
		if (count.length == 162) {
			System.out.println(count.length);
		} else {
			System.out.println(count.length + "does not match");
		}
	}

	@Then("^Generate a schema from API response and matches with Json schema$")
	public void generate_Schema() {
		Response res = RestAssured.get(url);
		System.out.println(res.getBody().asString());
		System.out.println(
				res.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("currency_schema.json")));

	}
}
