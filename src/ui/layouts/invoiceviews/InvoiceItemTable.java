/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.layouts.invoiceviews;

import com.core.invoices.InvoiceCalculator;
import com.core.invoices.InvoiceItem;
import com.core.persistence.Formatter;
import com.gui.laf.Backgrounds;
import com.gui.laf.Colors;
import com.gui.laf.WindowBuilder;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;

/**
 *
 * @author daan-
 */
public class InvoiceItemTable extends BorderPane {
    
    private TableView<InvoiceItemTableEntry> tableView;
    private Label totalExLabel;
    private Label totalTaxLabel;
    private Label totalIncLabel;
    
    
    
    public InvoiceItemTable() {
        tableView = new TableView<>();
        tableView.getColumns().addAll(idColumn(), nameColumn(), qColumn(), priceColumn(), taxColumn(), discountColumn(), totalColumn());
        FlowPane bottomPane = new FlowPane();
        VBox resultTagBox = new VBox(WindowBuilder.createWhiteLabel("Total ex. BTW"), WindowBuilder.createWhiteLabel("Total Taxes"), WindowBuilder.createWhiteLabel("Total inc. BTW"));
        totalExLabel = WindowBuilder.createWhiteLabel("-");
        totalTaxLabel = WindowBuilder.createWhiteLabel("-");
        totalIncLabel = WindowBuilder.createWhiteLabel("-");
        VBox resultValueBox = new VBox(totalExLabel, totalTaxLabel, totalIncLabel);
        bottomPane.setAlignment(Pos.CENTER_RIGHT);
        bottomPane.getChildren().addAll(resultTagBox, resultValueBox);
        setCenter(tableView);
        setBottom(bottomPane);
        setBackground(Backgrounds.createColorBg(Colors.BLACK1));
        tableView.setMaxHeight(200);
        tableView.getColumns().forEach((t) -> {
            t.prefWidthProperty().bind(tableView.widthProperty().multiply(0.99 / (double) tableView.getColumns().size()));
        });
    }
    
    
    
    public void clear() {
        if (tableView.getItems() != null) {
            tableView.getItems().clear();
        }
        totalExLabel.setText("-");
        totalTaxLabel.setText("-");
        totalIncLabel.setText("-");
    }
    
    
    
    public void initInvoiceItems(ObservableList<InvoiceItem> itemList) {
        clear();
        ObservableList<InvoiceItemTableEntry> items = FXCollections.observableArrayList();
        if (itemList != null && !itemList.isEmpty()) {
            double totalEx = InvoiceCalculator.totalEx(itemList);
            double totalTax = InvoiceCalculator.totalTax(itemList);
            double totalInc = InvoiceCalculator.totalInc(itemList);
            totalExLabel.setText("€  " + Formatter.formatPrice(totalEx));
            totalTaxLabel.setText("€  " + Formatter.formatPrice(totalTax));
            totalIncLabel.setText("€  " + Formatter.formatPrice(totalInc));
            for (InvoiceItem invoiceItem : itemList) {
                InvoiceItemTableEntry entry = new InvoiceItemTableEntry(invoiceItem);
                items.add(entry);
            }
            tableView.setItems(items);
        }
        
    }
    
    
    
    private TableColumn<InvoiceItemTableEntry, String> idColumn() {
        TableColumn<InvoiceItemTableEntry, String> column = new TableColumn<>("ID");
        column.setCellValueFactory(new PropertyValueFactory<>("id"));
        column.setPrefWidth(100);
        return column;
    }
    
    
    
    private TableColumn<InvoiceItemTableEntry, String> nameColumn() {
        TableColumn<InvoiceItemTableEntry, String> column = new TableColumn<>("Product");
        column.setCellValueFactory(new PropertyValueFactory<>("name"));
        column.setPrefWidth(100);
        return column;
    }
    
    
    
    private TableColumn<InvoiceItemTableEntry, String> qColumn() {
        TableColumn<InvoiceItemTableEntry, String> column = new TableColumn<>("Quantity");
        column.setCellValueFactory(new PropertyValueFactory<>("q"));
        column.setPrefWidth(100);
        return column;
    }
    
    
    
    private TableColumn<InvoiceItemTableEntry, String> priceColumn() {
        TableColumn<InvoiceItemTableEntry, String> column = new TableColumn<>("Price");
        column.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        column.setPrefWidth(100);
        return column;
    }
    
    
    
    private TableColumn<InvoiceItemTableEntry, String> taxColumn() {
        TableColumn<InvoiceItemTableEntry, String> column = new TableColumn<>("Tax");
        column.setCellValueFactory(new PropertyValueFactory<>("tax"));
        column.setPrefWidth(100);
        return column;
    }
    
    
    
    private TableColumn<InvoiceItemTableEntry, String> discountColumn() {
        TableColumn<InvoiceItemTableEntry, String> column = new TableColumn<>("Discount");
        column.setCellValueFactory(new PropertyValueFactory<>("discount"));
        column.setPrefWidth(100);
        return column;
    }
    
    
    
    private TableColumn<InvoiceItemTableEntry, String> totalColumn() {
        TableColumn<InvoiceItemTableEntry, String> column = new TableColumn<>("Total Ex BTW");
        column.setCellValueFactory(new PropertyValueFactory<>("totalEx"));
        column.setPrefWidth(100);
        return column;
    }
    
}
