/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.layouts.invoiceviews;

import javafx.geometry.Pos;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import ui.layouts.util.ButtonBuilder;

/**
 *
 * @author daan-
 */
public class InvoiceEditorMenu extends BorderPane {

    private ToggleButton createButton;
    private ToggleButton editButton;
    private ToggleButton copyButton;



    public InvoiceEditorMenu() {
        super();
        createButton = ButtonBuilder.newInvoiceButton();
        editButton = ButtonBuilder.editInvoiceButton();
        copyButton = ButtonBuilder.copyInvoiceButton();
        super.setPrefSize(1500, 820);
        FlowPane leftPane = buildWrapper(createButton);
        FlowPane centerPane = buildWrapper(editButton);
        FlowPane rightPane = buildWrapper(copyButton);
        setLeft(leftPane);
        setCenter(centerPane);
        setRight(rightPane);
    }



    private FlowPane buildWrapper(ToggleButton toggle) {
        FlowPane pane = new FlowPane(toggle);
        pane.setAlignment(Pos.CENTER);
        pane.setBackground(Background.EMPTY);
        pane.prefWidthProperty().bind(super.widthProperty().divide(3.0));
        return pane;
    }

}
