package com.tcs.trainingxi.epm.models.enums;

public enum ManagementUrl {

    EPM_URL("https://www.epm.com.co/site/");

    private String url;

    ManagementUrl(String url) {
        this.setUrl(url);
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
