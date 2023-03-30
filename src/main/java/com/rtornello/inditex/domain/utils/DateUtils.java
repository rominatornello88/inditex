package com.rtornello.inditex.domain.utils;

import com.rtornello.inditex.domain.constants.ConstantPrice;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtils {

    public DateUtils() {
        throw new IllegalStateException("DateUtils class");
    }

    public static LocalDateTime getLocalDateTime(String dateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(ConstantPrice.YYYY_MM_DD_HH_MM);
        LocalDateTime dateTimeFormatter = LocalDateTime.parse(dateTime, formatter);
        return dateTimeFormatter;
    }


}
