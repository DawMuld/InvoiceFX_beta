/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.products;

import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;

/**
 *
 * @author daan-
 */
public class ProductDataBase {

    private final ObservableList<Product> sourceList;
    private FilteredList<Product> filteredList;

    public ProductDataBase(ObservableList<Product> sourceList) {
        this.sourceList = sourceList;
        filteredList = new FilteredList<>(this.sourceList, t -> true);
    }

    public FilteredList<Product> getItems() {
        return filteredList;
    }

    public void updateFilter(String value) {
        filteredList.setPredicate((product) -> {
            if (value == null || value.isEmpty()) {
                return true;
            }
            String filter = value.toLowerCase();
            if (product.getName().toLowerCase().contains(filter)) {
                return true;
            }
            return product.getDetails().toLowerCase().contains(filter);
        });
    }

}
