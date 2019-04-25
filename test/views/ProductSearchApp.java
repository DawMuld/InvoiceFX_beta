/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import com.core.products.ProductSearchView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author daan-
 */
public class ProductSearchApp extends Application{

    public static void main(String[] args){launch(args);}
    
    @Override
    public void start(Stage stage) throws Exception {
        ProductSearchView root = new ProductSearchView();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    
}
