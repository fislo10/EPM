package com.tcs.trainingxi.epm.models.enums;

public enum ManagementWindows {

    FACTURA_WEB_INICIO("Factura Web - Inicio");

    private String window;

    ManagementWindows(String window) {
        this.setWindow(window);
    }

    public String getWindow() {
        return window;
    }

    public void setWindow(String window) {
        this.window = window;
    }

}
