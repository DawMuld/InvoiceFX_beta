/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app;

import com.gui.laf.Backgrounds;
import com.gui.laf.Colors;
import com.gui.laf.ControlBuilder;
import com.gui.laf.WindowBuilder;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;

/**
 *
 * @author daan-
 */
public class AppView extends BorderPane {

    private AnchorPane menuPane;
    private AnchorPane contentPane;
    private Button settingsButton;



    public AppView() {
        super();
        super.setPrefSize(1600, 900);
        menuPane = new AnchorPane();
        contentPane = new AnchorPane();
        contentPane.setBackground(Backgrounds.createColorBg(Color.web("#ECF0F1")));
        menuPane.setBackground(Backgrounds.createColorBg(Colors.RED1));
        contentPane.setPrefSize(1500, 900);
        menuPane.setPrefSize(100, 900);
        setCenter(contentPane);
        setLeft(menuPane);

        initMenuButtons();
    }


    public AnchorPane getContentPane(){
        return contentPane;
    }
    
    

    public void setMenuColor(Color color) {
        menuPane.setBackground(Backgrounds.createColorBg(color));
    }



    public Button getSettingsButton() {
        return settingsButton;
    }



    private void initMenuButtons() {
        ToggleGroup toggleGroup = new ToggleGroup();
        ToggleButton homeButton = ControlBuilder.createHomeToggleButton(32);
        homeButton.setToggleGroup(toggleGroup);
        ToggleButton invoiceButton = ControlBuilder.createInvoicesToggleButton(32);
        invoiceButton.setToggleGroup(toggleGroup);
        ToggleButton customerButton = ControlBuilder.createCustomersToggleButton(32);
        customerButton.setToggleGroup(toggleGroup);
        ToggleButton productButton = ControlBuilder.createProductsToggleButton(32);
        productButton.setToggleGroup(toggleGroup);
        ToggleButton companyButton = ControlBuilder.createCompaniesToggleButton(32);
        companyButton.setToggleGroup(toggleGroup);
        toggleGroup.selectToggle(homeButton);
        FlowPane buttonsPane = new FlowPane(Orientation.VERTICAL, 0, 16, homeButton, invoiceButton, customerButton, productButton, companyButton);
        buttonsPane.setAlignment(Pos.CENTER);
        AnchorPane.setTopAnchor(buttonsPane, 0.0);
        AnchorPane.setBottomAnchor(buttonsPane, 32.0);
        AnchorPane.setRightAnchor(buttonsPane, 0.0);
        AnchorPane.setLeftAnchor(buttonsPane, 0.0);
        settingsButton = WindowBuilder.createSettingsButton(32);
        AnchorPane.setBottomAnchor(settingsButton, 8.0);
        AnchorPane.setLeftAnchor(settingsButton, 0.0);
        AnchorPane.setRightAnchor(settingsButton, 0.0);
        menuPane.getChildren().addAll(buttonsPane, settingsButton);
    }

}
