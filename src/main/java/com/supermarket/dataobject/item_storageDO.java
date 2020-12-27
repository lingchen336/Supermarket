package com.supermarket.dataobject;

import java.math.BigDecimal;

public class item_storageDO {
    private String itemId;
    private String itemName;
    private Double itemPrice;
    private Double storageNumber;


    public String getItemId() {
        return itemId;
    }
    public void setItemId(String itemId) {
        this.itemId = itemId == null ? null : itemId.trim();
    }
    public String getItemName() {
        return itemName;
    }
    public void setItemName(String itemName) {
        this.itemName = itemName == null ? null : itemName.trim();
    }

    public Double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(Double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public Double getStorageNumber() {
        return storageNumber;
    }

    public void setStorageNumber(Double storageNumber) {
        this.storageNumber = storageNumber;
    }

    public item_storageDO(String itemId, String itemName, double itemPrice, double storageNumber) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.storageNumber = storageNumber;
    }
}