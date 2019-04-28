/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.customers;

import com.core.entity.DataBase;
import com.core.entity.DesyncObserver;
import com.core.entity.SaveTableView;
import com.gui.complex.DetailsDialogView;
import com.gui.complex.SearchViewBundle;
import com.gui.laf.Backgrounds;
import com.gui.laf.ControlBuilder;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;

/**
 *
 * @author daan-
 */
public class CustomerSearchView extends BorderPane implements DesyncObserver {

    private final CustomerDataBase dataBase;
    private final SaveTableView<Customer> tableView;
    private final TextField searchField;
    private final Button saveButton;
    private final Button undoButton;
    private final Button createButton;
    private final Button deleteButton;



    public static SearchViewBundle<Customer> createBundle() {
        DataBase<Customer> dataBase = new CustomerDataBase(CustomerLayer.readAll());
        SaveTableView<Customer> tableView = CustomerLayer.buildTableView();
        TextField searchField = ControlBuilder.createSearchTextField();
        Button saveButton = ControlBuilder.createSaveButton();
        Button undoButton = ControlBuilder.createUndoButton();
        saveButton.setDisable(true);
        saveButton.setOnAction((event) -> {
            tableView.saveChanges();
        });

        undoButton.setDisable(true);
        undoButton.setOnAction((event) -> {
            tableView.undoChange();
        });

        searchField.textProperty().addListener((observable, oldValue, newValue) -> {
            dataBase.updateFilter(newValue);
        });
        tableView.setItems(dataBase.getItems());
        tableView.setEditable(true);
        tableView.registerDesyncObserver(new DesyncObserver() {
            @Override
            public void stateDesynced() {
                saveButton.setDisable(false);
                undoButton.setDisable(false);
            }



            @Override
            public void stateSynced() {
                saveButton.setDisable(true);
                undoButton.setDisable(true);
            }
        });
        return new SearchViewBundle(dataBase, tableView, searchField, saveButton, undoButton);
    }



    public CustomerSearchView() {
        this(new CustomerDataBase(CustomerLayer.readAll()));
    }



    public CustomerSearchView(CustomerDataBase dataBase) {
        super();
        this.dataBase = dataBase;
        tableView = CustomerLayer.buildTableView();
        searchField = ControlBuilder.createSearchTextField();
        saveButton = ControlBuilder.createSaveButton();
        createButton = ControlBuilder.createCreateButton();
        deleteButton = ControlBuilder.createDeleteButton();

        saveButton.setOnAction((event) -> {
            tableView.saveChanges();
        });
        saveButton.setDisable(true);
        undoButton = ControlBuilder.createUndoButton();
        undoButton.setOnAction((event) -> {
            tableView.undoChange();
        });
        undoButton.setDisable(true);
        deleteButton.setDisable(true);
        tableView.getSelectionModel().selectedItemProperty().addListener((o, v1, v2) -> {
            if (v2 == null) {
                deleteButton.setDisable(true);
            } else {
                deleteButton.setDisable(false);
            }
        });
        deleteButton.setOnAction((event) -> {
            Customer customer = tableView.getSelectionModel().getSelectedItem();
            if (customer != null) {

            }
        });

        createButton.setOnAction((event) -> {
            DetailsDialogView<Customer> view = new DetailsDialogView(CustomerLayer.buildDetailsView());
            Customer entry = tableView.getSelectionModel().getSelectedItem();
            if (entry != null) {
                view.loadAndShow(entry);
            } else {
                view.loadAndShow(CustomerLayer.create());
            }
        });

        FlowPane buttonPane = new FlowPane(searchField, undoButton, createButton, deleteButton, saveButton);
        buttonPane.setPrefWrapLength(600);
        Label titleLabel = ControlBuilder.buildTitleLabel("Customers");

        buttonPane.setAlignment(Pos.CENTER_RIGHT);

        AnchorPane.setTopAnchor(titleLabel, 8.0);
        AnchorPane.setBottomAnchor(titleLabel, 8.0);
        AnchorPane.setLeftAnchor(titleLabel, 0.0);

        AnchorPane.setTopAnchor(buttonPane, 8.0);
        AnchorPane.setBottomAnchor(buttonPane, 8.0);
        AnchorPane.setRightAnchor(buttonPane, 8.0);

        AnchorPane topPane = new AnchorPane(titleLabel, buttonPane);

        super.setTop(topPane);
        super.setCenter(tableView);
        searchField.textProperty().addListener((observable, oldValue, newValue) -> {
            dataBase.updateFilter(newValue);
        });
        tableView.setItems(dataBase.getItems());
        tableView.setEditable(true);
        tableView.registerDesyncObserver(this);

        setPrefWidth(1155);
        setBackground(Backgrounds.createBlack1ImageBackground());
        setPadding(new Insets(16));
        tableView.styleTableView();
    }



    @Override
    public void stateDesynced() {
        saveButton.setDisable(false);
        undoButton.setDisable(false);
    }



    @Override
    public void stateSynced() {
        saveButton.setDisable(true);
        undoButton.setDisable(true);
    }

}
