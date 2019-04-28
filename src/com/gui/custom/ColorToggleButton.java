/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gui.custom;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

/**
 *
 * @author daan-
 */
public class ColorToggleButton extends ToggleButton{
    private final Color color1;
    private final Color color2;
    
    public ColorToggleButton(Color color1, Color color2){
        super();
        this.color1 = color1;
        this.color2 = color2;
        ImageView imageView = new ImageView(createImage(color1, color2));
        super.setGraphic(imageView);
    }



    public Color getColor1() {
        return color1;
    }



    public Color getColor2() {
        return color2;
    }
    
    
    public static Image createImage(Color c1, Color c2){
        BufferedImage canvas = new BufferedImage(32, 32, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = canvas.createGraphics();
        g.setColor(new java.awt.Color((float)c1.getRed(), (float)c1.getGreen(), (float)c1.getBlue()));
        g.fillRect(0, 0, 16, 16);
        g.setColor(new java.awt.Color((float)c2.getRed(), (float)c2.getGreen(), (float)c2.getBlue()));
        g.fillRect(16, 0, 16, 16);
        return SwingFXUtils.toFXImage(canvas, null);
    }
    
    
    
    
}
