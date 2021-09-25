package html;

import grabber.Parse;
import grabber.utils.DateTimeParser;
import grabber.utils.SqlRuDateTimeParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SqlRuParse implements Parse {

    private final DateTimeParser dateTimeParser;

    public SqlRuParse(DateTimeParser dateTimeParser) {
        this.dateTimeParser = dateTimeParser;
    }

    @Override
    public List<Post> list(String link) throws IOException {
        List<Post> list = new ArrayList<>();
        Document doc = Jsoup.connect(link).get();
        Elements row = doc.select(".postslisttopic");
        for (Element td : row) {
            Element href = td.child(0);
            String linkJava = href.attr("href");
            if (linkJava.contains("java-")) {
                list.add(detail(linkJava));
            }
        }
        return list;
    }

    @Override
    public Post detail(String link) throws IOException {
        Document document = Jsoup.connect(link).get();
        Elements rowTitle = document.select(".messageHeader");
        String title = rowTitle.first().text();
        Elements rowDes = document.select(".msgBody");
        int indexDes = 1;
        String des = rowDes.get(indexDes).text();
        Elements rowDate = document.select(".msgFooter");
        String date = rowDate.first().text();
        LocalDateTime create = dateTimeParser.parse(date.substring(0, date.indexOf(":") + 3));
        return new Post(title, link, des, create);
    }
}