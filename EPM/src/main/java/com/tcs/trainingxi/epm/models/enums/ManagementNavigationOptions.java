package com.tcs.trainingxi.epm.models.enums;

public enum ManagementNavigationOptions {

    CLIENTE("Clientes"),
    PAGA_TU_FACTURA("Paga tu factura"),
    PERFIL("perfil");

    private String option;

    ManagementNavigationOptions(String option) {
        this.setOption(option);
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

}
