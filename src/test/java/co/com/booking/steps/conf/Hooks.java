package co.com.booking.steps.conf;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Steps;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;


public class Hooks {
    public static final Actor CAMILA = Actor.named("Camila");
    @Steps(shared = true)
    SharedComponents sharedComponents;
    private AppiumDriver driver;

    @Before
    public void setup(Scenario scenario) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "11");
        capabilities.setCapability("deviceName", "DevicePixel2");
        capabilities.setCapability("appium:app", System.getProperty("user.dir") + "/apps/booking-com-32-9.apk");
        capabilities.setCapability("appium:ensureWebviewsHavePages", true);

        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), capabilities);

        sharedComponents.setDriver(driver);

        OnStage.setTheStage(new OnlineCast());
        CAMILA.whoCan(BrowseTheWeb.with(driver));
    }

}
