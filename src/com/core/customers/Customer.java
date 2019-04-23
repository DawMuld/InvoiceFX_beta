/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.customers;

import com.core.entity.Entity;
import java.time.LocalDateTime;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author daan-
 */
public class Customer extends Entity {

    private final StringProperty id;
    private final StringProperty name;
    private final StringProperty street;
    private final StringProperty zipcode;
    private final StringProperty city;
    private final StringProperty email;
    private final StringProperty phone;
    private final StringProperty mobile;

    public Customer(int primaryKey, String name, String street, String zipcode, String city) {
        super(primaryKey);
        this.id = new SimpleStringProperty(String.valueOf(super.getPrimaryKey()));
        this.name = new SimpleStringProperty(name);
        this.street = new SimpleStringProperty(street);
        this.zipcode = new SimpleStringProperty(zipcode);
        this.city = new SimpleStringProperty(city);
        this.email = new SimpleStringProperty("");
        this.phone = new SimpleStringProperty("");
        this.mobile = new SimpleStringProperty("");
    }

    public Customer(int primaryKey, LocalDateTime createdAt, LocalDateTime lastMod, String id, String name, String street, String zipcode, String city, String email, String phone, String mobile) {
        super(primaryKey, createdAt, lastMod);
        this.id = new SimpleStringProperty(id);
        this.name = new SimpleStringProperty(name);
        this.street = new SimpleStringProperty(street);
        this.zipcode = new SimpleStringProperty(zipcode);
        this.city = new SimpleStringProperty(city);
        this.email = new SimpleStringProperty("");
        if (email != null && email.length() > 1) {
            this.email.set(email);
        }
        this.phone = new SimpleStringProperty("");
        if (phone != null && phone.length() > 1) {
            this.phone.set(phone);
        }
        this.mobile = new SimpleStringProperty("");
        if (mobile != null && mobile.length() > 1) {
            this.mobile.set(mobile);
        }
    }

    public String getId() {
        return id.get();
    }

    public void setId(String value) {
        if (value == null || value.length() < 1) {
            return;
        }
        id.set(value);
    }

    public StringProperty getIdProperty() {
        return id;
    }

    public String getName() {
        return name.get();
    }

    public void setName(String value) {
        if (value == null || value.length() < 1) {
            return;
        }
        name.set(value);
    }

    public StringProperty getNameProperty() {
        return name;
    }

    public String getStreet() {
        return street.get();
    }

    public void setStreet(String value) {
        if (value == null || value.length() < 1) {
            return;
        }
        street.set(value);
    }

    public StringProperty getStreetProperty() {
        return street;
    }

    public String getZipcode() {
        return zipcode.get();
    }

    public void setZipcode(String value) {
        if (value == null || value.length() < 1) {
            return;
        }
        zipcode.set(value);
    }

    public StringProperty getZipcodeProperty() {
        return zipcode;
    }

    public String getCity() {
        return city.get();
    }

    public void setCity(String value) {
        if (value == null || value.length() < 1) {
            return;
        }
        city.set(value);
    }

    public StringProperty getCityProperty() {
        return city;
    }

    public String getEmail() {
        return email.get();
    }

    public void setEmail(String value) {
        if (value == null || value.length() < 1) {
            return;
        }
        email.set(value);
    }

    public StringProperty getEmailProperty() {
        return email;
    }

    public String getPhone() {
        return phone.get();
    }

    public void setPhone(String value) {
        if (value == null || value.length() < 1) {
            return;
        }
        phone.set(value);
    }

    public StringProperty getPhoneProperty() {
        return phone;
    }

    public String getMobile() {
        return mobile.get();
    }

    public void setMobile(String value) {
        if (value == null || value.length() < 1) {
            return;
        }
        mobile.set(value);
    }

    public StringProperty getMobileProperty() {
        return mobile;
    }

}
