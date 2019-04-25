/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.entity;

/**
 *
 * @author daan-
 */
public class TableChange {

    private final int key;
    private final String field;
    private final String oldValue;
    private final String newValue;

    public TableChange(int key, String field, String oldValue, String newValue) {
        this.key = key;
        this.field = field;
        if (oldValue == null || oldValue.isEmpty()) {
            this.oldValue = " ";
        } else {
            this.oldValue = oldValue;
        }
        if (newValue == null || newValue.isEmpty()) {
            this.newValue = " ";
        } else {
            this.newValue = newValue;
        }
    }

    public int getKey() {
        return key;
    }

    public String getField() {
        return field;
    }

    public String getOldValue() {
        return oldValue;
    }

    public String getNewValue() {
        return newValue;
    }

}
