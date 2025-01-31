package com.example.service;

import com.example.model.SalesRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Service
public class DemandForecastService {

    private final RestTemplate restTemplate = new RestTemplate();

    @Value("${ai.service.url}")
    private String aiServiceUrl;

    public int predictDemand(List<SalesRecord> salesHistory) {
        try {
            Map<String, Object> request = Map.of(
                    "sales_data", salesHistory,
                    "next_month", LocalDate.now().plusMonths(1).getMonthValue()
            );
            return restTemplate.postForObject(aiServiceUrl + "/predict", request, Integer.class);
        } catch (Exception e) {
            // Fallback to simple average
            return (int) salesHistory.stream()
                    .mapToInt(SalesRecord::getQuantitySold)
                    .average()
                    .orElse(0);
        }
    }
}