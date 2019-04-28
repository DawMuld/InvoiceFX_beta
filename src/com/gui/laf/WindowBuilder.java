/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gui.laf;

import java.io.File;
import java.io.FileInputStream;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

/**
 *
 * @author daan-
 */
public class WindowBuilder {

    private static final Font BUTTON_IDLE = Nunito.thin(14);
    private static final Font BUTTON_HOVER = Nunito.regular(14);
    private static final Background RED_BG = Backgrounds.createColorBg(Color.web("#C91A1A"));
    private static final Background ORANGE_BG = Backgrounds.createColorBg(Color.web("#D35400"));
    private static final Background HOVER_BG = Backgrounds.createColorBg(Color.web(Colors.GRAY1.toString(), 0.5));
    private static final Background TOGGLE_HOVER_BG = Backgrounds.createColorBg(Color.web("#356272", 0.2));
    private static final Background TOGGLE_SELECT_BG = Backgrounds.createColorBg(Color.web("#356272", 0.4));



    public static Button createCloseWindowButton() {
        Button button = new Button("X");
        button.setBackground(Background.EMPTY);
        button.setBorder(Border.EMPTY);
        button.setFont(BUTTON_IDLE);
        button.setPadding(new Insets(4, 16, 4, 16));
        button.setTextFill(Color.web("#FFFFFF"));
        button.hoverProperty().addListener((o, v1, v2) -> {
            if (v2 == false) {
                button.setBackground(Background.EMPTY);
            } else {
                button.setBackground(RED_BG);
            }
        });
        return button;
    }



    public static Button createMinimizeWindowButton() {
        Button button = new Button("-");
        button.setBackground(Background.EMPTY);
        button.setBorder(Border.EMPTY);
        button.setFont(BUTTON_IDLE);
        button.setPadding(new Insets(4, 16, 4, 16));
        button.setTextFill(Color.web("#FFFFFF"));
        button.hoverProperty().addListener((o, v1, v2) -> {
            if (v2 == false) {
                button.setBackground(Background.EMPTY);
            } else {
                button.setBackground(ORANGE_BG);
            }
        });
        return button;
    }



    public static Label createLabel(String text) {
        Label label = new Label(text);
        label.setFont(Nunito.regular(14));
        label.setPadding(new Insets(4));
        label.setAlignment(Pos.CENTER_LEFT);
        label.setTextAlignment(TextAlignment.LEFT);
        label.setBackground(Background.EMPTY);
        return label;
    }



    public static Label createWhiteLabel(String text) {
        Label label = new Label(text);
        label.setFont(Nunito.regular(14));
        label.setPadding(new Insets(4));
        label.setTextFill(Colors.WHITE1);
        label.setAlignment(Pos.CENTER_LEFT);
        label.setTextAlignment(TextAlignment.LEFT);
        label.setBackground(Background.EMPTY);
        return label;
    }



    public static ToggleButton createSubMenuButton(String text) {
        ToggleButton button = new ToggleButton(text);
        button.setTextFill(Color.web("#FFFFFF"));
        button.setFont(BUTTON_IDLE);
        button.setBorder(Border.EMPTY);
        button.setBackground(Background.EMPTY);
        button.hoverProperty().addListener((o, v1, v2) -> {
            if (v2 == true) {
                if (!button.isSelected()) {
                    button.setBackground(TOGGLE_HOVER_BG);
                }
            } else {
                if (!button.isSelected()) {
                    button.setBackground(Background.EMPTY);
                }
            }
        });
        button.selectedProperty().addListener((o, v1, v2) -> {
            if (v2 == true) {
                button.setBackground(TOGGLE_SELECT_BG);
            } else {
                button.setBackground(Background.EMPTY);
            }
        });
        return button;

    }



    public static Button createSettingsButton(double size) {
        File file = new File(System.getProperty("user.dir") + "\\res\\icons\\settings.png");
        Image image = null;
        try {
            image = new Image(new FileInputStream(file));
        } catch (Exception e) {
        }
        ImageView imageView = new ImageView(image);
        Button button = new Button("", imageView);
        button.setBackground(Background.EMPTY);
        button.setBorder(Border.EMPTY);
        imageView.setFitWidth(size);
        imageView.setFitHeight(size);
        button.hoverProperty().addListener((o, v1, v2) -> {
            if (v2 == true) {
                button.setBackground(HOVER_BG);
            } else {
                button.setBackground(Background.EMPTY);
            }
        });
        return button;
    }



    public static Button createShowMenuButton(double size) {
        File file = new File(System.getProperty("user.dir") + "\\res\\icons\\menu.png");
        Image image = null;
        try {
            image = new Image(new FileInputStream(file));
        } catch (Exception e) {
        }
        ImageView imageView = new ImageView(image);
        Button button = new Button("", imageView);
        button.setBackground(Background.EMPTY);
        button.setBorder(Border.EMPTY);
        imageView.setFitWidth(size);
        imageView.setFitHeight(size);
        button.hoverProperty().addListener((o, v1, v2) -> {
            if (v2 == true) {
                button.setBackground(HOVER_BG);
            } else {
                button.setBackground(Background.EMPTY);
            }
        });
        return button;
    }



    public static Button createHideMenuButton(double size) {
        File file = new File(System.getProperty("user.dir") + "\\res\\icons\\closemenu.png");
        Image image = null;
        try {
            image = new Image(new FileInputStream(file));
        } catch (Exception e) {
        }
        ImageView imageView = new ImageView(image);
        Button button = new Button("", imageView);
        button.setBackground(Background.EMPTY);
        button.setBorder(Border.EMPTY);
        imageView.setFitWidth(size);
        imageView.setFitHeight(size);
        button.hoverProperty().addListener((o, v1, v2) -> {
            if (v2 == true) {
                button.setBackground(HOVER_BG);
            } else {
                button.setBackground(Background.EMPTY);
            }
        });
        return button;
    }



    public static Button createFlatButton(String text) {
        Button button = new Button(text);
        button.setBackground(Background.EMPTY);
        button.setBorder(Border.EMPTY);
        button.setFont(BUTTON_IDLE);
        button.setPadding(new Insets(4));
        button.setMinWidth(20);
        button.hoverProperty().addListener((o, v1, v2) -> {
            if (v2 == false) {
                button.setFont(BUTTON_IDLE);
            } else {
                button.setFont(BUTTON_HOVER);
            }
        });
        return button;
    }
}
