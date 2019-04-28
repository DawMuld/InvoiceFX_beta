/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gui.views.invoices;

import com.gui.window.ViewMenuController;

/**
 *
 * @author daan-
 */
public class InvoiceMenuController implements ViewMenuController{

    @Override
    public boolean requireSubMenuDrawer() {
        return true;
    }
    
}
