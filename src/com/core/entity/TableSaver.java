/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.entity;

import java.util.Iterator;

/**
 *
 * @author daan-
 */
public interface TableSaver<T> {

    public void onSaveChanges(Iterator<T> i);

    public void undoChange(TableChange tableChange, Iterator<T> i);

}
