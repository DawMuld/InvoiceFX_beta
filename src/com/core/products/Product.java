/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.products;

import com.core.entity.Entity;
import java.time.LocalDateTime;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author daan-
 */
public class Product extends Entity {

    private final StringProperty id;
    private final StringProperty name;
    private final StringProperty details;
    private final DoubleProperty purchasePrice;
    private final DoubleProperty sellingPrice;

    public Product(int primaryKey, String name, double sellingPrice) {
        super(primaryKey);
        this.id = new SimpleStringProperty(String.valueOf(super.getPrimaryKey()));
        this.name = new SimpleStringProperty(name);
        this.details = new SimpleStringProperty(name);
        this.purchasePrice = new SimpleDoubleProperty(sellingPrice);
        this.sellingPrice = new SimpleDoubleProperty(sellingPrice);
    }

    public Product(int primaryKey, LocalDateTime createdAt, LocalDateTime lastMod, String id, String name, String details, double purchasePrice, double sellingPrice) {
        super(primaryKey, createdAt, lastMod);
        this.id = new SimpleStringProperty(id);
        this.name = new SimpleStringProperty(name);
        this.details = new SimpleStringProperty(details);
        this.purchasePrice = new SimpleDoubleProperty(purchasePrice);
        this.sellingPrice = new SimpleDoubleProperty(sellingPrice);
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

    public String getDetails() {
        return details.get();
    }

    public void setDetails(String value) {
        details.set(value);
    }

    public StringProperty getDetailsProperty() {
        return details;
    }

    public double getPurchasePrice() {
        return purchasePrice.get();
    }

    public void setPurchasePrice(double value) {
        purchasePrice.set(value);
    }

    public DoubleProperty getPurchasePriceProperty() {
        return purchasePrice;
    }

    public double getSellingPrice() {
        return sellingPrice.get();
    }

    public void setSellingPrice(double value) {
        sellingPrice.set(value);
    }

    public DoubleProperty getSellingPriceProperty() {
        return sellingPrice;
    }

}
