package html;

import grabber.utils.SqlRuDateTimeParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.time.LocalDateTime;

public class SqlRuParse {
    public static void main(String[] args) throws Exception {
        for (int i = 1; i <= 5; i++) {
            String url = "https://www.sql.ru/forum/job-offers/" + i;
            Document doc = Jsoup.connect(url).get();
            Elements row = doc.select(".postslisttopic");
            for (Element td : row) {
                Element href = td.child(0);
                System.out.println(href.attr("href"));
                System.out.println(href.text());
                Element date = td.parent();
                System.out.println(date.children().get(5).text());
            }
        }
    }
    public static void parseUrl(Post post, String url) throws IOException {
        Document document = Jsoup.connect(url).get();
        Elements rowDes = document.select(".msgBody");
        int indexDes = 1;
        post.setDescription(rowDes.get(indexDes).text());
        Elements rowDate = document.select(".msgFooter");
        String date = rowDate.first().text();
        LocalDateTime create = new SqlRuDateTimeParser().parse(date.substring(0, date.indexOf(":") + 3));
        post.setCreated(create);
    }
}