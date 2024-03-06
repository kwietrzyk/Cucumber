package StepsDef;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.messages.internal.com.fasterxml.jackson.databind.util.JSONPObject;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.*;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class StepsDef_Rest {

    RequestSpecification requestSpecification;
    Response response;
    Faker faker = new Faker();
    JSONObject jsonBody = new JSONObject();

    @Given("I set base url")
    public void i_set_base_url() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com/";
    }
    @Given("I set request specification")
    public void i_set_request_specification() {
        requestSpecification = given().contentType(ContentType.JSON);
    }
    @When("I get user with id {int}")
    public void i_get_user_with_id(Integer id) {
        response = given().spec(requestSpecification).get("users/" + id);
    }
    @Then("I receive correct username: {}")
    public void i_receive_correct_username(String username) {
        response.then().body("username", equalTo(username));
    }
    @Then("I receive correct email: {}")
    public void i_receive_correct_email(String email) {
        response.then().body("email", equalTo(email));
    }

    @Given("I prepare correct body input")
    public void i_prepare_correct_body_input() {
        jsonBody.put("name", faker.name());
        jsonBody.put("username", faker.ancient().titan());
        jsonBody.put("email", faker.internet().emailAddress());
    }
    @When("I post new user with correct body")
    public void i_post_new_user_with_correct_body() {
        response = given().spec(requestSpecification).body(jsonBody.toString()).post("users/");
    }
    @Then("I receive response code 201 with expected body")
    public void i_receive_response_code_with_expected_body() {
        response.then().statusCode(201);
        response.then()
                .body("", hasKey("name"))
                .body("", hasKey("username"))
                .body("", hasKey("email"));
    }
}
