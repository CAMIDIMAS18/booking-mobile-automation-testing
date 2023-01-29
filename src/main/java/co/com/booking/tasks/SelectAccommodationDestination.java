package co.com.booking.tasks;

import co.com.booking.tasks.common.ScrollByText;
import co.com.booking.utils.data.BookingData;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.booking.userinterface.stays.AccommodationDatesPage.BTN_CONFIRM_DATES;
import static co.com.booking.userinterface.stays.AccommodationDestinationPage.INPUT_SEARCH_BOX_ACCOMMODATION_DESTINATION;
import static co.com.booking.userinterface.stays.AccommodationDestinationPage.SELECT_ACCOMMODATION_DESTINATION;
import static co.com.booking.userinterface.stays.AccommodationOccupancyPage.*;
import static co.com.booking.userinterface.stays.HomePage.SEARCH_BOX_ACCOMMODATION_DESTINATION;
import static co.com.booking.userinterface.stays.HomePage.SEARCH_BOX_ACCOMODATION_OCCUPANCY;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;

public class SelectAccommodationDestination {

    private SelectAccommodationDestination() {
        //Nothing
    }

    public static Performable withCustomerData() {
        return Task.where("{0} enters-select search information",
                WaitUntil.the(SEARCH_BOX_ACCOMMODATION_DESTINATION, isEnabled()).forNoMoreThan(5).seconds(),
                Click.on(SEARCH_BOX_ACCOMMODATION_DESTINATION),

                WaitUntil.the(INPUT_SEARCH_BOX_ACCOMMODATION_DESTINATION, isEnabled()).forNoMoreThan(5).seconds(),
                Click.on(INPUT_SEARCH_BOX_ACCOMMODATION_DESTINATION),
                SendKeys.of(BookingData.getData().get("ciudad").toString()).into(INPUT_SEARCH_BOX_ACCOMMODATION_DESTINATION),
                WaitUntil.the(SELECT_ACCOMMODATION_DESTINATION, isEnabled()).forNoMoreThan(5).seconds(),
                Click.on(SELECT_ACCOMMODATION_DESTINATION),

                WaitUntil.the(BTN_CONFIRM_DATES, isEnabled()).forNoMoreThan(5).seconds(),
                Click.on(BTN_CONFIRM_DATES),

                WaitUntil.the(SEARCH_BOX_ACCOMODATION_OCCUPANCY, isEnabled()).forNoMoreThan(5).seconds(),
                Click.on(SEARCH_BOX_ACCOMODATION_OCCUPANCY),

                WaitUntil.the(BTN_SELECT_CHILDREN_OPTION, isEnabled()).forNoMoreThan(5).seconds(),
                Click.on(BTN_SELECT_CHILDREN_OPTION),

                ScrollByText.toFindTheParameter(BookingData.getData().get("ageChildren").toString()),
                Click.on(BTN_OK),

                WaitUntil.the(BTN_CONFIRM_SELECT_ROOMS_AND_GUESTS, isEnabled()).forNoMoreThan(5).seconds(),
                Click.on(BTN_CONFIRM_SELECT_ROOMS_AND_GUESTS),

                Click.on(BTN_SEARCH)
        );
    }
}