package com.tcs.trainingxi.epm.models;

import com.tcs.trainingxi.epm.models.builders.UserDataBuilder;

public class UserData {

    private String email;
    private String password;
    private String name;
    private String address;
    private String phone;
    private String cellphone;


    public UserData(UserDataBuilder userDataFields) {
        this.email = userDataFields.getListUserData().get(0).getEmail();
        this.password = userDataFields.getListUserData().get(0).getPassword();
        this.name = userDataFields.getListUserData().get(0).getName();
        this.address = userDataFields.getListUserData().get(0).getAddress();
        this.phone = userDataFields.getListUserData().get(0).getPhone();
        this.cellphone = userDataFields.getListUserData().get(0).getCellphone();
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getCellphone() {
        return cellphone;
    }

}
