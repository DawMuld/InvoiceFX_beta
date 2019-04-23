/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.products;

import com.core.persistence.ExcludeSet;
import com.core.persistence.Formatter;
import com.core.persistence.IndexReader;
import com.core.persistence.StorageManager;
import com.core.persistence.TimeStamper;
import com.core.entity.DetailsView;
import com.gui.listcells.ProductListCell;
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
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

/**
 *
 * @author daan-
 */
public class ProductLayer {

    public static Product create() {
        int primaryKey = IndexReader.preserveNextPrimaryKey(StorageManager.getProductFile());
        return new Product(primaryKey, "", 0.0);
    }

    public static ObservableList<Product> readAll() {
        ObservableList<Product> list = FXCollections.observableArrayList();
        try {
            File file = StorageManager.getProductFile();
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            for (line = reader.readLine(); line != null; line = reader.readLine()) {
                Product product = inflate(line);
                if (product != null) {
                    list.add(product);
                }
            }
            reader.close();
        } catch (Exception e) {
        }
        return list;
    }

    public static void update(Product product) {
        try {
            File temp = new File("temp");
            File source = StorageManager.getProductFile();
            BufferedReader reader = new BufferedReader(new FileReader(source));
            PrintWriter writer = new PrintWriter(new FileWriter(temp));
            String line;
            for (line = reader.readLine(); line != null; line = reader.readLine()) {
                int lineIndex = IndexReader.getLineIndex(line);
                if (lineIndex == product.getPrimaryKey()) {
                    writer.println(deflate(product));
                } else {
                    writer.println(line);
                }
            }
            writer.close();
            reader.close();
            source.delete();
            temp.renameTo(source);

        } catch (Exception e) {
        }
    }

    public static void delete(Product product) {
        ExcludeSet.exclude(product.getPrimaryKey(), StorageManager.getDeletedProductFile());
    }

    public static Product find(int primaryKey) {
        Product product = null;
        try {
            File file = StorageManager.getProductFile();
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            for (line = reader.readLine(); line != null; line = reader.readLine()) {
                int index = IndexReader.getLineIndex(line);
                if (index == primaryKey) {
                    product = inflate(line);
                    break;
                }
            }
            reader.close();

        } catch (Exception e) {
        }
        return product;
    }

    public static TableView<Product> buildTableView() {
        TableView<Product> tableView = new TableView<>();

        TableColumn<Product, Integer> keyColumn = new TableColumn<>("Primary Key");
        keyColumn.setCellValueFactory(new PropertyValueFactory<>("primaryKey"));

        TableColumn<Product, String> idColumn = new TableColumn<>("ID");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        idColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        idColumn.setOnEditCommit((TableColumn.CellEditEvent<Product, String> t) -> {
            ((Product) t.getTableView().getItems().get(t.getTablePosition().getRow())).setId(t.getNewValue());
        });

        TableColumn<Product, String> nameColumn = new TableColumn<>("Name");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        idColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        idColumn.setOnEditCommit((TableColumn.CellEditEvent<Product, String> t) -> {
            ((Product) t.getTableView().getItems().get(t.getTablePosition().getRow())).setName(t.getNewValue());
        });

        TableColumn<Product, String> detailsColumn = new TableColumn<>("Details");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("details"));
        idColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        idColumn.setOnEditCommit((TableColumn.CellEditEvent<Product, String> t) -> {
            ((Product) t.getTableView().getItems().get(t.getTablePosition().getRow())).setDetails(t.getNewValue());
        });

        TableColumn<Product, String> purchasePriceColumn = new TableColumn<>("Purchase Price");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("purchasePrice"));
        idColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        idColumn.setOnEditCommit((TableColumn.CellEditEvent<Product, String> t) -> {
            ((Product) t.getTableView().getItems().get(t.getTablePosition().getRow())).setPurchasePrice(Formatter.formatPrice(t.getNewValue()));
        });

        TableColumn<Product, String> sellingPriceColumn = new TableColumn<>("Selling Price");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("sellingPrice"));
        idColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        idColumn.setOnEditCommit((TableColumn.CellEditEvent<Product, String> t) -> {
            ((Product) t.getTableView().getItems().get(t.getTablePosition().getRow())).setSellingPrice(Formatter.formatPrice(t.getNewValue()));
        });

        tableView.getColumns().addAll(keyColumn, idColumn, nameColumn, detailsColumn, purchasePriceColumn, sellingPriceColumn);
        return tableView;

    }

    public static ListView<Product> buildListView() {
        ListView<Product> listView = new ListView<>();
        listView.setCellFactory((param) -> {
            return new ProductListCell();
        });
        return listView;
    }

    public static DetailsView<Product> buildDetailsView() {
        return new ProductDetailsView();
    }

    public static Product inflate(String line) {
        String[] cells = line.split(";");
        int primaryKey = Integer.parseInt(cells[0]);
        LocalDateTime createdAt = TimeStamper.parseLocalDateTime(cells[1]);
        LocalDateTime lastMod = TimeStamper.parseLocalDateTime(cells[2]);
        String id = cells[3];
        String name = cells[4];
        String details = cells[5];
        double purchasePrice = Formatter.formatPrice(cells[6]);
        double sellingPrice = Formatter.formatPrice(cells[7]);
        return new Product(primaryKey, createdAt, lastMod, id, name, details, purchasePrice, sellingPrice);

    }

    public static String deflate(Product entry) {
        String line = String.valueOf(entry.getPrimaryKey());
        line += ";" + TimeStamper.parseTimeStamp(entry.getCreatedAt());
        line += ";" + TimeStamper.parseTimeStamp(entry.getLastMod());
        line += ";" + entry.getId();
        line += ";" + entry.getName();
        line += ";" + entry.getDetails();
        line += ";" + Formatter.formatPrice(entry.getPurchasePrice());
        line += ";" + Formatter.formatPrice(entry.getSellingPrice());
        return line;
    }

}
