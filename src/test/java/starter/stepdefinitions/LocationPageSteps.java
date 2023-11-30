package starter.stepdefinitions;
import org.json.simple.JSONObject;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import starter.pageObjects.LocationsPage;
import net.serenitybdd.screenplay.ensure.Ensure;
import starter.pageObjects.SignInPage;
import starter.util.helpers.ReadTestData;

public class LocationPageSteps {

    @And("verify {actor} can able to login")
    public void verifyUserCanAbleToLogin(Actor actor) {
        actor.attemptsTo(Ensure.that(LocationsPage.DIV_LOCATION).isDisplayed());
    }
    @When("{actor} select location {string}")
    public void userSelectLocation(Actor actor, String jsonDataName) throws Exception
    {
    	JSONObject jo = ReadTestData.getTestData(jsonDataName);
        actor.wasAbleTo(LocationsPage.selectLocation(jo.get("location").toString()));
    }
}
