/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.entity;

import java.time.LocalDateTime;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;

/**
 *
 * @author daan-
 */
public class Entity {

    private final IntegerProperty primaryKey;
    private final ReadOnlyObjectProperty<LocalDateTime> createdAt;
    private final ObjectProperty<LocalDateTime> lastMod;



    public Entity(int primaryKey) {
        this.primaryKey = new SimpleIntegerProperty(primaryKey);
        this.createdAt = new SimpleObjectProperty<>(LocalDateTime.now());
        this.lastMod = new SimpleObjectProperty<>(LocalDateTime.now());
    }



    public Entity(int primaryKey, LocalDateTime createdAt, LocalDateTime lastMod) {
        this.primaryKey = new SimpleIntegerProperty(primaryKey);
        this.createdAt = new SimpleObjectProperty<>(createdAt);
        this.lastMod = new SimpleObjectProperty<>(lastMod);
    }



    public int getPrimaryKey() {
        return primaryKey.get();
    }



    public IntegerProperty getPrimaryKeyProperty() {
        return primaryKey;
    }



    public LocalDateTime getCreatedAt() {
        return createdAt.get();
    }



    public ReadOnlyObjectProperty<LocalDateTime> getCreatedAtProperty() {
        return createdAt;
    }



    public LocalDateTime getLastMod() {
        return lastMod.get();
    }



    public void setLastMod(LocalDateTime value) {
        lastMod.set(value);
    }



    public ObjectProperty<LocalDateTime> getLastModProperty() {
        return lastMod;
    }

}
