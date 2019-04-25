/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gui.custom;

import java.text.DecimalFormat;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.text.TextAlignment;
import javafx.util.converter.DoubleStringConverter;

/**
 *
 * @author daan-
 */
public class PriceTableCell<T> extends TextFieldTableCell<T, Double> {

    public static final DecimalFormat DF = new DecimalFormat("0.00");

    public PriceTableCell() {
        super(new DoubleStringConverter());

    }

    @Override
    public void updateItem(Double item, boolean empty) {
        super.updateItem(item, empty);
        if (empty == true) {
            setText("");
            setGraphic(null);
        } else {
            String price = DF.format(item);
            setText("€\t" + price);
            setTextAlignment(TextAlignment.RIGHT);
        }
    }

}
