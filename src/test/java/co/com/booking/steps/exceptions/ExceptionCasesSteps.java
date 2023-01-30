package co.com.booking.steps.exceptions;

import co.com.booking.questions.IsEnabled;
import co.com.booking.questions.ObtainText;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.actions.Click;

import static co.com.booking.steps.conf.Hooks.CAMILA;
import static co.com.booking.userinterface.stays.HomePage.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class ExceptionCasesSteps {

    @Cuando("ella seleccione la opción de buscar sin colocar la cuidad de destino")
    public void selectSearchOptionWithoutDestinationCity() {
        CAMILA.should(seeThat(IsEnabled.theTarget(SEARCH_FIELDS), equalTo(true)));
        CAMILA.attemptsTo(Click.on(SEARCH_BOX_ACCOMMODATION));
    }

    @Entonces("deberá visualizar el mensaje de {string}")
    public void viewErrorMessage(String message) {
        CAMILA.should(seeThat(ObtainText.element(ALERT_MESSAGE_ERROR), containsString(message)));
    }
}
