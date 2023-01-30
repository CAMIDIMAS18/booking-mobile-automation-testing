package co.com.booking.steps.booking;

import co.com.booking.interactions.Pause;
import co.com.booking.questions.IsEnabled;
import co.com.booking.tasks.booking.FillInUserInformation;
import co.com.booking.tasks.booking.SelectAccommodationDestination;
import co.com.booking.tasks.booking.SelectRooms;
import co.com.booking.tasks.booking.ValidateBookingInformation;
import co.com.booking.tasks.common.scroll.Scroll;
import co.com.booking.utils.data.BookingData;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.actions.Click;

import static co.com.booking.steps.conf.Hooks.CAMILA;
import static co.com.booking.userinterface.accommodation_search.ViewBookingPage.RESULT_BOOKING;
import static co.com.booking.userinterface.info_booking.InfoBookingPages.BTN_FINAL_STEP;
import static co.com.booking.userinterface.user_data.UserDataPage.INPUT_FIRST_NAME;
import static co.com.booking.utils.data.Constants.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

public class EnterUserInformationSteps {

    @Dado("que Camila se encuentra en la pantalla de ingreso de información del cliente")
    public void goToPageUserInformation() {
        CAMILA.attemptsTo(SelectAccommodationDestination.withCustomerData(
                BookingData.getData().get(CITY_DESTINATION).toString(),
                BookingData.getData().get(START_DATE).toString(),
                BookingData.getData().get(END_DATE).toString(),
                BookingData.getData().get(AGE_CHILDREN).toString()
        ));
        CAMILA.attemptsTo(Scroll.toElement(), Click.on(RESULT_BOOKING));
        CAMILA.attemptsTo(SelectRooms.chooseRoom());
        CAMILA.should(seeThat(IsEnabled.theTarget(INPUT_FIRST_NAME), equalTo(true)));
    }

    @Cuando("ella ingresa sus datos personales en el formulario")
    public void ellaIngresaSusDatos() {
        CAMILA.attemptsTo(FillInUserInformation.withTheFollowingFields());
    }

    @Entonces("podrá validar el resumen de su reserva su precio total {string}, fecha de inicio {string} y fecha fin {string}")
    public void validateInformationEnteredInReservationSummary(String price, String checkIn, String checkOut) {
        CAMILA.attemptsTo(ValidateBookingInformation.inTheResume(), Click.on(BTN_FINAL_STEP), Pause.withDuration(2));
    }
}


