/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.invoices;

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
public class InvoiceItemDetailsView extends DetailsView<InvoiceItem>{
    private InvoiceItem hold;
    
    private Label idLabel;
    private Label nameLabel;
    private Label qLabel;
    private Label priceLabel;
    private Label taxLabel;
    private Label discountLabel;
    
    private TextField idField;
    private TextField nameField;
    private TextField qField;
    private TextField priceField;
    private TextField taxField;
    private TextField discountField;
    
    public InvoiceItemDetailsView(){
        super();
        createLabels();
        createFields();
        super.getChildren().addAll(
                idLabel, idField,
                nameLabel, nameField,
                qLabel, qField, 
                priceLabel,priceField,
                taxLabel, taxField,
                discountLabel, discountField);
        
    }

    @Override
    public void inflate(InvoiceItem entry) {
        hold = entry;
        clearFields();
        if(hold!= null){
            idField.setText(hold.getProductId());
            nameField.setText(hold.getProductName());
            qField.setText(String.valueOf(hold.getQuantity()));
            priceField.setText(Formatter.formatPrice(hold.getUnitPrice()));
            taxField.setText(Formatter.asPercentage(hold.getTax()));
            discountField.setText(Formatter.asPercentage(hold.getDiscount()));
        }
    }

    @Override
    public InvoiceItem deflate() {
        String id = idField.getText();
        String name = nameField.getText();
        String qString = qField.getText();
        qString = qString.replaceAll("\\D", "");
        int q = 1;
        if(qString.length() > 0){
            try{
                q = Integer.parseInt(qString);
            }catch(NumberFormatException e){}
        }
        double price = Formatter.formatPrice(priceField.getText());
        double tax = Formatter.asPercentage(taxField.getText());
        double discount = Formatter.asPercentage(discountField.getText());
        if(hold == null){
            hold = new InvoiceItem(id, name, q, price, tax, discount);
        }else{
            hold.setProductId(id);
            hold.setProductName(name);
            hold.setQuantity(q);
            hold.setUnitPrice(price);
            hold.setTax(tax);
            hold.setDiscount(discount);
        }
        return hold;
            
        
    }

    @Override
    public void clearFields() {
        idField.setText("");
        nameField.setText("");
        qField.setText("");
        priceField.setText("");
        taxField.setText("");
        discountField.setText("");
                               
    }

    private void createLabels() {
        idLabel = ControlBuilder.createSimpleLabel("Product ID");
        nameLabel = ControlBuilder.createSimpleLabel("Product Name");
        qLabel = ControlBuilder.createSimpleLabel("Quantity");
        priceLabel = ControlBuilder.createSimpleLabel("Unit Price");
        taxLabel = ControlBuilder.createSimpleLabel("Tax (%)");
        discountLabel = ControlBuilder.createSimpleLabel("Discount (%)");
    
        GridPane.setConstraints(idLabel, 0, 0, 1, 1, HPos.LEFT, VPos.CENTER);
        GridPane.setConstraints(nameLabel, 0, 1, 1, 1, HPos.LEFT, VPos.CENTER);
        GridPane.setConstraints(qLabel, 0, 2, 1, 1, HPos.LEFT, VPos.CENTER);
        GridPane.setConstraints(priceLabel, 0, 3, 1, 1, HPos.LEFT, VPos.CENTER);
        GridPane.setConstraints(taxLabel, 0, 4, 1, 1, HPos.LEFT, VPos.CENTER);
        GridPane.setConstraints(discountLabel, 0, 5, 1, 1, HPos.LEFT, VPos.CENTER);
    
    }
    
    

    private void createFields() {
        idField = ControlBuilder.createSimpleTextField(20);
        nameField = ControlBuilder.createSimpleTextField(20);
        qField = ControlBuilder.createSimpleTextField(20);
        priceField = ControlBuilder.createSimpleTextField(20);
        taxField = ControlBuilder.createSimpleTextField(20);
        discountField = ControlBuilder.createSimpleTextField(20);
        
        
        GridPane.setConstraints(idField, 1, 0, 1, 1, HPos.LEFT, VPos.CENTER);
        GridPane.setConstraints(nameField, 1, 1, 1, 1, HPos.LEFT, VPos.CENTER);
        GridPane.setConstraints(qField, 1, 2, 1, 1, HPos.LEFT, VPos.CENTER);
        GridPane.setConstraints(priceField, 1, 3, 1, 1, HPos.LEFT, VPos.CENTER);
        GridPane.setConstraints(taxField, 1, 4, 1, 1, HPos.LEFT, VPos.CENTER);
        GridPane.setConstraints(discountField, 1, 5, 1, 1, HPos.LEFT, VPos.CENTER);
    }
    
}
