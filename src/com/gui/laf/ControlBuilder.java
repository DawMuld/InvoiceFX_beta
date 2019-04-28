/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gui.laf;

import java.io.File;
import java.io.FileInputStream;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 *
 * @author daan-
 */
public class ControlBuilder {

    private static final Font BUTTON_IDLE = Nunito.thin(16);
    private static final Font BUTTON_HOVER = Nunito.regular(16);

    public static Label createSimpleLabel(String text) {
        Label label = new Label(text);
        label.setPadding(new Insets(8));
        label.setFont(Nunito.medium(18));
        label.setTextFill(Color.web("#000000"));
        label.setMinWidth(120);
        return label;
    }

    public static TextField createSimpleTextField(int columns) {
        TextField field = new TextField();
        field.setPrefColumnCount(columns);
        field.setFont(Nunito.medium(18));
        field.setBorder(Borders.textFieldBorder());
        field.setBackground(Backgrounds.createTextFieldBackground());
        field.setPadding(new Insets(8));
        field.focusedProperty().addListener((o, v1, v2) -> {
            if (v2 == true) {
                field.setBackground(Backgrounds.createColorBg(Color.web("#BBBBBB")));
            } else {
                field.setBackground(Backgrounds.createTextFieldBackground());
            }
        });
        return field;
    }

    public static TextField createSearchTextField() {
        int columns = 15;
        TextField field = new TextField();
        field.setPrefColumnCount(columns);
        field.setFont(Nunito.medium(16));
        field.setBorder(Borders.textFieldBorder());
        field.setBackground(Backgrounds.createTextFieldBackground());
        field.setPadding(new Insets(4));
        field.setPromptText("Search");
        return field;
    }

    public static Button createFlatButton(String text) {
        Button button = new Button(text.toUpperCase());
        button.setBackground(Background.EMPTY);
        button.setBorder(Border.EMPTY);
        button.setFont(BUTTON_IDLE);
        button.setPadding(new Insets(4));
        button.setMinWidth(20);
        button.hoverProperty().addListener((o, v1, v2) -> {
            if (v2 == false) {
                button.setFont(BUTTON_IDLE);
            } else {
                button.setFont(BUTTON_HOVER);
            }
        });
        return button;
    }

    public static Button createMenuButton(double size) {
        File file = new File(System.getProperty("user.dir") + "\\res\\icons\\menu.png");
        Image image = null;
        try {
            image = new Image(new FileInputStream(file));
        } catch (Exception e) {
        }
        ImageView imageView = new ImageView(image);
        Button button = new Button("", imageView);
        button.setBackground(Background.EMPTY);
        button.setBorder(Border.EMPTY);
        imageView.setFitWidth(size);
        imageView.setFitHeight(size);
        return button;
    }

    public static Button createSaveButton() {
        File file = new File(System.getProperty("user.dir") + "\\res\\icons\\save.png");
        Image image = null;
        try {
            image = new Image(new FileInputStream(file));
        } catch (Exception e) {
        }
        ImageView imageView = new ImageView(image);
        Button button = new Button("", imageView);
        button.setBackground(Background.EMPTY);
        button.setBorder(Border.EMPTY);
        imageView.setFitWidth(32);
        imageView.setFitHeight(32);
        return button;
    }

    public static Button createUndoButton() {
        File file = new File(System.getProperty("user.dir") + "\\res\\icons\\undo.png");
        Image image = null;
        try {
            image = new Image(new FileInputStream(file));
        } catch (Exception e) {
        }
        ImageView imageView = new ImageView(image);
        Button button = new Button("", imageView);
        button.setBackground(Background.EMPTY);
        button.setBorder(Border.EMPTY);
        imageView.setFitWidth(32);
        imageView.setFitHeight(32);
        return button;
    }

