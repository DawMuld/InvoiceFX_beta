/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.invoices;

import com.core.persistence.ExcludeSet;
import com.core.persistence.Formatter;
import com.core.persistence.IndexReader;
import com.core.persistence.StorageManager;
import com.core.persistence.TimeStamper;
import com.core.entity.DetailsView;
import com.gui.listcells.InvoiceItemListCell;
import com.gui.listcells.InvoiceListCell;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.List;
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
public class InvoiceLayer {

    public static Invoice create() {
        int primaryKey = IndexReader.preserveNextPrimaryKey(StorageManager.getInvoiceFile());
        return new Invoice(primaryKey);
    }

    public static ObservableList<Invoice> readAll() {
        ObservableList<Invoice> list = FXCollections.observableArrayList();
        try {
            File file = StorageManager.getInvoiceFile();
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            for (line = reader.readLine(); line != null; line = reader.readLine()) {
                Invoice invoice = inflate(line);
                if (invoice != null) {
                    list.add(invoice);
                }
            }
            reader.close();
        } catch (Exception e) {
        }
        return list;
    }

    public static void update(Invoice invoice) {
        try {
            File temp = new File("temp");
            File source = StorageManager.getInvoiceFile();
            BufferedReader reader = new BufferedReader(new FileReader(source));
            PrintWriter writer = new PrintWriter(new FileWriter(temp));
            String line;
            for (line = reader.readLine(); line != null; line = reader.readLine()) {
                int lineIndex = IndexReader.getLineIndex(line);
                if (lineIndex == invoice.getPrimaryKey()) {
                    writer.println(deflate(invoice));
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

    public static void delete(Invoice invoice) {
        ExcludeSet.exclude(invoice.getPrimaryKey(), StorageManager.getDeletedInvoiceFile());
    }

    public static Invoice find(int primaryKey) {
        Invoice invoice = null;
        try {
            File file = StorageManager.getInvoiceFile();
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            for (line = reader.readLine(); line != null; line = reader.readLine()) {
                int lineKey = IndexReader.getLineIndex(line);
                if (lineKey == primaryKey) {
                    invoice = inflate(line);
                    break;
                }
            }
            reader.close();
        } catch (Exception e) {
        }
        return invoice;
    }

    public static TableView<InvoiceItem> buildInvoiceItemTableView() {
        TableView<InvoiceItem> tableView = new TableView<>();

        TableColumn<InvoiceItem, String> idColumn = new TableColumn<>("Product ID");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("productId"));
        idColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        idColumn.setOnEditCommit((TableColumn.CellEditEvent<InvoiceItem, String> t) -> {
            ((InvoiceItem) t.getTableView().getItems().get(t.getTablePosition().getRow())).setProductId(t.getNewValue());
        });

        TableColumn<InvoiceItem, String> nameColumn = new TableColumn<>("Product Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("productName"));
        nameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        nameColumn.setOnEditCommit((TableColumn.CellEditEvent<InvoiceItem, String> t) -> {
            ((InvoiceItem) t.getTableView().getItems().get(t.getTablePosition().getRow())).setProductName(t.getNewValue());
        });

        TableColumn<InvoiceItem, String> quantityColumn = new TableColumn<>("Quantity");
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        quantityColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        quantityColumn.setOnEditCommit((TableColumn.CellEditEvent<InvoiceItem, String> t) -> {
            int q = 0;
            try {
                q = Integer.parseInt(t.getNewValue());
            } catch (NumberFormatException e) {
                return;
            }
            ((InvoiceItem) t.getTableView().getItems().get(t.getTablePosition().getRow())).setQuantity(q);
        });

        TableColumn<InvoiceItem, String> unitPriceColumn = new TableColumn<>("Unit Price");
        unitPriceColumn.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        unitPriceColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        unitPriceColumn.setOnEditCommit((TableColumn.CellEditEvent<InvoiceItem, String> t) -> {
            double price = Formatter.formatPrice(t.getNewValue());
            ((InvoiceItem) t.getTableView().getItems().get(t.getTablePosition().getRow())).setUnitPrice(price);
        });

        TableColumn<InvoiceItem, String> taxColumn = new TableColumn<>("Tax");
        taxColumn.setCellValueFactory(new PropertyValueFactory<>("tax"));
        taxColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        taxColumn.setOnEditCommit((TableColumn.CellEditEvent<InvoiceItem, String> t) -> {
            double tax = Formatter.asPercentage(t.getNewValue());
            ((InvoiceItem) t.getTableView().getItems().get(t.getTablePosition().getRow())).setTax(tax);
        });

        TableColumn<InvoiceItem, String> discountColumn = new TableColumn<>("Discount");
        discountColumn.setCellValueFactory(new PropertyValueFactory<>("discount"));
        discountColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        discountColumn.setOnEditCommit((TableColumn.CellEditEvent<InvoiceItem, String> t) -> {
            double discount = Formatter.asPercentage(t.getNewValue());
            ((InvoiceItem) t.getTableView().getItems().get(t.getTablePosition().getRow())).setDiscount(discount);
        });

        tableView.getColumns().addAll(idColumn, nameColumn, quantityColumn, unitPriceColumn, taxColumn, discountColumn);
        return tableView;

    }

    public static ListView<Invoice> buildListView() {
        ListView<Invoice> listView = new ListView<>();
        listView.setCellFactory((param) -> {
            return new InvoiceListCell();
        });
        return listView;
    }

    public static ListView<InvoiceItem> buildInvoiceItemListView() {
        ListView<InvoiceItem> listView = new ListView<>();
        listView.setCellFactory((param) -> {
            return new InvoiceItemListCell();
        });
        return listView;
    }

    public static DetailsView<InvoiceItem> buildInvoiceItemDetailsView() {
        return new InvoiceItemDetailsView();
    }

    public static Invoice inflate(String line) {
        String[] cells = line.split(";");
        int primaryKey = Integer.parseInt(cells[0]);
        LocalDateTime createdAt = TimeStamper.parseLocalDateTime(cells[1]);
        LocalDateTime lastMod = TimeStamper.parseLocalDateTime(cells[2]);
        int companyKey = -1;
        try {
            companyKey = Integer.parseInt(cells[3]);
        } catch (NumberFormatException e) {
        }
        int customerKey = -1;
        try {
            customerKey = Integer.parseInt(cells[4]);
        } catch (NumberFormatException e) {
        }
        LocalDateTime invoiceDate = TimeStamper.parseLocalDateTime(cells[5]);
        ObservableList<InvoiceItem> list = FXCollections.observableArrayList();
        if (cells.length > 6) {
            for (int i = 6; i < cells.length; i++) {
                InvoiceItem item = inflateInvoiceItem(cells[i]);
                if (item != null) {
                    list.add(item);
                }
            }
        }
        return new Invoice(primaryKey, createdAt, lastMod, companyKey, customerKey, invoiceDate, list);
    }

    public static InvoiceItem inflateInvoiceItem(String part) {
        String[] cells = part.split("_");
        String id = cells[0];
        String name = cells[1];
        int quantity = 1;
        try {
            quantity = Integer.parseInt(cells[2]);
        } catch (NumberFormatException e) {
        }
        double price = Formatter.formatPrice(cells[3]);
        double tax = Formatter.asPercentage(cells[4]);
        double discount = Formatter.asPercentage(cells[5]);
        return new InvoiceItem(id, name, quantity, price, tax, discount);
    }

    public static String deflate(Invoice entry) {
        String line = String.valueOf(entry.getPrimaryKey());
        line += ";" + TimeStamper.parseTimeStamp(entry.getCreatedAt());
        line += ";" + TimeStamper.parseTimeStamp(entry.getLastMod());
        line += ";" + String.valueOf(entry.getCompanyKey());
        line += ";" + String.valueOf(entry.getCustomerKey());
        line += ";" + TimeStamper.parseTimeStamp(entry.getInvoiceDate());
        List<InvoiceItem> list = entry.getItemList();
        if (!list.isEmpty()) {
            for (InvoiceItem item : list) {
                line += ";" + deflate(item);
            }
        }
        return line;

    }

    public static String deflate(InvoiceItem entry) {
        String part = entry.getProductId();
        part += "_" + entry.getProductName();
        part += "_" + String.valueOf(entry.getQuantity());
        part += "_" + Formatter.formatPrice(entry.getUnitPrice());
        part += "_" + Formatter.asPercentage(entry.getTax());
        part += "_" + Formatter.asPercentage(entry.getDiscount());
        return part;
    }
}
