/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.layouts.util;

import com.gui.laf.Backgrounds;
import com.gui.laf.Colors;
import com.gui.laf.Nunito;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.TextAlignment;

/**
 *
 * @author daan-
 */
public class TableUtils {

    public static FlowPane createColumnHeaderGraphics(String text) {
        Label label = new Label(text);
        label.setBackground(Background.EMPTY);
        label.setBorder(Border.EMPTY);
        label.setAlignment(Pos.CENTER);
        label.setTextAlignment(TextAlignment.CENTER);
        label.setFont(Nunito.bold(16));
        label.setTextFill(Colors.WHITE1);
        FlowPane header = new FlowPane(label);
        header.setAlignment(Pos.CENTER);
        header.setBorder(Border.EMPTY);
        header.setBackground(Backgrounds.createColorBg(Colors.BLACK2));
        header.setPadding(Insets.EMPTY);
        return header;
    }



    public static Label createLabelCell() {
        Label label = new Label("");
        label.setBackground(Backgrounds.createColorBg(Colors.BLACK2));
        label.setBorder(Border.EMPTY);
        label.setAlignment(Pos.CENTER);
        label.setTextAlignment(TextAlignment.CENTER);
        label.setFont(Nunito.bold(16));
        label.setTextFill(Colors.WHITE1);
        return label;
    }



    public static FlowPane createLabelPane() {
        Label label = new Label("");
        label.setBackground(Background.EMPTY);
        label.setBorder(Border.EMPTY);
        label.setAlignment(Pos.CENTER);
        label.setTextAlignment(TextAlignment.CENTER);
        label.setFont(Nunito.bold(16));
        label.setTextFill(Colors.WHITE1);
        FlowPane header = new FlowPane(label);
        header.setAlignment(Pos.CENTER);
        header.setBackground(Backgrounds.createColorBg(Colors.BLACK2));
        header.setPadding(Insets.EMPTY);
        return header;

    }



    public static TextField cteateCellField() {
        TextField field = new TextField();
        field.setBorder(Border.EMPTY);
        field.setBackground(Backgrounds.createColorBg(Colors.BLACK1));
        field.setFont(Nunito.regular(14));
        field.setStyle("-fx-text-fill: #ECF0F1;");
        field.setAlignment(Pos.CENTER);
        field.setEditable(false);
        field.setOnMouseClicked((event) -> {
            if (event.getClickCount() >= 2) {
                field.setEditable(true);
                field.setBackground(Backgrounds.createColorBg(Colors.BLACK2));
                field.selectAll();
            }
        });
        field.focusedProperty().addListener((o, v1, v2) -> {
            if (v2 == false) {
                field.redo();
                field.setBackground(Backgrounds.createColorBg(Colors.BLACK1));
                field.setEditable(false);
            } else {
                if (v1 == null || v1 == false) {

                }
            }
        });

        return field;

    }

}
