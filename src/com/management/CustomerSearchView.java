/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.management;

import com.core.customers.Customer;
import com.core.customers.CustomerDataBase;
import com.core.customers.CustomerLayer;
import com.gui.laf.ControlBuilder;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;

/**
 *
 * @author daan-
 */
public class CustomerSearchView extends BorderPane {

    private final CustomerDataBase dataBase;
    private final TableView<Customer> tableView;
    private final TextField searchField;

    public CustomerSearchView() {
        super();
        this.dataBase = new CustomerDataBase(CustomerLayer.readAll());
        tableView = CustomerLayer.buildTableView();

        searchField = ControlBuilder.createSearchTextField();
        FlowPane topPane = new FlowPane(searchField);
        topPane.setAlignment(Pos.CENTER);
        topPane.setPadding(new Insets(16));
        super.setTop(topPane);
        super.setCenter(tableView);
        searchField.textProperty().addListener((observable, oldValue, newValue) -> {
            dataBase.updateFilter(newValue);
        });
        tableView.setItems(dataBase.getItems());
        tableView.setEditable(true);
    }

}
