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
        if (ar[0].equals("сегодня,")) {
            String[] time = ar[1].split(":");
            hour = Integer.parseInt(time[0]);
            minute = Integer.parseInt(time[1]);
            localDate = LocalDate.now();
            return localDate.atTime(hour, minute);
        }
        if (ar[0].equals("вчера,")) {
            String[] time = ar[1].split(":");
            hour = Integer.parseInt(time[0]);
            minute = Integer.parseInt(time[1]);
            localDate = LocalDate.now().minusDays(1);
            return localDate.atTime(hour, minute);
        }
        day = Integer.parseInt(ar[0]);
        for (String s : MONTHS.keySet()) {
            if (s.equals(ar[1])) {
                month = MONTHS.get(s);
            }
        }
        year = Integer.parseInt(ar[2].substring(0, 1));
        String[] time = ar[4].split(":");
        hour = Integer.parseInt(time[0]);
        minute = Integer.parseInt(time[1]);
        return LocalDateTime.of(year, month, day, hour, minute);
    }
}
