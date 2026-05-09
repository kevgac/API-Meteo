package com.example.demo.service;

import com.example.demo.model.WeatherResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

  @Value("${weather.api.key}")
  private String apiKey;

  @Value("${weather.api.url}")
  private String apiUrl;

  private final RestTemplate restTemplate = new RestTemplate();

  @Cacheable(value = "weather", key = "#city")
  public WeatherResponse getWeather(String city) {
    System.out.println("Appel API externe pour : " + city);
    String url = String.format("%s?q=%s&appid=%s&units=metric", apiUrl, city, apiKey);
    return restTemplate.getForObject(url, WeatherResponse.class);
  }
}