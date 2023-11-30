package starter.pageObjects;

import java.time.Duration;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.targets.Target;

public class SignInPage extends UIInteractionSteps {

	static Target BUTTON_SIGNIN = Target.the("Button SignIn").locatedBy("//button/div[text()='Sign In']");
	static Target INPUT_USERNAME = Target.the("Input Username").locatedBy("//input[contains(@id,'idToken') and contains(@placeholder,'Employee ID')]").waitingForNoMoreThan(Duration.ofSeconds(60));
	static Target INPUT_PASSWORD = Target.the("INPUT PASSWORD").locatedBy("//input[contains(@id,'idToken') and (@type='password')]");
	static Target BUTTON_LOGIN = Target.the("Button Login").locatedBy("//input[contains(@id,'loginButton')]");
	static Target BUTTON_NEXT = Target.the("Button Next").locatedBy("//input[@value='Next']").waitingForNoMoreThan(Duration.ofSeconds(60));


	public static Performable clicksOnSingInButton() {
		return Task.where("{0} clicks On SingIn Button",
				Click.on(BUTTON_SIGNIN));
	}

	public static Performable enterUserName(String userName) {
		return Task.where("{0} enter username '" + userName + "'",
				Enter.theValue(userName)
				.into(INPUT_USERNAME));
	}
	public static Performable enterPassword(String password) {
		return Task.where("{0} enter password '" + password + "'",
				Enter.theValue(password)
				.into(INPUT_PASSWORD));
	}
	public static Performable clicksOnLoginButton() {
		return Task.where("{0} clicks On Login Button",
				Click.on(BUTTON_LOGIN));
	}
	public static Performable clicksOnNextButton() {
		return Task.where("{0} clicks On Next Button",
				Click.on(BUTTON_NEXT));
	}
}
