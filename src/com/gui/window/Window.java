/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gui.window;

import com.gui.laf.Backgrounds;
import com.gui.laf.ControlBuilder;
import com.gui.laf.Effects;
import com.gui.laf.WindowBuilder;
import com.gui.views.companies.CompanyMenuController;
import com.gui.views.customers.CustomerMenuController;
import com.gui.views.home.HomeMenuController;
import com.gui.views.invoices.InvoiceMenuController;
import com.gui.views.products.ProductMenuController;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

/**
 *
 * @author daan-
 */
public class Window extends Application {

    private Stage mainStage;
    private StackPane layerPane;
    private AnchorPane menuDrawer;
    private AnchorPane subMenuDrawer;
    private AnchorPane contentLayer;
    private BorderPane contentPane;
    private MenuButtonPane menuButtonPane;
    private FlowPane subMenuButtonPane;

    private TranslateTransition showMenuTransition;
    private TranslateTransition hideMenuTransition;
    private TranslateTransition showSubMenuTransition;
    private TranslateTransition hideSubMenuTransition;

    private ViewMenuController activeMenuController;
    private HomeMenuController homeMenuController;
    private InvoiceMenuController invoiceMenuController;
    private CustomerMenuController customerMenuController;
    private ProductMenuController productMenuController;
    private CompanyMenuController companyMenuController;



    public static void main(String[] args) {
        launch(args);
    }



    @Override
    public void start(Stage stage) throws Exception {
        mainStage = stage;
        contentPane = new BorderPane();
        AnchorPane.setTopAnchor(contentPane, 0.0);
        AnchorPane.setBottomAnchor(contentPane, 0.0);
        AnchorPane.setRightAnchor(contentPane, 0.0);
        AnchorPane.setLeftAnchor(contentPane, 0.0);
        contentLayer = new AnchorPane(contentPane);
        menuDrawer = new AnchorPane();
        menuDrawer.setMaxWidth(80);
        menuDrawer.setBackground(Backgrounds.createColorBg(Color.web("#2C3E50")));

        subMenuDrawer = new AnchorPane();
        subMenuDrawer.setMaxWidth(300);
        subMenuDrawer.setBackground(Backgrounds.createColorBg(Color.web("#34495E")));

        contentLayer.setBackground(Backgrounds.createWhiteBackground());
        layerPane = new StackPane(contentLayer, subMenuDrawer, menuDrawer);
        layerPane.setPrefSize(1600, 900);
        layerPane.setAlignment(Pos.CENTER_LEFT);
        menuDrawer.setEffect(Effects.createMenuShadow());
        subMenuDrawer.setEffect(Effects.createMenuShadow());
        initMenuDrawer();
        initSubMenuDrawer();
        initContentPane();
        initWindowHeader();
        initViewMenuControllers();
        initMenuButtons();
        Scene scene = new Scene(layerPane);
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();

    }



    public boolean isShowingSubMenuDrawer() {
        return subMenuDrawer.getTranslateX() > -10;
    }



    public void showMenuDrawer() {
        showMenuTransition.play();
    }



    public void hideMenuDrawer() {
        if (subMenuDrawer.getTranslateX() > -10) {
            hideSubMenuDrawer();
        }
        hideMenuTransition.play();
    }



    public void showSubMenuDrawer() {
        showSubMenuTransition.play();

    }



    public void hideSubMenuDrawer() {
        hideSubMenuTransition.play();
    }



    public void closeWindow() {
        if (mainStage != null) {
            mainStage.close();
        }
    }



    public void onMenuButtonAction(ViewMenuController controller) {
        if (activeMenuController == controller) {
            if (!isShowingSubMenuDrawer() && controller.requireSubMenuDrawer()) {
                showSubMenuDrawer();
            } else if (isShowingSubMenuDrawer() && !controller.requireSubMenuDrawer()) {
                hideSubMenuDrawer();
            }
        } else {
            activeMenuController = controller;
            activeMenuController.loadMainView(contentPane);
            initSubMenuButtonPane();
            hideMenuDrawer();

        }
    }



    public void initSubMenuButtonPane() {
        if (subMenuButtonPane != null) {
            subMenuDrawer.getChildren().remove(subMenuButtonPane);
        }
        if (activeMenuController != null && activeMenuController.requireSubMenuDrawer()) {
            subMenuButtonPane = activeMenuController.getSubMenuButtonPane();
            if (subMenuButtonPane != null) {
                AnchorPane.setBottomAnchor(subMenuButtonPane, 8.0);
                AnchorPane.setTopAnchor(subMenuButtonPane, 32.0);
                AnchorPane.setLeftAnchor(subMenuButtonPane, 88.0);
                AnchorPane.setRightAnchor(subMenuButtonPane, 8.0);
                subMenuDrawer.getChildren().add(subMenuButtonPane);
            }
        }
    }



