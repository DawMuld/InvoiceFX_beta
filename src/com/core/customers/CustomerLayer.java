/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.customers;

import com.core.debug.Debug;
import com.core.entity.DetailsView;
import com.core.entity.SaveTableView;
import com.core.entity.TableChange;
import com.core.persistence.ExcludeSet;
import com.core.persistence.IndexReader;
import com.core.persistence.StorageManager;
import com.core.persistence.TimeStamper;
import com.gui.listcells.CustomerListCell;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

/**
 *
 * @author daan-
 */
public class CustomerLayer {

    public static Customer create() {
        int primaryKey = IndexReader.preserveNextPrimaryKey(StorageManager.getCustomerFile());
        return new Customer(primaryKey, "", "", "", "");

    }

    public static ObservableList<Customer> readAll() {
        ObservableList<Customer> list = FXCollections.observableArrayList();
        try {
            File file = StorageManager.getCustomerFile();
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            for (line = reader.readLine(); line != null; line = reader.readLine()) {
                Customer customer = inflate(line);
                if (customer != null) {
                    list.add(customer);
                }
            }
            reader.close();

        } catch (Exception e) {
            Debug.out(e.getStackTrace());
        }
        return list;
    }

    public static void update(Customer customer) {
        try {
            File temp = new File("temp");
            File source = StorageManager.getCustomerFile();
            BufferedReader reader = new BufferedReader(new FileReader(source));
            PrintWriter writer = new PrintWriter(new FileWriter(temp));
            String line;
            for (line = reader.readLine(); line != null; line = reader.readLine()) {
                int lineIndex = IndexReader.getLineIndex(line);
                if (lineIndex == customer.getPrimaryKey()) {
                    writer.println(deflate(customer));
                } else {
                    writer.println(line);
                }
            }
            reader.close();
            writer.close();
            source.delete();
            temp.renameTo(source);
        } catch (Exception e) {
        }

    }

    public static void delete(Customer customer) {
        ExcludeSet.exclude(customer.getPrimaryKey(), StorageManager.getDeletedCustomerFile());
    }

    public static Customer find(int primaryKey) {
        Customer customer = null;
        try {
            File file = StorageManager.getCustomerFile();
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            for (line = reader.readLine(); line != null; line = reader.readLine()) {
                int lineIndex = IndexReader.getLineIndex(line);
                if (lineIndex == primaryKey) {
                    customer = inflate(line);
                    break;
                }
            }
            reader.close();

        } catch (Exception e) {
        }
        return customer;
    }

