package starter.pageObjects;

import java.io.IOException;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.model.environment.SystemEnvironmentVariables;
import starter.util.helpers.ReadProperties;

public class NavigateTo extends UIInteractionSteps {

    public static Performable theHomePage() throws IOException {
    	String env = SystemEnvironmentVariables.currentEnvironmentVariables().getProperty("Env");
    	String url=ReadProperties.getProperty(env+"-url");
        return Task.where("{0} opens the home page",
        		Open.url(url));
    }
}
