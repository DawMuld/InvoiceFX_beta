/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.persistence;

import com.core.debug.Debug;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

/**
 *
 * @author daan-
 */
public class IndexReader {

    private static int getNextIndex(File file) {
        int index = 0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            for (line = reader.readLine(); line != null; line = reader.readLine()) {
                String[] cells = line.split(";");
                if (cells != null && cells.length > 0) {
                    try {
                        int linekey = Integer.parseInt(cells[0]);
                        index = linekey;
                    } catch (NumberFormatException e) {
                        Debug.out("Could not resolve primary key for line = " + line);
                    }
                }
            }
            reader.close();
        } catch (Exception e) {
            Debug.out(e.getStackTrace());
        }
        return (index + 1);
    }

    public static int preserveNextPrimaryKey(File file) {
        int primaryKey = getNextIndex(file);
        try {
            PrintWriter writer = new PrintWriter(new FileWriter(file, true));
            writer.println(String.valueOf(primaryKey) + ";");
            writer.close();
        } catch (Exception e) {
            Debug.out("Error while preserving new line");
        }
        return primaryKey;
    }

    public static int getLineIndex(String line) {
        String[] cells = line.split(";");
        return Integer.parseInt(cells[0]);

    }

}
