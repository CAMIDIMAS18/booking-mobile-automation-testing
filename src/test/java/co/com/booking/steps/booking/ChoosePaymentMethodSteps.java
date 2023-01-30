package co.com.booking.steps.booking;

import co.com.booking.interactions.Pause;
import co.com.booking.questions.IsEnabled;
import co.com.booking.tasks.booking.*;
import co.com.booking.tasks.common.scroll.Scroll;
import co.com.booking.utils.data.BookingData;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.actions.Click;

import static co.com.booking.steps.conf.Hooks.CAMILA;
import static co.com.booking.userinterface.accommodation_search.ViewBookingPage.RESULT_BOOKING;
import static co.com.booking.userinterface.info_booking.InfoBookingPages.BTN_FINAL_STEP;
import static co.com.booking.userinterface.payment_method.FinishBookingPage.BTN_BOOK_NOW;
import static co.com.booking.userinterface.user_data.UserDataPage.INPUT_FIRST_NAME;
import static co.com.booking.utils.data.Constants.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

public class ChoosePaymentMethodSteps {

    @Dado("que Camila se encuentra en la pantalla de selección de medio de pago")
    public void goToPaymentMethodScreen() {
        CAMILA.attemptsTo(SelectAccommodationDestination.withCustomerData(
                BookingData.getData().get(CITY_DESTINATION).toString(),
                BookingData.getData().get(START_DATE).toString(),
                BookingData.getData().get(END_DATE).toString(),
                BookingData.getData().get(AGE_CHILDREN).toString()));
        CAMILA.should(seeThat(IsEnabled.theTarget(RESULT_BOOKING), equalTo(true)));
        CAMILA.attemptsTo(Scroll.toElement(), Click.on(RESULT_BOOKING));
        CAMILA.attemptsTo(SelectRooms.chooseRoom());
        CAMILA.should(seeThat(IsEnabled.theTarget(INPUT_FIRST_NAME), equalTo(true)));
        CAMILA.attemptsTo(FillInUserInformation.withTheFollowingFields());
        CAMILA.attemptsTo(ValidateBookingInformation.inTheResume(), Click.on(BTN_FINAL_STEP), Pause.withDuration(5));
    }

    @Cuando("ella ingrese el número de su tarjeta {string} y la fecha de expedición {string}")
    public void enterCreditCardInformation(String cardNumber, String expirationDate) {
        CAMILA.attemptsTo(ChoosePaymentMethod.withTheFollowingFields(cardNumber, expirationDate));
    }

    @Entonces("ella finalizará correctamente su reserva")
    public void finalizeBooking() {
        CAMILA.attemptsTo(Click.on(BTN_BOOK_NOW), Pause.withDuration(20));
    }
}


