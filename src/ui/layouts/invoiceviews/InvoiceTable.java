/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.layouts.invoiceviews;

import com.core.invoices.Invoice;
import java.util.List;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import ui.app.AppDB;

/**
 *
 * @author daan-
 */
public class InvoiceTable extends BorderPane {

    private TableView<InvoiceTableEntry> tableView;



    public InvoiceTable() {
        super();
        tableView = new TableView<>();
        ObservableList<InvoiceTableEntry> items = FXCollections.observableArrayList();
        List<Invoice> iList = AppDB.getDataBases().getInvoiceDB().getSource();
        for (Invoice invoice : iList) {
            items.add(new InvoiceTableEntry(invoice));
        }
        tableView.setItems(items);
        tableView.getColumns().addAll(buildDateColumn(), buildCompanyColumn(), buildCustomerColumn(), buildTotalExColumn(), buildTotalTaxColumn(), buildTotalIcColumn());
        super.setCenter(tableView);
        tableView.getColumns().forEach((t) -> {
            t.prefWidthProperty().bind(tableView.widthProperty().multiply(1.0 / (double) tableView.getColumns().size()));
        });

    }



    public ReadOnlyObjectProperty<InvoiceTableEntry> getSelectedInvoiceProperty() {
        return tableView.getSelectionModel().selectedItemProperty();
    }



    private TableColumn<InvoiceTableEntry, String> buildDateColumn() {
        TableColumn<InvoiceTableEntry, String> column = new TableColumn<>("Invoice Date");
        column.setCellValueFactory(new PropertyValueFactory<>("invoiceDate"));
        column.setPrefWidth(150);
        return column;
    }



    private TableColumn<InvoiceTableEntry, String> buildCompanyColumn() {
        TableColumn<InvoiceTableEntry, String> column = new TableColumn<>("Creditor");
        column.setCellValueFactory(new PropertyValueFactory<>("companyName"));
        column.setPrefWidth(200);
        return column;
    }



    private TableColumn<InvoiceTableEntry, String> buildCustomerColumn() {
        TableColumn<InvoiceTableEntry, String> column = new TableColumn<>("Debtor");
        column.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        column.setPrefWidth(200);
        return column;
    }



    private TableColumn<InvoiceTableEntry, String> buildTotalExColumn() {
        TableColumn<InvoiceTableEntry, String> column = new TableColumn<>("Total ex BTW");
        column.setCellValueFactory(new PropertyValueFactory<>("totalEx"));
        column.setPrefWidth(200);
        return column;
    }



    private TableColumn<InvoiceTableEntry, String> buildTotalTaxColumn() {
        TableColumn<InvoiceTableEntry, String> column = new TableColumn<>("Total Tax");
        column.setCellValueFactory(new PropertyValueFactory<>("totalTax"));
        column.setPrefWidth(200);
        return column;
    }



    private TableColumn<InvoiceTableEntry, String> buildTotalIcColumn() {
        TableColumn<InvoiceTableEntry, String> column = new TableColumn<>("Total inc BTW");
        column.setCellValueFactory(new PropertyValueFactory<>("totalInc"));
        column.setPrefWidth(200);
        return column;
    }

}
