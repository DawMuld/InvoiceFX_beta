/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.Company;

import com.core.entity.DetailsView;
import com.core.entity.SaveTableView;
import com.core.entity.TableChange;
import com.core.persistence.ExcludeSet;
import com.core.persistence.IndexReader;
import com.core.persistence.StorageManager;
import com.core.persistence.TimeStamper;
import com.gui.listcells.CompanyListCell;
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
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

/**
 *
 * @author daan-
 */
public class CompanyLayer {

    public static Company create() {
        int primaryKey = IndexReader.preserveNextPrimaryKey(StorageManager.getCompanyFile());
        return new Company(primaryKey, "", "", "", "", "", "", "", "");
    }

    public static ObservableList<Company> readAll() {
        ObservableList<Company> list = FXCollections.observableArrayList();
        try {
            File file = StorageManager.getCompanyFile();
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            for (line = reader.readLine(); line != null; line = reader.readLine()) {
                Company company = inflate(line);
                if (company != null) {
                    list.add(company);
                }
            }
            reader.close();

        } catch (Exception e) {
        }
        ExcludeSet.removeExcluded(StorageManager.getDeletedCompaniesFile(), list);
        return list;
    }

    public static void update(Company company) {
        try {
            File temp = new File("temp");
            File source = StorageManager.getCompanyFile();
            BufferedReader reader = new BufferedReader(new FileReader(source));
            PrintWriter writer = new PrintWriter(new FileWriter(temp));
            String line;
            for (line = reader.readLine(); line != null; line = reader.readLine()) {
                int lineIndex = IndexReader.getLineIndex(line);
                if (lineIndex == company.getPrimaryKey()) {
                    company.setLastMod(LocalDateTime.now());
                    writer.println(deflate(company));
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

    public static void delete(Company company) {
        ExcludeSet.exclude(company.getPrimaryKey(), StorageManager.getDeletedCompaniesFile());
    }

    public static Company find(int primaryKey) {
        Company company = null;
        try {
            File file = StorageManager.getCompanyFile();
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            for (line = reader.readLine(); line != null; line = reader.readLine()) {
                int lineIndex = IndexReader.getLineIndex(line);
                if (lineIndex == primaryKey) {
                    company = inflate(line);
                    break;
                }
            }
            reader.close();

        } catch (Exception e) {
        }
        return company;
    }

    public static SaveTableView<Company> buildTableView() {
        SaveTableView<Company> tableView = new SaveTableView<>(new CompanySaver());

        TableColumn<Company, Integer> keyColumn = new TableColumn<>("Primary Key");
        keyColumn.setCellValueFactory(new PropertyValueFactory<>("primaryKey"));

        TableColumn<Company, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory("name"));
        nameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        nameColumn.setOnEditCommit((CellEditEvent<Company, String> t) -> {
            Company c = ((Company) t.getTableView().getItems().get(t.getTablePosition().getRow()));
            TableChange tc = new TableChange(c.getPrimaryKey(), "NAME", c.getName(), t.getNewValue());
            tableView.createDesyncRecord(tc, c);
            c.setName(t.getNewValue());
        });

        TableColumn<Company, String> streetColumn = new TableColumn<>("Street");
        streetColumn.setCellValueFactory(new PropertyValueFactory("street"));
        streetColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        streetColumn.setOnEditCommit((CellEditEvent<Company, String> t) -> {
            Company c = ((Company) t.getTableView().getItems().get(t.getTablePosition().getRow()));
            TableChange tc = new TableChange(c.getPrimaryKey(), "STREET", c.getStreet(), t.getNewValue());
            tableView.createDesyncRecord(tc, c);
            c.setStreet(t.getNewValue());
        });

        TableColumn<Company, String> zipcodeColumn = new TableColumn<>("Zipcode");
        zipcodeColumn.setCellValueFactory(new PropertyValueFactory("zipcode"));
        zipcodeColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        zipcodeColumn.setOnEditCommit((CellEditEvent<Company, String> t) -> {
            Company c = ((Company) t.getTableView().getItems().get(t.getTablePosition().getRow()));
            TableChange tc = new TableChange(c.getPrimaryKey(), "ZIPCODE", c.getZipcode(), t.getNewValue());
            tableView.createDesyncRecord(tc, c);
            c.setZipcode(t.getNewValue());
        });

        TableColumn<Company, String> cityColumn = new TableColumn<>("City");
        cityColumn.setCellValueFactory(new PropertyValueFactory("city"));
        cityColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        cityColumn.setOnEditCommit((CellEditEvent<Company, String> t) -> {
            Company c = ((Company) t.getTableView().getItems().get(t.getTablePosition().getRow()));
            TableChange tc = new TableChange(c.getPrimaryKey(), "CITY", c.getCity(), t.getNewValue());
            tableView.createDesyncRecord(tc, c);
            c.setCity(t.getNewValue());
        });

        TableColumn<Company, String> mobileColumn = new TableColumn<>("Mobile");
        mobileColumn.setCellValueFactory(new PropertyValueFactory("mobile"));
        mobileColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        mobileColumn.setOnEditCommit((CellEditEvent<Company, String> t) -> {
            Company c = ((Company) t.getTableView().getItems().get(t.getTablePosition().getRow()));
            TableChange tc = new TableChange(c.getPrimaryKey(), "MOBILE", c.getMobile(), t.getNewValue());
            tableView.createDesyncRecord(tc, c);
            c.setMobile(t.getNewValue());
        });

        TableColumn<Company, String> ibanColumn = new TableColumn<>("IBAN");
        ibanColumn.setCellValueFactory(new PropertyValueFactory("iban"));
        ibanColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        ibanColumn.setOnEditCommit((CellEditEvent<Company, String> t) -> {
            Company c = ((Company) t.getTableView().getItems().get(t.getTablePosition().getRow()));
            TableChange tc = new TableChange(c.getPrimaryKey(), "IBAN", c.getIban(), t.getNewValue());
            tableView.createDesyncRecord(tc, c);
            c.setIban(t.getNewValue());
        });

        TableColumn<Company, String> btwColumn = new TableColumn<>("BTW");
        btwColumn.setCellValueFactory(new PropertyValueFactory("btw"));
        btwColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        btwColumn.setOnEditCommit((CellEditEvent<Company, String> t) -> {
            Company c = ((Company) t.getTableView().getItems().get(t.getTablePosition().getRow()));
            TableChange tc = new TableChange(c.getPrimaryKey(), "BTW", c.getBtw(), t.getNewValue());
            tableView.createDesyncRecord(tc, c);
            c.setBtw(t.getNewValue());
        });

        TableColumn<Company, String> kvkColumn = new TableColumn<>("K.v.K");
        kvkColumn.setCellValueFactory(new PropertyValueFactory("kvk"));
        kvkColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        kvkColumn.setOnEditCommit((CellEditEvent<Company, String> t) -> {
            Company c = ((Company) t.getTableView().getItems().get(t.getTablePosition().getRow()));
            TableChange tc = new TableChange(c.getPrimaryKey(), "KVK", c.getKvk(), t.getNewValue());
            tableView.createDesyncRecord(tc, c);
            c.setKvk(t.getNewValue());
        });

        tableView.getColumns().addAll(keyColumn, nameColumn, streetColumn, zipcodeColumn, cityColumn, mobileColumn, ibanColumn, btwColumn, kvkColumn);
        return tableView;

    }

    public static ListView<Company> buildListView() {
        ListView<Company> listView = new ListView<>();
        listView.setCellFactory((param) -> {
            return new CompanyListCell();
        });
        return listView;
    }

    public static DetailsView<Company> buildDetailsView() {
        return new CompanyDetailsView();
    }

    public static Company inflate(String line) {
        String[] cells = line.split(";");
        int primaryKey = Integer.parseInt(cells[0]);
        LocalDateTime created = TimeStamper.parseLocalDateTime(cells[1]);
        LocalDateTime lastMod = TimeStamper.parseLocalDateTime(cells[2]);
        String name = cells[3];
        String street = cells[4];
        String zipcode = cells[5];
        String city = cells[6];
        String mobile = cells[7];
        String iban = cells[8];
        String btw = cells[9];
        String kvk = cells[10];
        return new Company(primaryKey, created, lastMod, name, street, zipcode, city, mobile, iban, btw, kvk);

    }

    public static String deflate(Company entry) {
        String line = String.valueOf(entry.getPrimaryKey()) + ";"
                + TimeStamper.parseTimeStamp(entry.getCreatedAt()) + ";"
                + TimeStamper.parseTimeStamp(entry.getLastMod()) + ";"
                + entry.getName() + ";"
                + entry.getStreet() + ";"
                + entry.getZipcode() + ";"
                + entry.getCity() + ";"
                + entry.getMobile() + ";"
                + entry.getIban() + ";"
                + entry.getBtw() + ";"
                + entry.getKvk();
        return line;
    }

}
