// // 5 Write an example that, for a given year, reports the length of each month within that year.

import java.time.Month;
import java.time.Year;
import java.time.YearMonth;
import java.time.DateTimeException;

import java.io.PrintStream;
import java.lang.NumberFormatException;

public class MonthsInYear {
    public static void main(String[] args) {
        int year = 0;

        if (args.length <= 0) {
            System.out.printf("Usage: MonthsInYear <year>%n");
            throw new IllegalArgumentException();
        }

        try {
            year = Integer.parseInt(args[0]);
        } catch (NumberFormatException nexc) {
            System.out.printf("%s is not a properly formatted number.%n",
                args[0]);
            throw nexc;     // Rethrow the exception.
        }

        try {
            Year test = Year.of(year);
        } catch (DateTimeException exc) {
            System.out.printf("%d is not a valid year.%n", year);
            throw exc;     // Rethrow the exception.
        }

        System.out.printf("For the year %d:%n", year);
        for (Month month : Month.values()) {
            YearMonth ym = YearMonth.of(year, month);
            System.out.printf("%s: %d days%n", month, ym.lengthOfMonth());
        }
    }
}