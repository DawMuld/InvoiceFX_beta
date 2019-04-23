/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;
 
import com.management.CustomerSearchView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author daan-
 */
public class CustomerSearchApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        CustomerSearchView customerSearchView = new CustomerSearchView();
        Scene scene = new Scene(customerSearchView);
        stage.setScene(scene);
        stage.show();
    }

}
