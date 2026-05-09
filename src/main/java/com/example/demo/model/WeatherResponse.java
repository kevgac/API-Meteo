package com.example.demo.model;

import lombok.Data;
import java.io.Serializable;

@Data
public class WeatherResponse implements Serializable {
    private String name;
    private MainData main;

    @Data
    public static class MainData implements Serializable {
        private double temp;
        private int humidity;
    }
}