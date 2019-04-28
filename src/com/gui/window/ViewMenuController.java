/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gui.window;

import com.gui.laf.Backgrounds;
import com.gui.laf.WindowBuilder;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;

/**
 *
 * @author daan-
 */
public interface ViewMenuController {

    public boolean requireSubMenuDrawer();



    public default void loadMainView(BorderPane contentPane) {
        FlowPane flowPane = new FlowPane();
        flowPane.setBackground(Backgrounds.createPoly1ImageBackground());
        contentPane.setCenter(flowPane);
    }



    public default FlowPane getSubMenuButtonPane() {
        FlowPane flowPane = new FlowPane(Orientation.VERTICAL, 8, 8);
        flowPane.getChildren().addAll(
                WindowBuilder.createSubMenuButton("Dummy button 1"),
                WindowBuilder.createSubMenuButton("Dummy button 2"),
                WindowBuilder.createSubMenuButton("Dummy button 3"),
                WindowBuilder.createSubMenuButton("Dummy button 4")
        );
        ToggleGroup tg = new ToggleGroup();
        for (Node node : flowPane.getChildren()) {
            ToggleButton btn = (ToggleButton) node;
            btn.setToggleGroup(tg);
        }
        return flowPane;

    }

}
