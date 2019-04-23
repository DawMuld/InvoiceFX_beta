/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customer;

import java.time.LocalDateTime;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author daan-
 */
public class Customer {

    private final IntegerProperty primaryKey;
    private final ObjectProperty<LocalDateTime> created;
    private final ObjectProperty<LocalDateTime> lastMod;
    private final StringProperty id;
    private final StringProperty name;
    private final StringProperty street;
    private final StringProperty zip;
    private final StringProperty city;

    public Customer(int primaryKey, String name, String street, String zip, String city) {
        this.primaryKey = new SimpleIntegerProperty(primaryKey);
        this.created = new SimpleObjectProperty<>(LocalDateTime.now());
        this.lastMod = new SimpleObjectProperty<>(LocalDateTime.now());
        this.id = new SimpleStringProperty(String.valueOf(primaryKey));
        this.name = new SimpleStringProperty(name);
        this.street = new SimpleStringProperty(street);
        this.zip = new SimpleStringProperty(zip);
        this.city = new SimpleStringProperty(city);
    }

    public Customer(int primaryKey, LocalDateTime created, LocalDateTime lastMod, String id, String name, String street, String zip, String city) {
        this.primaryKey = new SimpleIntegerProperty(primaryKey);
        this.created = new SimpleObjectProperty<>(created);
        this.lastMod = new SimpleObjectProperty<>(lastMod);
        this.id = new SimpleStringProperty(id);
        this.name = new SimpleStringProperty(name);
        this.street = new SimpleStringProperty(street);
        this.zip = new SimpleStringProperty(zip);
        this.city = new SimpleStringProperty(city);
    }

    public int getPrimaryKey() {
        return primaryKey.get();
    }

    public void setPrimaryKey(int value) {
        primaryKey.set(value);
    }

    public IntegerProperty getPrimaryKeyProperty() {
        return primaryKey;
    }

    public LocalDateTime getCreated() {
        return created.get();
    }

    public void setCreated(LocalDateTime value) {
        created.set(value);
    }

    public ObjectProperty<LocalDateTime> getCreatedProperty() {
        return created;
    }

    public LocalDateTime getLastMod() {
        return lastMod.get();
    }

    public void setLastMod(LocalDateTime value) {
        lastMod.set(value);
    }

    public ObjectProperty<LocalDateTime> getLastModProperty() {
        return lastMod;
    }

    public String getId() {
        return id.get();
    }

    public void setId(String value) {
        id.set(value);
    }

    public StringProperty getIdProperty() {
        return id;
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

    public String getZip() {
        return zip.get();
    }

    public void setZip(String value) {
        zip.set(value);
    }

    public StringProperty getZipProperty() {
        return zip;
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

}
