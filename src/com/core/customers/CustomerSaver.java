/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.customers;

import com.core.entity.TableChange;
import com.core.entity.TableSaver;
import java.util.Iterator;

/**
 *
 * @author daan-
 */
public class CustomerSaver implements TableSaver<Customer> {

    @Override
    public void onSaveChanges(Iterator<Customer> i) {
        while (i.hasNext()) {
            CustomerLayer.update(i.next());
        }
    }

    @Override
    public void undoChange(TableChange tc, Iterator<Customer> i) {
        Customer c = findById(i, tc.getKey());
        if (c != null) {
            switch (tc.getField()) {
                case "ID":
                    c.setId(tc.getOldValue());
                    break;
                case "NAME":
                    c.setName(tc.getOldValue());
                    break;
                case "STREET":
                    c.setStreet(tc.getOldValue());
                    break;
                case "ZIPCODE":
                    c.setZipcode(tc.getOldValue());
                    break;
                case "CITY":
                    c.setCity(tc.getOldValue());
                    break;
                case "EMAIL":
                    c.setEmail(tc.getOldValue());
                    break;
                case "PHONE":
                    c.setPhone(tc.getOldValue());
                    break;
                case "MOBILE":
                    c.setMobile(tc.getOldValue());
                    break;
            }
        }
    }

    public static Customer findById(Iterator<Customer> i, int key) {
        Customer customer = null;
        while (i.hasNext()) {
            Customer hold = i.next();
            if (hold.getPrimaryKey() == key) {
                customer = hold;
                break;
            }
        }
        return customer;

    }
}
