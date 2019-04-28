/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.invoices;

import com.core.entity.DataBase;
import java.time.LocalDate;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;

/**
 *
 * @author daan-
 */
public class InvoiceDataBase extends DataBase<Invoice> {

    private final ObservableList<Invoice> sourceList;
    private FilteredList<Invoice> filteredList;
    private LocalDate lBound;
    private LocalDate uBound;



    public InvoiceDataBase(ObservableList<Invoice> sourceList) {
        this.sourceList = sourceList;
        filteredList = new FilteredList<>(this.sourceList, t -> true);
    }



    @Override
    public ObservableList<Invoice> getSource() {
        return sourceList;
    }



    @Override
    public FilteredList<Invoice> getItems() {
        return filteredList;
    }



    @Override
    public void updateFilter(String value) {
        lBound = null;
        uBound = null;
        if (value != null && !value.isEmpty()) {
            String[] filterDates = value.split(" ");
            lBound = parseDate(filterDates[0]);
            uBound = parseDate(filterDates[1]);
        }
        filteredList.setPredicate((invoice) -> {
            if (value == null || value.isEmpty()) {
                return true;
            }
            if (lBound != null && uBound != null) {
                if (lBound.isBefore(invoice.getInvoiceDate().toLocalDate())) {
                    if (uBound.isAfter(invoice.getInvoiceDate().toLocalDate())) {
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            } else if (lBound != null) {
                return lBound.isBefore(invoice.getInvoiceDate().toLocalDate());
            } else if (uBound != null) {
                return uBound.isAfter(invoice.getInvoiceDate().toLocalDate());
            }
            return true;

        });
    }



    private LocalDate parseDate(String filterDate) {
        String[] values = filterDate.split("-");
        if (values[0].contains("x")) {
            return null;
        }
        int year = Integer.parseInt(values[0]);
        int month = Integer.parseInt(values[1]);
        int day = Integer.parseInt(values[2]);
        return LocalDate.of(year, month, day);
    }

}
