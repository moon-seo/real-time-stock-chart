//package com.observer.realtimestockchart;
//
//import org.jsoup.Connection;
//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
//import org.jsoup.nodes.Element;
//import org.jsoup.select.Elements;
//import org.springframework.stereotype.Component;
//import org.springframework.util.ObjectUtils;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//public class CrawlingExample {
////    public static Connection getJsoupConnection(String url) {
////        return Jsoup.connect(url);
////    }
////
////    public static Elements getJsoupElements(Connection connection, String url, String query) throws IOException {
////        Connection conn = !(ObjectUtils.isEmpty(connection)) ? connection : getJsoupConnection(url);
////        Elements result = null;
////
////        result = conn.get().select(query);
////
////        return result;
////    }
//
//    public void process() {
//        String url = "https://finance.naver.com/item/main.naver?code=267850";
//        Connection conn = Jsoup.connect(url);
//        Document doc = null;
//        try {
//            doc = conn.get();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        List<String> list = getDataList(doc);
//    }
//
//    private List<String> getDataList(Document doc) {
//        List<String> list = new ArrayList<>();
//        Elements selects = doc.select(".new_totalinfo dd:contains(현재가)");
//        String extractedText = selects.text();
//        System.out.println(extractedText);
//
//        return list;
//    }
//
//}
