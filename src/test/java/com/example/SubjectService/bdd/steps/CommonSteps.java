package com.example.SubjectService.bdd.steps;

import com.example.SubjectService.bdd.SubjectServiceFeatureTest;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.slf4j.Logger;
import org.springframework.http.HttpStatus;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.slf4j.LoggerFactory.getLogger;

public class CommonSteps extends SubjectServiceFeatureTest {

    private static final Logger LOGGER = getLogger(CommonSteps.class);

    @When("^the client calls /(.+)$")
    public void the_client_issues_GET_version(String endpoint) throws Throwable {
        executeGet("http://localhost:30001/" + endpoint);
    }

    @Then("^the client receives status code of (\\d+)$")
    public void the_client_receives_status_code_of(int statusCode) throws Throwable {
        final HttpStatus currentStatusCode = latestResponse.getTheResponse().getStatusCode();
        assertThat("status code is incorrect : " + latestResponse.getBody(), currentStatusCode.value(), is(statusCode));
    }

    @And("^the client receives server version (.+)$")
    public void the_client_receives_server_version_body(String version) throws Throwable {
        assertThat(latestResponse.getBody(), is(version));
    }
}