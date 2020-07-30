package com.tcs.trainingxi.epm.tasks;

import net.serenitybdd.screenplay.Tasks;

public class Navigate {

    public static ToLoginPage toLoginPage(String transactionOption, String leftMenuOption){
        return Tasks.instrumented(ToLoginPage.class, transactionOption, leftMenuOption);
    }

    public static ToProfilePage toProfilePage(String option){
        return Tasks.instrumented(ToProfilePage.class, option);
    }

}
