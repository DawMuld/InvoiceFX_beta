/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.debug;

import java.util.List;

/**
 *
 * @author daan-
 */
public class Debug {

    public static void out(String line) {
        System.out.println(line);
    }

    public static void out(Object line) {
        Debug.out(line.toString());
    }

    public static void out(String[] lines) {
        for (String line : lines) {
            Debug.out(line);
        }
    }

    public static void out(Object[] lines) {
        for (Object line : lines) {
            Debug.out(line.toString());
        }
    }

    public static void out(List<Object> lines) {
        lines.forEach((line) -> {
            Debug.out(line.toString());
        });
    }

}
