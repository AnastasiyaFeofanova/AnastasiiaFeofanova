package lesson6.steps;

import cucumber.api.java.en.When;
import pageObjects.HomePageSelenide;

public class ActionSteps {
    @When("^I login as user ([^\"]*) with password ([^\"]*)$")
    public void iLoginAsUserWithPassword(String username, String password){
        new HomePageSelenide().login(username, password);
    }
//    @Then("Ilogin as user ''$")
//    public void iLoginAsUser(){
//        new HomePageSelenide(User);
//    }
}
