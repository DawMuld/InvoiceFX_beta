/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.Company;

import com.core.entity.DataBase;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;

/**
 *
 * @author daan-
 */
public class CompanyDataBase extends DataBase<Company> {

    private final ObservableList<Company> sourceList;
    private final FilteredList<Company> filteredList;

    public CompanyDataBase(ObservableList<Company> sourceList) {
        this.sourceList = sourceList;
        filteredList = new FilteredList<>(this.sourceList, t -> true);
    }

    @Override
    public ObservableList<Company> getSource() {
        return sourceList;
    }

    @Override
    public FilteredList<Company> getItems() {
        return filteredList;
    }

    @Override
    public void updateFilter(String value) {
        filteredList.setPredicate((company) -> {
            if (value == null || value.isEmpty()) {
                return true;
            }
            String filter = value.toLowerCase();
            if (company.getName().toLowerCase().contains(filter)) {
                return true;
            }

            if (company.getCity().toLowerCase().contains(filter)) {
                return true;
            }

            return company.getStreet().toLowerCase().contains(filter);
        });
    }

}
