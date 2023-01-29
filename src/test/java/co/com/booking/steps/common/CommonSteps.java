package co.com.booking.steps.common;

import co.com.booking.tasks.common.NavigateTo;
import io.cucumber.java.es.Dado;
import net.serenitybdd.screenplay.ensure.Ensure;

import static co.com.booking.steps.conf.Hooks.CAMILA;
import static co.com.booking.userinterface.stays.HomePage.SEARCH_FIELDS;


public class CommonSteps {
    @Dado("que Camila se encuentra en la opción de Stays")
    public void startAppBooking() {
        CAMILA.attemptsTo(
                NavigateTo.theStaysTab(),
                Ensure.that(SEARCH_FIELDS).isEnabled()
        );
    }
}
