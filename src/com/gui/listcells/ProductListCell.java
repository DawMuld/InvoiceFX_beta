/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gui.listcells;

import com.core.products.Product;
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
public class ProductListCell extends ListCell<Product> {

    @Override
    public void updateItem(Product item, boolean empty) {
        super.updateItem(item, empty);
        if (empty == true) {
            setText("");
            setGraphic(null);
        } else {
            String index = Formatter.formatIndex(item.getPrimaryKey());
            String name = item.getName();
            Label indexLabel = new Label(index);
            Label nameLabel = new Label(name);
            indexLabel.setPadding(new Insets(4, 8, 4, 4));
            indexLabel.setFont(Nunito.regular(14));
            nameLabel.setPadding(new Insets(4));
            nameLabel.setFont(Nunito.medium(14));
            FlowPane pane = new FlowPane(indexLabel, nameLabel);
            pane.setAlignment(Pos.CENTER_LEFT);
            pane.setBackground(Backgrounds.createWhiteBackground());
            setGraphic(pane);

        }
    }

}
