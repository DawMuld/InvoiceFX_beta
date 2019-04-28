/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.layouts.util;

import com.gui.laf.Backgrounds;
import com.gui.laf.Colors;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;

/**
 *
 * @author daan-
 */
public class WrapperBuilder {

    public static FlowPane createBlackWrapper(Node node) {
        FlowPane pane = new FlowPane(node);
        pane.setAlignment(Pos.TOP_CENTER);
        pane.setBackground(Backgrounds.createColorBg(Colors.BLACK1, 25));

        pane.setPadding(new Insets(16));
        return pane;

    }



    public static void setRightAnchors(Node node, double gap) {
        AnchorPane.setBottomAnchor(node, gap);
        AnchorPane.setTopAnchor(node, gap);
        AnchorPane.setRightAnchor(node, gap);
        AnchorPane.setLeftAnchor(node, AnchorPane.USE_PREF_SIZE);

    }



    public static void setLeftAnchors(Node node, double gap) {
        AnchorPane.setBottomAnchor(node, gap);
        AnchorPane.setTopAnchor(node, gap);
        AnchorPane.setLeftAnchor(node, gap);

    }

}
