package grabber.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;

public class SqlRuDateTimeParser implements DateTimeParser {

    private static final Map<String, Integer> MONTHS = Map.ofEntries(
            Map.entry("янв", 1),
            Map.entry("фев", 2),
            Map.entry("мар", 3),
            Map.entry("апр", 4),
            Map.entry("мая", 5),
            Map.entry("июн", 6),
            Map.entry("июл", 7),
            Map.entry("авг", 8),
            Map.entry("сен", 9),
            Map.entry("окт", 10),
            Map.entry("ноя", 11),
            Map.entry("дек", 12)
    );

    @Override
    public LocalDateTime parse(String parse) {
        LocalDate localDate;
        int day = 0;
        int month = 0;
        int year = 0;
        int hour = 0;
        int minute = 0;
        String[] ar = parse.split(" ");
        String[] time  = ar[ar.length - 1].split(":");
        hour = Integer.parseInt(time[0]);
        minute = Integer.parseInt(time[1]);
        if (ar[0].equals("сегодня,")) {
            localDate = LocalDate.now();
            return localDate.atTime(hour, minute);
        }
        if (ar[0].equals("вчера,")) {
            localDate = LocalDate.now().minusDays(1);
            return localDate.atTime(hour, minute);
        }
        day = Integer.parseInt(ar[0]);
        month = MONTHS.get(ar[1]);
        year = Integer.parseInt(ar[2].substring(0, 2)) + 2000;
        return LocalDateTime.of(year, month, day, hour, minute);
    }

    public static void main(String[] args) {
        String date = "2 дек 19, 22:29";
        System.out.println(new SqlRuDateTimeParser().parse(date));
    }
}
