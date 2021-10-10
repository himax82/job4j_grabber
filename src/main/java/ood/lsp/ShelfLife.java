package ood.lsp;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ShelfLife {

    public static double daysCoef(LocalDate expiryDate, LocalDate createDate) {
        LocalDate now = LocalDate.now();
        double dayCreate = (double) ChronoUnit.DAYS.between(createDate, now);
        double dayStorage = (double) ChronoUnit.DAYS.between(createDate, expiryDate);
        return dayCreate / dayStorage;
    }
}
