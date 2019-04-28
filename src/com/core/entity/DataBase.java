/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.entity;

import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;

/**
 *
 * @author daan-
 */
public abstract class DataBase<T> {

    public abstract ObservableList<T> getSource();

    public abstract FilteredList<T> getItems();

    public abstract void updateFilter(String value);

    public void removeItem(T item) {
        getSource().remove(item);
    }
    
    public void addItem(T item){
        getSource().add(item);
    }
}
