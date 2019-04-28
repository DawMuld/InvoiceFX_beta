/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.layouts.invoiceviews;

import com.core.customers.Customer;
import com.core.customers.CustomerLayer;
import com.core.invoices.Invoice;
import com.core.invoices.InvoiceCalculator;
import com.core.invoices.InvoiceItem;
import com.core.persistence.Formatter;
import com.core.persistence.TimeStamper;
import com.gui.custom.ColorListCell;
import com.gui.laf.Backgrounds;
import com.gui.laf.Colors;
import com.gui.laf.WindowBuilder;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;

/**
 *
 * @author daan-
 */
public class InvoicePresenter extends AnchorPane {

    private TaggedLabel customerIdTag;
    private TaggedLabel customerNameTag;
    private TaggedLabel customerStreetTag;
    private TaggedLabel customerAddressTag;
    private TaggedLabel invoiceIdTag;
    private TaggedLabel invoiceDateTag;
    private ListView<InvoiceItem> listView;
    private TaggedLabel totalExTag;
    private TaggedLabel totalTaxTag;
    private TaggedLabel totalIncTag;



    public InvoicePresenter() {
        super();
        customerIdTag = new TaggedLabel("Customer id    : ", false);

        customerNameTag = new TaggedLabel("Customer name  : ", false);

        customerStreetTag = new TaggedLabel("Customer street: ", false);

        customerAddressTag = new TaggedLabel("Customer city  : ", false);

        invoiceIdTag = new TaggedLabel("Invoice id   : ", true);
        invoiceDateTag = new TaggedLabel("Invoice date : ", true);
        listView = new ListView<>();
        listView.setCellFactory((param) -> {
            return new ItemListCell();
        });
        totalExTag = new TaggedLabel("total ex. btw   : ", true);
        totalTaxTag = new TaggedLabel("total btw      : ", true);
        totalIncTag = new TaggedLabel("total inc. btw : ", true);
        VBox customerBox = new VBox(customerIdTag, customerNameTag, customerStreetTag, customerAddressTag);
        VBox invoiceBox = new VBox(invoiceIdTag, invoiceDateTag);
        VBox resultBox = new VBox(totalExTag, totalTaxTag, totalIncTag);
        AnchorPane.setTopAnchor(customerBox, 8.0);
        AnchorPane.setLeftAnchor(customerBox, 8.0);
        AnchorPane.setTopAnchor(invoiceBox, 8.0);
        AnchorPane.setRightAnchor(invoiceBox, 8.0);
        AnchorPane.setBottomAnchor(resultBox, 8.0);
        AnchorPane.setRightAnchor(resultBox, 8.0);
        AnchorPane.setRightAnchor(listView, 16.0);
        AnchorPane.setLeftAnchor(listView, 16.0);
        AnchorPane.setBottomAnchor(listView, 100.0);
        AnchorPane.setTopAnchor(listView, 180.0);
        listView.setFixedCellSize(38);
        listView.setPrefWidth(700);
        listView.setPrefHeight(400);
        listView.setBackground(Backgrounds.createColorBg(Colors.BLACK1));
        super.getChildren().addAll(customerBox, invoiceBox, listView, resultBox);
        super.setBackground(Backgrounds.createColorBg(Colors.BLACK1));
        super.setPrefWidth(800);
    }



    public void clearPresenter() {
        customerAddressTag.setLabel("");
        customerIdTag.setLabel("");
        customerNameTag.setLabel("");
        customerStreetTag.setLabel("");
        invoiceDateTag.setLabel("");
        invoiceIdTag.setLabel("");
        totalExTag.setLabel("");
        totalTaxTag.setLabel("");
        totalIncTag.setLabel("");

    }



