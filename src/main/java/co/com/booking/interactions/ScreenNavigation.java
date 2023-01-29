package co.com.booking.interactions;

import io.appium.java_client.AppiumBy;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;

public class ScreenNavigation {
    static WebDriver driver = BrowseTheWeb.as(theActorCalled("Camila")).getDriver();

    private ScreenNavigation() {
        //Nothing
    }

    public static WebElement verticalScrollToAnElementByResourceIdAndText(String resourceId, String text) {
        return driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).setAsVerticalList()" +
                        ".scrollIntoView(new UiSelector().resourceId(\"" + resourceId + "\").text(\"" + text + "\"));"));
    }

    public static WebElement horizontalScrollToAnElementByResourceIdAndText(String resourceId, String text) {
        return driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).setAsHorizontalList()" +
                        ".scrollIntoView(new UiSelector().resourceId(\"" + resourceId + "\").text(\"" + text + "\"));"));
    }

    public static WebElement scrollToAnElementByText(String text) {
        return driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true))" +
                        ".scrollIntoView(new UiSelector().textContains(\"" + text + "\"))"));
    }

}
