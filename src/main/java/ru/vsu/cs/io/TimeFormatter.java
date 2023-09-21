package ru.vsu.cs.io;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeFormatter {

    public String getCurrentDateTimeString() {
        return DateTimeFormatter
                .ofPattern("ddMMyyyy_HHmmss")
                .format(LocalDateTime.now());
    }
}
