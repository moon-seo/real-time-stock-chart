package com.observer.realtimestockchart.repository;

import com.observer.realtimestockchart.domain.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, Long> {
}
