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
public interface DesyncObserver {

    public void stateDesynced();

    public void stateSynced();

}