    public static Button createCreateButton() {
        File file = new File(System.getProperty("user.dir") + "\\res\\icons\\create.png");
        Image image = null;
        try {
            image = new Image(new FileInputStream(file));
        } catch (Exception e) {
        }
        ImageView imageView = new ImageView(image);
        Button button = new Button("", imageView);
        button.setBackground(Background.EMPTY);
        button.setBorder(Border.EMPTY);
        imageView.setFitWidth(32);
        imageView.setFitHeight(32);
        return button;
    }

    public static Button createDeleteButton() {
        File file = new File(System.getProperty("user.dir") + "\\res\\icons\\delete.png");
        Image image = null;
        try {
            image = new Image(new FileInputStream(file));
        } catch (Exception e) {
        }
        ImageView imageView = new ImageView(image);
        Button button = new Button("", imageView);
        button.setBackground(Background.EMPTY);
        button.setBorder(Border.EMPTY);
        imageView.setFitWidth(32);
        imageView.setFitHeight(32);
        return button;
    }

    public static Button createCompaniesButton(double size) {
        File file = new File(System.getProperty("user.dir") + "\\res\\icons\\companies.png");
        Image image = null;
        try {
            image = new Image(new FileInputStream(file));
        } catch (Exception e) {
        }
        ImageView imageView = new ImageView(image);
        Button button = new Button("", imageView);
        button.setBackground(Background.EMPTY);
        button.setBorder(Border.EMPTY);
        imageView.setFitWidth(size);
        imageView.setFitHeight(size);
        return button;
    }

    public static Button createCompaniesSquareButton(double size) {
        File file = new File(System.getProperty("user.dir") + "\\res\\icons\\companies_square.png");
        Image image = null;
        try {
            image = new Image(new FileInputStream(file));
        } catch (Exception e) {
        }
        ImageView imageView = new ImageView(image);
        Button button = new Button("", imageView);
        button.setBackground(Background.EMPTY);
        button.setBorder(Border.EMPTY);
        imageView.setFitWidth(size);
        imageView.setFitHeight(size);
        return button;
    }

    public static Button createCustomersButton(double size) {
        File file = new File(System.getProperty("user.dir") + "\\res\\icons\\customers.png");
        Image image = null;
        try {
            image = new Image(new FileInputStream(file));
        } catch (Exception e) {
        }
        ImageView imageView = new ImageView(image);
        Button button = new Button("", imageView);
        button.setBackground(Background.EMPTY);
        button.setBorder(Border.EMPTY);
        imageView.setFitWidth(size);
        imageView.setFitHeight(size);
        return button;
    }

    public static Button createCustomersSquareButton(double size) {
        File file = new File(System.getProperty("user.dir") + "\\res\\icons\\customers_square.png");
        Image image = null;
        try {
            image = new Image(new FileInputStream(file));
        } catch (Exception e) {
        }
        ImageView imageView = new ImageView(image);
        Button button = new Button("", imageView);
        button.setBackground(Background.EMPTY);
        button.setBorder(Border.EMPTY);
        imageView.setFitWidth(size);
        imageView.setFitHeight(size);
        return button;
    }

    public static Button createInvoicesButton(double size) {
        File file = new File(System.getProperty("user.dir") + "\\res\\icons\\invoices.png");
        Image image = null;
        try {
            image = new Image(new FileInputStream(file));
        } catch (Exception e) {
        }
        ImageView imageView = new ImageView(image);
        Button button = new Button("", imageView);
        button.setBackground(Background.EMPTY);
        button.setBorder(Border.EMPTY);
        imageView.setFitWidth(size);
        imageView.setFitHeight(size);
        return button;
    }

    public static Button createInvoicesSquareButton(double size) {
        File file = new File(System.getProperty("user.dir") + "\\res\\icons\\Invoices_square.png");
        Image image = null;
        try {
            image = new Image(new FileInputStream(file));
        } catch (Exception e) {
        }
        ImageView imageView = new ImageView(image);
        Button button = new Button("", imageView);
        button.setBackground(Background.EMPTY);
        button.setBorder(Border.EMPTY);
        imageView.setFitWidth(size);
        imageView.setFitHeight(size);
        return button;
    }

