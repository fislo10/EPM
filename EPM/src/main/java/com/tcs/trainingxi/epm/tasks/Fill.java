package com.tcs.trainingxi.epm.tasks;

import com.tcs.trainingxi.epm.models.UserData;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;


import static com.tcs.trainingxi.epm.ui.ProfilePage.FIELD;

public class Fill implements Task {

    private String fieldName;
    private String fieldAddress;
    private String fieldPhone;
    private String fieldCellphone;
    private UserData userData;

    public Fill(String fieldName, String fieldAddress, String fieldPhone, String fieldCellphone, UserData userData) {
        this.fieldName = fieldName;
        this.fieldAddress = fieldAddress;
        this.fieldPhone = fieldPhone;
        this.fieldCellphone = fieldCellphone;
        this.userData = userData;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(FIELD.of(fieldName), WebElementStateMatchers.isVisible()),
                Enter.theValue(userData.getName()).into(FIELD.of(fieldName)),
                Enter.theValue(userData.getAddress()).into(FIELD.of(fieldAddress)),
                Enter.theValue(userData.getPhone()).into(FIELD.of(fieldPhone)),
                Enter.theValue(userData.getCellphone()).into(FIELD.of(fieldCellphone)));
    }

    public static Fill profileForm(String fieldName, String fieldAddress, String fieldPhone, String fieldCellphone, UserData userData){
        return Tasks.instrumented(Fill.class, fieldName,fieldAddress,fieldPhone,fieldCellphone,userData);
    }

}
