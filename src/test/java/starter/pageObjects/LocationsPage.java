package starter.pageObjects;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import java.time.Duration;

public class LocationsPage extends UIInteractionSteps {
    public static Target DIV_LOCATION = Target.the("Header Content").locatedBy("//div[text()='Location']").waitingForNoMoreThan(Duration.ofSeconds(60));
    public static Target LABEL_MACYS = Target.the("Header Content").locatedBy("//label[not(contains(text(),'Backstage'))]").waitingForNoMoreThan(Duration.ofSeconds(60));
    public static Target LABEL_MACYS_BACKSTAGE = Target.the("Header Content").locatedBy("//label[contains(text(),'Backstage')]").waitingForNoMoreThan(Duration.ofSeconds(60));

    public static Performable selectLocation(String location) {
    	if("Macys".equalsIgnoreCase(location)){
        return Task.where("{0} selects location",
                Click.on(LABEL_MACYS));
        }else 
        	return Task.where("{0} selects location",
                    Click.on(LABEL_MACYS_BACKSTAGE));
            }
        }    
