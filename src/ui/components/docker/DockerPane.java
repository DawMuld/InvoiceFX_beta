/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.components.docker;

import com.gui.laf.Backgrounds;
import com.gui.laf.Colors;
import com.gui.laf.WindowBuilder;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import ui.components.content.ContentPane;
import ui.components.drawer.DrawerPane;
import ui.components.header.WindowHeader;
import ui.layouts.invoiceviews.InvoiceEditorMenu;
import ui.layouts.invoiceviews.InvoiceItemTable;
import ui.layouts.invoiceviews.InvoiceListView;
import ui.layouts.invoiceviews.InvoicePresenter;
import ui.layouts.invoiceviews.InvoiceTable;
import ui.layouts.util.WrapperBuilder;

/**
 *
 * @author daan-
 */
public class DockerPane extends BorderPane {

    private WindowHeader windowHeader;
    private StackPane layerPane;
    private ContentPane contentPane;
    private DrawerPane drawerPane;

    private InvoicePresenter invoicePresenter;
    private InvoiceListView invoiceListView;
    private InvoiceTable invoiceTable;
    private InvoiceItemTable itemTable;



    public DockerPane(Stage stage) {
        super();
        windowHeader = new WindowHeader(stage);
        contentPane = new ContentPane();
        drawerPane = new DrawerPane();
        FlowPane flowPane = new FlowPane(contentPane);
        flowPane.setAlignment(Pos.CENTER_RIGHT);

        layerPane = new StackPane(flowPane, drawerPane);
        layerPane.setAlignment(Pos.CENTER_LEFT);
        setTop(windowHeader);
        setCenter(layerPane);
        windowHeader.addButton(drawerPane.getShowMenuButton());
        windowHeader.setTitle("Testing title");

        contentPane.installDrawerPane(drawerPane);
        contentPane.widthProperty().addListener((o, v1, v2) -> {
            contentPane.requestLayout();
        });

        initInvoiceMenu();
        Button[] customerButtons = new Button[]{WindowBuilder.createFlatButton("My Customers"), WindowBuilder.createFlatButton("Add Customer")};
        drawerPane.addButton("Customers", customerButtons);
        Button[] productButtons = new Button[]{WindowBuilder.createFlatButton("My Products"), WindowBuilder.createFlatButton("Add Product")};
        drawerPane.addButton("Products", productButtons);
    }



    private void initInvoiceMenu() {
        invoiceListView = new InvoiceListView();
        FlowPane listPane = new FlowPane(invoiceListView);
        listPane.setPadding(new Insets(16));
        listPane.setAlignment(Pos.TOP_CENTER);
        listPane.setBackground(Backgrounds.createColorBg(Colors.BLACK1, 25));

        invoicePresenter = new InvoicePresenter();
        FlowPane presenterPane = new FlowPane(invoicePresenter);
        presenterPane.setPadding(new Insets(16));
        presenterPane.setAlignment(Pos.TOP_CENTER);
        presenterPane.setBackground(Backgrounds.createColorBg(Colors.BLACK1, 25));

        invoiceListView.selectedInvoiceProperty().addListener((o, v1, v2) -> {
            invoicePresenter.initPresenter(v2);
        });
        AnchorPane.setTopAnchor(listPane, 32.0);
        AnchorPane.setTopAnchor(presenterPane, 32.0);
        AnchorPane.setRightAnchor(presenterPane, 32.0);
        AnchorPane.setLeftAnchor(listPane, 32.0);
        AnchorPane.setBottomAnchor(listPane, 32.0);
        AnchorPane.setBottomAnchor(presenterPane, 32.0);
        Button invoiceButton = WindowBuilder.createFlatButton("My Invoices");
        invoiceButton.setOnAction((event) -> {
            drawerPane.hideMenuDrawer();
            windowHeader.setTitle("My Invoices");
            contentPane.getChildren().clear();
            contentPane.getChildren().addAll(listPane, presenterPane);

        });
        /**
         * ************
         * ************
         */

        invoiceTable = new InvoiceTable();
        itemTable = new InvoiceItemTable();
        invoiceTable.getSelectedInvoiceProperty().addListener((observable, v1, v2) -> {
            if (v2 != null) {
                itemTable.initInvoiceItems(v2.getInvoice().getItemList());
            } else {
                itemTable.clear();
            }
        });
        invoiceTable.setPrefWidth(1400);
        itemTable.setPrefWidth(1400);
        FlowPane tableWrapper = WrapperBuilder.createBlackWrapper(invoiceTable);
        FlowPane itemWrapper = WrapperBuilder.createBlackWrapper(itemTable);
        AnchorPane.setTopAnchor(tableWrapper, 32.0);
        AnchorPane.setLeftAnchor(tableWrapper, 32.0);
        AnchorPane.setRightAnchor(tableWrapper, 32.0);
        AnchorPane.setBottomAnchor(tableWrapper, 464.0);
        itemWrapper.setMaxHeight(400);
        itemWrapper.setMinHeight(380);
        AnchorPane.setLeftAnchor(itemWrapper, 32.0);
        AnchorPane.setRightAnchor(itemWrapper, 32.0);
        AnchorPane.setBottomAnchor(itemWrapper, 32.0);
        Button createInvoiceButton = WindowBuilder.createFlatButton("Invoice Table");
        createInvoiceButton.setOnAction((event) -> {
            drawerPane.hideMenuDrawer();
            windowHeader.setTitle("Invoice Table");
            contentPane.getChildren().clear();
            contentPane.getChildren().addAll(tableWrapper, itemWrapper);
        });

        /**
         *
         *
         */
        InvoiceEditorMenu editorMenu = new InvoiceEditorMenu();
        AnchorPane.setTopAnchor(editorMenu, 32.0);
        AnchorPane.setBottomAnchor(editorMenu, 32.0);
        AnchorPane.setLeftAnchor(editorMenu, 32.0);
        AnchorPane.setRightAnchor(editorMenu, 32.0);
        Button statsButton = WindowBuilder.createFlatButton("Invoice Editor");
        statsButton.setOnAction((event) -> {
            drawerPane.hideMenuDrawer();
            windowHeader.setTitle("Invoice Editor");
            contentPane.getChildren().clear();
            contentPane.getChildren().add(editorMenu);
        });

        Button[] buttons = new Button[]{invoiceButton, createInvoiceButton, statsButton};
        drawerPane.addButton("Invoices", buttons);
    }

}
