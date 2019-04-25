/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.products;

import com.core.entity.TableChange;
import com.core.entity.TableSaver;
import com.core.persistence.Formatter;
import java.util.Iterator;

/**
 *
 * @author daan-
 */
public class ProductSaver implements TableSaver<Product> {

    @Override
    public void onSaveChanges(Iterator<Product> i) {
        while (i.hasNext()) {
            ProductLayer.update(i.next());
        }
    }

    @Override
    public void undoChange(TableChange tableChange, Iterator<Product> i) {
        Product p = findByKey(i, tableChange.getKey());
        if (p != null) {
            switch (tableChange.getField()) {
                case "ID":
                    p.setId(tableChange.getOldValue());
                    break;
                case "NAME":
                    p.setName(tableChange.getOldValue());
                    break;
                case "DETAILS":
                    p.setDetails(tableChange.getOldValue());
                    break;
                case "PURCHASE_PRICE":
                    p.setPurchasePrice(Formatter.formatPrice(tableChange.getOldValue()));
                    break;
                case "SELLING_PRICE":
                    p.setSellingPrice(Formatter.formatPrice(tableChange.getOldValue()));
                    break;
            }
        }
    }

    private static Product findByKey(Iterator<Product> i, int key) {
        Product product = null;
        while (i.hasNext()) {
            Product hold = i.next();
            if (hold.getPrimaryKey() == key) {
                product = hold;
                break;
            }
        }
        return product;
    }
}
