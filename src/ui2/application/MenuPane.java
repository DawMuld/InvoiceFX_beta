/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui2.application;

import javafx.geometry.Insets;
import javafx.scene.layout.FlowPane;

/**
 *
 * @author daan-
 */
public class MenuPane extends FlowPane {
    
    public MenuPane(){
        super(24, 24);
        super.setPadding(new Insets(24));
        super.setMinWidth(600);
        super.setMaxWidth(1200);
        super.setMinHeight(500);
        super.setMaxHeight(700);
        
    }
    
    
}