    private void initMenuDrawer() {
        menuButtonPane = new MenuButtonPane();
        AnchorPane.setBottomAnchor(menuButtonPane, 8.0);
        AnchorPane.setTopAnchor(menuButtonPane, 16.0);
        AnchorPane.setLeftAnchor(menuButtonPane, 8.0);
        AnchorPane.setRightAnchor(menuButtonPane, 8.0);
        menuDrawer.getChildren().add(menuButtonPane);
        Button closeButton = ControlBuilder.createFlatButton("X");
        AnchorPane.setTopAnchor(closeButton, 4.0);
        AnchorPane.setRightAnchor(closeButton, 4.0);
        menuDrawer.getChildren().add(closeButton);
        closeButton.setOnAction((event) -> {
            hideMenuDrawer();
        });
        closeButton.setTextFill(Color.web("#ECF0F1"));
        showMenuTransition = new TranslateTransition(Duration.millis(500), menuDrawer);
        showMenuTransition.setByX(90);
        showMenuTransition.setAutoReverse(false);
        hideMenuTransition = new TranslateTransition(Duration.millis(500), menuDrawer);
        hideMenuTransition.setByX(-90);
        hideMenuTransition.setAutoReverse(false);

    }



    private void initSubMenuDrawer() {
        Button closeButton = ControlBuilder.createFlatButton("X");
        AnchorPane.setTopAnchor(closeButton, 4.0);
        AnchorPane.setRightAnchor(closeButton, 4.0);
        subMenuDrawer.getChildren().add(closeButton);
        closeButton.setOnAction((event) -> {
            hideSubMenuDrawer();
        });
        closeButton.setTextFill(Color.web("#ECF0F1"));
        subMenuDrawer.setTranslateX(-300);
        showSubMenuTransition = new TranslateTransition(Duration.millis(400), subMenuDrawer);
        showSubMenuTransition.setByX(300);
        showSubMenuTransition.setAutoReverse(false);
        hideSubMenuTransition = new TranslateTransition(Duration.millis(400), subMenuDrawer);
        hideSubMenuTransition.setByX(-300);
        hideSubMenuTransition.setAutoReverse(false);

    }



    private void initWindowHeader() {
        Button closeButton = WindowBuilder.createCloseWindowButton();
        Button minimizeButton = ControlBuilder.createFlatButton("_");
        FlowPane windowButtonPane = new FlowPane(4, 4, minimizeButton, closeButton);
        windowButtonPane.setAlignment(Pos.CENTER_RIGHT);
        Button menuButton = ControlBuilder.createMenuButton(24);
        minimizeButton.setTextFill(Color.web("#ECF0F1"));

        AnchorPane.setTopAnchor(windowButtonPane, 4.0);
        AnchorPane.setRightAnchor(windowButtonPane, 4.0);
        AnchorPane.setBottomAnchor(windowButtonPane, 4.0);

        AnchorPane.setBottomAnchor(menuButton, 4.0);
        AnchorPane.setTopAnchor(menuButton, 4.0);
        AnchorPane.setLeftAnchor(menuButton, 4.0);

        menuButton.setOnAction((event) -> {
            showMenuDrawer();
        });

        closeButton.setOnAction((event) -> {
            closeWindow();
        });

        AnchorPane headerPane = new AnchorPane(menuButton, windowButtonPane);
        headerPane.setBackground(Backgrounds.createColorBg(Color.web("#34495E")));
        headerPane.setPrefWidth(1600);
        contentPane.setTop(headerPane);
    }



    private void initContentPane() {
        contentPane.setPrefWidth(1600);
    }



    private void initViewMenuControllers() {
        homeMenuController = new HomeMenuController();
        invoiceMenuController = new InvoiceMenuController();
        customerMenuController = new CustomerMenuController();
        productMenuController = new ProductMenuController();
        companyMenuController = new CompanyMenuController();
        activeMenuController = homeMenuController;
    }



    private void initMenuButtons() {
        menuButtonPane.getHomeButton().setOnAction((event) -> {
            ToggleButton target = (ToggleButton) event.getSource();
            target.setSelected(true);
            onMenuButtonAction(homeMenuController);
        });
        menuButtonPane.getInvoiceButton().setOnAction((event) -> {
            ToggleButton target = (ToggleButton) event.getSource();
            target.setSelected(true);
            onMenuButtonAction(invoiceMenuController);
        });
        menuButtonPane.getCustomerButton().setOnAction((event) -> {
            ToggleButton target = (ToggleButton) event.getSource();
            target.setSelected(true);
            onMenuButtonAction(customerMenuController);
        });
        menuButtonPane.getProductButton().setOnAction((event) -> {
            ToggleButton target = (ToggleButton) event.getSource();
            target.setSelected(true);
            onMenuButtonAction(productMenuController);
        });
        menuButtonPane.getCompanyButton().setOnAction((event) -> {
            ToggleButton target = (ToggleButton) event.getSource();
            target.setSelected(true);
            onMenuButtonAction(companyMenuController);
        });

    }
}
