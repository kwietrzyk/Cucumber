package StepsDef;

import Calculator.Calc;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class StepsDef_Calculator {
    Calc calc;
    int result;

    @Given("Calculator is started")
    public void i_test_calculator() {
        calc = new Calc();
    }

    @When("I add {int} and {int}")
    public void i_add_and(Integer int1, Integer int2) {
        result = calc.sum(int1, int2);
    }

    @Then("result is {int}")
    public void result_is(Integer int1) {
        Assertions.assertEquals(int1, result);
    }

    @When("I multiply {int} and {int}")
    public void i_multiply_and(Integer int1, Integer int2) {
        result = calc.multiply(int1, int2);
    }
}