    public static Button createProductsButton(double size) {
        File file = new File(System.getProperty("user.dir") + "\\res\\icons\\products.png");
        Image image = null;
        try {
            image = new Image(new FileInputStream(file));
        } catch (Exception e) {
        }
        ImageView imageView = new ImageView(image);
        Button button = new Button("", imageView);
        button.setBackground(Background.EMPTY);
        button.setBorder(Border.EMPTY);
        imageView.setFitWidth(size);
        imageView.setFitHeight(size);
        return button;
    }

    public static Button createProductsSquareButton(double size) {
        File file = new File(System.getProperty("user.dir") + "\\res\\icons\\products_square.png");
        Image image = null;
        try {
            image = new Image(new FileInputStream(file));
        } catch (Exception e) {
        }
        ImageView imageView = new ImageView(image);
        Button button = new Button("", imageView);
        button.setBackground(Background.EMPTY);
        button.setBorder(Border.EMPTY);
        imageView.setFitWidth(size);
        imageView.setFitHeight(size);
        return button;
    }

    public static ToggleButton createCustomersToggleButton(double size) {
        File file1 = new File(System.getProperty("user.dir") + "\\res\\icons\\customers.png");
        Image image1 = null;
        File file2 = new File(System.getProperty("user.dir") + "\\res\\icons\\customers_square.png");
        Image image2 = null;
        try {
            image1 = new Image(new FileInputStream(file1));
            image2 = new Image(new FileInputStream(file2));
        } catch (Exception e) {
        }
        ImageView imageView1 = new ImageView(image1);
        ImageView imageView2 = new ImageView(image2);
        ToggleButton button = new ToggleButton("", imageView1);
        button.setBackground(Background.EMPTY);
        button.setBorder(Border.EMPTY);
        imageView1.setFitWidth(size);
        imageView1.setFitHeight(size);
        imageView2.setFitWidth(size);
        imageView2.setFitHeight(size);
        button.hoverProperty().addListener((o, v1, v2) -> {
            if (v2 == true) {
                button.setGraphic(imageView2);
            } else if (!button.isSelected()) {
                button.setGraphic(imageView1);
            }
        });
        button.selectedProperty().addListener((o, v1, v2) -> {
            if (v2 == true) {
                button.setGraphic(imageView2);
            } else {
                button.setGraphic(imageView1);
            }
        });
        return button;
    }

    public static ToggleButton createCompaniesToggleButton(double size) {
        File file1 = new File(System.getProperty("user.dir") + "\\res\\icons\\companies.png");
        Image image1 = null;
        File file2 = new File(System.getProperty("user.dir") + "\\res\\icons\\companies_square.png");
        Image image2 = null;
        try {
            image1 = new Image(new FileInputStream(file1));
            image2 = new Image(new FileInputStream(file2));
        } catch (Exception e) {
        }
        ImageView imageView1 = new ImageView(image1);
        ImageView imageView2 = new ImageView(image2);
        ToggleButton button = new ToggleButton("", imageView1);
        button.setBackground(Background.EMPTY);
        button.setBorder(Border.EMPTY);
        imageView1.setFitWidth(size);
        imageView1.setFitHeight(size);
        imageView2.setFitWidth(size);
        imageView2.setFitHeight(size);
        button.hoverProperty().addListener((o, v1, v2) -> {
            if (v2 == true) {
                button.setGraphic(imageView2);
            } else if (!button.isSelected()) {
                button.setGraphic(imageView1);
            }
        });
        button.selectedProperty().addListener((o, v1, v2) -> {
            if (v2 == true) {
                button.setGraphic(imageView2);
            } else {
                button.setGraphic(imageView1);
            }
        });
        return button;
    }

