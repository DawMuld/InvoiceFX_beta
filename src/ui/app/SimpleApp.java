/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.app;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ui.components.docker.DockerPane;

/**
 *
 * @author daan-
 */
public class SimpleApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }



    @Override
    public void start(Stage primaryStage) throws Exception {
        String filePath = "file:/" + System.getProperty("user.dir").replace("\\", "/") + "/res/css/tableStyle.css";
        DockerPane root = new DockerPane(primaryStage);
        Scene scene = new Scene(root);
        scene.getStylesheets().add(filePath);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
