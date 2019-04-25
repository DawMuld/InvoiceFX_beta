/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.products;

import com.core.entity.DesyncObserver;
import com.core.entity.SaveTableView;
import com.gui.laf.ControlBuilder;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;

/**
 *
 * @author daan-
 */
public class ProductSearchView extends BorderPane implements DesyncObserver {

    private final ProductDataBase dataBase;
    private final SaveTableView<Product> tableView;
    private final TextField searchField;
    private final Button saveButton;
    private final Button undoButton;

    public ProductSearchView() {
        this.dataBase = new ProductDataBase(ProductLayer.readAll());
        this.tableView = ProductLayer.buildTableView();
        this.searchField = ControlBuilder.createSearchTextField();
        this.saveButton = ControlBuilder.createSaveButton();
        this.undoButton = ControlBuilder.createUndoButton();

        saveButton.setDisable(true);
        saveButton.setOnAction((event) -> {
            tableView.saveChanges();
        });

        undoButton.setDisable(true);
        undoButton.setOnAction((event) -> {
            tableView.undoChange();
        });

        FlowPane buttonPane = new FlowPane(undoButton, saveButton);
        buttonPane.setAlignment(Pos.CENTER_RIGHT);

        AnchorPane.setTopAnchor(searchField, 8.0);
        AnchorPane.setBottomAnchor(searchField, 8.0);
        AnchorPane.setLeftAnchor(searchField, 8.0);

        AnchorPane.setTopAnchor(buttonPane, 8.0);
        AnchorPane.setBottomAnchor(buttonPane, 8.0);
        AnchorPane.setRightAnchor(buttonPane, 8.0);

        AnchorPane topPane = new AnchorPane(searchField, buttonPane);
        super.setTop(topPane);
        super.setCenter(tableView);
        searchField.textProperty().addListener((observable, oldValue, newValue) -> {
            dataBase.updateFilter(newValue);
        });
        tableView.setItems(dataBase.getItems());
        tableView.setEditable(true);
        tableView.registerDesyncObserver(this);

        widthProperty().addListener((o, v1, v2) -> {
            System.out.println(String.valueOf(v2));
        });

        setPrefWidth(1300);

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
