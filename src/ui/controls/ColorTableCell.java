/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.controls;

import com.core.persistence.Formatter;
import com.gui.laf.Backgrounds;
import com.gui.laf.Colors;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javafx.geometry.Pos;
import javafx.scene.control.TableCell;
import javafx.scene.control.TextField;
import javafx.scene.text.TextAlignment;
import ui.layouts.util.TableUtils;

/**
 *
 * @author daan-
 */
public class ColorTableCell<T, Object> extends TableCell<T, Object> {

    public static final DateTimeFormatter DTF = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    private TextField field = TableUtils.cteateCellField();
    private boolean center;
    private String text;



    public ColorTableCell() {
        super();
        center = true;
    }



    public ColorTableCell(boolean center) {
        super();
        this.center = center;
    }



    @Override
    public void updateItem(Object item, boolean empty) {
        super.updateItem(item, empty);
        if (empty == true) {

        } else {
            text = getObjectString(item);
            super.setText(text);
            super.setTextFill(Colors.WHITE1);
            if (center == true) {
                super.setTextAlignment(TextAlignment.CENTER);
                super.setAlignment(Pos.CENTER);
            }
            super.setBackground(Backgrounds.createColorBg(Colors.BLACK1));
        }

    }



    private String getObjectString(Object item) {
        if (item instanceof LocalDate) {
            return DTF.format((LocalDate) item);
        } else if (item instanceof Double) {
            double value = (Double) item;
            if (value < 1.0 && value > 0.0) {
                return Formatter.asPercentage(value) + "%";
            } else {
                return "€ " + Formatter.formatPrice(value);
            }
        } else if (item instanceof Integer) {
            return String.valueOf((Integer) item);
        }
        return item.toString();
    }

}
