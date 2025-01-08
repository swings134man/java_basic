//package test.making;
//
//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
//import org.jsoup.select.Elements;
//
//import java.io.IOException;
//
///************
// * @info : 크롤링2 - 개발 블로그 최신 글 20개
// * @name : Crawling_2
// * @date : 2023/04/02 6:48 PM
// * @author : SeokJun Kang(swings134@gmail.com)
// * @version : 1.0.0
// * @Description :
// ************/
//public class Crawling_2 {
//
//    protected static final String URL = "https://lucas-owner.tistory.com/";
//
//
//    public void connect() throws IOException {
//        Document document = Jsoup.connect(URL).get();
//
//        // data
//        Elements select = document.select(".cover-thumbnail-2 ul li a span.title");
//        System.out.println(select.text());
//        System.out.println();
//
//        for (int i = 0; i < select.size(); i++) {
//            System.out.println(i + " ---> " + select.get(i).text());
//        }
//    }
//
//
//    public static void main(String[] args) throws IOException {
//        Crawling_2 c2 = new Crawling_2();
//        c2.connect();
//    }
//}
