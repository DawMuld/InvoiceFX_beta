/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.persistence;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author daan-
 */
public class TimeStamper {

    public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
    public static final DateTimeFormatter DTF = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    public static final DateTimeFormatter DF = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    public static final DateTimeFormatter TF = DateTimeFormatter.ofPattern("HH:mm:ss");

    public static LocalDateTime parseLocalDateTime(String cell) {
        int year = Integer.parseInt(cell.substring(0, 4));
        int month = Integer.parseInt(cell.substring(4, 6));
        int day = Integer.parseInt(cell.substring(6, 8));
        int hour = Integer.parseInt(cell.substring(8, 10));
        int minutes = Integer.parseInt(cell.substring(10, 12));
        int seconds = Integer.parseInt(cell.substring(12));
        return LocalDateTime.of(year, month, day, hour, minutes, seconds);
    }

    public static String parseTimeStamp(LocalDateTime ldr) {
        return FORMATTER.format(ldr);
    }

    public static String parseDate(LocalDateTime ldt) {
        return DF.format(ldt);
    }

    public static String parseTime(LocalDateTime ldt) {
        return TF.format(ldt);
    }

}
