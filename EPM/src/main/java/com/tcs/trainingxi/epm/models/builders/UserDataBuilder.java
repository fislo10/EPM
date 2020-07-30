package com.tcs.trainingxi.epm.models.builders;

import com.tcs.trainingxi.epm.models.UserData;
import javafx.util.Builder;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserDataBuilder implements Builder<UserData>{


    private String email;
    private String password;
    private String name;
    private String address;
    private String phone;
    private String cellphone;



    protected static UserData objUserData;
    private List<UserDataBuilder> listUserData = new ArrayList<>();

    private UserDataBuilder(Map<String, String> data) {
        this.email= data.get("email");
        this.password = data.get("password");
        this.name= data.get("name");
        this.address = data.get("fieldAddress");
        this.phone= data.get("fieldPhone");
        this.cellphone = data.get("fieldCellphone");
    }

    public static UserDataBuilder UserDataInformation(List<Map<String, String>> mapList) {
        return new UserDataBuilder(mapList);
    }

    public UserDataBuilder(List<Map<String, String>> dataCard) {
        createConstructor(dataCard);
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

    private void createConstructor(List<Map<String, String>> dataCard) {
        for (Map<String, String> data : dataCard) {
            listUserData.add(new UserDataBuilder(data));
        }
    }

    public static void setUserdata(UserData userData) {
        UserDataBuilder.objUserData = userData;
    }

    @Override
    public UserData build() {
        UserData createdUserData = new UserData(this);
        UserDataBuilder.setUserdata(createdUserData);
        return createdUserData;
    }

    public List<UserDataBuilder> getListUserData() {
        return listUserData;
    }

}