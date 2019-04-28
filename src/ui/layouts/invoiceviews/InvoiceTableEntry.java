/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.layouts.invoiceviews;

import com.core.Company.Company;
import com.core.Company.CompanyLayer;
import com.core.customers.Customer;
import com.core.customers.CustomerLayer;
import com.core.invoices.Invoice;
import com.core.invoices.InvoiceCalculator;
import com.core.persistence.Formatter;
import com.core.persistence.TimeStamper;
import java.time.LocalDateTime;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

/**
 *
 * @author daan-
 */
public class InvoiceTableEntry {

    private final ObjectProperty<Invoice> invoice;



    public InvoiceTableEntry(Invoice invoice) {
        this.invoice = new SimpleObjectProperty<>(invoice);
    }



    public Invoice getInvoice() {
        return invoice.get();
    }



    public String getInvoiceDate() {
        return TimeStamper.DF.format(invoice.get().getInvoiceDate());
    }



    public void setInvoiceDate(String value) {
        if (value != null && !value.isEmpty()) {
            String[] cells = value.split("-");
            if (cells.length >= 3) {
                int v1 = Integer.parseInt(cells[0]);
                int v2 = Integer.parseInt(cells[1]);
                int v3 = Integer.parseInt(cells[2]);
                if (v1 < 33) {
                    LocalDateTime ldt = LocalDateTime.of(v3, v2, v1, 0, 0, 0);
                    invoice.get().setInvoiceDate(ldt);
                } else {
                    LocalDateTime ldt = LocalDateTime.of(v1, v2, v3, 0, 0, 0);
                    invoice.get().setInvoiceDate(ldt);
                }
            }
        }
    }



    public String getCompanyName() {
        int key = invoice.get().getCompanyKey();
        if (key >= 0) {
            Company company = CompanyLayer.find(key);
            if (company != null) {
                return company.getName();
            }
        }
        return " ";
    }



    public void setCompanyName(String value) {
        //
    }



    public String getCustomerName() {
        int key = invoice.get().getCustomerKey();
        Customer customer = CustomerLayer.find(key);
        if (customer != null) {
            return customer.getName();
        }
        return "-";
    }



    public void setCustomerName(String value) {
        //
    }



    public String getTotalEx() {
        double totalEx = InvoiceCalculator.totalEx(invoice.get().getItemList());
        return "€ " + Formatter.formatPrice(totalEx);
    }



    public void setTotalEx(String value) {
        //
    }



    public String getTotalTax() {
        double totalEx = InvoiceCalculator.totalTax(invoice.get().getItemList());
        return "€ " + Formatter.formatPrice(totalEx);
    }



    public void setTotalTax(String value) {
        //
    }



    public String getTotalInc() {
        double totalEx = InvoiceCalculator.totalInc(invoice.get().getItemList());
        return "€ " + Formatter.formatPrice(totalEx);
    }



    public void setTotalInc(String value) {
        //
    }

}
