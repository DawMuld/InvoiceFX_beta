/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.products;

import com.core.entity.DetailsView;
import com.core.entity.SaveTableView;
import com.core.entity.TableChange;
import com.core.persistence.ExcludeSet;
import com.core.persistence.Formatter;
import com.core.persistence.IndexReader;
import com.core.persistence.StorageManager;
import com.core.persistence.TimeStamper;
import com.gui.custom.PriceTableCell;
import com.gui.listcells.ProductListCell;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
public class ProductLayer {

    public static Product create() {
        int primaryKey = IndexReader.preserveNextPrimaryKey(StorageManager.getProductFile());
        return new Product(primaryKey, "", 0.0);
    }

    public static ObservableList<Product> readAll() {
        ObservableList<Product> list = FXCollections.observableArrayList();
        try {
            File file = StorageManager.getProductFile();
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                for (line = reader.readLine(); line != null; line = reader.readLine()) {
                    Product product = inflate(line);
                    if (product != null) {
                        list.add(product);
                    }
                }
            }
        } catch (IOException e) {
        }
        ExcludeSet.removeExcluded(StorageManager.getDeletedProductFile(), list);
        return list;
    }

    public static void update(Product product) {
        try {
            File temp = new File("temp");
            File source = StorageManager.getProductFile();
            try (BufferedReader reader = new BufferedReader(new FileReader(source)); PrintWriter writer = new PrintWriter(new FileWriter(temp))) {
                String line;
                for (line = reader.readLine(); line != null; line = reader.readLine()) {
                    int lineIndex = IndexReader.getLineIndex(line);
                    if (lineIndex == product.getPrimaryKey()) {
                        product.setLastMod(LocalDateTime.now());
                        writer.println(deflate(product));
                    } else {
                        writer.println(line);
                    }
                }
            }
            source.delete();
            temp.renameTo(source);

        } catch (IOException e) {
        }
    }

    public static void delete(Product product) {
        ExcludeSet.exclude(product.getPrimaryKey(), StorageManager.getDeletedProductFile());
    }

    public static Product find(int primaryKey) {
        Product product = null;
        try {
            File file = StorageManager.getProductFile();
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                for (line = reader.readLine(); line != null; line = reader.readLine()) {
                    int index = IndexReader.getLineIndex(line);
                    if (index == primaryKey) {
                        product = inflate(line);
                        break;
                    }
                }
            }

        } catch (IOException e) {
        }
        return product;
    }

    public static SaveTableView<Product> buildTableView() {
        SaveTableView<Product> tableView = new SaveTableView<>(new ProductSaver());

        TableColumn<Product, Integer> keyColumn = new TableColumn<>("Primary Key");
        keyColumn.setCellValueFactory(new PropertyValueFactory<>("primaryKey"));

        TableColumn<Product, String> idColumn = new TableColumn<>("ID");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        idColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        idColumn.setOnEditCommit((TableColumn.CellEditEvent<Product, String> t) -> {
            Product p = ((Product) t.getTableView().getItems().get(t.getTablePosition().getRow()));
            TableChange tc = new TableChange(p.getPrimaryKey(), "ID", p.getId(), t.getNewValue());
            tableView.createDesyncRecord(tc, p);
            p.setId(t.getNewValue());
        });

        TableColumn<Product, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        nameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        nameColumn.setOnEditCommit((TableColumn.CellEditEvent<Product, String> t) -> {
            Product p = ((Product) t.getTableView().getItems().get(t.getTablePosition().getRow()));
            TableChange tc = new TableChange(p.getPrimaryKey(), "NAME", p.getName(), t.getNewValue());
            tableView.createDesyncRecord(tc, p);
            p.setName(t.getNewValue());
        });

        TableColumn<Product, String> detailsColumn = new TableColumn<>("Details");
        detailsColumn.setCellValueFactory(new PropertyValueFactory<>("details"));
        detailsColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        detailsColumn.setOnEditCommit((TableColumn.CellEditEvent<Product, String> t) -> {
            Product p = ((Product) t.getTableView().getItems().get(t.getTablePosition().getRow()));
            TableChange tc = new TableChange(p.getPrimaryKey(), "DETAILS", p.getDetails(), t.getNewValue());
            tableView.createDesyncRecord(tc, p);
            p.setDetails(t.getNewValue());
        });

        TableColumn<Product, Double> purchasePriceColumn = new TableColumn<>("Purchase Price");
        purchasePriceColumn.setCellValueFactory(new PropertyValueFactory<>("purchasePrice"));
        purchasePriceColumn.setCellFactory((param) -> {
            return new PriceTableCell(); //To change body of generated lambdas, choose Tools | Templates.
        });
        purchasePriceColumn.setOnEditCommit((TableColumn.CellEditEvent<Product, Double> t) -> {
            Product p = ((Product) t.getTableView().getItems().get(t.getTablePosition().getRow()));
            TableChange tc = new TableChange(p.getPrimaryKey(), "PURCHASE_PRICE", Formatter.formatPrice(p.getPurchasePrice()), Formatter.formatPrice(t.getNewValue()));
            tableView.createDesyncRecord(tc, p);
            p.setPurchasePrice((t.getNewValue()));
        });

        TableColumn<Product, Double> sellingPriceColumn = new TableColumn<>("Selling Price");
        sellingPriceColumn.setCellValueFactory(new PropertyValueFactory<>("sellingPrice"));
        sellingPriceColumn.setCellFactory((param) -> {
            return new PriceTableCell(); //To change body of generated lambdas, choose Tools | Templates.
        });
        sellingPriceColumn.setOnEditCommit((TableColumn.CellEditEvent<Product, Double> t) -> {
            Product p = ((Product) t.getTableView().getItems().get(t.getTablePosition().getRow()));
            TableChange tc = new TableChange(p.getPrimaryKey(), "SELLING_PRICE", Formatter.formatPrice(p.getSellingPrice()), Formatter.formatPrice(t.getNewValue()));
            tableView.createDesyncRecord(tc, p);
            p.setSellingPrice((t.getNewValue()));
        });

        keyColumn.setPrefWidth(93);
        idColumn.setPrefWidth(148);
        nameColumn.setPrefWidth(405);
        detailsColumn.setPrefWidth(410);
        purchasePriceColumn.setPrefWidth(110);
        sellingPriceColumn.setPrefWidth(110);
        

        tableView.getColumns().addAll(keyColumn, idColumn, nameColumn, detailsColumn, purchasePriceColumn, sellingPriceColumn);
        tableView.styleTableView();
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
