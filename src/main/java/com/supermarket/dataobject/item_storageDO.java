package com.supermarket.dataobject;

import java.math.BigDecimal;

public class item_storageDO {
    private String itemId;
    private String itemName;
    private Integer storageNumber;
    private BigDecimal itemPrice;

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
    public Integer getStorageNumber() {
        return storageNumber;
    }
    public void setStorageNumber(Integer storageNumber) {
        this.storageNumber = storageNumber;
    }
    public BigDecimal getItemPrice() {
        return itemPrice;
    }
    public void setItemPrice(BigDecimal itemPrice) {
        this.itemPrice = itemPrice;
    }

    public item_storageDO(String itemId, String itemName, Integer storageNumber, BigDecimal itemPrice) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.storageNumber = storageNumber;
        this.itemPrice = itemPrice;
    }
}