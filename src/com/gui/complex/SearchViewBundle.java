/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gui.complex;

import com.core.entity.DataBase;
import com.core.entity.SaveTableView;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 *
 * @author daan-
 */
public class SearchViewBundle<T> {

    private final DataBase<T> dataBase;
    private final SaveTableView<T> tableView;
    private final TextField searchField;
    private final Button saveButton;
    private final Button undoButton;

    public SearchViewBundle(DataBase<T> dataBase, SaveTableView<T> tableView, TextField searchField, Button saveButton, Button undoButton) {
        this.dataBase = dataBase;
        this.tableView = tableView;
        this.searchField = searchField;
        this.saveButton = saveButton;
        this.undoButton = undoButton;
    }

    public DataBase<T> getDataBase() {
        return dataBase;
    }

    public SaveTableView<T> getTableView() {
        return tableView;
    }

    public TextField getSearchField() {
        return searchField;
    }

    public Button getSaveButton() {
        return saveButton;
    }

    public Button getUndoButton() {
        return undoButton;
    }

}
