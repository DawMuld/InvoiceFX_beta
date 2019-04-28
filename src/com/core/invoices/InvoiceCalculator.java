/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.invoices;

import com.core.persistence.Formatter;
import java.util.List;

/**
 *
 * @author daan-
 */
public class InvoiceCalculator {

    public static double normalize(double value) {
        String price = Formatter.formatPrice(value);
        return Formatter.formatPrice(price);
    }

    public static void addItem(List<InvoiceItem> list, InvoiceItem item) {
        if (list.isEmpty()) {
            list.add(item);
        } else {
            boolean present = false;
            for (InvoiceItem listItem : list) {
                if (listItem.getProductId().equalsIgnoreCase(item.getProductId())) {
                    present = true;
                    int q = listItem.getQuantity() + item.getQuantity();
                    listItem.setQuantity(q);
                    break;
                }
            }
            if (present == false) {
                list.add(item);
            }
        }
    }

    public static void removeItem(List<InvoiceItem> list, InvoiceItem item) {
        InvoiceItem target = null;
        for (InvoiceItem listItem : list) {
            if (listItem.getProductId().equalsIgnoreCase(item.getProductId())) {
                target = listItem;
                break;
            }
        }
        if (target != null) {
            int qTotal = target.getQuantity();
            int qSub = item.getQuantity();
            int qResult = qTotal - qSub;
            if (qResult > 0) {
                target.setQuantity(qResult);
            } else {
                list.remove(target);
            }
        }
    }

    public static double itemResult(InvoiceItem item) {
        double q = (double) item.getQuantity();
        double p = item.getUnitPrice() * q;
        if(item.getDiscount() > 0){
            p -=(item.getDiscount() * p);
        }
        p *= (1.0 + item.getTax());
        return normalize(p);
    }

    public static double itemResultEx(InvoiceItem item) {
        double q = (double) item.getQuantity();
        double p = item.getUnitPrice() * q;
        if(item.getDiscount() > 0){
            p -= (item.getDiscount() * p);
        }
        return normalize(p);
    }

    public static double itemTax(InvoiceItem item) {
        double q = (double) item.getQuantity();
        double p = item.getUnitPrice() - (item.getDiscount() * item.getUnitPrice());
        double tax = p * item.getTax();
        return normalize(tax);
    }

    public static double totalEx(List<InvoiceItem> list) {
        double result = 0.0;
        for (InvoiceItem item : list) {
            double itemResult = itemResultEx(item);
            result += itemResult;
        }
        return result;
    }

    public static double totalTax(List<InvoiceItem> list) {
        double result = 0.0;
        for (InvoiceItem item : list) {
            double itemResult = itemResultEx(item);
            double itemTax = item.getTax() * itemResult;
            result += normalize(itemTax);
        }
        return result;
    }

    public static double totalInc(List<InvoiceItem> list) {
        double result = 0.0;
        for (InvoiceItem item : list) {
            double itemResult = itemResult(item);
            result += itemResult;
        }
        return result;
    }

}
