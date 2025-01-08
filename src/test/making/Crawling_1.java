//package test.making;
//
//import org.jsoup.Connection;
//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
//import org.jsoup.select.Elements;
//
//import java.io.IOException;
//
///************
// * @info : Java 크롤링1 - 네이버 연합뉴스 기사
// * @name : Crawling_1
// * @date : 2023/04/02 6:05 PM
// * @author : SeokJun Kang(swings134@gmail.com)
// * @version : 1.0.0
// * @Description :
// ************/
//public class Crawling_1 {
//
//    protected final String url = "https://news.naver.com/main/list.naver?mode=LPOD&mid=sec&sid1=001&sid2=140&oid=001&isYeonhapFlash=Y";
//
//    // Connections - and Get Data
//    public void connect() throws IOException {
//        // 1. 연결
//        Document document = Jsoup.connect(url).get();
//
//        // 2. data - 기사 속보
//        Elements hot = document.select(".type04 dd ul li");
//        System.out.println("현재 기사 속보 탑3");
//        for (int i = 0; i < hot.size(); i++) {
//            System.out.println(i + " ---> " + hot.get(i).text());
//        }
//        System.out.println("------------------------------------------------------------");
//
//
//        // 3. data - 일반 기사
//        // class = typ02 인것중에서 하위의 li를 가져오는것.
//        Elements select = document.select(".type02 li");
//
//        System.out.println("Naver 연합뉴스 일반 크롤링 ");
//        for (int i = 0; i < select.size(); i++) {
//            System.out.println(i + " ---> " + select.get(i).text());
//        }
//
//    }
//
//    public static void main(String[] args) throws IOException {
//        Crawling_1 c = new Crawling_1();
//        c.connect();
//    }
//
//}
