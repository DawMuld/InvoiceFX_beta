/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app;

import com.app.settingsview.SettingsView;
import com.gui.laf.Backgrounds;
import com.gui.laf.Colors;
import com.gui.laf.WindowBuilder;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author daan-
 */
public class InvoiceApp extends Application {

    private AnchorPane headerPane;
    private AppView appView;

    private Stage mainStage;

    private double prevWindowX = 0;
    private double prevWindowY = 0;



    public static void main(String[] args) {
        launch(args);
    }



    @Override
    public void start(Stage stage) throws Exception {
        this.mainStage = stage;
        this.appView = new AppView();
        Button minButton = WindowBuilder.createMinimizeWindowButton();
        minButton.setOnAction((event) -> {
            mainStage.setIconified(true);
        });
        Button closeButton = WindowBuilder.createCloseWindowButton();
        closeButton.setOnAction((event) -> {
            mainStage.close();
        });
        FlowPane buttonPane = new FlowPane(minButton, closeButton);
        buttonPane.setAlignment(Pos.CENTER_RIGHT);
        AnchorPane.setRightAnchor(buttonPane, 4.0);
        AnchorPane.setTopAnchor(buttonPane, 4.0);
        AnchorPane.setBottomAnchor(buttonPane, 4.0);
        headerPane = new AnchorPane(buttonPane);
        headerPane.setBackground(Backgrounds.createColorBg(Colors.RED2));

        AnchorPane.setTopAnchor(appView, 30.0);
        AnchorPane.setLeftAnchor(appView, 0.0);
        AnchorPane.setRightAnchor(appView, 0.0);
        AnchorPane.setBottomAnchor(appView, 0.0);

        AnchorPane.setTopAnchor(headerPane, 0.0);
        AnchorPane.setLeftAnchor(headerPane, 0.0);
        AnchorPane.setRightAnchor(headerPane, 0.0);
        headerPane.setMaxHeight(30);

        headerPane.setOnMouseDragged((event) -> {
            double dx = event.getScreenX() - prevWindowX;
            double dy = event.getScreenY() - prevWindowY;
            prevWindowX = event.getScreenX();
            prevWindowY = event.getScreenY();
            if (dx < 50.0 && dx > -50.0) {
                mainStage.setX(mainStage.getX() + dx);
                mainStage.setY(mainStage.getY() + dy);
            }
        });

        headerPane.setOnMouseClicked((event) -> {
            if (event.getClickCount() >= 2) {
                mainStage.centerOnScreen();
            }
        });

        AnchorPane appViewPane = new AnchorPane(appView, headerPane);

        appView.getSettingsButton().setOnAction((event) -> {
            loadView(new SettingsView());
        });

        Scene scene = new Scene(appViewPane);
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
    }



    public void setWindowColors(Color color1, Color color2) {
        headerPane.setBackground(Backgrounds.createColorBg(color2));
        appView.setMenuColor(color1);
    }



    public void loadView(ViewLoader viewLoader) {
        AnchorPane contentPane = appView.getContentPane();
        contentPane.getChildren().clear();
        viewLoader.loadView(contentPane, this);
    }

}
