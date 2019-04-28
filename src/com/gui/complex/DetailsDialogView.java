/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gui.complex;

import com.core.entity.DetailsView;
import com.gui.laf.Backgrounds;
import com.gui.laf.ControlBuilder;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

/**
 *
 * @author daan-
 */
public class DetailsDialogView<T> extends BorderPane {

    private DetailsView<T> detailsView;
    private Stage stage;
    private Button cancelButton;
    private Button saveButton;
    private Button saveAsNewButton;

    public DetailsDialogView(DetailsView<T> detailsView) {
        super();
        this.detailsView = detailsView;
        cancelButton = ControlBuilder.createFlatButton("Cancel");
        saveButton = ControlBuilder.createFlatButton("Save");
        saveAsNewButton = ControlBuilder.createFlatButton("Save ss new");
        FlowPane buttonPane = new FlowPane(8, 8, cancelButton, saveAsNewButton, saveButton);
        buttonPane.setAlignment(Pos.CENTER_RIGHT);
        setCenter(detailsView);
        setBottom(buttonPane);
        setPadding(new Insets(32));
        setBackground(Backgrounds.createPoly1ImageBackground());
    }

    public void loadAndShow(T entry) {
        detailsView.inflate(entry);
        if (stage == null || !stage.isShowing()) {
            loadAndShow();
        }
    }

    public void loadAndShow() {
        if (stage == null) {
            Scene scene = new Scene(this);
            stage = new Stage();
            stage.setScene(scene);
        }
        stage.show();
    }

    
   

}
