package co.com.booking.steps.booking;

import co.com.booking.questions.IsEnabled;
import co.com.booking.tasks.booking.SelectAccommodationDestination;
import co.com.booking.tasks.booking.SelectRooms;
import co.com.booking.tasks.common.scroll.Scroll;
import co.com.booking.utils.data.BookingData;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.actions.Click;

import static co.com.booking.steps.conf.Hooks.CAMILA;
import static co.com.booking.userinterface.accommodation_search.ViewBookingPage.RESULT_BOOKING;
import static co.com.booking.userinterface.user_data.UserDataPage.INPUT_FIRST_NAME;
import static co.com.booking.utils.data.Constants.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

public class AccommodationSearchSteps {
    @Cuando("ella seleccione la opción de alojamiento que desea")
    public void selectionOfAccommodationOption() {
        CAMILA.attemptsTo(SelectAccommodationDestination.withCustomerData(
                BookingData.getData().get(CITY_DESTINATION).toString(),
                BookingData.getData().get(START_DATE).toString(),
                BookingData.getData().get(END_DATE).toString(),
                BookingData.getData().get(AGE_CHILDREN).toString()
        ));
        CAMILA.attemptsTo(
                Scroll.toElement(),
                Click.on(RESULT_BOOKING));
    }

    @Entonces("podrá elegir y reservar su habitación")
    public void chooseAndReserveRooms() {
        CAMILA.attemptsTo(SelectRooms.chooseRoom());
        CAMILA.should(seeThat(IsEnabled.theTarget(INPUT_FIRST_NAME), equalTo(true)));
    }
}
