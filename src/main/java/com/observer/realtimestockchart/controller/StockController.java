package com.observer.realtimestockchart.controller;

import com.observer.realtimestockchart.domain.Stock;
import com.observer.realtimestockchart.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StockController {
    private final StockService stockService;
    private SimpMessagingTemplate messagingTemplate;

    static String url = "https://finance.naver.com/item/main.naver?code=267850";

    @Autowired
    public StockController(StockService stockService, SimpMessagingTemplate messagingTemplate) {
        this.stockService = stockService;
        this.messagingTemplate = messagingTemplate;
    }

    @GetMapping("/charts")
    public String chart(Model model) {

//        List<Stock> stocks = stockService.findAll();
//        model.addAttribute("stocks", stocks);

        String data = stockService.connect(url);
        model.addAttribute("data", data);

        return "charts";
    }

//    @PostMapping("/charts")
//    public String insert()

//    @PostMapping("/update-data")
//    public void updateData() {
//        String updatedData = stockService.connect(url);
//        messagingTemplate.convertAndSend("/topic/data-update", updatedData);
//    }
}
