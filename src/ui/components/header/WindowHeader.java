/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.components.header;

import com.gui.laf.Backgrounds;
import com.gui.laf.Colors;
import com.gui.laf.Nunito;
import com.gui.laf.WindowBuilder;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author daan-
 */
public class WindowHeader extends AnchorPane {

    private final FlowPane windowButtonPane;
    private final FlowPane centerPane;
    private final FlowPane leftButtonPane;
    private final Button closeWindowButton;
    private final Button minimizeWindowButton;
    private final Label titleLabel;

    private Stage stage;
    private CloseWindowHandler closeWindowHandler;

    private double prevWindowX = 0;
    private double prevWindowY = 0;



    public WindowHeader() {
        super();
        closeWindowButton = WindowBuilder.createCloseWindowButton();
        minimizeWindowButton = WindowBuilder.createMinimizeWindowButton();
        windowButtonPane = new FlowPane(minimizeWindowButton, closeWindowButton);
        windowButtonPane.setAlignment(Pos.CENTER_RIGHT);

        titleLabel = new Label();
        titleLabel.setBackground(Background.EMPTY);
        titleLabel.setBorder(Border.EMPTY);
        titleLabel.setFont(Nunito.thin(14));
        titleLabel.setTextFill(Colors.WHITE1);
        titleLabel.setMinWidth(100);
        centerPane = new FlowPane(titleLabel);
        centerPane.setAlignment(Pos.CENTER);
        leftButtonPane = new FlowPane();
        leftButtonPane.setAlignment(Pos.CENTER_LEFT);
        initHeader();
        initWindowButtons();
    }



    public WindowHeader(Stage stage) {
        super();
        setStage(stage);
        closeWindowButton = WindowBuilder.createCloseWindowButton();
        minimizeWindowButton = WindowBuilder.createMinimizeWindowButton();
        windowButtonPane = new FlowPane(minimizeWindowButton, closeWindowButton);
        windowButtonPane.setAlignment(Pos.CENTER_RIGHT);

        titleLabel = new Label();
        titleLabel.setBackground(Background.EMPTY);
        titleLabel.setBorder(Border.EMPTY);
        titleLabel.setFont(Nunito.thin(14));
        titleLabel.setTextFill(Colors.WHITE1);
        titleLabel.setMinWidth(100);

        centerPane = new FlowPane(titleLabel);
        centerPane.setAlignment(Pos.CENTER);
        leftButtonPane = new FlowPane();
        leftButtonPane.setAlignment(Pos.CENTER_LEFT);
        initHeader();
        initWindowButtons();
    }



    public void setStage(Stage stage) {
        this.stage = stage;
        stage.initStyle(StageStyle.UNDECORATED);
    }
    


    public void setCloseWindowHandler(CloseWindowHandler handler) {
        this.closeWindowHandler = handler;
    }



    public void setTitle(String title) {
        titleLabel.setText(title);
    }



    public void addButton(Button button) {
        leftButtonPane.getChildren().add(button);
    }



    private void closeWindow() {
        if (this.stage != null) {
            if (closeWindowHandler != null) {
                closeWindowHandler.onCloseWindow(stage);
            } else {
                stage.close();
            }
        }
    }



    private void minimizeWindow() {
        if (this.stage != null) {
            stage.setIconified(true);
        }

    }



    private void centralizeStage() {
        if (this.stage != null) {
            stage.centerOnScreen();
        }
    }



    private void dragStage(double x, double y) {
        double dx = x - prevWindowX;
        double dy = y - prevWindowY;
        prevWindowX = x;
        prevWindowY = y;
        if (dx < 50 && dx > -50) {
            if (stage != null) {
                stage.setX(stage.getX() + dx);
                stage.setY(stage.getY() + dy);
            }
        }

    }



    private void initHeader() {
        AnchorPane.setTopAnchor(leftButtonPane, 1.0);
        AnchorPane.setBottomAnchor(leftButtonPane, 1.0);
        AnchorPane.setLeftAnchor(leftButtonPane, 1.0);

        AnchorPane.setTopAnchor(windowButtonPane, 1.0);
        AnchorPane.setBottomAnchor(windowButtonPane, 1.0);
        AnchorPane.setRightAnchor(windowButtonPane, 1.0);

        AnchorPane.setTopAnchor(centerPane, 1.0);
        AnchorPane.setBottomAnchor(centerPane, 1.0);
        AnchorPane.setRightAnchor(centerPane, 120.0);
        AnchorPane.setLeftAnchor(centerPane, 120.0);

        super.getChildren().addAll(leftButtonPane, centerPane, windowButtonPane);
        super.setBackground(Backgrounds.createColorBg(Colors.BLACK2));
    }



    private void initWindowButtons() {
        closeWindowButton.setOnAction((event) -> {
            closeWindow();
        });
        minimizeWindowButton.setOnAction((event) -> {
            minimizeWindow();
        });
        this.setOnMouseClicked((event) -> {
            if (event.getClickCount() >= 2) {
                centralizeStage();
            }
        });
        this.setOnMouseDragged((event) -> {
            dragStage(event.getScreenX(), event.getScreenY());
        });

    }

}
