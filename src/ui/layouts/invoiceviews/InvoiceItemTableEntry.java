/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.layouts.invoiceviews;

import com.core.invoices.InvoiceCalculator;
import com.core.invoices.InvoiceItem;
import com.core.persistence.Formatter;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

/**
 *
 * @author daan-
 */
public class InvoiceItemTableEntry {

    private ObjectProperty<InvoiceItem> item;



    public InvoiceItemTableEntry(InvoiceItem item) {
        this.item = new SimpleObjectProperty<>(item);
    }



    public InvoiceItem getInvoiceItem() {
        return item.get();
    }



    public String getId() {
        return item.get().getProductId();
    }



    public void setId(String value) {
    }



    public String getName() {
        return item.get().getProductName();
    }



    public void setName() {
        //
    }



    public String getQ() {
        return String.valueOf(item.get().getQuantity());
    }



    public void setQ(String value) {
        //
    }



    public String getUnitPrice() {
        return "€ " + Formatter.formatPrice(item.get().getUnitPrice());
    }



    public void setUnitPrice(String value) {
    }



    public String getTax() {
        return Formatter.asPercentage(item.get().getTax()) + "%";
    }



    public void setTax(String value) {
        //
    }



    public String getDiscount() {
        return Formatter.asPercentage(item.get().getDiscount()) + "%";
    }



    public void setDiscount(String value) {
        //
    }



    public String getTotalEx() {
        double total = InvoiceCalculator.itemResultEx(item.get());
        return "€ " + Formatter.formatPrice(total);
    }



    public void setTotalEx(String value) {
        //
    }

}
