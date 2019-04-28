/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.components.drawer;

import com.gui.laf.Backgrounds;
import com.gui.laf.Colors;
import com.gui.laf.Effects;
import com.gui.laf.WindowBuilder;
import javafx.animation.TranslateTransition;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import ui.controls.MenuToggle;

/**
 *
 * @author daan-
 */
public class DrawerPane extends AnchorPane {

    private Button showMenuButton;
    private Button hideMenuButton;
    private FlowPane buttonPane;
    private TranslateTransition showDrawer;
    private TranslateTransition hideDrawer;



    public DrawerPane() {
        super();
        super.setMaxWidth(300);
        super.setMinWidth(300);
        super.setBackground(Backgrounds.createColorBg(Colors.BLACK1));
        super.setTranslateX(-310);
        super.setEffect(Effects.createMenuShadow());
        showMenuButton = WindowBuilder.createShowMenuButton(24);
        hideMenuButton = WindowBuilder.createHideMenuButton(24);
        showDrawer = new TranslateTransition(Duration.millis(500), this);
        showDrawer.setByX(310);
        showDrawer.setFromX(-310);
        showDrawer.setAutoReverse(false);
        showMenuButton.setOnAction((event) -> {
            showDrawer.play();
        });
        hideDrawer = new TranslateTransition(Duration.millis(500), this);
        hideDrawer.setByX(-310);
        hideDrawer.setFromX(0);
        hideDrawer.setAutoReverse(false);
        hideMenuButton.setOnAction((event) -> {
            hideDrawer.play();
        });
        AnchorPane.setTopAnchor(hideMenuButton, 4.0);
        AnchorPane.setRightAnchor(hideMenuButton, 4.0);

        buttonPane = new FlowPane(Orientation.VERTICAL, 8, 8);
        buttonPane.setAlignment(Pos.TOP_LEFT);

        AnchorPane.setTopAnchor(buttonPane, 64.0);
        AnchorPane.setLeftAnchor(buttonPane, 8.0);
        AnchorPane.setRightAnchor(buttonPane, 8.0);

        super.getChildren().addAll(hideMenuButton, buttonPane);

    }
    
    public void hideMenuDrawer(){
        hideDrawer.play();
    }



    public Button getShowMenuButton() {
        return showMenuButton;
    }



    public void addButton(String groupName, Button[] buttons) {
        VBox menuBox = new VBox();
        MenuToggle menuToggle = new MenuToggle(groupName, menuBox);
        for (Button button : buttons) {
            menuToggle.addButton(button);
        }
        menuBox.getChildren().add(menuToggle);
        buttonPane.getChildren().add(menuBox);
    }

}
