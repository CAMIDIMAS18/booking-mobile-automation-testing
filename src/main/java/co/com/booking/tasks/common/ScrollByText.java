package co.com.booking.tasks.common;

import io.appium.java_client.AppiumBy;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ScrollByText implements Task {

    private String text;

    public ScrollByText(String text) {
        this.text = text;
    }

    public static ScrollByText toFindTheParameter(String text) {
        return instrumented(ScrollByText.class, text);
    }

    @Override
    @Step("Searching for the #text parameter in the list")
    public <T extends Actor> void performAs(T actor) {

        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true))" +
                        ".scrollIntoView(new UiSelector().textContains(\"" + text + "\"))"));
    }
}
