package com.shop.supermarket.dto;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Customerdto {


    private int id;
    private String username;
//    @NotEmpty(message = "password cannot be empty")
//    @Size(min = 4,message = "password should be of min length 4")
    private String password;
    private String email;
    private String address;
    private String  number;
    private short enabled;

    public Customerdto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public short getEnabled() {
        return enabled;
    }

    public void setEnabled(short enabled) {
        this.enabled = enabled;
    }

    public Customerdto(int id, String username, String password, String email, String address, String number, short enabled) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.address = address;
        this.number = number;
        this.enabled = enabled;
    }


}