    public void initPresenter(Invoice invoice) {
        clearPresenter();
        if (invoice != null) {
            initCustomer(invoice.getCustomerKey());
            invoiceDateTag.setLabel(TimeStamper.DF.format(invoice.getInvoiceDate()));
            invoiceIdTag.setLabel(String.valueOf(invoice.getPrimaryKey()));
            ObservableList<InvoiceItem> itemList = listView.getItems();
            if (itemList == null) {
                listView.setItems(invoice.getItemList());
            } else {
                itemList.clear();
                itemList.addAll(invoice.getItemList());
            }
            totalExTag.setLabel("€  " + Formatter.formatPrice(InvoiceCalculator.totalEx(invoice.getItemList())));
            totalTaxTag.setLabel("€  " + Formatter.formatPrice(InvoiceCalculator.totalTax(invoice.getItemList())));
            totalIncTag.setLabel("€  " + Formatter.formatPrice(InvoiceCalculator.totalInc(invoice.getItemList())));

        }
    }



    private void initCustomer(int customerKey) {
        Customer c = CustomerLayer.find(customerKey);
        if (c != null) {
            customerIdTag.setLabel(c.getId());
            customerNameTag.setLabel(c.getName());
            customerStreetTag.setLabel(c.getStreet());
            customerAddressTag.setLabel(c.getZipcode() + ", " + c.getCity());
        }
    }

    public class TaggedLabel extends FlowPane {

        private Label tag;
        private Label label;



        public TaggedLabel() {
            super(8, 8);
            super.setAlignment(Pos.CENTER_LEFT);
            tag = WindowBuilder.createWhiteLabel(" :");
            label = WindowBuilder.createWhiteLabel("-");
            tag.setMinWidth(150);
            label.setMinWidth(150);
            super.getChildren().addAll(tag, label);
        }



        public TaggedLabel(String tagName, boolean allignRight) {
            super(8, 8);
            super.setAlignment(Pos.CENTER_LEFT);
            if (allignRight == true) {
                super.setAlignment(Pos.CENTER_RIGHT);
            }
            tag = WindowBuilder.createWhiteLabel(tagName);
            label = WindowBuilder.createWhiteLabel("-");
            tag.setMinWidth(150);
            label.setMinWidth(150);
            super.getChildren().addAll(tag, label);
        }



        public void setTag(String value) {
            tag.setText(value);
        }



        public void setLabel(String value) {
            label.setText(value);
        }

    }

    public class ItemListCell extends ColorListCell<InvoiceItem> {

        @Override
        public void updateItem(InvoiceItem item, boolean empty) {
            super.updateItem(item, empty);
            if (empty) {
                super.getRoot().getChildren().clear();
                super.getRoot().setBackground(Backgrounds.createColorBg(C1));
            }
            if (!empty) {
                Label idLabel = WindowBuilder.createWhiteLabel(item.getProductId());
                idLabel.setMinWidth(70);
                Label nameLabel = WindowBuilder.createWhiteLabel(item.getProductName());
                nameLabel.setMinWidth(300);
                Label qLabel = WindowBuilder.createWhiteLabel(String.valueOf(item.getQuantity()));
                qLabel.setMinWidth(40);
                Label priceLabel = WindowBuilder.createWhiteLabel("€  " + Formatter.formatPrice(item.getUnitPrice()));
                priceLabel.setMinWidth(120);
                Label taxLabel = WindowBuilder.createWhiteLabel(Formatter.asPercentage(item.getTax()) + " %");
                taxLabel.setMinWidth(60);
                Label discountLabel = WindowBuilder.createWhiteLabel("-" + Formatter.asPercentage(item.getDiscount()) + " %");
                discountLabel.setMinWidth(60);
                super.getRoot().getChildren().addAll(idLabel, nameLabel, qLabel, priceLabel, taxLabel, discountLabel);
                selectedProperty().addListener((o, v1, v2) -> {
                    if (v2 == true) {
                        idLabel.setFont(F2);
                        nameLabel.setFont(F2);
                        qLabel.setFont(F2);
                        priceLabel.setFont(F2);
                        taxLabel.setFont(F2);
                        discountLabel.setFont(F2);
                    } else {
                        idLabel.setFont(F1);
                        nameLabel.setFont(F1);
                        qLabel.setFont(F1);
                        priceLabel.setFont(F1);
                        taxLabel.setFont(F1);
                        discountLabel.setFont(F1);
                    }
                });
            }

        }

    }

}
