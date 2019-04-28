/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gui.custom;

import com.gui.laf.Backgrounds;
import com.gui.laf.Colors;
import com.gui.laf.Nunito;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ListCell;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 *
 * @author daan-
 */
public class ColorListCell<T> extends ListCell<T> {

    public static Color C1 = Colors.BLACK1;
    public static Color C2 = Colors.BLACK2;
    public static Font F1 = Nunito.regular(14);
    public static Font F2 = Nunito.bold(14);

    private FlowPane root;



    public ColorListCell() {
        super();
        root = new FlowPane();
        root.setBackground(Backgrounds.createColorBg(C1));
        root.setPadding(Insets.EMPTY);
        root.setMinHeight(38);
        root.setAlignment(Pos.CENTER_LEFT);
        root.setHgap(8);
        super.setPadding(Insets.EMPTY);
        super.setMinHeight(38);
    }



    @Override
    public void updateItem(T item, boolean empty) {
        super.updateItem(item, empty);
        setText("");
        setGraphic(root);
        if (empty == true) {
            root.getChildren().clear();
            root.setBackground(Backgrounds.createColorBg(C1));

        } else {
            if (super.getListView().getItems().indexOf(item) % 2 != 0) {
                root.setBackground(Backgrounds.createColorBg(C2));
            }
        }
    }



    public FlowPane getRoot() {
        return root;
    }

}
