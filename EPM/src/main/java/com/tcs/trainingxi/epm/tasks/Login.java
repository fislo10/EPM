package com.tcs.trainingxi.epm.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.tcs.trainingxi.epm.ui.LoginPage.*;

public class Login implements Task {

    private String email;
    private String password;

    public Login(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(EMAIL_FIELD, WebElementStateMatchers.isVisible()),
                Enter.theValue(email).into(EMAIL_FIELD),
                Enter.theValue(password).into(PASSWORD_FIELD),
                Click.on(SIGNIN_BUTTON)
        );
    }

    public static Login with(String email, String password){
        return Tasks.instrumented(Login.class, email, password);
    }



}
