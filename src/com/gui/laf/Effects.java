/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gui.laf;

import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;

/**
 *
 * @author daan-
 */
public class Effects {

    public static DropShadow createMenuShadow() {
        return new DropShadow(9, 2, 0, Color.web("#2B2B2B"));
    }
}
