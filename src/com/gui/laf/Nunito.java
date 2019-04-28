/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gui.laf;

import java.io.File;
import java.io.FileInputStream;
import javafx.scene.text.Font;

/**
 *
 * @author daan-
 */
public class Nunito {

    public static Font bold(double size) {
        return createFont("Nunito-Bold.ttf", size+2);
    }

    public static Font medium(double size) {
        return createFont("Nunito-SemiBold.ttf", size+2);
    }

    public static Font thin(double size) {
        return createFont("Nunito-Regular.ttf", size+2);
    }

    public static Font regular(double size) {
        return createFont("Nunito-ExtraLight.ttf", size+2);
    }

    private static Font createFont(String filename, double size) {
        File file = new File(System.getProperty("user.dir") + "\\res\\fonts\\nunito\\" + filename);
        try {
            return Font.loadFont(new FileInputStream(file), size);
        } catch (Exception e) {
        }
        return null;
    }

}
