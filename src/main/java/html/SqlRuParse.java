package html;

import grabber.utils.SqlRuDateTimeParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

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
        post.setDescription(rowDes.text());
        Elements rowDate = document.select(".msgFooter");
        post.setCreated(new SqlRuDateTimeParser().parse(rowDate.text()));
    }
}