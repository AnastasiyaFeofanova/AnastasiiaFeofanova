package lesson6.steps;

import lesson6.SuperHero;
import lesson6.po.SelenideUserTablePage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import pageObjects.HomePageSelenide;

import java.util.List;

public class AssertionSteps {
    @When("^I login as user ([^\"]*) with password ([^\"]*)$")
    public void iLoginAsUserWithPassword(String username, String password){
        new HomePageSelenide().login(username, password);
    }

    @And("Table assertion")
    public void userTableContainsFollowingValues(List<SuperHero> superHeroes) {
        new SelenideUserTablePage().checkSuperHeroes(superHeroes);
    }
}
