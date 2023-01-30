package co.com.booking.steps.booking;

import co.com.booking.questions.IsEnabled;
import co.com.booking.tasks.booking.SelectAccommodationDestination;
import co.com.booking.utils.data.BookingData;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;

import static co.com.booking.steps.conf.Hooks.CAMILA;
import static co.com.booking.userinterface.accommodation_search.ViewBookingPage.RESULT_BOOKING;
import static co.com.booking.utils.data.Constants.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

public class EnterSearchInformationSteps {

    @Cuando("ella ingresa los datos para la búsqueda de su alojamiento {string}, {string}, {string} y {string}")
    public void enterDataForAccommodationSearch(String city, String dateStart, String dateEnd, String ageChildren) {
        CAMILA.attemptsTo(SelectAccommodationDestination.withCustomerData(
                BookingData.getData().get(CITY_DESTINATION).toString(),
                BookingData.getData().get(START_DATE).toString(),
                BookingData.getData().get(END_DATE).toString(),
                BookingData.getData().get(AGE_CHILDREN).toString()
        ));
    }

    @Entonces("deberá visualizar la lista de resultados de alojamientos disponibles")
    public void selectDestinationOption() {
        CAMILA.should(seeThat(IsEnabled.theTarget(RESULT_BOOKING), equalTo(true)));
    }
}

