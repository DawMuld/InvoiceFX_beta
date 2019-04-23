/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.customers;

import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;

/**
 *
 * @author daan-
 */
public class CustomerDataBase {

    private final ObservableList<Customer> sourceList;
    private FilteredList<Customer> filteredList;

    public CustomerDataBase(ObservableList<Customer> sourceList) {
        this.sourceList = sourceList;
        filteredList = new FilteredList<>(this.sourceList, t -> true);
        System.out.println("Customer source list size=" + sourceList.size());
    }

    public FilteredList<Customer> getItems() {
        return filteredList;
    }

    public void updateFilter(String value) {
        filteredList.setPredicate((customer) -> {
            if (value == null || value.isEmpty()) {
                return true;
            }
            String filter = value.toLowerCase();
            if (customer.getName().toLowerCase().contains(filter)) {
                return true;
            }

            if (customer.getCity().toLowerCase().contains(filter)) {
                return true;
            }

            return customer.getStreet().toLowerCase().contains(filter);
        });
    }

}
