package com.tcs.trainingxi.epm.ui;

import net.serenitybdd.screenplay.targets.Target;

public class LoginPage {

    public static final Target EMAIL_FIELD = Target.the("email field").locatedBy("//input[@id='ctl00_cphPrincipal_txtCorreo']");

    public static final Target PASSWORD_FIELD = Target.the("password field").locatedBy("//input[@id='ctl00_cphPrincipal_txtClave']");

    public static final Target SIGNIN_BUTTON = Target.the("sig in button").locatedBy("//input[@id='ctl00_cphPrincipal_btnIngresar']");

}
