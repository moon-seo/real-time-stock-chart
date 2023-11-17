package com.observer.realtimestockchart.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Stock {
    @Id
    private Long id;
    private String code;
    private String name;
    private String price;

    public Long getId() {
        return id;
    }
}
