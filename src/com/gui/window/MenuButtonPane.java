/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gui.window;

import com.gui.laf.ControlBuilder;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.FlowPane;

/**
 *
 * @author daan-
 */
public class MenuButtonPane extends FlowPane {

    private final ToggleButton homeButton;
    private final ToggleButton invoiceButton;
    private final ToggleButton customerButton;
    private final ToggleButton productButton;
    private final ToggleButton companyButton;
    private final ToggleGroup toggleGroup;

    public MenuButtonPane() {
        super(Orientation.VERTICAL);
        super.setHgap(8);
        super.setVgap(32);
        super.setAlignment(Pos.CENTER);
        homeButton = ControlBuilder.createHomeToggleButton(44);
        invoiceButton = ControlBuilder.createInvoicesToggleButton(44);
        customerButton = ControlBuilder.createCustomersToggleButton(44);
        productButton = ControlBuilder.createProductsToggleButton(44);
        companyButton = ControlBuilder.createCompaniesToggleButton(44);
        toggleGroup = new ToggleGroup();
        homeButton.setToggleGroup(toggleGroup);
        invoiceButton.setToggleGroup(toggleGroup);
        customerButton.setToggleGroup(toggleGroup);
        productButton.setToggleGroup(toggleGroup);
        companyButton.setToggleGroup(toggleGroup);
        toggleGroup.selectToggle(homeButton);
        super.getChildren().addAll(homeButton, invoiceButton, customerButton, productButton, companyButton);
    }

    public ToggleButton getHomeButton() {
        return homeButton;
    }

    public ToggleButton getInvoiceButton() {
        return invoiceButton;
    }

    public ToggleButton getCustomerButton() {
        return customerButton;
    }

    public ToggleButton getProductButton() {
        return productButton;
    }

    public ToggleButton getCompanyButton() {
        return companyButton;
    }

    public ToggleGroup getToggleGroup() {
        return toggleGroup;
    }

}
