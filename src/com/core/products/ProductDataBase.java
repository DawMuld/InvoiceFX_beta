/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.products;

import com.core.entity.DataBase;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;

/**
 *
 * @author daan-
 */
public class ProductDataBase extends DataBase<Product> {

    private final ObservableList<Product> sourceList;
    private final FilteredList<Product> filteredList;

    public ProductDataBase(ObservableList<Product> sourceList) {
        this.sourceList = sourceList;
        filteredList = new FilteredList<>(this.sourceList, t -> true);
    }

    @Override
    public FilteredList<Product> getItems() {
        return filteredList;
    }

    @Override
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

    @Override
    public ObservableList<Product> getSource() {
        return sourceList;
    }

}
