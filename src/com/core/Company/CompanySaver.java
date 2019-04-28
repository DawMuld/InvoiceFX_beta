/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.Company;

import com.core.entity.TableChange;
import com.core.entity.TableSaver;
import java.util.Iterator;

/**
 *
 * @author daan-
 */
public class CompanySaver implements TableSaver<Company> {

    @Override
    public void onSaveChanges(Iterator<Company> i) {
        while (i.hasNext()) {
            CompanyLayer.update(i.next());
        }
    }

    @Override
    public void undoChange(TableChange tc, Iterator<Company> i) {
        Company c = findByKey(i, tc.getKey());
        if (c != null) {
            switch (tc.getField()) {
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
                case "MOBILE":
                    c.setMobile(tc.getOldValue());
                    break;
                case "IBAN":
                    c.setIban(tc.getOldValue());
                    break;
                case "BTW":
                    c.setBtw(tc.getOldValue());
                    break;
                case "KVK":
                    c.setKvk(tc.getOldValue());
                    break;

            }

        }

    }

    private static Company findByKey(Iterator<Company> i, int key) {
        Company company = null;
        while (i.hasNext()) {
            Company hold = i.next();
            if (hold.getPrimaryKey() == key) {
                company = hold;
                break;
            }
        }
        return company;
    }
}
