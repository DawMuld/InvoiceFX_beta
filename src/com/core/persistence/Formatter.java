/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.persistence;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author daan-
 */
public class Formatter {

    private static final DecimalFormat INDEX_FORMATTER = new DecimalFormat("0000");
    private static final DecimalFormat INT_FORMATTER = new DecimalFormat("0000");
    private static final DecimalFormat PRICE_FORMATTER = new DecimalFormat("0.00");
    private static final DateTimeFormatter DF = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    private static final DateTimeFormatter TF = DateTimeFormatter.ofPattern("HH:mm:ss");

    public static String formatIndex(int index) {
        return INDEX_FORMATTER.format(index);
    }

    public static String formatDate(LocalDateTime ldt) {
        return DF.format(ldt);
    }

    public static String formatPrice(double value) {
        return PRICE_FORMATTER.format(value);
    }

    public static double formatPrice(String value) {
        if (value.contains(",")) {
            value = value.replace(",", ".");
        }
        double price = 0.0;
        try {
            price = Double.parseDouble(value);
        } catch (NumberFormatException e) {
        }
        return price;
    }

    public static String asPercentage(double value) {
        if (value < 1.0) {
            value *= 100;
        }
        return INT_FORMATTER.format(value);
    }

    public static double asPercentage(String value) {
        double result = 0.0;
        if (value.contains(",")) {
            value = value.replace(",", ".");
        }
        try {
            result = Double.parseDouble(value);
        } catch (NumberFormatException e) {
        }
        if (result > 1.0) {
            result /= 100;
        }
        return result;

    }
}
