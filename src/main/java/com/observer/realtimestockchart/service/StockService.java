package com.observer.realtimestockchart.service;

import com.observer.realtimestockchart.domain.Stock;
import com.observer.realtimestockchart.repository.StockRepository;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StockService {
    private final StockRepository stockRepository;

    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    public String connect(String url) {
        Connection conn = Jsoup.connect(url);
        Document doc = null;
        try {
            doc = conn.get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String data = getPriceData(doc);
        return data;
    }

    private String getPriceData(Document doc) {
//        List<String> list = new ArrayList<>();
        Elements selects = doc.select(".new_totalinfo dd:contains(현재가)");
        String data = selects.text();
        System.out.println("--- getPriceData : "+data+" ---");
        return data;
    }

    // 주식 생성
    public Long createStock(Stock stock) {
        stockRepository.save(stock);
        return stock.getId();
    }

    // 주식 조회
    public Optional<Stock> findStock(Long id) {
        return stockRepository.findById(id);
    }
    public List<Stock> findAll() {
        return stockRepository.findAll();
    }
}
