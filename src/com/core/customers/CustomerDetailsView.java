/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.customers;

import com.core.entity.DetailsView;
import com.gui.laf.ControlBuilder;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

/**
 *
 * @author daan-
 */
public class CustomerDetailsView extends DetailsView<Customer> {

    private Customer hold;

    private Label idLabel;
    private Label nameLabel;
    private Label streetLabel;
    private Label zipcodeLabel;
    private Label cityLabel;
    private Label emailLabel;
    private Label phoneLabel;
    private Label mobileLabel;

    private TextField idField;
    private TextField nameField;
    private TextField streetField;
    private TextField zipcodeField;
    private TextField cityField;
    private TextField emailField;
    private TextField phoneField;
    private TextField mobileField;

    public CustomerDetailsView() {
        super();
        createLabels();
        createFields();
        super.getChildren().addAll(
                idLabel, idField,
                nameLabel, nameField,
                streetLabel, streetField,
                zipcodeLabel, zipcodeField,
                cityLabel, cityField,
                emailLabel, emailField,
                phoneLabel, phoneField,
                mobileLabel, mobileField);

    }

    @Override
    public void inflate(Customer entry) {
        hold = entry;
        clearFields();
        if (hold != null) {
            idField.setText(hold.getId());
            nameField.setText(hold.getName());
            streetField.setText(hold.getStreet());
            zipcodeField.setText(hold.getZipcode());
            cityField.setText(hold.getCity());
            emailField.setText(hold.getEmail());
            phoneField.setText(hold.getPhone());
            mobileField.setText(hold.getMobile());
        }
    }

    @Override
    public Customer deflate() {
        if (hold == null) {
            hold = CustomerLayer.create();
        }
        hold.setId(idField.getText());
        hold.setName(nameField.getText());
        hold.setStreet(streetField.getText());
        hold.setZipcode(zipcodeField.getText());
        hold.setCity(cityField.getText());
        hold.setEmail(emailField.getText());
        hold.setPhone(phoneField.getText());
        hold.setMobile(mobileField.getText());
        return hold;
    }

    @Override
    public void clearFields() {
        idField.setText("");
        nameField.setText("");
        streetField.setText("");
        zipcodeField.setText("");
        cityField.setText("");
        emailField.setText("");
        phoneField.setText("");
        mobileField.setText("");
    }

    private void createLabels() {
        idLabel = ControlBuilder.createSimpleLabel("Id");
        nameLabel = ControlBuilder.createSimpleLabel("Name");
        streetLabel = ControlBuilder.createSimpleLabel("Street");
        zipcodeLabel = ControlBuilder.createSimpleLabel("Zipcode");
        cityLabel = ControlBuilder.createSimpleLabel("City");
        emailLabel = ControlBuilder.createSimpleLabel("Email");
        phoneLabel = ControlBuilder.createSimpleLabel("Phone");
        mobileLabel = ControlBuilder.createSimpleLabel("Mobile");

        GridPane.setConstraints(idLabel, 0, 0, 1, 1, HPos.LEFT, VPos.CENTER);
        GridPane.setConstraints(nameLabel, 0, 1, 1, 1, HPos.LEFT, VPos.CENTER);
        GridPane.setConstraints(streetLabel, 0, 2, 1, 1, HPos.LEFT, VPos.CENTER);
        GridPane.setConstraints(zipcodeLabel, 0, 3, 1, 1, HPos.LEFT, VPos.CENTER);
        GridPane.setConstraints(cityLabel, 0, 4, 1, 1, HPos.LEFT, VPos.CENTER);
        GridPane.setConstraints(emailLabel, 0, 5, 1, 1, HPos.LEFT, VPos.CENTER);
        GridPane.setConstraints(phoneLabel, 0, 6, 1, 1, HPos.LEFT, VPos.CENTER);
        GridPane.setConstraints(mobileLabel, 0, 7, 1, 1, HPos.LEFT, VPos.CENTER);
    }

    private void createFields() {
        idField = ControlBuilder.createSimpleTextField(20);
        nameField = ControlBuilder.createSimpleTextField(20);
        streetField = ControlBuilder.createSimpleTextField(20);
        zipcodeField = ControlBuilder.createSimpleTextField(20);
        cityField = ControlBuilder.createSimpleTextField(20);
        emailField = ControlBuilder.createSimpleTextField(20);
        phoneField = ControlBuilder.createSimpleTextField(20);
        mobileField = ControlBuilder.createSimpleTextField(20);

        GridPane.setConstraints(idField, 1, 0, 1, 1, HPos.LEFT, VPos.CENTER);
        GridPane.setConstraints(nameField, 1, 1, 1, 1, HPos.LEFT, VPos.CENTER);
        GridPane.setConstraints(streetField, 1, 2, 1, 1, HPos.LEFT, VPos.CENTER);
        GridPane.setConstraints(zipcodeField, 1, 3, 1, 1, HPos.LEFT, VPos.CENTER);
        GridPane.setConstraints(cityField, 1, 4, 1, 1, HPos.LEFT, VPos.CENTER);
        GridPane.setConstraints(emailField, 1, 5, 1, 1, HPos.LEFT, VPos.CENTER);
        GridPane.setConstraints(phoneField, 1, 6, 1, 1, HPos.LEFT, VPos.CENTER);
        GridPane.setConstraints(mobileField, 1, 7, 1, 1, HPos.LEFT, VPos.CENTER);
    }

}
