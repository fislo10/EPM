package com.tcs.trainingxi.epm.ui;

import net.serenitybdd.screenplay.targets.Target;

public class ProfilePage {

    public static final Target FIELD = Target.the(" {0} field").locatedBy("//input[contains(@id,'{0}')]");

    public static final Target SAVE_CHANGES_BTN = Target.the("save changes button").locatedBy("//div[@class='grid_12 guardarDatosMiPerfil']/input[@id='ctl00_cphPrincipal_btnGuardar']");

}
