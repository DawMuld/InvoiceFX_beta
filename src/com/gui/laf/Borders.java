/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gui.laf;

import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

/**
 *
 * @author daan-
 */
public class Borders {

    public static Border textFieldBorder() {
        Border border = new Border(new BorderStroke(Color.web("#DADADA"), BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(1.0)));
        return border;
    }

}
