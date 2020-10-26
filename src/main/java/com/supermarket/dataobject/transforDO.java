package com.supermarket.dataobject;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

public class transforDO {

    private Integer transId;
    private String transDate;
    private String cashier;
    private String itemId;
    private String itemName;

    private Integer transNumber;

    private Double price;

    private Double statistics;

    public Integer getTransId() {
        return transId;
    }

    public void setTransId(Integer transId) {
        this.transId = transId;
    }

    public String getTransDate() {
        return transDate;
    }

    public void setTransDate(String transDate) {
        this.transDate = transDate;
    }

    public String getCashier() {
        return cashier;
    }

    public void setCashier(String cashier) {
        this.cashier = cashier;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Integer getTransNumber() {
        return transNumber;
    }

    public void setTransNumber(Integer transNumber) {
        this.transNumber = transNumber;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getStatistics() {
        return statistics;
    }

    public void setStatistics(Double statistics) {
        this.statistics = statistics;
    }

    public transforDO(Integer transId, String transDate, String cashier, String itemId, String itemName, Integer transNumber, Double price, Double statistics) {
        this.transId = transId;
        this.transDate = transDate;
        this.cashier = cashier;
        this.itemId = itemId;
        this.itemName = itemName;
        this.transNumber = transNumber;
        this.price = price;
        this.statistics = statistics;
    }
}