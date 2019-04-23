/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.products;

import com.core.entity.DetailsView;
import com.gui.laf.ControlBuilder;
import com.core.persistence.Formatter;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

/**
 *
 * @author daan-
 */
public class ProductDetailsView extends DetailsView<Product> {

    private Product hold;

    private Label idLabel;
    private Label nameLabel;
    private Label detailsLabel;
    private Label purchasePriceLabel;
    private Label sellingPriceLabel;

    private TextField idField;
    private TextField nameField;
    private TextField detailsField;
    private TextField purchasePriceField;
    private TextField sellingPriceField;

    public ProductDetailsView() {
        super();
        createLabels();
        createFields();
        super.getChildren().addAll(
                idLabel, idField,
                nameLabel, nameField,
                detailsLabel, detailsField,
                purchasePriceLabel, purchasePriceField,
                sellingPriceLabel, sellingPriceField);

    }

    @Override
    public void inflate(Product entry) {
        hold = entry;
        clearFields();
        if (hold != null) {
            idField.setText(hold.getId());
            nameField.setText(hold.getName());
            detailsField.setText(hold.getDetails());
            purchasePriceField.setText(Formatter.formatPrice(hold.getPurchasePrice()));
            sellingPriceField.setText(Formatter.formatPrice(hold.getSellingPrice()));
        }
    }

    @Override
    public Product deflate() {
        if (hold == null) {
            hold = ProductLayer.create();
        }
        hold.setId(idField.getText());
        hold.setName(nameField.getText());
        hold.setDetails(detailsField.getText());
        hold.setPurchasePrice(Formatter.formatPrice(purchasePriceField.getText()));
        hold.setSellingPrice(Formatter.formatPrice(sellingPriceField.getText()));
        return hold;
    }

    @Override
    public void clearFields() {
        idField.setText("");
        nameField.setText("");
        detailsField.setText("");
        purchasePriceField.setText("");
        sellingPriceField.setText("");

    }

    private void createLabels() {
        idLabel = ControlBuilder.createSimpleLabel("Id");
        nameLabel = ControlBuilder.createSimpleLabel("Name");
        detailsLabel = ControlBuilder.createSimpleLabel("Details");
        purchasePriceLabel = ControlBuilder.createSimpleLabel("Purchase Price");
        sellingPriceLabel = ControlBuilder.createSimpleLabel("Selling Price");

        GridPane.setConstraints(idLabel, 0, 0, 1, 1, HPos.LEFT, VPos.CENTER);
        GridPane.setConstraints(nameLabel, 0, 1, 1, 1, HPos.LEFT, VPos.CENTER);
        GridPane.setConstraints(detailsLabel, 0, 2, 1, 1, HPos.LEFT, VPos.CENTER);
        GridPane.setConstraints(purchasePriceLabel, 0, 3, 1, 1, HPos.LEFT, VPos.CENTER);
        GridPane.setConstraints(sellingPriceLabel, 0, 4, 1, 1, HPos.LEFT, VPos.CENTER);
    }

    private void createFields() {
        idField = ControlBuilder.createSimpleTextField(20);
        nameField = ControlBuilder.createSimpleTextField(20);
        detailsField = ControlBuilder.createSimpleTextField(20);
        purchasePriceField = ControlBuilder.createSimpleTextField(20);
        sellingPriceField = ControlBuilder.createSimpleTextField(20);

        GridPane.setConstraints(idField, 1, 0, 1, 1, HPos.LEFT, VPos.CENTER);
        GridPane.setConstraints(nameField, 1, 1, 1, 1, HPos.LEFT, VPos.CENTER);
        GridPane.setConstraints(detailsField, 1, 2, 1, 1, HPos.LEFT, VPos.CENTER);
        GridPane.setConstraints(purchasePriceField, 1, 3, 1, 1, HPos.LEFT, VPos.CENTER);
        GridPane.setConstraints(sellingPriceField, 1, 4, 1, 1, HPos.LEFT, VPos.CENTER);

    }

}
