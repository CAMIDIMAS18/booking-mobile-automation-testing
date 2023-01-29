package co.com.booking.questions;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.annotations.Subject;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

@Subject("the #target is displayed - ")
public class IsDisplayed implements Question<Boolean> {

    private Target target;

    public IsDisplayed(Target target) {
        this.target = target;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        actor.attemptsTo(
            WaitUntil.the(target, isVisible())
                .forNoMoreThan(10)
                .seconds(),
            Scroll.to(target)
        );
        return target.resolveFor(actor).isDisplayed();
    }

    public static IsDisplayed theTarget(Target target) {
        return Instrumented.instanceOf(IsDisplayed.class).withProperties(target);
    }

}
