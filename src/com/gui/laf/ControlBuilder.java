/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gui.laf;

import java.io.File;
import java.io.FileInputStream;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 *
 * @author daan-
 */
public class ControlBuilder {

    private static final Font BUTTON_IDLE = Nunito.thin(16);
    private static final Font BUTTON_HOVER = Nunito.regular(16);

    public static Label createSimpleLabel(String text) {
        Label label = new Label(text);
        label.setPadding(new Insets(8));
        label.setFont(Nunito.medium(18));
        label.setTextFill(Color.web("#000000"));
        label.setMinWidth(120);
        return label;
    }

    public static TextField createSimpleTextField(int columns) {
        TextField field = new TextField();
        field.setPrefColumnCount(columns);
        field.setFont(Nunito.medium(18));
        field.setBorder(Borders.textFieldBorder());
        field.setBackground(Backgrounds.createTextFieldBackground());
        field.setPadding(new Insets(8));
        field.focusedProperty().addListener((o, v1, v2) -> {
            if (v2 == true) {
                field.setBackground(Backgrounds.createColorBg(Color.web("#BBBBBB")));
            } else {
                field.setBackground(Backgrounds.createTextFieldBackground());
            }
        });
        return field;
    }

    public static TextField createSearchTextField() {
        int columns = 30;
        TextField field = new TextField();
        field.setPrefColumnCount(columns);
        field.setFont(Nunito.medium(18));
        field.setBorder(Borders.textFieldBorder());
        field.setBackground(Backgrounds.createTextFieldBackground());
        field.setPadding(new Insets(8));
        field.setPromptText("Search");
        return field;
    }

    public static Button createFlatButton(String text) {
        Button button = new Button(text.toUpperCase());
        button.setBackground(Background.EMPTY);
        button.setBorder(Border.EMPTY);
        button.setFont(BUTTON_IDLE);
        button.setPadding(new Insets(4));
        button.setMinWidth(64);
        button.hoverProperty().addListener((o, v1, v2) -> {
            if (v2 == false) {
                button.setFont(BUTTON_IDLE);
            } else {
                button.setFont(BUTTON_HOVER);
            }
        });
        return button;
    }

    public static Button createSaveButton() {
        File file = new File(System.getProperty("user.dir") + "\\res\\icons\\save.png");
        Image image = null;
        try {
            image = new Image(new FileInputStream(file));
        } catch (Exception e) {
        }
        ImageView imageView = new ImageView(image);
        Button button = new Button("", imageView);
        button.setBackground(Background.EMPTY);
        button.setBorder(Border.EMPTY);
        imageView.setFitWidth(32);
        imageView.setFitHeight(32);
        return button;
    }

    public static Button createUndoButton() {
        File file = new File(System.getProperty("user.dir") + "\\res\\icons\\undo.png");
        Image image = null;
        try {
            image = new Image(new FileInputStream(file));
        } catch (Exception e) {
        }
        ImageView imageView = new ImageView(image);
        Button button = new Button("", imageView);
        button.setBackground(Background.EMPTY);
        button.setBorder(Border.EMPTY);
        imageView.setFitWidth(32);
        imageView.setFitHeight(32);
        return button;
    }

}
