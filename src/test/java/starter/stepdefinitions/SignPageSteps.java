package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.thucydides.model.environment.SystemEnvironmentVariables;
import net.thucydides.model.util.EnvironmentVariables;
import starter.pageObjects.NavigateTo;
import starter.pageObjects.SignInPage;
import starter.util.helpers.ReadProperties;
import starter.util.helpers.ReadTestData;

import java.io.IOException;

import org.json.simple.*;

public class SignPageSteps {

    @Given("{actor} is on SignIn page")
    public void isOnAdinInPage(Actor actor) throws IOException {       
        actor.wasAbleTo(NavigateTo.theHomePage());
        actor.wasAbleTo(SignInPage.clicksOnSingInButton());
    }
    @When("{actor} enter login details")
    public void enterLoginDetails(Actor actor) throws Exception {       
        String env = SystemEnvironmentVariables.currentEnvironmentVariables().getProperty("Env");
        String username=ReadProperties.getProperty(env+"-username");
        actor.wasAbleTo(SignInPage.enterUserName(username));
        String password=ReadProperties.getProperty(env+"-password");
        actor.wasAbleTo(SignInPage.enterPassword(password));
        actor.wasAbleTo(SignInPage.clicksOnLoginButton());
    }

    @And("{actor} click on Next button")
        public void clickOnNextButton(Actor actor) {
        actor.wasAbleTo(SignInPage.clicksOnNextButton());

    }


}
