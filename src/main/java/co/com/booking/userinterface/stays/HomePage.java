package co.com.booking.userinterface.stays;

import io.appium.java_client.AppiumBy;
import net.serenitybdd.screenplay.targets.Target;

public class HomePage {
    public static final Target SEARCH_FIELDS = Target.the("search fields for stays")
            .located(AppiumBy.xpath("//android.widget.LinearLayout[@resource-id='com.booking:id/facet_search_box_fields']"));
    public static final Target SEARCH_BOX_ACCOMMODATION_DESTINATION = Target.the("option for accommodation destination")
            .located(AppiumBy.id("com.booking:id/facet_search_box_accommodation_destination"));
    public static final Target SEARCH_BOX_ACCOMMODATION_DATES = Target.the("option for accommodation destination")
            .located(AppiumBy.id("com.booking:id/facet_search_box_accommodation_dates"));
    public static final Target SEARCH_BOX_ACCOMODATION_OCCUPANCY = Target.the("option for accommodation occupancy")
            .located(AppiumBy.id("com.booking:id/facet_search_box_accommodation_occupancy"));
    public static final Target ALERT_MESSAGE_ERROR = Target.the("alerta with message error'")
            .located(AppiumBy.id("com.booking:id/message"));
    public static final Target SEARCH_BOX_ACCOMMODATION = Target.the("button to search accommodation")
            .located(AppiumBy.xpath("//android.widget.Button[@resource-id='com.booking:id/facet_search_box_cta']"));

    private HomePage() {
        //Nothing
    }
}
