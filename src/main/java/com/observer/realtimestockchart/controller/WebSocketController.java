package com.observer.realtimestockchart.controller;

import com.observer.realtimestockchart.service.StockService;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import static com.observer.realtimestockchart.controller.StockController.url;

@Controller
public class WebSocketController {
    Integer i = 0;
    private final StockService stockService;
//    private final StockController stockController;
    private final SimpMessagingTemplate messagingTemplate;

    public WebSocketController(StockService stockService, StockController stockController, SimpMessagingTemplate messagingTemplate) {
        this.stockService = stockService;
//        this.stockController = stockController;
        this.messagingTemplate = messagingTemplate;
    }

    @Scheduled(fixedDelay = 1000)    // 0.5초마다 실행
//    @SendTo("/topic/data-update")
    public void update() {

        String updatedData = stockService.connect(url);
        messagingTemplate.convertAndSend("/topic/data-update", updatedData);

        System.out.println("\n\n업데이트\n\n"+i+++": "+updatedData);
    }

//    @PostMapping("/update-data")
//    public void updateData() {
//        String updatedData = stockService.connect(url);
//        messagingTemplate.convertAndSend("/topic/data-update", updatedData);
//    }
}
