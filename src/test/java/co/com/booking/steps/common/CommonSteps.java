package co.com.booking.steps.common;

import co.com.booking.tasks.common.LoadDataTask;
import co.com.booking.tasks.common.NavigateTo;
import io.cucumber.java.es.Dado;
import net.serenitybdd.screenplay.ensure.Ensure;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static co.com.booking.models.UserInfoModel.userInformation;
import static co.com.booking.steps.conf.Hooks.CAMILA;
import static co.com.booking.userinterface.stays.HomePage.SEARCH_FIELDS;

public class CommonSteps {
    private static final Logger LOGGER = LoggerFactory.getLogger(CommonSteps.class.getSimpleName());

    @Dado("que Camila se encuentra en la opción de Stays")
    public void startAppBooking() {
        CAMILA.attemptsTo(
                NavigateTo.theStaysTab(),
                Ensure.that(SEARCH_FIELDS).isEnabled()
        );
        CAMILA.wasAbleTo(LoadDataTask.informationBooking(userInformation()));

        LOGGER.info("Data User is: {}", userInformation().values());
    }
}
