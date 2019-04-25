/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converters;

import com.core.persistence.Formatter;
import com.core.products.Product;
import com.core.products.ProductLayer;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 *
 * @author daan-
 */
public class ProductConverter {

    public static void main(String[] args) {
        try {
            File file = new File("D:\\temp\\products.csv");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            for (line = reader.readLine(); line != null; line = reader.readLine()) {
                String[] cells = line.split(";");
                String id = cells[1].trim();
                String name = cells[2].trim();
                double sellingPrice = Formatter.formatPrice(cells[3]);
                double purchasePrice = Formatter.formatPrice(cells[4]);
                String details = cells[5].trim();
                if (purchasePrice == 0.0) {
                    purchasePrice = sellingPrice;
                }

                Product p = ProductLayer.create();
                p.setId(id);
                p.setName(name);
                p.setDetails(details);
                p.setPurchasePrice(purchasePrice);
                p.setSellingPrice(sellingPrice);
                ProductLayer.update(p);

            }
            reader.close();

        } catch (Exception e) {
        }

    }
}
