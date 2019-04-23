/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.invoices;

import com.core.entity.Entity;
import java.time.LocalDateTime;
import java.util.List;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author daan-
 */
public class Invoice extends Entity {

    private final IntegerProperty companyKey;
    private final IntegerProperty customerKey;
    private final ObjectProperty<LocalDateTime> invoiceDate;
    private final ListProperty<InvoiceItem> itemList;

    public Invoice(int primaryKey) {
        super(primaryKey);
        this.companyKey = new SimpleIntegerProperty(-1);
        this.customerKey = new SimpleIntegerProperty(-1);
        this.invoiceDate = new SimpleObjectProperty(LocalDateTime.now());
        this.itemList = new SimpleListProperty<>(FXCollections.observableArrayList());
    }

    public Invoice(int primaryKey, LocalDateTime createdAt, LocalDateTime lastMod, int companyKey, int customerKey, LocalDateTime invoiceDate, ObservableList<InvoiceItem> itemList) {
        super(primaryKey, createdAt, lastMod);
        this.companyKey = new SimpleIntegerProperty(companyKey);
        this.customerKey = new SimpleIntegerProperty(customerKey);
        this.invoiceDate = new SimpleObjectProperty(invoiceDate);
        this.itemList = new SimpleListProperty<>(itemList);
    }

    public int getCompanyKey() {
        return companyKey.get();
    }

    public void setCompanyKey(int value) {
        companyKey.set(value);
    }

    public IntegerProperty getCompanyKeyProperty() {
        return companyKey;
    }

    public int getCustomerKey() {
        return customerKey.get();
    }

    public void setCustomerKey(int value) {
        customerKey.set(value);
    }

    public IntegerProperty getCustomerKeyProperty() {
        return customerKey;
    }

    public LocalDateTime getInvoiceDate() {
        return invoiceDate.get();
    }

    public void setInvoiceDate(LocalDateTime value) {
        invoiceDate.set(value);
    }

    public ObjectProperty<LocalDateTime> getInvoiceDateProperty() {
        return invoiceDate;
    }

    public void addItem(InvoiceItem item) {
        InvoiceCalculator.addItem(itemList.get(), item);
    }

    public void removeItem(InvoiceItem item) {
        InvoiceCalculator.removeItem(itemList.get(), item);
    }

    public ObservableList<InvoiceItem> getItemList() {
        return itemList.get();
    }

    public void setItemList(List<InvoiceItem> items) {
        for (InvoiceItem item : items) {
            addItem(item);
        }
    }

    public ListProperty<InvoiceItem> getItemListProperty() {
        return itemList;
    }

    public double getTotalEx() {
        return InvoiceCalculator.totalEx(itemList.get());
    }

    public double getTotalTax() {
        return InvoiceCalculator.totalTax(itemList.get());
    }

    public double getTotalInc() {
        return InvoiceCalculator.totalInc(itemList.get());
    }

}
