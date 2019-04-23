/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.invoices;

import com.core.products.Product;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author daan-
 */
public class InvoiceItem {

    private final StringProperty productId;
    private final StringProperty productName;
    private final IntegerProperty quantity;
    private final DoubleProperty unitPrice;
    private final DoubleProperty tax;
    private final DoubleProperty discount;

    public InvoiceItem(String productId, String productName, int quantity, double unitPrice, double tax, double discount) {
        this.productId = new SimpleStringProperty(productId);
        this.productName = new SimpleStringProperty(productName);
        this.quantity = new SimpleIntegerProperty(quantity);
        this.unitPrice = new SimpleDoubleProperty(unitPrice);
        this.tax = new SimpleDoubleProperty(tax);
        this.discount = new SimpleDoubleProperty(discount);
    }
    
    
    public InvoiceItem(Product product){
        this.productId = new SimpleStringProperty(product.getId());
        this.productName = new SimpleStringProperty(product.getName());
        this.quantity = new SimpleIntegerProperty(1);
        this.unitPrice = new SimpleDoubleProperty(product.getSellingPrice());
        this.tax = new SimpleDoubleProperty(0.21);
        this.discount = new SimpleDoubleProperty(0.0);
    }

    public String getProductId() {
        return productId.get();
    }

    public void setProductId(String value) {
        productId.set(value);
    }

    public StringProperty getProductIdProperty() {
        return productId;
    }

    public String getProductName() {
        return productName.get();
    }

    public void setProductName(String value) {
        productName.set(value);
    }

    public StringProperty getProductNameProperty() {
        return productName;
    }

    public int getQuantity() {
        return quantity.get();
    }

    public void setQuantity(int value) {
        quantity.set(value);
    }

    public IntegerProperty getQuantityProperty() {
        return quantity;
    }

    public double getUnitPrice() {
        return unitPrice.get();
    }

    public void setUnitPrice(double value) {
        unitPrice.set(value);
    }

    public DoubleProperty getUnitPriceProperty() {
        return unitPrice;
    }

    public double getTax() {
        return tax.get();
    }

    public void setTax(double value) {
        tax.set(value);
    }

    public DoubleProperty getTaxProperty() {
        return tax;
    }

    public double getDiscount() {
        return discount.get();
    }

    public void setDiscount(double value) {
        discount.set(value);
    }

    public DoubleProperty getDiscountProperty() {
        return discount;
    }

}
