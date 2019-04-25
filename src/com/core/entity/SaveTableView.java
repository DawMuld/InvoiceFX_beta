/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.entity;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import javafx.scene.control.TableView;

/**
 *
 * @author daan-
 */
public class SaveTableView<T> extends TableView<T> {

    private TableSaver<T> tableSaver;
    private Set<T> desyncSet;
    private Set<DesyncObserver> oSet;
    private Node head;

    public SaveTableView() {
        super();
        head = null;
        desyncSet = new HashSet<>();
        oSet = new HashSet<>();
    }

    public SaveTableView(TableSaver<T> tableSaver) {
        super();
        this.tableSaver = tableSaver;
        desyncSet = new HashSet<>();
        oSet = new HashSet<>();
    }

    public void saveChanges() {
        if (!desyncSet.isEmpty() && tableSaver != null) {
            tableSaver.onSaveChanges(desyncSet.iterator());
            head = null;
            desyncSet.clear();
            updateObservers();
        }

    }

    public void undoChange() {
        if (head != null) {
            TableChange tableChange = head.getTableChange();
            head = head.getNext();
            if (tableSaver != null) {
                tableSaver.undoChange(tableChange, desyncSet.iterator());
            }
            if (head == null) {
                desyncSet.clear();
                updateObservers();
            }
        }

    }

    public boolean isDesynchronized() {
        return head != null;

    }

    public void createDesyncRecord(TableChange change, T object) {
        Node node = new Node(change);
        node.setNext(head);
        head = node;
        desyncSet.add(object);
        updateObservers();
    }

    public void registerDesyncObserver(DesyncObserver o) {
        oSet.add(o);
    }

    public void unregisterDesyncObserver(DesyncObserver o) {
        oSet.remove(o);
    }

    public void updateObservers() {
        if (!oSet.isEmpty()) {
            Iterator<DesyncObserver> i = oSet.iterator();
            if (head == null) {
                while (i.hasNext()) {
                    i.next().stateSynced();
                }
            } else {
                while (i.hasNext()) {
                    i.next().stateDesynced();
                }
            }
        }
    }

    private class Node {

        private final TableChange tableChange;
        private Node next;

        Node(TableChange tableChange) {
            this.tableChange = tableChange;
            next = null;
        }

        void setNext(Node node) {
            next = node;
        }

        Node getNext() {
            return next;
        }

        boolean hasNext() {
            return next != null;
        }

        TableChange getTableChange() {
            return tableChange;
        }

    }

}
