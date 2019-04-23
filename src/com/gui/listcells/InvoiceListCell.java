/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gui.listcells;

import com.core.customers.Customer;
import com.core.customers.CustomerLayer;
import com.core.invoices.Invoice;
import com.gui.laf.Backgrounds;
import com.core.persistence.Formatter;
import com.gui.laf.Nunito;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.FlowPane;

/**
 *
 * @author daan-
 */
public class InvoiceListCell extends ListCell<Invoice> {

    private Customer customer;

    @Override
    public void updateItem(Invoice item, boolean empty) {
        super.updateItem(item, empty);
        if (empty == true) {
            setText("");
            setGraphic(null);
        } else {
            String index = Formatter.formatIndex(item.getPrimaryKey());
            String name = "";
            customer = CustomerLayer.find(item.getCustomerKey());
            if (customer != null) {
                name = customer.getName();
            }
            String date = Formatter.formatDate(item.getInvoiceDate());

            Label indexLabel = new Label(index);
            Label dateLabel = new Label(date);
            Label nameLabel = new Label(name);
            indexLabel.setPadding(new Insets(4, 8, 4, 4));
            indexLabel.setFont(Nunito.regular(14));
            dateLabel.setPadding(new Insets(4));
            dateLabel.setFont(Nunito.thin(14));
            nameLabel.setPadding(new Insets(4));
            nameLabel.setFont(Nunito.medium(14));
            FlowPane pane = new FlowPane(indexLabel, dateLabel, nameLabel);
            pane.setAlignment(Pos.CENTER_LEFT);
            pane.setBackground(Backgrounds.createWhiteBackground());
            setGraphic(pane);

        }
    }
}
