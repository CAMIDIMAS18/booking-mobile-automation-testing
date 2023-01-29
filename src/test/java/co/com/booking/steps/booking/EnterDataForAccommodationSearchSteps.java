package co.com.booking.steps.booking;

import co.com.booking.tasks.SelectAccommodationDestination;
import co.com.booking.tasks.common.LoadDataTask;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static co.com.booking.steps.conf.Hooks.CAMILA;
import static co.com.booking.userinterface.ViewBookingPage.RESULT_BOOKING;
import static co.com.booking.utils.data.Constants.BOOKING_DATA;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;


public class EnterDataForAccommodationSearchSteps {

    public AndroidTouchAction actions;
    private WebDriver driver;


    private void scrollDown() {
        actions = new AndroidTouchAction((PerformsTouchActions) driver)
                .press(PointOption.point(600, 600))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
                .moveTo(PointOption.point(600, -100))
                .release()
                .perform();
    }

    private void verticalScroll() {
        AppiumDriver driver = ((AppiumDriver) ((WebDriverFacade) getDriver()).getProxiedDriver());
        WebElement element1 = driver.findElement(AppiumBy.id("com.booking:id/calendar_month_list"));
        int centerX = element1.getRect().x + (element1.getSize().width / 2);

        double startY = element1.getRect().y + (element1.getSize().height * 0.9);

        double endY = element1.getRect().y + (element1.getSize().height * 0.1);
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 1);
        swipe.addAction(finger.createPointerMove(Duration.ofSeconds(0), PointerInput.Origin.viewport(), centerX, (int) startY));
        swipe.addAction(finger.createPointerDown(0));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(700),
                PointerInput.Origin.viewport(), centerX, (int) endY));
        swipe.addAction(finger.createPointerUp(0));
        driver.perform(Arrays.asList(swipe));
    }

    @Cuando("ella ingresa los datos para la búsqueda de su alojamiento")
    public void enterDataForAccommodationSearch(List<Map<String, String>> datos) {
        CAMILA.wasAbleTo(LoadDataTask.informationBooking(datos.get(0)));
        CAMILA.remember(BOOKING_DATA, datos);

        CAMILA.attemptsTo(SelectAccommodationDestination.withCustomerData());

    }

    @Entonces("deberá visualizar los resultados de alojamientos disponibles")
    public void selectDestinationOption() {
        //CAMILA.attemptsTo(ScrollByText.toFindTheParameter("android:id/numberpicker_input", "Palacio del Inka"));
        // CAMILA.should(seeThat(IsEnabled.theTarget(RESULT_BOOKING), equalTo(true)));
        CAMILA.attemptsTo(
                Click.on(RESULT_BOOKING));
    }
}

