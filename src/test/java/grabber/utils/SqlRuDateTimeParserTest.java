package grabber.utils;

import org.junit.Test;
import static org.junit.Assert.*;
import java.time.LocalDateTime;

public class SqlRuDateTimeParserTest {

    @Test
    public void whenFullDate() {
        String date = "2 дек 19, 22:29";
        LocalDateTime localDateTime = LocalDateTime.of(2019, 12, 2, 22, 29);
        SqlRuDateTimeParser sql = new SqlRuDateTimeParser();
        assertTrue(localDateTime.isEqual(sql.parse(date)));
    }

    @Test
    public void whenToDayDate() {
        String date = "сегодня, 22:29";
        LocalDateTime localDateTime = LocalDateTime.of(2021, 9, 28, 22, 29);
        SqlRuDateTimeParser sql = new SqlRuDateTimeParser();
        assertTrue(localDateTime.isEqual(sql.parse(date)));
    }

    @Test
    public void whenToYesterdayDate() {
        String date = "вчера, 22:29";
        LocalDateTime localDateTime = LocalDateTime.of(2021, 9, 27, 22, 29);
        SqlRuDateTimeParser sql = new SqlRuDateTimeParser();
        assertTrue(localDateTime.isEqual(sql.parse(date)));
    }
}