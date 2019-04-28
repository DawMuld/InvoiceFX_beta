/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.app;

import com.core.Company.CompanyDataBase;
import com.core.Company.CompanyLayer;
import com.core.customers.CustomerDataBase;
import com.core.customers.CustomerLayer;
import com.core.invoices.InvoiceDataBase;
import com.core.invoices.InvoiceLayer;
import com.core.products.ProductDataBase;
import com.core.products.ProductLayer;

/**
 *
 * @author daan-
 */
public class AppDB {

    private static AppDB instance;
    private final CustomerDataBase customerDataBase;
    private final ProductDataBase productDataBase;
    private final InvoiceDataBase invoiceDataBase;
    private final CompanyDataBase companyDataBase;



    public static AppDB getDataBases() {
        if (instance == null) {
            synchronized (AppDB.class) {
                if (instance == null) {
                    CustomerDataBase customerDataBase = new CustomerDataBase(CustomerLayer.readAll());
                    ProductDataBase productDataBase = new ProductDataBase(ProductLayer.readAll());
                    InvoiceDataBase invoiceDataBase = new InvoiceDataBase(InvoiceLayer.readAll());
                    CompanyDataBase companyDataBase = new CompanyDataBase(CompanyLayer.readAll());
                    instance = new AppDB(customerDataBase, productDataBase, invoiceDataBase, companyDataBase);
                }
            }
        }
        return instance;
    }



    protected AppDB(CustomerDataBase customerDataBase, ProductDataBase productDataBase, InvoiceDataBase invoiceDataBase, CompanyDataBase companyDataBase) {
        this.customerDataBase = customerDataBase;
        this.productDataBase = productDataBase;
        this.invoiceDataBase = invoiceDataBase;
        this.companyDataBase = companyDataBase;
    }



    public CustomerDataBase getCustomerDB() {
        return customerDataBase;
    }



    public ProductDataBase getProductDB() {
        return productDataBase;
    }



    public InvoiceDataBase getInvoiceDB() {
        return invoiceDataBase;
    }



    public CompanyDataBase getCompanyDB() {
        return companyDataBase;
    }

}
