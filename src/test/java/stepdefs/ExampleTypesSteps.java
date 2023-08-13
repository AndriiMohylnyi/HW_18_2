package stepdefs;

import io.cucumber.java.en.Given;

public class ExampleTypesSteps {

    @Given("give integer {int}")
    public void give_integer(Integer int1) {
        System.out.println(int1);
    }
    @Given("give string {string}")
    public void give_string(String string) {
        System.out.println(string);
    }

}
