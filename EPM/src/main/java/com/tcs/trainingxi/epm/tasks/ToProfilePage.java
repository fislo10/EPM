package com.tcs.trainingxi.epm.tasks;


import com.tcs.trainingxi.epm.ui.MiFacturaWebPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public class ToProfilePage implements Task {

    private String option;

    public ToProfilePage(String option) {
        this.option = option;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(MiFacturaWebPage.MY_ACCOUNT_OPTION.of(option))
        );
    }


}
