/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customer;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *
 * @author daan-
 */
public class CustomerTest extends Application {

    public static void main(String[] args){launch(args);}
    
    @Override
    public void start(Stage stage) throws Exception {
        BorderPane root = new BorderPane();
        root.setPrefSize(1600, 900);
        TableView<Customer> table = CustomerTableBuilder.createTableView();
        table.setEditable(true);
        table.setItems(CustomerTableBuilder.createDummyList());
        root.setCenter(table);
        Scene scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
        

    }
    
}
