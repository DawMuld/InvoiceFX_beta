/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customer;

import com.gui.custom.DateTimeTableCell;
import java.time.LocalDateTime;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

/**
 *
 * @author daan-
 */
public class CustomerTableBuilder {

    public static TableView<Customer> createTableView() {
        TableView<Customer> tableView = new TableView<>();

        TableColumn<Customer, Integer> primaryKeyColumn = new TableColumn<>("Primary Key");
        primaryKeyColumn.setCellValueFactory(new PropertyValueFactory<>("primaryKey"));

        TableColumn<Customer, LocalDateTime> createdColumn = new TableColumn<>("Created");
        createdColumn.setCellValueFactory(new PropertyValueFactory<>("created"));
        createdColumn.setCellFactory((param) -> {
            return new DateTimeTableCell<>();
        });

        TableColumn<Customer, LocalDateTime> lastModColumn = new TableColumn<>("Last Modified");
        lastModColumn.setCellValueFactory(new PropertyValueFactory<>("lastMod"));
        lastModColumn.setCellFactory((param) -> {
            return new DateTimeTableCell<>();
        });

        TableColumn<Customer, String> idColumn = new TableColumn<>("ID");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Customer, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        nameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        nameColumn.setOnEditCommit((CellEditEvent<Customer, String> t) -> {
            ((Customer) t.getTableView().getItems().get(t.getTablePosition().getRow())).setName(t.getNewValue());
        });

        TableColumn<Customer, String> streetColumn = new TableColumn<>("Street");
        streetColumn.setCellValueFactory(new PropertyValueFactory<>("street"));
        streetColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        streetColumn.setOnEditCommit((CellEditEvent<Customer, String> t) -> {
            ((Customer) t.getTableView().getItems().get(t.getTablePosition().getRow())).setStreet(t.getNewValue());
        });

        TableColumn<Customer, String> zipColumn = new TableColumn<>("Zipcode");
        zipColumn.setCellValueFactory(new PropertyValueFactory<>("zip"));
        zipColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        zipColumn.setOnEditCommit((CellEditEvent<Customer, String> t) -> {
            ((Customer) t.getTableView().getItems().get(t.getTablePosition().getRow())).setZip(t.getNewValue());
        });

        TableColumn<Customer, String> cityColumn = new TableColumn<>("City");
        cityColumn.setCellValueFactory(new PropertyValueFactory<>("city"));
        cityColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        cityColumn.setOnEditCommit((CellEditEvent<Customer, String> t) -> {
            ((Customer) t.getTableView().getItems().get(t.getTablePosition().getRow())).setCity(t.getNewValue());
        });

        tableView.getColumns().addAll(primaryKeyColumn, createdColumn, lastModColumn, idColumn, nameColumn, streetColumn, zipColumn, cityColumn);
        return tableView;
    }

    public static ObservableList<Customer> createDummyList() {
        ObservableList<Customer> list = FXCollections.observableArrayList(new Customer(1, "Pro Sweep", "Vierde Hambaken 77", "5231TW", "s-Hertogenbosch"),
                new Customer(2, "Esdonk Van", "Pieter Breugelstr;106", "5231 BR", "s-Hertogenbosch"),
                new Customer(3, "The Sweeper ", "Deken Van Baarsstraat 63  ", "5251 RJ", "Vlijmen"),
                new Customer(4, "Advance ", "Trompetstraat;41  ", "5216 JW", "s-Hertogenbosch")
        );
        return list;
    }

}
