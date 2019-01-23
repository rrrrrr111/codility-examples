package ru.roman.certification.datetime;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.ZonedDateTime;
import java.time.chrono.IsoChronology;
import java.time.chrono.ThaiBuddhistChronology;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DecimalStyle;
import java.time.format.FormatStyle;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class Examples {

    public static void main(String[] args) {

        System.out.printf("%s%n", DayOfWeek.MONDAY.plus(3));


        System.out.println(DayOfWeek.MONDAY.getDisplayName(TextStyle.FULL, Locale.getDefault()));
        System.out.println(DayOfWeek.MONDAY.getDisplayName(TextStyle.NARROW, Locale.getDefault()));
        System.out.println(DayOfWeek.MONDAY.getDisplayName(TextStyle.SHORT, Locale.getDefault()));

        System.out.printf("%s%n",
                Duration.between(Instant.now(), Instant.now().plus(Duration.ofSeconds(10))).toNanos()
        );

        howOldAreYou();
        printDates();
    }

    private static void howOldAreYou() {
        LocalDate today = LocalDate.now();
        LocalDate birthday = LocalDate.of(1983, Month.FEBRUARY, 28);

        Period p = Period.between(birthday, today);
        long total = ChronoUnit.DAYS.between(birthday, today);
        System.out.println("You are " + p.getYears() + " years, " + p.getMonths() + " months, and " + p.getDays()
                + " days old. (" + total + " days total)");
    }

    private static void printDates() {
        System.out.printf(">> 41 >> %s%n",
                DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL)
                        .withLocale(Locale.getDefault(Locale.Category.FORMAT))
                        .withChronology(ThaiBuddhistChronology.INSTANCE)
                        .withDecimalStyle(DecimalStyle.of(Locale.getDefault(Locale.Category.FORMAT)))
                        .format(ZonedDateTime.now())
        );

        System.out.printf(">> 42 >> %s%n",
                new DateTimeFormatterBuilder()
                        .parseLenient()
                        .appendPattern("M/d/yyyy GGGGG")
                        .toFormatter()
                        .withChronology(IsoChronology.INSTANCE)
                        .withDecimalStyle(DecimalStyle.of(Locale.getDefault(Locale.Category.FORMAT)))
                        .format(ZonedDateTime.now())
        );
    }
}
