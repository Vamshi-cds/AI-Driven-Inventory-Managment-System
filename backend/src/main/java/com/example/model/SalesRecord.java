package com.example.model;

import java.time.LocalDate;

public class SalesRecord {
    private Long productId;
    private int quantitySold;
    private LocalDate saleDate;

    // Constructor
    public SalesRecord(Long productId, int quantitySold, LocalDate saleDate) {
        this.productId = productId;
        this.quantitySold = quantitySold;
        this.saleDate = saleDate;
    }

    // Getters and Setters
    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public int getQuantitySold() {
        return quantitySold;
    }

    public void setQuantitySold(int quantitySold) {
        this.quantitySold = quantitySold;
    }

    public LocalDate getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(LocalDate saleDate) {
        this.saleDate = saleDate;
    }
}