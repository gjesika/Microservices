package com.example.demo1.Dto;

import com.example.demo1.model.order;

public class OrderDetailsDTO {
    private order order;
    private String userInfo;

    // Konstruktori që merr një `order` dhe një `userInfo`
    public OrderDetailsDTO(order order, String userInfo) {
        this.order = order;
        this.userInfo = userInfo;
    }

    // Getters dhe Setters
    public order getOrder() {
        return order;
    }

    public void setOrder(order order) {
        this.order = order;
    }

    public String getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(String userInfo) {
        this.userInfo = userInfo;
    }

    @Override
    public String toString() {
        return "OrderDetailsDTO{" +
                "order=" + order +
                ", userInfo='" + userInfo + '\'' +
                '}';
    }
}



