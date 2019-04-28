/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app;

import javafx.scene.layout.AnchorPane;

/**
 *
 * @author daan-
 */
public interface ViewLoader {
    
    public void loadView(AnchorPane contentPane, InvoiceApp invoiceApp);
    
}
