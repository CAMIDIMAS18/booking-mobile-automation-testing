package co.com.booking.tasks.common;

import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

import static net.serenitybdd.screenplay.Tasks.instrumented;

@Deprecated
public class ScrollById implements Task {

    public static ScrollById toFindTheParameter() {
        return instrumented(ScrollById.class);
    }

    @Override
    @Step("Searching for the #text parameter in the options")
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        TouchAction action = new TouchAction((PerformsTouchActions) driver)
                .press(PointOption.point(600, 600))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
                .moveTo(PointOption.point(600, -100))
                .release()
                .perform();
    }
}
