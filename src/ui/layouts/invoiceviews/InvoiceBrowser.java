/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.layouts.invoiceviews;

import com.gui.laf.Backgrounds;
import com.gui.laf.Colors;
import javafx.geometry.Insets;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;

/**
 *
 * @author daan-
 */
public class InvoiceBrowser extends FlowPane {

    public InvoiceBrowser() {
        super();
        InvoiceListView listView = new InvoiceListView();
        listView.setPrefWidth(600);
        InvoicePresenter presenter = new InvoicePresenter();
        listView.selectedInvoiceProperty().addListener((o, v1, v2) -> {
            presenter.initPresenter(v2);
        });
        HBox box = new HBox(listView, presenter);
        super.getChildren().add(box);
        box.setPadding(new Insets(32));
        box.setBackground(Backgrounds.createColorBg(Colors.BLACK1, 20));
    }

}
