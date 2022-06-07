package com.tistory.hrlim.utils;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class TimeUtils {
    public static LocalDateTime toLocalDateTime(long epochMillis) {
        return Instant.ofEpochMilli(epochMillis)
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
    }

    public static LocalDateTime toLocalDateTime(String yearMonth) {

        LocalDate localDate = LocalDate.parse(yearMonth + "01", DateTimeFormatter.BASIC_ISO_DATE);
        LocalDateTime localDateTime = localDate.atStartOfDay();
        return  localDateTime;

    }

    public static long toEpochMillis(LocalDateTime localDateTime) {
        return localDateTime.atZone(ZoneId.systemDefault())
                .toInstant()
                .toEpochMilli();
    }
}