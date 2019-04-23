/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.persistence;

import com.core.debug.Debug;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author daan-
 */
public class StorageManager {

    public static File getCustomerFile() {
        File file = new File(getCustomerFolder() + "\\customers.csv");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                Debug.out("IO Exception thrown while trying to create customer file");
                Debug.out(e.getStackTrace());
            }
        }
        return file;
    }

    public static File getDeletedCustomerFile() {
        File file = new File(getCustomerFolder() + "\\deleted_customers.csv");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                Debug.out("IO Exception thrown while trying to create deleted_customer file");
                Debug.out(e.getStackTrace());
            }
        }
        return file;
    }

    public static File getProductFile() {
        File file = new File(getProductFolder() + "\\products.csv");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                Debug.out("IO Exception thrown while trying to create product file");
                Debug.out(e.getStackTrace());
            }
        }
        return file;
    }

    public static File getDeletedProductFile() {
        File file = new File(getProductFolder() + "\\deleted_products.csv");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                Debug.out("IO Exception thrown while trying to create deleted_product file");
                Debug.out(e.getStackTrace());
            }
        }
        return file;
    }

    public static File getInvoiceFile() {
        File file = new File(getInvoiceFolder() + "\\invoices.csv");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                Debug.out("IO Exception thrown while trying to create invoice file");
                Debug.out(e.getStackTrace());
            }
        }
        return file;
    }

    public static File getDeletedInvoiceFile() {
        File file = new File(getInvoiceFolder() + "\\deleted_invoices.csv");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                Debug.out("IO Exception thrown while trying to create deleted_invoice file");
                Debug.out(e.getStackTrace());
            }
        }
        return file;
    }

    public static File getCompanyFile() {
        File file = new File(getCompanyFolder() + "\\companies.csv");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                Debug.out("IO Exception thrown while trying to create company file");
                Debug.out(e.getStackTrace());
            }
        }
        return file;
    }

    public static File getDeletedCompaniesFile() {
        File file = new File(getCompanyFolder() + "\\deleted_companies.csv");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                Debug.out("IO Exception thrown while trying to create deleted_company file");
                Debug.out(e.getStackTrace());
            }
        }
        return file;
    }

    private static String getCustomerFolder() {
        File file = new File(getStorageFolder() + "\\customers\\");
        if (!file.exists()) {
            Debug.out("Could not find customer folder...");
            Debug.out("Trying to create location for customers");
            file.mkdirs();
            if (file.exists()) {
                Debug.out("Successfully created customer folders");
            } else {
                Debug.out("!WARNING!:\n\tStill unable to create customer folders...");
            }
        }
        return file.getAbsolutePath();
    }

    private static String getProductFolder() {
        File file = new File(getStorageFolder() + "\\products\\");
        if (!file.exists()) {
            Debug.out("Could not find product folder...");
            Debug.out("Trying to create location for products");
            file.mkdirs();
            if (file.exists()) {
                Debug.out("Successfully created product folders");
            } else {
                Debug.out("!WARNING!:\n\tStill unable to create product folders...");
            }
        }
        return file.getAbsolutePath();
    }

    private static String getInvoiceFolder() {
        File file = new File(getStorageFolder() + "\\invoices\\");
        if (!file.exists()) {
            Debug.out("Could not find invoice folder...");
            Debug.out("Trying to create location for invoices");
            file.mkdirs();
            if (file.exists()) {
                Debug.out("Successfully created invoice folders");
            } else {
                Debug.out("!WARNING!:\n\tStill unable to create invoice folders...");
            }
        }
        return file.getAbsolutePath();
    }

    private static String getCompanyFolder() {
        File file = new File(getStorageFolder() + "\\companies\\");
        if (!file.exists()) {
            Debug.out("Could not find company folder...");
            Debug.out("Trying to create location for companies");
            file.mkdirs();
            if (file.exists()) {
                Debug.out("Successfully created company folders");
            } else {
                Debug.out("!WARNING!:\n\tStill unable to create company folders...");
            }
        }
        return file.getAbsolutePath();
    }

    private static String getStorageFolder() {
        File file = new File(System.getProperty("user.home") + "\\AppData\\Local\\InvoiceFiles\\");
        if (!file.exists()) {
            Debug.out("Could not find storage folder...");
            Debug.out("Trying to create location for storage");
            file.mkdirs();
            if (file.exists()) {
                Debug.out("Successfully created storage folders");
            } else {
                Debug.out("!WARNING!:\n\tStill unable to create storage folders...");
            }
        }
        return file.getAbsolutePath();
    }

}
