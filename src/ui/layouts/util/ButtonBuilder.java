/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.layouts.util;

import com.gui.laf.Backgrounds;
import com.gui.laf.Colors;
import com.gui.laf.Nunito;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Effect;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;
import javafx.scene.layout.FlowPane;

/**
 *
 * @author daan-
 */
public class ButtonBuilder {

    private static final Effect IDLE = new DropShadow(15, 1, 1, Colors.BLACK2);
    private static final Effect HOVER = new DropShadow(24, 1, 3, Colors.BLACK2);



    public static ToggleButton newInvoiceButton() {
        Label label = new Label("New Invoice");
        label.setFont(Nunito.bold(44));
        label.setTextFill(Colors.WHITE1);
        label.setEffect(new DropShadow(3, 1, 1, Colors.BLACK2));
        FlowPane root = new FlowPane(label);
        root.setAlignment(Pos.CENTER);
        root.setMinWidth(300);
        root.setMinHeight(600);
        root.setBackground(Backgrounds.createPoly1ImageBackground());
        ToggleButton toggle = new ToggleButton("", root);
        toggle.setBackground(Background.EMPTY);
        toggle.setBorder(Border.EMPTY);
        toggle.hoverProperty().addListener((o, v1, v2) -> {
            if (v2 == true) {
                toggle.setEffect(HOVER);
                toggle.setTranslateY(3);
            } else {
                toggle.setEffect(IDLE);
                toggle.setTranslateY(0);
            }
        });
        return toggle;
    }



    public static ToggleButton editInvoiceButton() {
        Label label = new Label("Edit Invoice");
        label.setFont(Nunito.bold(44));
        label.setTextFill(Colors.WHITE1);
        label.setEffect(new DropShadow(3, 1, 1, Colors.BLACK2));
        FlowPane root = new FlowPane(label);
        root.setAlignment(Pos.CENTER);
        root.setMinWidth(300);
        root.setMinHeight(600);
        root.setBackground(Backgrounds.createBlue1ImageBackground());
        ToggleButton toggle = new ToggleButton("", root);
        toggle.setBackground(Background.EMPTY);
        toggle.setBorder(Border.EMPTY);
        toggle.hoverProperty().addListener((o, v1, v2) -> {
            if (v2 == true) {
                toggle.setEffect(HOVER);
                toggle.setTranslateY(3);
            } else {
                toggle.setEffect(IDLE);
                toggle.setTranslateY(0);
            }
        });
        return toggle;
    }



    public static ToggleButton copyInvoiceButton() {
        Label label = new Label("Copy Existing");
        label.setFont(Nunito.bold(44));
        label.setTextFill(Colors.WHITE1);
        label.setEffect(new DropShadow(3, 1, 1, Colors.BLACK2));
        FlowPane root = new FlowPane(label);
        root.setAlignment(Pos.CENTER);
        root.setMinWidth(300);
        root.setMinHeight(600);
        root.setBackground(Backgrounds.createBlack3ImageBackground());
        ToggleButton toggle = new ToggleButton("", root);
        toggle.setBackground(Background.EMPTY);
        toggle.setBorder(Border.EMPTY);
        toggle.hoverProperty().addListener((o, v1, v2) -> {
            if (v2 == true) {
                toggle.setEffect(HOVER);
                toggle.setTranslateY(3);
            } else {
                toggle.setEffect(IDLE);
                toggle.setTranslateY(0);
            }
        });
        return toggle;
    }

}
