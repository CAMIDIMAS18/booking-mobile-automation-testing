/**
 * Pending...
 */
package co.com.booking.tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;

import static co.com.booking.userinterface.stays.AccommodationDatesPage.*;

public class SelectStayDates {

    public static Performable from(String startDate, String endDate) {
        return Task.where(
                Scroll.to(SELECT_START_DATE.of(startDate)),
                Click.on(SELECT_START_DATE),
                Scroll.to(SELECT_END_DATE.of(startDate)),
                Click.on(SELECT_START_DATE),
                Click.on(BTN_CONFIRM_DATES)
        );
    }
}
