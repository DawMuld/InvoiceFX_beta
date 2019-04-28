/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.layouts.invoiceviews;

import com.core.invoices.Invoice;
import com.gui.laf.Backgrounds;
import com.gui.laf.Colors;
import com.gui.laf.WindowBuilder;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import ui.app.AppDB;
import ui.controls.DatePickerDialog;

/**
 *
 * @author daan-
 */
public class InvoiceListView extends BorderPane {

    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private FlowPane filterPane;
    private Label fromLabel;
    private Label toLabel;
    private Label lDateLabel;
    private Label uDateLabel;
    private Button lDateButton;
    private Button uDateButton;
    private DatePickerDialog lDateDialog;
    private DatePickerDialog uDateDialog;
    private ListView<Invoice> listView;



    public InvoiceListView() {
        super();
        fromLabel = WindowBuilder.createLabel("from:");
        toLabel = WindowBuilder.createLabel("to  :");
        lDateLabel = WindowBuilder.createLabel("xxxx-xx-xx");
        uDateLabel = WindowBuilder.createLabel(dtf.format(LocalDate.now()));
        lDateButton = WindowBuilder.createFlatButton("Select");
        lDateDialog = new DatePickerDialog();
        lDateButton.setOnAction((event) -> {
            lDateDialog.showDatePickerDialog((localDate) -> {
                updateLowerBoundDate(localDate);
            });
        });
        uDateButton = WindowBuilder.createFlatButton("Select");
        uDateDialog = new DatePickerDialog();
        uDateButton.setOnAction((event) -> {
            uDateDialog.showDatePickerDialog((localDate) -> {
                updateUpperBoundDate(localDate);
            });
        });
        filterPane = new FlowPane(fromLabel, lDateLabel, lDateButton, toLabel, uDateLabel, uDateButton);
        filterPane.setAlignment(Pos.CENTER);
        filterPane.setHgap(16);
        filterPane.setPadding(new Insets(4, 8, 32, 8));
        fromLabel.setTextFill(Colors.WHITE1);
        toLabel.setTextFill(Colors.WHITE1);
        lDateLabel.setTextFill(Colors.WHITE1);
        uDateLabel.setTextFill(Colors.WHITE1);
        lDateButton.setTextFill(Colors.WHITE1);
        uDateButton.setTextFill(Colors.WHITE1);
        filterPane.setBackground(Backgrounds.createColorBg(Colors.BLACK2));
        setTop(filterPane);

        listView = new ListView<>();
        listView.setCellFactory((param) -> {
            return new InvoiceListCell();
        });
        listView.setBorder(Border.EMPTY);
        listView.setFixedCellSize(38);
        listView.setItems(AppDB.getDataBases().getInvoiceDB().getItems());
        listView.setPrefWidth(500);
        setCenter(listView);
        listView.setPadding(new Insets(0));
    }



    public ReadOnlyObjectProperty<Invoice> selectedInvoiceProperty() {
        return listView.getSelectionModel().selectedItemProperty();
    }



    private void updateLowerBoundDate(LocalDate localDate) {
        if (localDate != null) {
            String lString = dtf.format(localDate);
            lDateLabel.setText(lString);
        } else {
            lDateLabel.setText("xxxx-xx-xx");
        }
        String filter = lDateLabel.getText() + " " + uDateLabel.getText();
        lDateDialog = new DatePickerDialog();
        AppDB.getDataBases().getInvoiceDB().updateFilter(filter);

    }



    private void updateUpperBoundDate(LocalDate localDate) {
        if (localDate != null) {
            String uString = dtf.format(localDate);
            uDateLabel.setText(uString);
        } else {
            uDateLabel.setText("xxxx-xx-xx");
        }
        String filter = lDateLabel.getText() + " " + uDateLabel.getText();
        uDateDialog = new DatePickerDialog();
        AppDB.getDataBases().getInvoiceDB().updateFilter(filter);
    }

}
