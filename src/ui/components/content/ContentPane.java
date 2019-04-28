/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.components.content;

import com.gui.laf.Backgrounds;
import javafx.scene.layout.AnchorPane;
import ui.components.drawer.DrawerPane;

/**
 *
 * @author daan-
 */
public class ContentPane extends AnchorPane {

    public ContentPane() {
        super();
        super.setPrefSize(1600, 900);
        super.setBackground(Backgrounds.createBlue1ImageBackground());
    }



    public void installDrawerPane(DrawerPane drawer) {
        drawer.translateXProperty().addListener((observable, v1, v2) -> {
            double tX = (double) v2;
            if (tX <= -300) {
                setMaxWidth(1600);
            } else {
                double dX = Math.sqrt((tX * tX));
                double dW = -300 + dX;
                setMaxWidth(1600 + dW);
            }
        });
    }
}
