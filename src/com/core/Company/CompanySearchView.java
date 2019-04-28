/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.Company;

import com.core.entity.DataBase;
import com.core.entity.DesyncObserver;
import com.core.entity.SaveTableView;
import com.gui.complex.SearchViewBundle;
import com.gui.laf.Backgrounds;
import com.gui.laf.ControlBuilder;
import javafx.geometry.Insets;
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
public class CompanySearchView extends BorderPane implements DesyncObserver {

    private final CompanyDataBase dataBase;
    private final SaveTableView<Company> tableView;
    private final TextField searchField;
    private final Button saveButton;
    private final Button undoButton;
    private final Button createButton;
    private final Button deleteButton;

    public static SearchViewBundle<Company> createBundle() {
        DataBase<Company> dataBase = new CompanyDataBase(CompanyLayer.readAll());
        SaveTableView<Company> tableView = CompanyLayer.buildTableView();
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

    public CompanySearchView() {
        super();
        dataBase = new CompanyDataBase(CompanyLayer.readAll());
        tableView = CompanyLayer.buildTableView();
        searchField = ControlBuilder.createSearchTextField();
        saveButton = ControlBuilder.createSaveButton();
        undoButton = ControlBuilder.createUndoButton();
        createButton = ControlBuilder.createCreateButton();
        deleteButton = ControlBuilder.createDeleteButton();

        saveButton.setDisable(true);
        saveButton.setOnAction((event) -> {
            tableView.saveChanges();
        });

        undoButton.setDisable(true);
        undoButton.setOnAction((event) -> {
            tableView.undoChange();
        });

        deleteButton.setDisable(true);
        tableView.getSelectionModel().selectedItemProperty().addListener((o, v1, v2) -> {
            if (v2 == null) {
                deleteButton.setDisable(true);
            } else {
                deleteButton.setDisable(false);
            }
        });
        deleteButton.setOnAction((event) -> {
            Company company = tableView.getSelectionModel().getSelectedItem();
            if (company != null) {

            }
        });

        FlowPane buttonPane = new FlowPane(undoButton, createButton, deleteButton, saveButton);

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
        setPadding(new Insets(16));
        setBackground(Backgrounds.createBlack3ImageBackground());
        setPrefWidth(1000);

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
