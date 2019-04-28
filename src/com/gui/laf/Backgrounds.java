/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gui.laf;

import java.io.File;
import java.io.FileInputStream;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

/**
 *
 * @author daan-
 */
public class Backgrounds {

    public static Background createWhiteBackground() {
        return createColorBg(Color.web("#FFFFFF"));
    }



    public static Background createTextFieldBackground() {
        return createColorBg(Color.web("#D6D6D6"));
    }



    public static Background createColorBg(Paint paint) {
        return new Background(new BackgroundFill(paint, CornerRadii.EMPTY, Insets.EMPTY));
    }



    public static Background createColorBg(Paint paint, double radii) {
        return new Background(new BackgroundFill(paint, new CornerRadii(radii), Insets.EMPTY));
    }



    public static Background createColorBg(Paint paint, double opacity, double radii) {
        Color color = (Color) paint;
        Color c = Color.color(color.getRed(), color.getGreen(), color.getBlue(), opacity);
        return new Background(new BackgroundFill(c, new CornerRadii(radii), Insets.EMPTY));
    }



    public static Background createImageBackground(Image image) {
        return new Background(new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(1.0, 1.0, true, true, true, true)));
    }



    public static Background createBlack1ImageBackground() {
        return createImageBackground(loadBgImage("black_1.jpg"));
    }



    public static Background createBlack2ImageBackground() {
        return createImageBackground(loadBgImage("black_2.jpg"));
    }



    public static Background createBlack3ImageBackground() {
        return createImageBackground(loadBgImage("black_3.jpg"));
    }



    public static Background createBlue1ImageBackground() {
        return createImageBackground(loadBgImage("blue_1.jpg"));
    }



    public static Background createPoly1ImageBackground() {
        return createImageBackground(loadBgImage("poly_1.jpg"));
    }



    public static Image loadBgImage(String fileName) {
        File file = new File(System.getProperty("user.dir") + "\\res\\bgs\\" + fileName);
        try {
            return new Image(new FileInputStream(file));
        } catch (Exception e) {
        }
        return null;

    }
}
