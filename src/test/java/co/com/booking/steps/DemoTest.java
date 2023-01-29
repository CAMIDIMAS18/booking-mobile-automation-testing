/*
package co.com.booking.steps;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.net.URL;
import java.time.Duration;

public class DemoTest {
    public AndroidTouchAction actions;
    private AndroidDriver<WebElement> driver;

    @Before
    public void setUp() throws IOException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("automationName", "uiautomator2");
        caps.setCapability("platformName", "Android");
        caps.setCapability("appium:platformVersion", "11.0");
        caps.setCapability("appium:deviceName", "DevicePixel2");
        caps.setCapability("appium:newCommandTimeout", 3600);
        caps.setCapability("appium:app", System.getProperty("user.dir") + "/apps/booking-com-32-9.apk");
        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), caps);
        System.out.println("Automated application started!");
    }

    private void scrollDown() {
        Dimension dimension = driver.manage().window().getSize();
        int scrollStart = (int) (dimension.getHeight() * 0.8);
        int scrollEnd = (int) (dimension.getHeight() * 0.1);

        actions = new AndroidTouchAction(driver)
                .press(PointOption.point(600, 600))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
                .moveTo(PointOption.point(600, -100))
                .release()
                .perform();
    }


    @Test
    public void test_Appium() throws InterruptedException {
        Thread.sleep(2000);
        AndroidElement closeButton = (AndroidElement) driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']"));
        closeButton.click();
        System.out.println("Click en 'CERRAR VENTANA'");

        Thread.sleep(2000);
        AndroidElement selectBoxDestination = (AndroidElement) driver.findElement(By.id("com.booking:id/facet_search_box_accommodation_destination"));
        selectBoxDestination.click();
        System.out.println("Click  'SELECCIONAR DESTINO'");

        Thread.sleep(2000);
        AndroidElement enterDestination = (AndroidElement) driver.findElement(
                By.id("com.booking:id/facet_with_bui_free_search_booking_header_toolbar_content"));
        enterDestination.click();
        enterDestination.sendKeys("CUSCO");
        System.out.println("Click y Escribe en 'CAJA DE TEXTO DEL DESTINO'");

        Thread.sleep(2000);
        AndroidElement selectDestination = (AndroidElement) driver.findElement(By.xpath(
                "//android.widget.TextView[1][@resource-id='com.booking:id/view_disambiguation_destination_title']"
        ));
        selectDestination.click();
        System.out.println("Click en 'OPCIÓN CUSCO'");


        Thread.sleep(2000);
        System.out.println("Esperé....");

        scrollDown();

        Thread.sleep(5000);
        System.out.println("Esperé....");


        AndroidElement dateCheckin = (AndroidElement) driver.findElementByAccessibilityId("14 February 2023");
        dateCheckin.click();

        Thread.sleep(1000);
        AndroidElement dateCheckout = (AndroidElement) driver.findElementByAccessibilityId("28 February 2023");
        dateCheckout.click();


        Thread.sleep(1000);
        AndroidElement btnDatePickerConfirm = (AndroidElement) driver.findElement(
                By.id("com.booking:id/facet_date_picker_confirm"));
        Thread.sleep(1000);
        btnDatePickerConfirm.click();
        System.out.println("Click en 'CONFIRMAR FECHAS'");
        Thread.sleep(1000);
    }

    @After
    public void tearDown() {
        if (null != driver) {
            driver.quit();
        }
    }
}
*/
