/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import com.core.Company.CompanyLayer;
import com.core.customers.CustomerLayer;
import com.core.invoices.InvoiceLayer;
import com.core.products.ProductLayer;
import com.gui.laf.Backgrounds;
import com.gui.laf.ControlBuilder;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author daan-
 */
public class FieldApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane root = new BorderPane();
        Button btn1 = ControlBuilder.createFlatButton("company");
        btn1.setTextFill(Color.web("#FFFFFF"));
        btn1.setOnAction((event) -> {
            root.setCenter(CompanyLayer.buildDetailsView());
        });
        Button btn2 = ControlBuilder.createFlatButton("customer");
        btn2.setTextFill(Color.web("#FFFFFF"));
        btn2.setOnAction((event) -> {
            root.setCenter(CustomerLayer.buildDetailsView());
        });
        Button btn3 = ControlBuilder.createFlatButton("product");
        btn3.setTextFill(Color.web("#FFFFFF"));
        btn3.setOnAction((event) -> {
            root.setCenter(ProductLayer.buildDetailsView());
        });
        Button btn4 = ControlBuilder.createFlatButton("invoice item");
        btn4.setTextFill(Color.web("#FFFFFF"));
        btn4.setOnAction((event) -> {
            root.setCenter(InvoiceLayer.buildInvoiceItemDetailsView());
        });
        FlowPane pane = new FlowPane(btn1, btn2, btn3, btn4);
        pane.setBackground(Backgrounds.createColorBg(Color.web("#424242")));
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(16));
        root.setTop(pane);
        root.setCenter(CompanyLayer.buildDetailsView());

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

}
