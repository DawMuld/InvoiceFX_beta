/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.entity;

import com.gui.laf.Backgrounds;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;

/**
 *
 * @author daan-
 */
public abstract class DetailsView<T> extends GridPane {

    public DetailsView() {
        super();
        setPadding(new Insets(8));
        setBackground(Backgrounds.createWhiteBackground());
        setVgap(8);
        setHgap(8);
    }

    public abstract void inflate(T entry);

    public abstract T deflate();

    public abstract void clearFields();
}
