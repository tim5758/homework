package com.example.homework.model;

import java.util.Date;

public class Product {
    private Integer productId;
    private String productName;
    private String category;
    private Integer price;
    private Integer stock;
    private Date createdDate;
    private Date lastModifiedDate;

    public Product() {}

    public Product(Integer productId, String productName, String category, Integer price, Integer stock, Date createdDate, Date lastModifiedDate) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
        this.price = price;
        this.stock = stock;
        this.createdDate = createdDate;
        this.lastModifiedDate = lastModifiedDate;
    }

    @Override
    public String toString() {
        return "產品編號： " + productId + " ,產品名稱： " + productName + " ,產品分類： " + category +
                " ,產品價格： " + price + " ,產品庫存： " + stock + " ,創建日期： " + createdDate +
                " ,修改日期： " + lastModifiedDate;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }
}
