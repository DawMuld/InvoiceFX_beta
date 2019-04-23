/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gui.custom;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javafx.scene.control.TableCell;

/**
 *
 * @author daan-
 */
public class DateTimeTableCell<T> extends TableCell<T, LocalDateTime> {

    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    public static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss");

    @Override
    public void updateItem(LocalDateTime item, boolean empty) {
        super.updateItem(item, empty);
        if (empty == true) {
            setText("");
            setGraphic(null);
        } else {
            String dateString = DATE_FORMATTER.format(item);
            String timeString = TIME_FORMATTER.format(item);
            setText(dateString + " " + timeString);
        }
    }

}
