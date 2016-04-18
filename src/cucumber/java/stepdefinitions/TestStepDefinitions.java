package stepdefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Created by ehongka on 4/18/16.
 */
public class TestStepDefinitions {

    @Before public void beforeScenario() {

    }

    @After public void afterScenario() {

    }

    @Given("^calculator-service app is started$") public void calculator_service_app_is_started()
        throws Throwable {
        // TODO
    }

    @And("^a mongodb is started$") public void a_mongodb_is_started() throws Throwable {
        // TODO
    }

    @Given("^that I want to add (\\d+) and (\\d+)$")
    public void that_I_want_to_add_and(int arg1, int arg2) throws Throwable {
        // TODO
    }

    @When("^I submit the request$") public void I_submit_the_request() throws Throwable {
        // TODO
    }

    @Then("^I get the result (\\d+)$") public void I_get_the_result(int arg1) throws Throwable {
        // TODO
    }
}
