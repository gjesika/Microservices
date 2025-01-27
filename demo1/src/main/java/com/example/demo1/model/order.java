package com.example.demo1.model;

public class order{
    private Long orderId;
    private Long userId; // ID e përdoruesit që ka bërë porosinë
    private String product;
    private Double amount;

    // Default constructor
    public order() {
    }

    // Constructor with fields
    public order(Long orderId, Long userId, String product, Double amount) {
        this.orderId = orderId;
        this.userId = userId;
        this.product = product;
        this.amount = amount;
    }

    // Getters and Setters
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Order{orderId=" + orderId + ", userId=" + userId + ", product='" + product + "', amount=" + amount + "}";
    }
}