    public static ToggleButton createInvoicesToggleButton(double size) {
        File file1 = new File(System.getProperty("user.dir") + "\\res\\icons\\invoices.png");
        Image image1 = null;
        File file2 = new File(System.getProperty("user.dir") + "\\res\\icons\\invoices_square.png");
        Image image2 = null;
        try {
            image1 = new Image(new FileInputStream(file1));
            image2 = new Image(new FileInputStream(file2));
        } catch (Exception e) {
        }
        ImageView imageView1 = new ImageView(image1);
        ImageView imageView2 = new ImageView(image2);
        ToggleButton button = new ToggleButton("", imageView1);
        button.setBackground(Background.EMPTY);
        button.setBorder(Border.EMPTY);
        imageView1.setFitWidth(size);
        imageView1.setFitHeight(size);
        imageView2.setFitWidth(size);
        imageView2.setFitHeight(size);
        button.hoverProperty().addListener((o, v1, v2) -> {
            if (v2 == true) {
                button.setGraphic(imageView2);
            } else if (!button.isSelected()) {
                button.setGraphic(imageView1);
            }
        });
        button.selectedProperty().addListener((o, v1, v2) -> {
            if (v2 == true) {
                button.setGraphic(imageView2);
            } else {
                button.setGraphic(imageView1);
            }
        });
        return button;
    }

    public static ToggleButton createProductsToggleButton(double size) {
        File file1 = new File(System.getProperty("user.dir") + "\\res\\icons\\products.png");
        Image image1 = null;
        File file2 = new File(System.getProperty("user.dir") + "\\res\\icons\\products_square.png");
        Image image2 = null;
        try {
            image1 = new Image(new FileInputStream(file1));
            image2 = new Image(new FileInputStream(file2));
        } catch (Exception e) {
        }
        ImageView imageView1 = new ImageView(image1);
        ImageView imageView2 = new ImageView(image2);
        ToggleButton button = new ToggleButton("", imageView1);
        button.setBackground(Background.EMPTY);
        button.setBorder(Border.EMPTY);
        imageView1.setFitWidth(size);
        imageView1.setFitHeight(size);
        imageView2.setFitWidth(size);
        imageView2.setFitHeight(size);
        button.hoverProperty().addListener((o, v1, v2) -> {
            if (v2 == true) {
                button.setGraphic(imageView2);
            } else if (!button.isSelected()) {
                button.setGraphic(imageView1);
            }
        });
        button.selectedProperty().addListener((o, v1, v2) -> {
            if (v2 == true) {
                button.setGraphic(imageView2);
            } else {
                button.setGraphic(imageView1);
            }
        });
        return button;
    }

    public static ToggleButton createHomeToggleButton(double size) {
        File file1 = new File(System.getProperty("user.dir") + "\\res\\icons\\home.png");
        Image image1 = null;
        File file2 = new File(System.getProperty("user.dir") + "\\res\\icons\\home_square.png");
        Image image2 = null;
        try {
            image1 = new Image(new FileInputStream(file1));
            image2 = new Image(new FileInputStream(file2));
        } catch (Exception e) {
        }
        ImageView imageView1 = new ImageView(image1);
        ImageView imageView2 = new ImageView(image2);
        ToggleButton button = new ToggleButton("", imageView1);
        button.setBackground(Background.EMPTY);
        button.setBorder(Border.EMPTY);
        imageView1.setFitWidth(size);
        imageView1.setFitHeight(size);
        imageView2.setFitWidth(size);
        imageView2.setFitHeight(size);
        button.hoverProperty().addListener((o, v1, v2) -> {
            if (v2 == true) {
                button.setGraphic(imageView2);
            } else if (!button.isSelected()) {
                button.setGraphic(imageView1);
            }
        });
        button.selectedProperty().addListener((o, v1, v2) -> {
            if (v2 == true) {
                button.setGraphic(imageView2);
            } else {
                button.setGraphic(imageView1);
            }
        });
        return button;
    }

    public static Label buildTitleLabel(String text) {
        Label label = new Label(text);
        label.setPadding(new Insets(8));
        label.setFont(Nunito.bold(22));
        label.setBackground(Background.EMPTY);
        label.setTextFill(Color.web("#FFFFFF"));
        label.setMinWidth(120);
        return label;

    }

}
