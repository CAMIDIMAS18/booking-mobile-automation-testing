package co.com.booking.interaction.mobile;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class WaitElement implements Interaction {

	private final Target target;
	private final String state;
	private static final Logger LOGGER = LoggerFactory.getLogger(WaitElement.class.getSimpleName());

	public WaitElement(Target target, String state) {
		this.state = state;
		this.target = target;
	}

	@Override
	@Step("{0} waits the #target until be #state")
	public <T extends Actor> void performAs(T actor) {

		switch (state) {
		case "Visible":
			waitAs(actor).until(ExpectedConditions.visibilityOf(target.resolveFor(actor)));
			break;
		case "Invisible":
			waitAs(actor).until(ExpectedConditions.invisibilityOf(target.resolveFor(actor)));
			break;
		case "Enabled":
			waitAs(actor).until(ExpectedConditions.elementToBeClickable(target.resolveFor(actor)));
			break;
		default:
			LOGGER.info("No se encontró el case");
			break;
		}
	}

	private WebDriverWait waitAs(Actor actor) {
		return new WebDriverWait(BrowseTheWeb.as(actor).getDriver(), Duration.ofSeconds(6000));
	}

	public static WaitElement untilAppears(Target target) {
		return Tasks.instrumented(WaitElement.class, target, "Visible");
	}

	public static WaitElement untilDisappears(Target target) {
		return Tasks.instrumented(WaitElement.class, target, "Invisible");
	}

	public static WaitElement untilBeEnabled(Target target) {
		return Tasks.instrumented(WaitElement.class, target, "Enabled");
	}
}
