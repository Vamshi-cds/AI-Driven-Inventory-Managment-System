package com.example.controller;

import com.example.model.SalesRecord; // Import the SalesRecord class
import com.example.service.DemandForecastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate; // Import LocalDate
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000") // Allow requests from the frontend
@RestController
@RequestMapping("/api/predictions")
public class PredictionController {

    @Autowired
    private DemandForecastService demandForecastService;

    @GetMapping
    public List<Integer> getPredictions() {
        // Example sales data (replace with actual data from your database)
        List<SalesRecord> salesHistory = List.of(
                new SalesRecord(1L, 100, LocalDate.of(2024, 1, 1)),
                new SalesRecord(1L, 120, LocalDate.of(2024, 2, 1)),
                new SalesRecord(1L, 150, LocalDate.of(2024, 3, 1))
        );

        // Call the AI service to get predictions
        int prediction = demandForecastService.predictDemand(salesHistory);
        return List.of(prediction); // Return as a list for consistency
    }
}