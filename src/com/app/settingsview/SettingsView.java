/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.settingsview;

import com.app.InvoiceApp;
import com.app.ViewLoader;
import com.gui.custom.ColorToggleButton;
import com.gui.laf.Backgrounds;
import com.gui.laf.Colors;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.FlowPane;

/**
 *
 * @author daan-
 */
public class SettingsView implements ViewLoader {

    private FlowPane colorPane;
    private InvoiceApp invoiceApp;



    public SettingsView() {
        initColorPane();

    }



    @Override
    public void loadView(AnchorPane contentPane, InvoiceApp invoiceApp) {
        AnchorPane.setTopAnchor(colorPane, 16.0);
        AnchorPane.setRightAnchor(colorPane, 16.0);
        AnchorPane.setBottomAnchor(colorPane, 16.0);
        Background bg = Backgrounds.createColorBg(Colors.NAVYBLUE1,0.6, 20);
        colorPane.setBackground(bg);
        colorPane.setPadding(new Insets(32));
        this.invoiceApp = invoiceApp;
        contentPane.getChildren().add(colorPane);

    }



    private void initColorPane() {
        colorPane = new FlowPane(Orientation.HORIZONTAL, 16, 16);
        colorPane.setMaxWidth(600);
        ColorToggleButton[] buttons = Colors.createColorToggles();
        ToggleGroup toggleGroup = new ToggleGroup();
        for (ColorToggleButton button : buttons) {
            button.setToggleGroup(toggleGroup);
            button.setOnAction((event) -> {
                onSelectColor(button);
            });
            colorPane.getChildren().add(button);
        }
    }



    public void onSelectColor(ColorToggleButton colorToggleButton) {
        if (invoiceApp != null) {
            invoiceApp.setWindowColors(colorToggleButton.getColor1(), colorToggleButton.getColor2());
        }
    }

}
