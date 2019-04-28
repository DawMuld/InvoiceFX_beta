/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.controls;

import com.gui.laf.Colors;
import com.gui.laf.Nunito;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;

/**
 *
 * @author daan-
 */
public class MenuToggle extends ToggleButton {

    private VBox menuBox;
    private List<Button> buttonList;



    public MenuToggle(String menuText, VBox menuBox) {
        super(menuText.toUpperCase());
        super.setPadding(new Insets(4, 4, 4, 4));
        super.setBackground(Background.EMPTY);
        super.setBorder(Border.EMPTY);
        super.setTextAlignment(TextAlignment.LEFT);
        super.setTextFill(Colors.WHITE1);
        super.setFont(Nunito.bold(16));
        this.menuBox = menuBox;
        menuBox.setMaxWidth(250);
        menuBox.setAlignment(Pos.CENTER_LEFT);
        this.buttonList = FXCollections.observableArrayList();
        super.selectedProperty().addListener((o, v1, v2) -> {
            if (v2 == true) {
                if (!buttonList.isEmpty()) {
                    menuBox.getChildren().addAll(buttonList);
                }
            } else {
                if (!buttonList.isEmpty()) {
                    menuBox.getChildren().removeAll(buttonList);
                }
            }
        });
    }



    public void addButton(Button button) {
        button.setPadding(new Insets(4, 4, 4, 16));
        button.setTextFill(Colors.WHITE1);
        button.setBackground(Background.EMPTY);
        button.setBorder(Border.EMPTY);
        button.setTextAlignment(TextAlignment.LEFT);
        button.setFont(Nunito.regular(14));
        buttonList.add(button);
    }
}
