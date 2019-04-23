/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converters;

import com.core.customers.Customer;
import com.core.customers.CustomerLayer;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 *
 * @author daan-
 */
public class CustomerConverter {
    public static void main(String[] args){
        try{
            File file = new File("D:\\temp\\customerfile.csv");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            for(line = reader.readLine(); line !=  null; line = reader.readLine()){
                String[] cells = line.split(";");
                Customer customer = CustomerLayer.create();
                customer.setId(cells[0]);
                customer.setName(cells[1]);
                customer.setStreet(cells[2]);
                customer.setZipcode(cells[3]);
                customer.setCity(cells[4]);
                if(cells.length >=8){
                    if(cells[5] != null && cells[5].length() > 1){
                        customer.setEmail(cells[5]);
                    }
                    if(cells[6] != null && cells[6].length() > 1){
                        customer.setPhone(cells[6]);
                    }
                    if(cells[7] != null && cells[7].length() > 1){
                        customer.setMobile(cells[7]);
                    }
                }
                CustomerLayer.update(customer);
            }
            reader.close();
        }catch(Exception e){}
    
    }
    
}
