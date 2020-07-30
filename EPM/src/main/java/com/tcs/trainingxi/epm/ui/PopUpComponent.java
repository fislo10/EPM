package com.tcs.trainingxi.epm.ui;

import net.serenitybdd.screenplay.targets.Target;

public class PopUpComponent {

    public static final Target CLOSE_POPUP = Target.the("close popup button").locatedBy("//div[@class='contenido']/span[@class='close-popup']");

    public static final Target CLOSE_TRANSACTIONS = Target.the("close popup button").locatedBy("//div[@class='contentTabs']//a[@class='xTransacciones2']");

    public static final Target TRANSACTION_OPTION = Target.the("{0} option").locatedBy("//ul[@class='tabs-root-transacciones']//a[contains(@id, '{0}')]");

    public static final Target LEFT_MENU_OPTION = Target.the("{0} option").locatedBy("//div[@id='Clientes']//a[text()='{0}']");

    public static final Target FINAL_MESSAGE_FAIL = Target.the("fail message").locatedBy("//div[@id='simple-modal-required']//div[@class='contents']");

    public static final Target FINAL_MESSAGE_SUCCESSFULL = Target.the("successfull message").locatedBy("//div[@class='simple-modal-body']//span[@id='ctl00_panelMensajes_lblExito']");

}
