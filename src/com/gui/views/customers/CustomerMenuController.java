/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gui.views.customers;

import com.core.customers.CustomerDataBase;
import com.core.customers.CustomerLayer;
import com.core.customers.CustomerSearchView;
import com.gui.laf.WindowBuilder;
import com.gui.window.ViewMenuController;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;

/**
 *
 * @author daan-
 */
public class CustomerMenuController implements ViewMenuController {

    private CustomerDataBase customerDataBase;
    private FlowPane subMenuPane;
    private BorderPane mainView;
    private CustomerMasterDetailView masterDetailView;
    private CustomerSearchView searchView;
    private ToggleGroup toggleGroup;
    private ToggleButton masterDetailButton;
    private ToggleButton searchViewButton;



    public CustomerMenuController() {
        customerDataBase = new CustomerDataBase(CustomerLayer.readAll());
        initSubMenuPane();
        initMainView();
    }



    @Override
    public boolean requireSubMenuDrawer() {
        return true;
    }



    @Override
    public FlowPane getSubMenuButtonPane() {
        return subMenuPane;

    }



    @Override
    public void loadMainView(BorderPane contentPane) {
        contentPane.setCenter(mainView);
    }



    private void initSubMenuPane() {
        subMenuPane = new FlowPane(Orientation.VERTICAL, 8, 8);
        toggleGroup = new ToggleGroup();

        masterDetailButton = WindowBuilder.createSubMenuButton("My Customers");
        masterDetailButton.setToggleGroup(toggleGroup);
        masterDetailButton.setOnAction((event) -> {
            if (mainView.getCenter() == masterDetailView) {
                masterDetailButton.setSelected(true);
            } else {
                mainView.setCenter(masterDetailView);
            }
        });
        searchViewButton = WindowBuilder.createSubMenuButton("Customer Table");
        searchViewButton.setToggleGroup(toggleGroup);
        searchViewButton.setOnAction((event) -> {
            if (mainView.getCenter() == searchView) {
                searchViewButton.setSelected(true);
            } else {
                mainView.setCenter(searchView);
            }
        });

        toggleGroup.selectToggle(masterDetailButton);
        subMenuPane.getChildren().addAll(masterDetailButton, searchViewButton);
    }



    private void initMainView() {
        mainView = new BorderPane();

        masterDetailView = new CustomerMasterDetailView(customerDataBase);
        masterDetailView.setAlignment(Pos.CENTER);

        searchView = new CustomerSearchView(customerDataBase);

        mainView.setCenter(masterDetailView);

    }

}
