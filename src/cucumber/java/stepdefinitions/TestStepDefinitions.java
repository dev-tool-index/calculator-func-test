package stepdefinitions;

import com.example.devindextool.config.Params;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import lombok.extern.log4j.Log4j2;
import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;

/**
 * Created by ehongka on 4/18/16.
 */
@Log4j2 public class TestStepDefinitions {

    private static final String SERVLET_PATH = "/calculator-server";

    private int arg1_value;
    private int arg2_value;

    @Before public void beforeScenario() {

    }

    @After public void afterScenario() {

    }

    @Given("^calculator-service app is started$") public void calculator_service_app_is_started()
        throws Throwable {
        String base_uri = Params.HTTP_PROTOCOL + Params.CALCULATOR_SERVICE_IP;
        RestAssured.given().log().path().baseUri(base_uri).port(Params.CALCULATOR_SERVICE_PORT).
            get(SERVLET_PATH + "/health").then().log().ifError().assertThat().statusCode(HttpStatus.SC_OK)
            .contentType(ContentType.JSON).body("status", Matchers.is("UP"))
            .body("mongo.status", Matchers.is("UP"));
    }

    @And("^a mongodb is started$") public void a_mongodb_is_started() throws Throwable {
        String base_uri = Params.HTTP_PROTOCOL + Params.MONGO_IP;
        RestAssured.given().log().path().baseUri(base_uri).port(Params.MONGO_HTTP_PORT).
            get("/").then().log().ifError().assertThat().statusCode(HttpStatus.SC_OK);
    }

    @Given("^that I want to add (\\d+) and (\\d+)$")
    public void that_I_want_to_add_and(int arg1, int arg2) throws Throwable {
        log.info("arg1: " + arg1 + "; " + "arg2: " + arg2);
        arg1_value = arg1;
        arg2_value = arg2;
    }

    @When("^I submit the request$") public void I_submit_the_request() throws Throwable {

    }

    @Then("^I get the result (\\d+)$") public void I_get_the_result(int arg1) throws Throwable {
        String base_uri = Params.HTTP_PROTOCOL + Params.CALCULATOR_SERVICE_IP;
        log.info("arg1: " + arg1);
        // http://192.168.31.223:8090/calc/add?arg1=3&arg2=2
        RestAssured.given().log().path().contentType(ContentType.JSON).baseUri(base_uri)
            .port(Params.CALCULATOR_SERVICE_PORT).queryParam("arg1", arg1_value)
            .queryParam("arg2", arg2_value).get(SERVLET_PATH + "/calc/add").then().log().ifError().assertThat()
            .statusCode(HttpStatus.SC_OK).contentType(ContentType.JSON).
                body("result", Matchers.equalTo(arg1));
    }
}
