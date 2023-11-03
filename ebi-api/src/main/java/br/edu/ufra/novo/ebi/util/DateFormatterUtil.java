package br.edu.ufra.novo.ebi.util;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DateFormatterUtil {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

    private DateFormatterUtil() {
    }

    public static String formatInstant(Instant instant) {
        if (instant == null) {
            return null;
        }
        ZoneId spZone = getTimeZone();
        return instant.atZone(spZone).format(formatter);
    }

    public static Instant convertStringToInstant(String dateTime) {
        ZoneId spZone = getTimeZone();
        LocalDateTime localDateTime = LocalDateTime.parse(dateTime, formatter);
        ZonedDateTime zonedDateTime = localDateTime.atZone(spZone);
        return zonedDateTime.toInstant();
    }

    private static ZoneId getTimeZone() {
        return ZoneId.of("America/Sao_Paulo");
    }

    public static void main(String[] args) {
        Instant i1 = Instant.now();
        String formattedDate = formatInstant(i1);
        System.out.println("Data formatada no fuso horário de São Paulo: " + formattedDate);

        String dateTimeString = "03-11-2023 14:30";
        Instant i2 = convertStringToInstant(dateTimeString);
        System.out.println("Instant: " + i2);
    }
}
