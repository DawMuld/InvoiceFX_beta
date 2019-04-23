/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.persistence;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 *
 * @author daan-
 */
public class ExcludeSet {

    public static Set<Integer> getExcludeSet(File file) {
        Set<Integer> set = new HashSet<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            for (line = reader.readLine(); line != null; line = reader.readLine()) {
                String[] cells = line.split(";");
                for (String cell : cells) {
                    try {
                        int index = Integer.parseInt(cell);
                        set.add(index);
                    } catch (NumberFormatException e) {
                    }
                }
            }
            reader.close();

        } catch (Exception e) {
        }
        return set;
    }

    public static void exclude(int index, File file) {
        Set<Integer> set = getExcludeSet(file);
        if (!set.contains(index)) {
            set.add(index);
            List<Integer> list = new ArrayList<>();
            Iterator<Integer> i = set.iterator();
            while (i.hasNext()) {
                list.add(i.next());
            }
            Collections.sort(list);
            storeExcludeList(list, file);
        }
    }

    private static void storeExcludeList(List<Integer> list, File file) {
        try {
            File temp = new File("temp");
            PrintWriter writer = new PrintWriter(new FileWriter(temp));
            Iterator<Integer> i = list.iterator();
            while (i.hasNext()) {
                String line = createLine(i);
                writer.println(line);
            }
            writer.close();
            file.delete();
            temp.renameTo(file);
        } catch (Exception e) {
        }

    }

    private static String createLine(Iterator<Integer> iterator) {
        String line = "";
        int count = 0;
        while (iterator.hasNext() && count < 5) {
            line += String.valueOf(iterator.next()) + ";";
        }
        return line;

    }
}
