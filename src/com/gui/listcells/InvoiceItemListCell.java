/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gui.listcells;

import com.core.invoices.InvoiceItem;
import com.core.persistence.Formatter;
import com.gui.laf.Nunito;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author daan-
 */
public class InvoiceItemListCell extends ListCell<InvoiceItem> {

    @Override
    public void updateItem(InvoiceItem item, boolean empty) {
        super.updateItem(item, empty);
        if (empty == true) {
            setText("");
            setGraphic(null);
        } else {
            String name = item.getProductName();
            String quantity = "x" + String.valueOf(item.getQuantity());
            String price = "€ " + Formatter.formatPrice(item.getUnitPrice());
            Label nameLabel = new Label(name);
            Label qLabel = new Label(quantity);
            Label priceLabel = new Label(price);
            AnchorPane.setTopAnchor(nameLabel, 4.0);
            AnchorPane.setLeftAnchor(nameLabel, 4.0);
            AnchorPane.setTopAnchor(qLabel, 4.0);
            AnchorPane.setRightAnchor(qLabel, 100.0);
            AnchorPane.setTopAnchor(priceLabel, 3.0);
            AnchorPane.setRightAnchor(priceLabel, 4.0);
            AnchorPane root = new AnchorPane(nameLabel, qLabel, priceLabel);
            nameLabel.setFont(Nunito.regular(14));
            qLabel.setFont(Nunito.thin(14));
            priceLabel.setFont(Nunito.regular(14));
            setGraphic(root);

        }

    }

}
