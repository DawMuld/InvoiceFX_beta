/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gui.laf;

import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

/**
 *
 * @author daan-
 */
public class Backgrounds {

    public static Background createWhiteBackground() {
        return createColorBg(Color.web("#FFFFFF"));
    }
    public static Background createTextFieldBackground() {
        return createColorBg(Color.web("#D6D6D6"));
    }

    public static Background createColorBg(Paint paint) {
        return new Background(new BackgroundFill(paint, CornerRadii.EMPTY, Insets.EMPTY));
    }

}
