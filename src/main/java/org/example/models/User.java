package org.example.models;

import java.util.ArrayList;
import java.util.List;

public class User extends AbstractModel{
    private String login;
    private String password;
    private String email;
    List<Advertise> listUserAdvertises = new ArrayList<Advertise>();

    public User(String login, String password, String email) {
        this.login = login;
        this.password = password;
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void addAdvertise(Advertise advert){
        listUserAdvertises.add(advert);
    }
}