    public static SaveTableView<Customer> buildTableView() {
        SaveTableView<Customer> tableView = new SaveTableView<>(new CustomerSaver());

        TableColumn<Customer, Integer> keyColumn = new TableColumn<>("Primary Key");
        keyColumn.setCellValueFactory(new PropertyValueFactory<>("primaryKey"));

        TableColumn<Customer, String> idColumn = new TableColumn<>("ID");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        idColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        idColumn.setOnEditCommit((TableColumn.CellEditEvent<Customer, String> t) -> {
            Customer c = ((Customer) t.getTableView().getItems().get(t.getTablePosition().getRow()));
            TableChange tc = new TableChange(c.getPrimaryKey(), "ID", c.getId(), t.getNewValue());
            tableView.createDesyncRecord(tc, c);
            c.setId(t.getNewValue());
        });

        TableColumn<Customer, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        nameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        nameColumn.setOnEditCommit((TableColumn.CellEditEvent<Customer, String> t) -> {
            Customer c = ((Customer) t.getTableView().getItems().get(t.getTablePosition().getRow()));
            TableChange tc = new TableChange(c.getPrimaryKey(), "NAME", c.getName(), t.getNewValue());
            tableView.createDesyncRecord(tc, c);
            c.setName(t.getNewValue());
        });

        TableColumn<Customer, String> streetColumn = new TableColumn<>("Street");
        streetColumn.setCellValueFactory(new PropertyValueFactory<>("street"));
        streetColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        streetColumn.setOnEditCommit((TableColumn.CellEditEvent<Customer, String> t) -> {
            Customer c = ((Customer) t.getTableView().getItems().get(t.getTablePosition().getRow()));
            TableChange tc = new TableChange(c.getPrimaryKey(), "STREET", c.getStreet(), t.getNewValue());
            tableView.createDesyncRecord(tc, c);
            c.setStreet(t.getNewValue());
        });

        TableColumn<Customer, String> zipcodeColumn = new TableColumn<>("Zipcode");
        zipcodeColumn.setCellValueFactory(new PropertyValueFactory<>("zipcode"));
        zipcodeColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        zipcodeColumn.setOnEditCommit((TableColumn.CellEditEvent<Customer, String> t) -> {
            Customer c = ((Customer) t.getTableView().getItems().get(t.getTablePosition().getRow()));
            TableChange tc = new TableChange(c.getPrimaryKey(), "ZIPCODE", c.getZipcode(), t.getNewValue());
            tableView.createDesyncRecord(tc, c);
            c.setZipcode(t.getNewValue());
        });

        TableColumn<Customer, String> cityColumn = new TableColumn<>("City");
        cityColumn.setCellValueFactory(new PropertyValueFactory<>("city"));
        cityColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        cityColumn.setOnEditCommit((TableColumn.CellEditEvent<Customer, String> t) -> {
            Customer c = ((Customer) t.getTableView().getItems().get(t.getTablePosition().getRow()));
            TableChange tc = new TableChange(c.getPrimaryKey(), "CITY", c.getCity(), t.getNewValue());
            tableView.createDesyncRecord(tc, c);
            c.setCity(t.getNewValue());
        });

        TableColumn<Customer, String> emailColumn = new TableColumn<>("Email");
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        emailColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        emailColumn.setOnEditCommit((TableColumn.CellEditEvent<Customer, String> t) -> {
            Customer c = ((Customer) t.getTableView().getItems().get(t.getTablePosition().getRow()));
            TableChange tc = new TableChange(c.getPrimaryKey(), "EMAIL", c.getEmail(), t.getNewValue());
            tableView.createDesyncRecord(tc, c);
            c.setEmail(t.getNewValue());
        });

        TableColumn<Customer, String> phoneColumn = new TableColumn<>("Phone");
        phoneColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));
        phoneColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        phoneColumn.setOnEditCommit((TableColumn.CellEditEvent<Customer, String> t) -> {
            Customer c = ((Customer) t.getTableView().getItems().get(t.getTablePosition().getRow()));
            TableChange tc = new TableChange(c.getPrimaryKey(), "PHONE", c.getPhone(), t.getNewValue());
            tableView.createDesyncRecord(tc, c);
            c.setPhone(t.getNewValue());
        });

        TableColumn<Customer, String> mobileColumn = new TableColumn<>("Mobile");
        mobileColumn.setCellValueFactory(new PropertyValueFactory<>("mobile"));
        mobileColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        mobileColumn.setOnEditCommit((TableColumn.CellEditEvent<Customer, String> t) -> {
            Customer c = ((Customer) t.getTableView().getItems().get(t.getTablePosition().getRow()));
            TableChange tc = new TableChange(c.getPrimaryKey(), "MOBILE", c.getMobile(), t.getNewValue());
            tableView.createDesyncRecord(tc, c);
            c.setMobile(t.getNewValue());
        });

        tableView.getColumns().addAll(keyColumn, idColumn, nameColumn, streetColumn, zipcodeColumn, cityColumn, emailColumn, phoneColumn, mobileColumn);
        return tableView;
    }

    public static ListView<Customer> buildListView() {
        ListView<Customer> listView = new ListView<>();
        listView.setCellFactory((param) -> {
            return new CustomerListCell();
        });
        return listView;
    }

    public static DetailsView<Customer> buildDetailsView() {
        return new CustomerDetailsView();

    }

    public static Customer inflate(String line) {
        String[] cells = line.split(";");
        int primaryKey = Integer.parseInt(cells[0]);
        LocalDateTime createdAt = TimeStamper.parseLocalDateTime(cells[1]);
        LocalDateTime lastMod = TimeStamper.parseLocalDateTime(cells[2]);
        String id = cells[3];
        String name = cells[4];
        String street = cells[5];
        String zipcode = cells[6];
        String city = cells[7];
        String email = " ";
        String phone = " ";
        String mobile = " ";
        if (cells.length >= 9) {
            if (cells[8] != null && cells[8].length() > 1) {
                if (!cells[8].contains("empty")) {
                    email = cells[8];
                }
            }
        }
        if (cells.length >= 10) {
            if (cells[9] != null && cells[9].length() > 1) {
                if (!cells[9].contains("empty")) {
                    phone = cells[9];
                }
            }
        }
        if (cells.length >= 11) {
            if (cells[10] != null && cells[10].length() > 1) {
                if (!cells[10].contains("empty")) {
                    mobile = cells[10];
                }
            }
        }
        return new Customer(primaryKey, createdAt, lastMod, id, name, street, zipcode, city, email, phone, mobile);
    }

    public static String deflate(Customer entry) {
        String line = String.valueOf(entry.getPrimaryKey());
        line += ";" + TimeStamper.parseTimeStamp(entry.getCreatedAt());
        line += ";" + TimeStamper.parseTimeStamp(entry.getLastMod());
        line += ";" + entry.getId();
        line += ";" + entry.getName();
        line += ";" + entry.getStreet();
        line += ";" + entry.getZipcode();
        line += ";" + entry.getCity();
        line += ";" + entry.getEmail();
        line += ";" + entry.getPhone();
        line += ";" + entry.getMobile();
        return line;
    }

}
