/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.Company;

import com.core.entity.Entity;
import java.time.LocalDateTime;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author daan-
 */
public class Company extends Entity {

    private final StringProperty name;
    private final StringProperty street;
    private final StringProperty zipcode;
    private final StringProperty city;
    private final StringProperty mobile;
    private final StringProperty iban;
    private final StringProperty btw;
    private final StringProperty kvk;

    public Company(int primaryKey, String name, String street, String zipcode, String city, String mobile, String iban, String btw, String kvk) {
        super(primaryKey);
        this.name = new SimpleStringProperty(name);
        this.street = new SimpleStringProperty(street);
        this.zipcode = new SimpleStringProperty(zipcode);
        this.city = new SimpleStringProperty(city);
        this.mobile = new SimpleStringProperty(mobile);
        this.iban = new SimpleStringProperty(iban);
        this.btw = new SimpleStringProperty(btw);
        this.kvk = new SimpleStringProperty(kvk);
    }

    public Company(int primaryKey, LocalDateTime createdAt, LocalDateTime lastMod, String name, String street, String zipcode, String city, String mobile, String iban, String btw, String kvk) {
        super(primaryKey, createdAt, lastMod);
        this.name = new SimpleStringProperty(name);
        this.street = new SimpleStringProperty(street);
        this.zipcode = new SimpleStringProperty(zipcode);
        this.city = new SimpleStringProperty(city);
        this.mobile = new SimpleStringProperty(mobile);
        this.iban = new SimpleStringProperty(iban);
        this.btw = new SimpleStringProperty(btw);
        this.kvk = new SimpleStringProperty(kvk);
    }

    public String getName() {
        return name.get();
    }

    public void setName(String value) {
        name.set(value);
    }

    public StringProperty getNameProperty() {
        return name;
    }

    public String getStreet() {
        return street.get();
    }

    public void setStreet(String value) {
        street.set(value);
    }

    public StringProperty getStreetProperty() {
        return street;
    }

    public String getZipcode() {
        return zipcode.get();
    }

    public void setZipcode(String value) {
        zipcode.set(value);
    }

    public StringProperty getZipcodeProperty() {
        return zipcode;
    }

    public String getCity() {
        return city.get();
    }

    public void setCity(String value) {
        city.set(value);
    }

    public StringProperty getCityProperty() {
        return city;
    }

    public String getMobile() {
        return mobile.get();
    }

    public void setMobile(String value) {
        mobile.set(value);
    }

    public StringProperty getMobileProperty() {
        return mobile;
    }

    public String getIban() {
        return iban.get();
    }

    public void setIban(String value) {
        iban.set(value);
    }

    public StringProperty getIbanProperty() {
        return iban;
    }

    public String getBtw() {
        return btw.get();
    }

    public void setBtw(String value) {
        btw.set(value);
    }

    public StringProperty getBtwProperty() {
        return btw;
    }

    public String getKvk() {
        return kvk.get();
    }

    public void setKvk(String value) {
        kvk.set(value);
    }

    public StringProperty getKvkProperty() {
        return kvk;
    }

}
