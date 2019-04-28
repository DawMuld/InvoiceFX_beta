/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gui.views.customers;

import com.core.customers.Customer;
import com.core.customers.CustomerDataBase;
import com.core.customers.CustomerLayer;
import com.core.entity.DetailsView;
import com.gui.laf.Backgrounds;
import com.gui.laf.ControlBuilder;
import javafx.geometry.Insets;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;

/**
 *
 * @author daan-
 */
public class CustomerMasterDetailView extends FlowPane {

    private BorderPane mainPane;
    private BorderPane listPane;
    private ListView<Customer> listView;

    private BorderPane detailsPane;
    private DetailsView<Customer> detailsView;

    private CustomerDataBase customerDB;



    public CustomerMasterDetailView(CustomerDataBase customerDB) {
        super(16, 16);
        super.setPadding(new Insets(16));
        super.setBackground(Backgrounds.createPoly1ImageBackground());
        this.customerDB = customerDB;
        listView = CustomerLayer.buildListView();
        listView.setItems(customerDB.getItems());
        listPane = new BorderPane();
        TextField searchField = ControlBuilder.createSearchTextField();
        searchField.textProperty().addListener((o, v1, v2) -> {
            customerDB.updateFilter(v2);
        });
        FlowPane searchPane = new FlowPane(searchField);
        searchPane.setPadding(new Insets(16));
        searchPane.setBackground(Background.EMPTY);
        listPane.setTop(searchPane);
        listPane.setCenter(listView);

        detailsPane = new BorderPane();
        detailsView = CustomerLayer.buildDetailsView();
        detailsPane.setCenter(detailsView);

        listView.getSelectionModel().selectedItemProperty().addListener((o, v1, v2) -> {
            if (v2 == null) {
                detailsView.clearFields();
            } else {
                detailsView.inflate(v2);
            }
        });
        listPane.setPrefWidth(500);

        mainPane = new BorderPane();
        mainPane.setPrefWidth(1400);
        mainPane.setPrefHeight(700);
        mainPane.setCenter(detailsPane);
        mainPane.setLeft(listPane);
        super.getChildren().add(mainPane);
        mainPane.setPadding(new Insets(32));
        mainPane.setBackground(Backgrounds.createColorBg(Color.web("#FFFFFF", 0.9)));

    }

}
