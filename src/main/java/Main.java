import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Obj> list = new ArrayList<>();
        Integer pages = 20;
        try {
            for (int i = 1; i <= pages ; i++) {
                Document doc = Jsoup.connect("http://bang.dangdang.com/books/newhotsales/01.00.00.00.00.00-recent7-0-0-2-"+i)
                        .data("query", "Java")
                        .userAgent("Mozilla")
                        .cookie("auth", "token")
                        .post();

                Elements lis = doc.body().select(".bang_list li");
                for (Element element:lis) {
                    String rank = element.select(".number").text();
                    String src = element.getElementsByAttribute("src").attr("src");
                    String bookName = element.select(".name a").text();
                    if (bookName.indexOf("（") != -1){
                        bookName = bookName.substring(0,bookName.indexOf("（"));
                    }
                    String comment = element.select(".star a").text();
                    Long commentnum = 0L;
                    if(comment.indexOf("条") != 0){
                        commentnum = Long.valueOf(comment.substring(0, comment.indexOf("条")));
                    }
                    Elements publisherInfos = element.select(".publisher_info a");
                    String author ;
                    if (publisherInfos.size() > 1){
                        author = publisherInfos.get(0).text();
                    }else {
                        author = "XXX";
                    }
                    String publishTime = element.select(".publisher_info span").first().text();

                    String price_r = element.select(".price_r").text();
                    String price_n = element.select(".price_n").text();
                    String price_s = element.select(".price_s").text();
                    Obj obj = new Obj();
                    obj.setAuthor(author);
                    obj.setBookName(bookName);
                    obj.setCommentnum(String.valueOf(commentnum));
                    obj.setPublishTime(publishTime);
                    obj.setRank(rank);
                    obj.setPrice_r(price_r);
                    obj.setPrice_n(price_n);
                    obj.setPrice_s(price_s);
                    obj.setImgurl(src);
                    list.add(obj);
                }
            }
            ExcelUtil.WriteExcel(list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
