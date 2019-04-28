/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gui.laf;

import com.gui.custom.ColorToggleButton;
import javafx.scene.paint.Color;

/**
 *
 * @author daan-
 */
public class Colors {

    public static final Color RED1 = Color.web("#E74C3C");
    public static final Color RED2 = Color.web("#C0392B");

    public static final Color ORANGE1 = Color.web("#E67E22");
    public static final Color ORANGE2 = Color.web("#D35400");

    public static final Color YELLOW1 = Color.web("#FFCD02");
    public static final Color YELLOW2 = Color.web("#FFA800");

    public static final Color SAND1 = Color.web("#F0DEB4");
    public static final Color SAND2 = Color.web("#D5C295");

    public static final Color NAVYBLUE1 = Color.web("#34495E");
    public static final Color NAVYBLUE2 = Color.web("#2C3E50");

    public static final Color BLACK1 = Color.web("#2B2B2B");//"#2B2B2B");
    public static final Color BLACK2 = Color.web("#262626");//"#262626");

    public static final Color MAGENTA1 = Color.web("#9B59B6");
    public static final Color MAGENTA2 = Color.web("#8E44AD");

    public static final Color TEAL1 = Color.web("#3A6F81");
    public static final Color TEAL2 = Color.web("#356272");

    public static final Color SKYBLUE1 = Color.web("#3498DB");
    public static final Color SKYBLUE2 = Color.web("#2980B9");

    public static final Color GREEN1 = Color.web("#2ECC71");
    public static final Color GREEN2 = Color.web("#27AE60");

    public static final Color MINT1 = Color.web("#1ABC9C");
    public static final Color MINT2 = Color.web("#16A085");

    public static final Color WHITE1 = Color.web("#FFFFFF");
    public static final Color WHITE2 = Color.web("#BDC3C7");

    public static final Color GRAY1 = Color.web("#95A5A6");
    public static final Color GRAY2 = Color.web("#7F8C8D");

    public static final Color FORESTGREEN1 = Color.web("#345F41");
    public static final Color FORESTGREEN2 = Color.web("#2D5036");

    public static final Color PURPLE1 = Color.web("#745EC5");
    public static final Color PURPLE2 = Color.web("#5B48A2");

    public static final Color BROWN1 = Color.web("#5E4534");
    public static final Color BROWN2 = Color.web("#503B2C");

    public static final Color PLUM1 = Color.web("#5E345E");
    public static final Color PLUM2 = Color.web("#4F2B4F");

    public static final Color WATERMELON1 = Color.web("#EF717A");
    public static final Color WATERMELON2 = Color.web("#D95459");

    public static final Color LIME1 = Color.web("#A5C63B");
    public static final Color LIME2 = Color.web("#8EB021");

    public static final Color PINK1 = Color.web("#F47CC3");
    public static final Color PINK2 = Color.web("#D45C9E");

    public static final Color MAROON1 = Color.web("#79302A");
    public static final Color MAROON2 = Color.web("#662621");

    public static final Color COFFEE1 = Color.web("#A38671");
    public static final Color COFFEE2 = Color.web("#8E725E");

    public static final Color POWDERBLUE1 = Color.web("#B8C9F1");
    public static final Color POWDERBLUE2 = Color.web("#99ABD5");

    public static final Color BLUE1 = Color.web("#5065A1");
    public static final Color BLUE2 = Color.web("#394C81");



    public static ColorToggleButton[] createColorToggles() {
        return new ColorToggleButton[]{
            new ColorToggleButton(RED1, RED2),
            new ColorToggleButton(ORANGE1, ORANGE2),
            new ColorToggleButton(YELLOW1, YELLOW2),
            new ColorToggleButton(SAND1, SAND2),
            new ColorToggleButton(NAVYBLUE1, NAVYBLUE2),
            new ColorToggleButton(BLACK1, BLACK2),
            new ColorToggleButton(MAGENTA1, MAGENTA2),
            new ColorToggleButton(TEAL1, TEAL2),
            new ColorToggleButton(SKYBLUE1, SKYBLUE2),
            new ColorToggleButton(GREEN1, GREEN2),
            new ColorToggleButton(MINT1, MINT2),
            new ColorToggleButton(WHITE1, WHITE2),
            new ColorToggleButton(GRAY1, GRAY2),
            new ColorToggleButton(FORESTGREEN1, FORESTGREEN2),
            new ColorToggleButton(PURPLE1, PURPLE2),
            new ColorToggleButton(BROWN1, BROWN2),
            new ColorToggleButton(PLUM1, PLUM2),
            new ColorToggleButton(WATERMELON1, WATERMELON2),
            new ColorToggleButton(LIME1, LIME2),
            new ColorToggleButton(PINK1, PINK2),
            new ColorToggleButton(MAROON1, MAROON2),
            new ColorToggleButton(COFFEE1, COFFEE2),
            new ColorToggleButton(POWDERBLUE1, POWDERBLUE2),
            new ColorToggleButton(BLUE1, BLUE2)
        };

    }

}
