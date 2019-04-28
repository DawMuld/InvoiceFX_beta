/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.layouts.invoiceviews;

import com.core.customers.Customer;
import com.core.customers.CustomerLayer;
import com.core.invoices.Invoice;
import com.core.invoices.InvoiceCalculator;
import com.core.persistence.Formatter;
import com.gui.custom.ColorListCell;
import com.gui.laf.WindowBuilder;
import java.time.format.DateTimeFormatter;
import javafx.scene.control.Label;

/**
 *
 * @author daan-
 */
public class InvoiceListCell extends ColorListCell<Invoice> {

    public static DateTimeFormatter DTF = DateTimeFormatter.ofPattern("dd-MM-yyyy");



    @Override
    public void updateItem(Invoice item, boolean empty) {
        super.updateItem(item, empty);
        if (!empty) {
            Label dateLabel = WindowBuilder.createWhiteLabel(DTF.format(item.getInvoiceDate()));
            Label nameLabel = WindowBuilder.createWhiteLabel(" ");
            if (item.getCustomerKey() > 0) {
                Customer customer = CustomerLayer.find(item.getCustomerKey());
                if (customer != null) {
                    nameLabel.setText(customer.getName());
                }
            }
            double total = 0.0;
            if (item.getItemList() != null && !item.getItemList().isEmpty()) {
                total = InvoiceCalculator.totalEx(item.getItemList());
            }
            Label totalLabel = WindowBuilder.createWhiteLabel("€  " + Formatter.formatPrice(total));
            nameLabel.setMinWidth(200);
            super.getRoot().getChildren().addAll(dateLabel, nameLabel, totalLabel);
            selectedProperty().addListener((o, v1, v2) -> {
                if (v2 == true) {
                    nameLabel.setFont(F2);
                    dateLabel.setFont(F2);
                    totalLabel.setFont(F2);
                } else {
                    nameLabel.setFont(F1);
                    dateLabel.setFont(F1);
                    totalLabel.setFont(F1);
                }
            });
        }

    }

}
