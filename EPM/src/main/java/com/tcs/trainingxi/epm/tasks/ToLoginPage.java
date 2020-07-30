package com.tcs.trainingxi.epm.tasks;

import com.tcs.trainingxi.epm.interactions.SwitchToWindow;
import com.tcs.trainingxi.epm.ui.PopUpComponent;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static com.tcs.trainingxi.epm.models.enums.ManagementWindows.FACTURA_WEB_INICIO;
import static com.tcs.trainingxi.epm.ui.FacturaWebPage.LOGIN_BUTTON;
import static com.tcs.trainingxi.epm.ui.HomePage.TRANSACCIONES_BUTTON;
import static com.tcs.trainingxi.epm.ui.PopUpComponent.*;

public class ToLoginPage implements Task {

    private String leftMenuOption;
    private String transactionOption;


    public ToLoginPage(String transactionOption ,String leftMenuOption) {
        this.leftMenuOption = leftMenuOption;
        this.transactionOption = transactionOption;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(CLOSE_POPUP),
                Click.on(TRANSACCIONES_BUTTON),
                Click.on(TRANSACTION_OPTION.of(transactionOption)),
                Click.on(LEFT_MENU_OPTION.of(leftMenuOption)),
                Click.on(CLOSE_TRANSACTIONS),
                SwitchToWindow.withTitle(FACTURA_WEB_INICIO.getWindow()),
                Click.on(LOGIN_BUTTON));
    }

}
