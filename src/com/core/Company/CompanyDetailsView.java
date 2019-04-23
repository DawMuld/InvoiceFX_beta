/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.Company;

import com.core.entity.DetailsView;
import com.gui.laf.Backgrounds;
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
public class CompanyDetailsView extends DetailsView<Company> {

    private Company hold;

    private Label nameLabel;
    private Label streetLabel;
    private Label zipcodeLabel;
    private Label cityLabel;
    private Label mobileLabel;
    private Label ibanLabel;
    private Label btwLabel;
    private Label kvkLabel;

    private TextField nameField;
    private TextField streetField;
    private TextField zipcodeField;
    private TextField cityField;
    private TextField mobileField;
    private TextField ibanField;
    private TextField btwField;
    private TextField kvkField;

    public CompanyDetailsView() {
        super();
        createLabels();
        createFields();
        super.getChildren().addAll(nameLabel, nameField,
                streetLabel, streetField,
                zipcodeLabel, zipcodeField,
                cityLabel, cityField,
                mobileLabel, mobileField,
                ibanLabel, ibanField,
                btwLabel, btwField,
                kvkLabel, kvkField);
        super.setBackground(Backgrounds.createWhiteBackground());
    }

    @Override
    public void inflate(Company entry) {
        hold = entry;
        clearFields();
        if (hold != null) {
            nameField.setText(entry.getName());
            streetField.setText(entry.getStreet());
            zipcodeField.setText(entry.getZipcode());
            cityField.setText(entry.getCity());
            mobileField.setText(entry.getMobile());
            ibanField.setText(entry.getIban());
            btwField.setText(entry.getBtw());
            kvkField.setText(entry.getKvk());
        }
    }

    @Override
    public Company deflate() {
        if (hold == null) {
            hold = CompanyLayer.create();
        }
        hold.setName(nameField.getText());
        hold.setStreet(streetField.getText());
        hold.setZipcode(zipcodeField.getText());
        hold.setCity(cityField.getText());
        hold.setMobile(mobileField.getText());
        hold.setIban(ibanField.getText());
        hold.setBtw(btwField.getText());
        hold.setKvk(kvkField.getText());
        return hold;
    }

    @Override
    public void clearFields() {
        nameField.setText("");
        streetField.setText("");
        zipcodeField.setText("");
        cityField.setText("");
        mobileField.setText("");
        ibanField.setText("");
        btwField.setText("");
        kvkField.setText("");

    }

    private void createLabels() {
        nameLabel = ControlBuilder.createSimpleLabel("Name");
        streetLabel = ControlBuilder.createSimpleLabel("Street");
        zipcodeLabel = ControlBuilder.createSimpleLabel("Zipcode");
        cityLabel = ControlBuilder.createSimpleLabel("City");
        mobileLabel = ControlBuilder.createSimpleLabel("Mobile");
        ibanLabel = ControlBuilder.createSimpleLabel("Iban");
        btwLabel = ControlBuilder.createSimpleLabel("Btw");
        kvkLabel = ControlBuilder.createSimpleLabel("Kvk");

        GridPane.setConstraints(nameLabel, 0, 0, 1, 1, HPos.LEFT, VPos.CENTER);
        GridPane.setConstraints(streetLabel, 0, 1, 1, 1, HPos.LEFT, VPos.CENTER);
        GridPane.setConstraints(zipcodeLabel, 0, 2, 1, 1, HPos.LEFT, VPos.CENTER);
        GridPane.setConstraints(cityLabel, 0, 3, 1, 1, HPos.LEFT, VPos.CENTER);
        GridPane.setConstraints(mobileLabel, 0, 4, 1, 1, HPos.LEFT, VPos.CENTER);
        GridPane.setConstraints(ibanLabel, 0, 5, 1, 1, HPos.LEFT, VPos.CENTER);
        GridPane.setConstraints(btwLabel, 0, 6, 1, 1, HPos.LEFT, VPos.CENTER);
        GridPane.setConstraints(kvkLabel, 0, 7, 1, 1, HPos.LEFT, VPos.CENTER);
    }

    private void createFields() {
        nameField = ControlBuilder.createSimpleTextField(20);
        streetField = ControlBuilder.createSimpleTextField(20);
        zipcodeField = ControlBuilder.createSimpleTextField(20);
        cityField = ControlBuilder.createSimpleTextField(20);
        mobileField = ControlBuilder.createSimpleTextField(20);
        ibanField = ControlBuilder.createSimpleTextField(20);
        btwField = ControlBuilder.createSimpleTextField(20);
        kvkField = ControlBuilder.createSimpleTextField(20);

        GridPane.setConstraints(nameField, 1, 0, 1, 1, HPos.LEFT, VPos.CENTER);
        GridPane.setConstraints(streetField, 1, 1, 1, 1, HPos.LEFT, VPos.CENTER);
        GridPane.setConstraints(zipcodeField, 1, 2, 1, 1, HPos.LEFT, VPos.CENTER);
        GridPane.setConstraints(cityField, 1, 3, 1, 1, HPos.LEFT, VPos.CENTER);
        GridPane.setConstraints(mobileField, 1, 4, 1, 1, HPos.LEFT, VPos.CENTER);
        GridPane.setConstraints(ibanField, 1, 5, 1, 1, HPos.LEFT, VPos.CENTER);
        GridPane.setConstraints(btwField, 1, 6, 1, 1, HPos.LEFT, VPos.CENTER);
        GridPane.setConstraints(kvkField, 1, 7, 1, 1, HPos.LEFT, VPos.CENTER);

    }

}
